
// Keep for now. Does not use Students_Graded_Exams_Table2 in builder
// or tester. Track this down. 
// Seems important

package main.java;

import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewStudentExam {

	Integer selectedExamIndex;
	Integer studentPrimaryKey;
	ArrayList<QuestionSuper> listOfQuestionsSER;
	ArrayList<ArrayList<QuestionSuper>> masterListOfQuestionsSER;
	ArrayList<ArrayList<QuestionSuper>> deserializedObject;

	@SuppressWarnings("unchecked")
	// StudentPrimaryKey is not used anymore
	public ArrayList<ArrayList<QuestionSuper>> getStudentFinalRowData(Integer studentPrimaryKey) //
			throws IOException, SQLException, ClassNotFoundException {
		System.out.println("Top of ReviewStudentExam class' getStudentFinalRowData() method");		

		String sqlRS = " SELECT id, STUDENTLASTNAME,  STUDENTFIRSTNAME, LISTOFQUESTIONS, LISTOFGRADEDEXAMSLISTS FROM Students_Graded_Exams_Table2 ";

		try(Connection conn = DatabaseConfig.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sqlRS);		
		ResultSet rs = stmt.executeQuery()){		
		byte[] listOfMasterBytes = null;
		// For testing only?
		var builderDBTesterUtility = new BuilderDBTesterUtility();
		System.out
				.println(builderDBTesterUtility.getRowCountStudentsFinalGraded() + " RS rowcount StudentsFinalGraded");
		PrintedRowSoBreak: while (rs.next()) {
			int id = rs.getInt("id");

			if (id == 0) {
				String STUDENTLASTNAME = rs.getString("STUDENTLASTNAME");
				System.out.println(id + " id printed");
				System.out.println(STUDENTLASTNAME + " STUDENTLASTNAME printed");
				listOfMasterBytes = rs.getBytes("LISTOFGRADEDEXAMSLISTS");				

				if (listOfMasterBytes != null) {
					try (ByteArrayInputStream bais = new ByteArrayInputStream(listOfMasterBytes);
							ObjectInputStream ois = new ObjectInputStream(bais)) {
						deserializedObject = (ArrayList<ArrayList<QuestionSuper>>) ois.readObject();
					} catch (EOFException ef) {
						System.out.println("EOFException in getStudentFinalRowData() method");
					}
					masterListOfQuestionsSER = deserializedObject;
					// But we don't use a studentPrimaryKey anymore. Did selectedExamIndex replace it?
					listOfQuestionsSER = masterListOfQuestionsSER.get(studentPrimaryKey);
					break PrintedRowSoBreak;
				}
			}			
		}
		System.out.println("Bottom of ReviewStudentExam class' getStudentFinalRowData() method");
		}
		return masterListOfQuestionsSER;
	}
}
