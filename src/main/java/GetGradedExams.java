
// Bogus because of masterGradedList but keep anyway - lots of info in there. 
// Do not clean up.

package main.java;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

// Do not clean up. Keep, but do not use because I believe it is bogus. Read below
// THIS GETS THE MASTERLIST OF LISTSd and should print the info out
// THUR DANGER DANGER DANGER THIS IS ALL BOGUS AND YOU NEED TO START FROM SCRATCH
// WITH THE BEGIN BUTTON
// getMasterGradedList is called from CheckBoolListIfCorrect but I don't need it cause it returns a masterlist.
// should I do a new one that returns a serlist? or a boolean list of the prof's correcdt answers? so confused

public class GetGradedExams {

	ArrayList<ArrayList<QuestionSuper>> masterGradedList;
	ArrayList<ArrayList<QuestionSuper>> deserializedObject;

	
	//SAT 1-17-26 THIS JUST RETURNS THE MASTERLIST SO DISREGARD. ALL BOGUS. I'M USING THE
	// SERLIST THAT IS PULLED UP IN THE EVALUATE BUTTON?
	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<QuestionSuper>> getMasterGradedList() throws IOException, SQLException, ClassNotFoundException {

		// WED DANGER, DANGER. YOU HAVE TO FIRST PULL THE NESTED LIST OUT OF THE MASTER
		// LIST, DUMMY

		//

		System.out.println("Top of GetGradedExams getMasterGradedList() method in Tester");
		// this.selectedExamIndex = selectedExamIndex;

		// handy
		// id, EXAM_NUMBER, "
		// + "STUDENTLASTNAME, LISTOFQUESTIONS, LISTOFGRADEDEXAMSLISTS )
		String sqlRS = " SELECT id, EXAM_NUMBER, STUDENTLASTNAME, LISTOFQUESTIONS, LISTOFGRADEDEXAMSLISTS FROM TESTER_EXAMS_LIST_4 ";

		try(Connection conn = DatabaseConfig.getConnection();
		PreparedStatement stmt = conn.prepareStatement(sqlRS);
		ResultSet rs = stmt.executeQuery()){

		byte[] masterListOfQBytes = null;

		// i DON'T THINK I NEED THIS loop for now. Just want the first one
		// while (rs.next()) {

		// while(rs.next()) {
		rs.next();
		System.out.println(" Now I'm inside the while using the TESTER_EXAMS_LIST_4 table");
		int id = rs.getInt("id");
		System.out.println(id + " id should be 0");

		// System.out.println(" 2");
		if (id == 0) {
			// System.out.println(" 3");
			int EXAM_NUMBER = rs.getInt("EXAM_NUMBER");
			System.out.println(EXAM_NUMBER + " TUE - but does this print the  the EXAM_NUMBER?");

			// System.out.println(" 4");
			String lastName = rs.getString("STUDENTLASTNAME");
			System.out.println(lastName + " WED - but does this printy the STUDENTLASTNAME?");

			masterListOfQBytes = rs.getBytes("LISTOFGRADEDEXAMSLISTS");
			System.out
					.println(masterListOfQBytes + " WED masterListOfQBytes array should print a listoflists object? ");
			System.out.println(" 5");

			// WED MAJOR CHANGE, THIS CODE MUST BE USED FOR THE MASTER LIST INSTEAD OF THE
			// QUESTIONS LIST
			if (masterListOfQBytes != null) {
				System.out.println(" 5B");
				try (ByteArrayInputStream bais = new ByteArrayInputStream(masterListOfQBytes);
						ObjectInputStream ois = new ObjectInputStream(bais)) {
					System.out.println(" 5C");

					System.out.println("sun I'm in the GetGradedExam class");

// %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%						
					
// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&

					deserializedObject = (ArrayList<ArrayList<QuestionSuper>>) ois.readObject(); // i r emoved
																									// deserializedObject
																									// = = temp
					System.out.println(" 6");

				} catch (ClassNotFoundException ef) {
					ef.printStackTrace();
					// System.out.println("EOFException in getRowData() method");
					System.out.println("stumped");
				}
// &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&				
				// SUNDAY DANG IT, WHY ARE THESE NULL????
				System.out.println(deserializedObject);
				System.out.println(masterGradedList);
				// PRINTS [NULL, NULL, NULL]
				// this thing is null and I'm returning null
				System.out.println(" 7");

				masterGradedList = deserializedObject;

				// WED THIS IS SUPPOSED TO
				// THUR THIS IS THROWING A NULLPOINTER CAUSE THERE IS NO NESTED LIST IN THERE
				// and there shouldn't be over in builder cause it doesn't have the master list
				// so
				// I need to add that nested list somewhere
				System.out.println(deserializedObject
						+ " deserializedObject should print null because of stmt.setObject(4, null);");
				System.out.println(masterGradedList + " masterGradedList prints null");

				// SUNDAY THROWS NULLPOINTER
				// SUNDAY HUGE HUGE PROBLEM. IT'S NOT SETTING THE NEXTED ARRAY

				// sunday why isn't it adding the nested array???

				System.out.println(masterGradedList.get(0) + "  nope, throws nullpointer so i have no mastergradedlist"
						+ " so why did it mastergradedlist not get set???");

				

			} // end of if
			System.out.println(" 8");

			System.out.println(EXAM_NUMBER + " printing EXAM_NUMBER from getMasterGradedList");

			

		} // XMAS END OF IF TO TEST IF id == if id == selectedExamIndex

		System.out.println("Bottom of getMasterGradedList method IN GetGradedExams");

		// return listOfQuestionsSER;

		return masterGradedList;
		}
	}

}
