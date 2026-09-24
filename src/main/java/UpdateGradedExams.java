// Class UpdateGradedExams receives graded listOfQuestionsSER from Begin Exam button
// But am I even still using the FINAL_GRADED_EXAMS_2 table? Yes. 
// Where is it called from? From the 'Begin Exam' button in Tester, but
// is FINAL_GRADED_EXAMS_2 table in the third table in the chain of placeholders?

package main.java;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UpdateGradedExams {
	ArrayList<QuestionSuper> listOfQuestionsSER;
	// Unfortunately the method is singular of the class name which is plural, and
	// easy to confuse.
	public void updateGradedExam(Integer selectedExamIndex, ArrayList<QuestionSuper> listOfQuestionsSER,
			String lastNameStudent) throws IOException, SQLException, ClassNotFoundException {
		System.out.println("Top of updateGradedExam() method of the UpdateGradedExams class ");

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(listOfQuestionsSER);
		byte[] serializedObjectBytes = baos.toByteArray();
		oos.close();

		String updateSQL = "UPDATE FINAL_GRADED_EXAMS_2  SET id = ?, EXAM_NUMBER =?, STUDENTLASTNAME = ?,"
				+ "LISTOFQUESTIONS = ?, LISTOFGRADEDEXAMSLISTS = ?  WHERE id=?";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement(updateSQL)) {

			stmt.setInt(1, selectedExamIndex + 1);
			stmt.setInt(2, selectedExamIndex + 1);
			stmt.setString(3, lastNameStudent);
			stmt.setObject(4, serializedObjectBytes);
			stmt.setObject(5, null);
			stmt.setInt(6, selectedExamIndex + 1);
			int rowsEffected2 = stmt.executeUpdate();

			System.out.println(rowsEffected2 + " RowsEffected from update() is mjieu589475");
		}
		System.out.println("Bottom of updateGradedExam method in UpdateGradedExams class");
	}
}
