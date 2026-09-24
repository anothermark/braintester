
// Keep for now, but I don't recall where it is used
// Not in Builder or Tester, and it uses incorrect table.
// Retain for now to make certain. 

package main.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

// I MIGHT (or probably not) BE USING THIS, ESPECIALLY THE setOriginalProfExams() METHOD. DOUBLE CHECK

public class PopulateTesterRows {

	// I think this is one is important, or maybe not. Double check
	public void populateInitialRowsTester(Integer selectedExamIndex,
			ArrayList<ArrayList<QuestionSuper>> masterGradedList) throws SQLException, IOException, ClassNotFoundException {

		// THIS INITIALLY POPULATES THE PROF'S ORIGINALS, but why is it in Tester,
		// and note it's an old table, TESTER_EXAMS_LIST_3

		String insertSQL = "INSERT INTO TESTER_EXAMS_LIST_3 (id, EXAM_NUMBER, "
				+ "STUDENTLASTNAME,  LISTOFQUESTIONS, LISTOFGRADEDEXAMSLISTS ) VALUES(?, ?, ?, ?, ?)";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(masterGradedList);
			byte[] serializedObjectBytes = baos.toByteArray();
			oos.close();

			stmt.setInt(1, 0); // this maps to the selectedExamIndex from first JList ?
			stmt.setInt(2, 0);
			stmt.setString(3, "FILLER LAST NAME");
			stmt.setObject(4, null);
			// masterlistoflists
			stmt.setObject(5, serializedObjectBytes);
			int rowsEffected2 = stmt.executeUpdate();
			System.out.println(rowsEffected2 + " rowsEffected2 original prof table");
		}
		System.out.println(
				"Bottom of populateInitialRowsTester() of the PopulateTesterRows class which inserts the initial nothing rows placeholders");
	}

//I MIGHT BE USING THIS, ESPECIALLY THE setOriginalProfExams() METHOD. DOUBLE CHECK, and clean up
	// Although it uses an outdated table TESTER_EXAMS_LIST_3 - caveat
	public void setOriginalProfExams(Integer selectedExamIndex, ArrayList<ArrayList<QuestionSuper>> masterGradedList)
			throws SQLException, IOException, ClassNotFoundException {
		System.out.println("Top of setOriginalProfExams() of the PopulateTesterRows class");
		// Here is where the prof sets the final exams for the student to retrieve,
		// except that it is an old table TESTER_EXAMS_LIST_3 instead of the latest
		// TESTER_EXAMS_LIST_4
		String insertSQL = "INSERT INTO TESTER_EXAMS_LIST_3 (id, EXAM_NUMBER, "
				+ "STUDENTLASTNAME,  LISTOFQUESTIONS, LISTOFGRADEDEXAMSLISTS ) VALUES(?, ?, ?, ?, ?)";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement(insertSQL)) {

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(masterGradedList);
			byte[] serializedObjectBytes = baos.toByteArray();
			oos.close();

			stmt.setInt(1, 0); // this maps to the selectedExamIndex from first JList, and
			stmt.setInt(2, 0);
			stmt.setString(3, "LastName");
			stmt.setObject(4, null);
			// my masterlistoflists
			stmt.setObject(5, serializedObjectBytes);

			int rowsEffected2 = stmt.executeUpdate();
			System.out.println(rowsEffected2 + " RowsEffected master Original tester table");
		}
		System.out.println("Bottom of setOriginalProfExams() of the PopulateTesterRows class");
		// return listOfQuestionsSER;

	}

}
