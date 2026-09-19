// Class FAQ Data formats Strings for the FAQ pane
// Class called and String variables loaded upon FAQ list selection

package main.java;

public class FAQData {
	String one;
	String two;
	String three;
	String four;
	String five;
	String six;
	String seven;
	String eight;
	String nine;
	String emptyString = "";

	public String loadFAQData(Integer selectedExamIndex) {

		one = "SELECT AN EXAM\n\n" + "After providing last and first names, an exam must first "
				+ "be selected from the combo box drop-down menu by clicking "
				+ "the down arrow. By default, the combo box lists exams as Exam 1, Exam 2, Exam 3, etc. \n\n"
				+ "Even for Exam 1, you must drop down the menu list and " + "specifically "
				+ "select the exam by name before beginning the exam.";

		two = "BEGIN AN EXAM \n\n"
				+ "Currently in this version of the program only one answer may be selected. Failure to answer any "
				+ "questions results in an automatic fail for that question. \n\n"
				+ "Click 'Begin Exam' whereupon a dialog prompts you to choose a preferred question evaluation "
				+ "timing scheme. You may choose to evaluate each question upon its completion, recommended, (click Evaluate) "
				+ "by clicking 'Yes'. An answer is selected, 'Evaluate' is clicked, and pass/fail is immediately displayed "
				+ "for immediate review along with the correct answer including detailed explanations and other "
				+ "useful and relevant information. This technique is convenient because the question is still fresh in your mind.\n\n"
				
				+ "On the other hand, you might prefer a more traditional approach and have all questions graded in bulk "
				+ "one time at the end of the exam when the 'Finish' button is selected. If that's the preferred scheme "
				+ "click 'No'. Once you begin you still click 'Evaluate' and 'Next' just as if you were taking a "
				+ "regular exam. But here you get feedback only after all questions are graded and if you "
				+ "choose to review your graded questions at a later time. \n"
				
				+ "When the exam begins and you proceed from one Question to the next the various text fields will be populated "
				+ "with information such as title, topic, question, five (5) possible mutiple-choice answers, or T/F options, "
				+ "and usually a detailed explanation. So, make your radio button selection, click 'Evaluate' and "
				+ "then click 'Next' until you reach the last question after which you must click 'Finish'. \n\n";

		three = "NAVIGATING WITH NEXT AND PREVIOUS\n\n"
				+ "When taking the exam one may only click 'Next' and move forward; you can't go backward "
				+ "during the exam in the event you change your mind about an answer or failed to make "
				+ "a selection. 'Previous' works only after the exam has finished/concluded when one "
				+ "is reviewing results of the most recent exam.";		

		four = "EVALUATE/GRADE/FINISH YOUR EXAM\n\n"
				+ "After the last question is answered click 'Finish' at which point your correct and "
				+ "incorrect answers are added up and calculated. Then a dialog pop-up will inform you of your grade "
				+ "and whether you passed or failed.\n\n"
				+ "You may take any exam multiple times, and while all will be saved, "
				+ "only the most recent exam is reviewable (see REVIEW GRADED EXAMS). ";
		
		five = "REVIEW GRADED EXAMS\n\n"
				+ "Once the exam is finished and graded the user may review the most recent exam in the "
				+ "'Question Preview - Exams - Review of Questions' panel. "
				+ "In the 'Review Most Recent Graded Exams' pane, select the exam from the list at which time two (2) tables "
				+ "are populated. To the immediate right in the 'Review of Questions' table the question number, pass/fail grade and topic "
				+ "for that exam are filled. \n\nImmediately above in the skinny horizontal table additional information is presented regarding the most recent "
				+ "exam, such as title, date of exam, times taken, latest score, and number of correct answers.\n\n"
				+ "Clicking 'Delete Exam' does just that and deletes an exam beginning with the earliest exam, the oldest.\n\n";

		six = "INDIVIDUAL EXAM DETAILS\n\n"
				+ "After selecting a finished exam from the list, note the radio button labeled 'R' (for Review) "
				+ "to the immediate left of each vertical table row. Clicking the button that corresponds to a question number "
				+ "will populate not only the more reader-friendly large preview pane with data, but also the question and "
				+ "answer rows, and detailed explanations. Additionally, it will display your radio button selections, "
				+ "over on the left-hand side of your screen.";

		seven = "TROUBLE-SHOOTING PROBLEMS - such as db already running when selecting an exam from the"
				+ " combobox drop-down menu. Solution - Shut down the app and start it back up";

		eight = "Something else";
		
		nine = "Misc.";

		if (selectedExamIndex == 1) {
			return one;
		} else if (selectedExamIndex == 2) {
			return two;
		} else if (selectedExamIndex == 3) {
			return three;
		} else if (selectedExamIndex == 4) {
			return four;
		} else if (selectedExamIndex == 5) {
			return five;
		} else if (selectedExamIndex == 6) {
			return six;
		} else if (selectedExamIndex == 7) {
			return seven;
		} else if (selectedExamIndex == 8) {
			return eight;
		} else if (selectedExamIndex == 9) {
			return nine;
		}
		return emptyString;
	}
}
