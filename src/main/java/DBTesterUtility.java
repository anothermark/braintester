
// Gets row counts, deletes rows, displays db info.
// Used in both Builder(?) and Tester. 

package main.java;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBTesterUtility implements Serializable {
	Integer numberOfAdditionalQuestions;
	Integer selectedExamIndex;
	int count;
	PreparedStatement stmt;
	ArrayList<ArrayList<QuestionSuper>> innerMasterListOfQuestionsSER;
	ArrayList<ArrayList<ArrayList<QuestionSuper>>> outerMasterListOfMastersSER;

	public Integer getRowCount() throws IOException, SQLException, ClassNotFoundException {
		System.out.println("Top of getRowCount() of class DBTesterUtility");
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(" SELECT COUNT(*) AS rowcount FROM TESTER_EXAMS_LIST_4")) {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " What rs.getInt(1) returns, ie the count");
				count = rs.getInt(1);
				System.out.println("This table contains " + count + " rows");
			}
			return count;
		}
	}

	public Integer getRowCountFinalGraded() throws IOException, SQLException, ClassNotFoundException {
		System.out.println("Top of getRowCountFinalGraded() of class DBTesterUtility");
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(" SELECT COUNT(*) AS rowcount FROM FINAL_GRADED_EXAMS_2")) {
			while (rs.next()) {
				System.out
						.println(rs.getInt(1) + " What rs.getInt(1) returns, ie the count in getRowCountFinalGraded()");
				count = rs.getInt(1);
				System.out.println("This table contains " + count + " rows");
			}
			return count;
		}
	}

	public void deleteRows(Integer selectedExamIndex) throws IOException, SQLException, ClassNotFoundException {
		System.out.println("Top of deleteRows() of class DBTesterUtility");
		String sqlDeleteRows = " DELETE FROM TESTER_EXAMS_LIST_4 WHERE id = selectedExamIndex";
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(sqlDeleteRows)) {
			int affectedRows123 = stmt.executeUpdate();
			System.out.println(affectedRows123 + " Number of affectedRows123");
		}
	}

	// Used in development, not deployment. Probably remove.
	public void displayDBInfo() throws IOException, SQLException, ClassNotFoundException {
		String sqlRS = " SELECT * FROM TESTER_EXAMS_LIST_4 ";
		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(sqlRS);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				System.out.println(rs.getInt(1) + " Prints what rs.getInt(1) returns.");
			}
		}
	}

	public ArrayList<ArrayList<QuestionSuper>> deleteGradedRowInReview(Integer selectedExamIndex,
			ArrayList<ArrayList<QuestionSuper>> innerMasterListOfQuestionsSER)
			throws SQLException, ClassNotFoundException, IOException {
		System.out.println("Top of deleteGradedRowInReview in class DBTesterUtility");
		innerMasterListOfQuestionsSER.removeFirst();
		return innerMasterListOfQuestionsSER;
	}
}
