
// Not used anymore but keep for future reference, and just in case
// This might not be necessary as it uses old TESTER_EXAMS_LIST_3
// Who calls it? Maybe remove? Do not clean up.

// lost, double-check, but don't throw out just yet. Uses masterGradedList.
// Not found in builder or tester

package main.java;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

//import main.java.badclasses.RetrieveRowData2B;

// TUE I THINK THIS IS THE ORIGANAL INSERTED BY PROF, NOT THE FINAL GRADED
public class InsertGraded {
	static ArrayList<ArrayList<QuestionSuper>> masterGradedList = new ArrayList<>();
	ArrayList<QuestionSuper> listOfQuestionsSER;

	public void insertGradedMasterList() throws SQLException, IOException {
		System.out.println(listOfQuestionsSER + " listOfQuestionsSER is it null? Yes sunday, top of method");
		//var retrieveRowData = new RetrieveRowData2B();// from tester

		// TUE I DON'T NEED THIS BELOW STUFF CAUSE I'VE ALEADY CREATED NULL LOADED
		// MASTERLIST TO INSERT IN THE NEEW PopulateTesterRows CLASS
		//listOfQuestionsSER = retrieveRowData.getRowData();
		System.out.println(
				listOfQuestionsSER + " listOfQuestionsSER should not be null now cause just retrieved from builder db");
		masterGradedList.add(null);
		// masterGradedList.set(0, listOfQuestionsSER);
		System.out.println(masterGradedList
				+ " THUR I'm in the insertGraded class after adding one listOfQuestionsSER. Is it " + "in there? Yes");

// #############################################################################################################################		
		// SUNDAY SO HERE IS THE PROBLEM - I THINK - like my first swing project, the
		// retrieved listOfQuestionsSER
		// is not getting assigned set to the global listOfQuestionsSER of the Tester
		// page. so the
		// listOfQuestionsSER with the default is getting sent over there, not the
		// retrieved o0ne with one
		// with the new one and two anon questions in it
		// SUND CONT. SO HOW DO i SEND THAT NEW listOfQuestionsSER INTO this
		// insertGradedMasterList() method?
		//

		// DON'T FORGET TO ADD ALL THE OTHER COLUMN INFORMATION
		// like primary key, exam number, student name and list of Questions (maybe not)
		// and
		// the master list of lists

		// handy
		// String createTableSQLT = "CREATE TABLE TESTER_EXAMS_LIST_1 ("
		// + "id Integer NOT NULL," // primary key
		// + "EXAM_NUMBER Integer NOT NULL," // probably the same as primary key?
		// + "STUDENTLASTNAME VARCHAR(100),"
		// + "LISTOFQUESTIONS JAVA_OBJECT(10000) ," // I'm allowing null. Is that bad?
		// This one will be null cause using
		// list of lists if it will let me
		// + "LISTOFGRADEDEXAMSLISTS JAVA_OBJECT(10000) "
		// + ");";

		String insertSQL = "INSERT INTO TESTER_EXAMS_LIST_3 (id, EXAM_NUMBER, "
				+ "STUDENTLASTNAME,  LISTOFQUESTIONS, LISTOFGRADEDEXAMSLISTS ) VALUES(?, ?, ?, ?, ?)";

		try(Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		PreparedStatement stmt = conn.prepareStatement(insertSQL)){

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
		System.out.println(rowsEffected2 + " RowsEffected master table");

		System.out.println("Bottom of insertGradedMasterList populateRows() method");
		// return listOfQuestionsSER;

		// sunday let's try calling
		}
	}// end of method

	// TUE THIS COULD BE WHAT I GOT WRONG. i JUST ADDED THIS COPIED FROM BUILDER
	// INSERT CLASS

	public void updateRowsTester(Integer selectedExamIndex, ArrayList<ArrayList<QuestionSuper>> masterGradedList)
			throws SQLException, IOException, ClassNotFoundException {

		System.out.println("Top of InsertlistOfQuestionsSERtoDB THE NEW updateRows() method");

		System.out.println(masterGradedList + " What does this masterGradedList print 	TUE? ");

// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
//  FOR SUNDAY FIGURE OUT WHY THE FIRST QUESTION IN SECOND EXAM ISN'T GETTING SET !!!!!

// $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(masterGradedList);
		byte[] serializedObjectBytes = baos.toByteArray();
		oos.close();

		String updateSQL = "UPDATE TESTER_EXAMS_LIST_3  SET id = ?, EXAM_NUMBER =?, STUDENTLASTNAME = ?,"
				+ "LISTOFQUESTIONS = ?, LISTOFGRADEDEXAMSLISTS = ?  WHERE id=?";

		try(Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		PreparedStatement stmt = conn.prepareStatement(updateSQL)){

//  SAturday huge, huge lesson. I HAVE TO SET ALL FIVE PARAMETERS EVEN IF I'M ONLY CHANGING/UPDATING ONE VALUE
		stmt.setInt(1, selectedExamIndex);
		stmt.setInt(2, selectedExamIndex);
		stmt.setString(3, "LastName");
		stmt.setObject(4, null);
		stmt.setObject(5, serializedObjectBytes);// i think wrong re serializedObjectBytes
		stmt.setInt(6, selectedExamIndex);

		int rowsEffected2 = stmt.executeUpdate();

		System.out.println(rowsEffected2 + " RowsEffected TUE");
		}
		System.out.println("Bottom of InsertlistOfQuestionsSERtoDB updateRows() method");

	}

}
