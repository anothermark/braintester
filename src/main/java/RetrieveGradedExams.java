// Keep, used in Tester, does not show up in Builder main.

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

public class RetrieveGradedExams {
	// This method gets a lot of use as it is used to
	// display the initial questions, next, previous, in the begin button, and
	// evaluate and more
	ArrayList<QuestionSuper> listOfQuestionsSER;
	Integer selectedExamIndex;
	ArrayList<QuestionSuper> deserializedObject;

	@SuppressWarnings("unchecked")
	public ArrayList<QuestionSuper> getGradedExam(Integer selectedExamIndex)
			throws SQLException, ClassNotFoundException, IOException {
		System.out.println("Top of RetrieveGradedExams class getGradedExam() method");

		String sqlRS = " SELECT id, EXAM_NUMBER,  STUDENTLASTNAME, LISTOFQUESTIONS, LISTOFGRADEDEXAMSLISTS FROM FINAL_GRADED_EXAMS_2 ";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlRS);
				ResultSet rs = stmt.executeQuery()) {
			byte[] listOfQBytes = null;
			// For trouble-shoot only?
			var builderDBTesterUtility = new BuilderDBTesterUtility();
			System.out.println(builderDBTesterUtility.getGradedRowCount() + " RS rowcount  is .... got to here 4-20");

			PrintedRowSoBreak: while (rs.next()) {
				int id = rs.getInt("id");

				if (id == selectedExamIndex + 1) {
					int EXAM_NUMBER = rs.getInt("EXAM_NUMBER");// Probably remove now
					String STUDENTLASTNAME = rs.getString("STUDENTLASTNAME");// Probably remove now
					listOfQBytes = rs.getBytes("LISTOFQUESTIONS");

					if (listOfQBytes != null) {
						try (ByteArrayInputStream bais = new ByteArrayInputStream(listOfQBytes);
								ObjectInputStream ois = new ObjectInputStream(bais)) {
							deserializedObject = (ArrayList<QuestionSuper>) ois.readObject();
						} catch (EOFException ef) {
							System.out.println("EOFException in getGradedExam() method");
						}
						listOfQuestionsSER = deserializedObject;
						break PrintedRowSoBreak;
					}
				}
			}
		}
		System.out.println("Bottom of RetrieveGradedExams class' getGradedExam() method");
		return listOfQuestionsSER;
	}
}
