// Class UpdateFinalStudentExams 
// Very important class.
// THIS (among other things) ADDS THE FINAL GRADED EXAM TO THE MASTERLIST, then the outerMasterListofMastersSER,
// and then SERIALIZES IT STICKS the outerMasterListofMastersSER IN THE STUDENTS_OUTERNESTED_TABLE4 
// via setOuterMasterListOfMastersSER()

package main.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class UpdateFinalStudentExams {

	Integer selectedExamIndex;
	Integer studentPrimaryKey;

	ArrayList<ArrayList<QuestionSuper>> innerMasterListOfQuestionsSER;
	ArrayList<ArrayList<ArrayList<QuestionSuper>>> outerMasterListofMastersSER;
	ArrayList<QuestionSuper> listOfQuestionsSER;
	ArrayList<ArrayList<Boolean>> gradeOnceListOfListsSER;
	ArrayList<ArrayList<QuestionSuper>> masterListOfQuestionsSER;
	ArrayList<ArrayList<ArrayList<QuestionSuper>>> deserializedOuterMasterObject;
	ArrayList<ArrayList<QuestionSuper>> deserializedInnerMasterObject;

	public void upDateFinalGradedStudentExams(Integer selectedExamIndex, ArrayList<QuestionSuper> listOfQuestionsSER)
			throws ClassNotFoundException, IOException, SQLException {

		// THIS IS CALLED FROM THE FINISH BUTTON AFTER PERCENTAGES GRADED ETC.
		System.out.println("Top of UpdateFinalStudentExams class upDateFinalGradedStudentExams() method");

		outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
		System.out.println(outerMasterListofMastersSER + "outerMasterListofMastersSER poeiroet8");
		innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
		
		
		// innerMasterListOfQuestionsSER is [] but shouldn't it have a null?
		System.out.println(innerMasterListOfQuestionsSER + " ,ldiroeiu9");
		// indexoutofbounds 0 of 0
		// 7-21 PROBLEM THROWS INDEXOUTOFBOUNDS? 
		//System.out.println(innerMasterListOfQuestionsSER.get(0) + " poercieu");
		
		// But 7-21 don't I always want to add the exam and never set it?
		// because I'm always adding the latest. So no need for if/else
		innerMasterListOfQuestionsSER.add(listOfQuestionsSER);
		/*
		if (innerMasterListOfQuestionsSER.get(0) != null) {
			System.out.println("kcerioe8594");
			innerMasterListOfQuestionsSER.set(0, listOfQuestionsSER); // I want to do this part which is still good
		} else {
			System.out.println("djfvmspuerte");
			innerMasterListOfQuestionsSER.add(listOfQuestionsSER);
		}
		*/

		
		
		if ((outerMasterListofMastersSER != null) && (outerMasterListofMastersSER.size() > 0)) {
			outerMasterListofMastersSER.set(selectedExamIndex, innerMasterListOfQuestionsSER);
			setOuterMasterListOfMastersSER(selectedExamIndex, outerMasterListofMastersSER);
			outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
			innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
		} else {
			JOptionPane.showMessageDialog(null, "That exam structure has not been created"); // But that's dumb because
		}
		
		setOuterMasterListOfMastersSER(selectedExamIndex, outerMasterListofMastersSER);
		
		outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
		innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
		// Returns the most recent exam taken and stored in the
		// outerMasterListofMastersSER
		listOfQuestionsSER = innerMasterListOfQuestionsSER.get(innerMasterListOfQuestionsSER.size() - 1);

		System.out.println("Bottom of UpdateFinalStudentExams class upDateFinalGradedStudentExams() method");

		System.out.println("bottom of UpdateFinalStudentExams class upDateFinalGradedStudentExams() method");
	}

	public void setOuterMasterListOfMastersSER(Integer selectedExamIndex,
			ArrayList<ArrayList<ArrayList<QuestionSuper>>> outerMasterListofMastersSER)
			throws SQLException, IOException, ClassNotFoundException {

		this.outerMasterListofMastersSER = outerMasterListofMastersSER;
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(outerMasterListofMastersSER);
		byte[] serializedOuterMasterBytes = baos.toByteArray();
		oos.close();

		String updateSQL = "UPDATE STUDENTS_OUTERNESTED_TABLE4  SET id = ?, STUDENTLASTNAME = ?, STUDENTFIRSTNAME = ?, OUTERNESTEDMASTERS = ?, LISTOFGRADEDEXAMSLISTS = ?  WHERE id=?";

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(updateSQL)) {

			stmt.setInt(1, 1);
			stmt.setString(2, "StudentLastName");
			stmt.setString(3, "StudentFirstName");
			stmt.setObject(4, serializedOuterMasterBytes);
			stmt.setObject(5, null);
			stmt.setInt(6, 1);
			Integer rowsEffectedFinalStudent = stmt.executeUpdate();
			System.out.println(rowsEffectedFinalStudent + " rowsEffectedFinalStudent prints how many rows?");
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<ArrayList<QuestionSuper>>> getOuterMasterListOfMastersSER()
			throws ClassNotFoundException, IOException, SQLException {

		String sqlRS = " SELECT id, STUDENTLASTNAME,  STUDENTFIRSTNAME, OUTERNESTEDMASTERS, "
				+ "LISTOFGRADEDEXAMSLISTS FROM STUDENTS_OUTERNESTED_TABLE4 ";

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(sqlRS);
				ResultSet rSet = stmt.executeQuery()) {
			byte[] listOfOuterMasterBytes = null;
			if (rSet.next()) { // There should be only 1 row for the outerMasterListofMastersSER
				listOfOuterMasterBytes = rSet.getBytes("OUTERNESTEDMASTERS");

				if (listOfOuterMasterBytes != null) {
					try (ByteArrayInputStream bais = new ByteArrayInputStream(listOfOuterMasterBytes);
							ObjectInputStream ois = new ObjectInputStream(bais)) {
						deserializedOuterMasterObject = (ArrayList<ArrayList<ArrayList<QuestionSuper>>>) ois
								.readObject();
						outerMasterListofMastersSER = deserializedOuterMasterObject;
					}
				}
			}
		}
		return outerMasterListofMastersSER;
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<Boolean>> getGradedOnceInnerMasterListSER()
			throws ClassNotFoundException, IOException, SQLException {
		System.out.println(" Top of getGradedOnceInnerMasterListSER() of UpdateFinalStudentExams class");

		String sqlRS = " SELECT id, STUDENTLASTNAME,  STUDENTFIRSTNAME, OUTERNESTEDMASTERS, LISTOFGRADEDEXAMSLISTS FROM STUDENTS_OUTERNESTED_TABLE4 ";

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(sqlRS);
				ResultSet rSet = stmt.executeQuery()) {
			byte[] gradeOnceBytes = null;
			rSet.next();
			gradeOnceBytes = rSet.getBytes("LISTOFGRADEDEXAMSLISTS");

			if (gradeOnceBytes != null) {
				try (ByteArrayInputStream bais = new ByteArrayInputStream(gradeOnceBytes);
						ObjectInputStream ois = new ObjectInputStream(bais)) {
					gradeOnceListOfListsSER = (ArrayList<ArrayList<Boolean>>) ois.readObject();
					System.out.println(gradeOnceListOfListsSER + " gradeOnceListOfListsSER printed here");
				}
			}
		}
		System.out.println(" Bottom of getGradedOnceInnerMasterListSER() in class UpdateFinalStudentExams");
		return gradeOnceListOfListsSER;
	}
}
