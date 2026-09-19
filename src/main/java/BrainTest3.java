
// Licenses: 
// Copyright: MKS (2025 - 2026)

package main.java;

import java.util.prefs.BackingStoreException;
import java.util.prefs.Preferences;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Point;

import javax.swing.InputVerifier;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.JTextArea;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.DefaultCaret;
import javax.swing.text.JTextComponent;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.border.LineBorder;
import javax.swing.AbstractListModel;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;

public class BrainTest3 extends JDialog {
	
	private static final long serialVersionUID = -1970291761632341584L;

	private static final String PREF_KEY = "show_message";
	private static final Preferences prefs =
	Preferences.userNodeForPackage(BrainTest3.class);
	
	boolean isCurrentExamFinished = true;

	Integer qNumForButton;
	Integer currentExamIndex;
	Integer selectedExamIndex;
	Integer selectedIndexExamNumber;
	Integer selectedExamNumber;
	Integer selectedExamList;
	Integer selectedExamIndexInteger;
	Integer sizeOfFirstSerList;
	Integer sizeOfSerList;
	Integer countingRows;
	Integer NumberOfExams = 0;
	Integer rowCountComboInt;
	Integer numPass = 0;
	Integer selected = 0;
	Integer questionNumber2;
	Integer questionIndex = 0;
	Integer examNumber;
	Integer numberOfRows;
	Integer selectable = 1; // (Say what?) How many answers can be selected (required) over in the BUILDER
							// !!!!!!!!

	static Integer countEval = 0;
	static Integer indexOfSelected = null;
	static Integer qIndex = 0; // This is the index of the question in the listOfQuestionsSER
	static Integer qNumber = 1;// This is the question number which will be qIndex + 1 set below
	static Integer qNumberBegin = 0; // don't use this
	static Integer indexQTempList = 0;

	int switchCheckerCorrect;
	int switchCheckerIncorrect;
	static int questionNumber;
	static int qCount = 0;
	static int questionNumberBeingEvaluated = 0;

	Double percentGrade;

	Boolean isTheExamFinished = false;
	Boolean noSelectionMade;
	Boolean isQGraded;
	boolean evalGradeImmediately;
	boolean evalGradesEndOfExam;
	Boolean isExamStarted = false;
	Boolean isQuestionGraded;
	static Boolean isCompletedQ = false;

	QuestionSuper questionObject;
	ButtonGroup aGroup;
	DBTesterUtility dBTesterUtility;
	LocalTime nowBegin;
	LocalTime nowEnd;
	LocalDate todayDate;
	EvaluateAnswersLists evaluateAnswersLists;
	ExamComboLabelsTester comboLabels;
	ExamComboLabelsTester examComboLabelsTester;
	ExamComboLabelsTester exComboLabelsTes;

	private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("hh:mm:ss");

	String trueBool1 = "";
	String trueBool2 = "";
	String trueBool3 = "";
	String trueBool4 = "";
	String trueBool5 = "";

	String correctAnswer0 = "";
	String correctAnswer1 = "";
	String correctAnswer2 = "";
	String correctAnswer3 = "";
	String correctAnswer4 = "";

	String exam1;
	String exam2;
	String exam3;
	String exam4;
	String exam5;
	String exam6;
	String exam7;
	String exam8;
	String exam9;
	String exam10;

	String finalStr;
	String finalStrX = "";
	String dateOfExamStr;

	String passFail;
	String passOrFail;
	String topic;
	String lastName;
	String firstName;
	String selectedValue;
	String selectedIndexExamString;
	String previouslySelectedCommand;
	String prevSelectCommandChk = null;
	String qPassFailMessage;

	ArrayList<ArrayList<QuestionSuper>> innerMasterListOfQuestionsSER;
	ArrayList<ArrayList<ArrayList<QuestionSuper>>> outerMasterListOfMastersSER;
	ArrayList<ArrayList<ArrayList<Boolean>>> outerMasterCorrectAnswersProfs;
	ArrayList<ArrayList<ArrayList<QuestionSuper>>> outerMasterListofMastersSER;
	ArrayList<ArrayList<ArrayList<QuestionSuper>>> deserializedOuterMasterObject;
	ArrayList<ArrayList<QuestionSuper>> deserializedInnerMasterObject;
	ArrayList<ArrayList<Boolean>> gradeOnceListOfListsSER;
	ArrayList<ArrayList<Boolean>> masterListOfProfsCorrectAnswers;
	ArrayList<ArrayList<QuestionSuper>> masterListOfQuestionsSER;
	ArrayList<QuestionSuper> listOfQuestionsSER;
	ArrayList<Boolean> profCorrectAnswers;
	ArrayList<Boolean> theProfsCorrectAnswers;
	// Don't think this is used
	// ArrayList<Boolean> gradedBoolList = new ArrayList<Boolean>();

	ArrayList<QuestionSuper> gradedQuestionsListSER;
	ArrayList<ArrayList<QuestionSuper>> innerMasterListOfMastersSER;
	ArrayList<QuestionSuper> previousListOfQuestionsSER;
	static ArrayList<Boolean> testIfNoSelect;

	JTextPane textPane;
	JTextArea textArea_1;
	JTextArea txtAreaQuestion;
	JTextArea textAreaAns1;
	JTextArea textAreaAns2;
	JTextArea textAreaAns3;
	JTextArea textAreaAns4;
	JTextArea textAreaAns5;
	JTextArea textAreaQEvaluated;
	JTextArea textAreaExplanation;

	private final JPanel contentPanel = new JPanel();

	private JTextField textFieldExTitle;
	private JTextField textFieldTopic;
	private JTextField textFieldExNumber;
	private JTextField textFieldQNum;
	private JTextField textFieldLastName;
	private JTextField textFieldPassOrFail;
	private JTextField textFieldQuestNum;

	String prevQTitle;
	String prevQTopic;
	String prevQuestion;
	String prevAns1;
	String prevAns2;
	String prevAns3;
	String prevAns4;
	String prevAns5;
	String prevCorrectAns1;
	String prevCorrectAns2;
	String prevCorrectAns3;
	String prevCorrectAns4;
	String prevCorrectAns5;
	String prevExplanation;

	private JTable table;
	private JTextField textFieldStudentFirstName;
	private JTextField textFieldDateTime;
	private JTextField textFieldStartTime;
	private JTextField textFieldEndTime;
	private JTextField textFieldTime;
	private JTable tableReviewExam;
	private JTextField textFieldNumExams;
	private JTextField textFieldNumQueInExam;
	private JTextField textFieldComboRows;

	String exam1LabelStr = "";
	String exam2LabelStr = "";
	String exam3LabelStr = "";
	String exam4LabelStr = "";
	String exam5LabelStr = "";
	String exam6LabelStr = "";
	String exam7LabelStr = "";
	String exam8LabelStr = "";
	String exam9LabelStr = "";
	String exam10LabelStr = "";

	/**
	 * Launch the application
	 * 
	 * @throws BackingStoreException
	 * @throws SQLException
	 */
	public static void main(String[] args) throws BackingStoreException, SQLException {
		System.out.println("Top of The main() method");
		try {
			BrainTest3 dialog = new BrainTest3();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setLocation(50, 15);
			dialog.setVisible(true);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		 if (!prefs.getBoolean(PREF_KEY, true)) {
		 prefs.clear();
		 return;
		 }
		JCheckBox checkBox2 = new JCheckBox("Don't show this message again");
		Object[] message2 = { "After last and first names are entered, to take an exam you must first select \n"
				+ "it (click the down-arrow) from the drop-down menu in the combo box. Then, click \n"
				+ "'Begin Exam' upon which you will be asked to choose an evaluation \n"
				+ "method. \n\nWhen questions are presented, after selecting your answer, click 'Evaluate' \n"
				+ "and then 'Next' until you have completed the exam. Remember, failure to answer a \n"
				+ "question results in a 'fail' as you are prohibited from returning to previous \n"
				+ "unanswered questions. Then, click 'Finish'. For a more comprehensive explanation \n"
				+ "of the process, including how to review your most recent graded exam, please visit the FAQ panel. \n",
				checkBox2 };
		int result = JOptionPane.showConfirmDialog(null, message2, "Intro", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		 if (result == JOptionPane.OK_OPTION && checkBox2.isSelected()) {
		 prefs.putBoolean(PREF_KEY, false);
		 prefs.clear();
		 System.out.println("User checked don't show again");
		 }
		// ################################################################################################################
		// KEEP THIS deleteExamsComboRows() below. IT SAVED MY HIDE A FEW TIMES because
		// I was locked out because I had
		// an older obsolete version of the class object in the db table, serialversion
		// incompatability problems with no way to delete that row because I could not
		// get to the
		// apps delete-that-row-button, so that I could use a modified version
		// of the class object. If that happens, uncomment this and compile and run the
		// program, and that should empty out that table and you are good to go.
		// But after you are done remember to re-comment it again or nothing
		// happens because your row keeps getting deleted.
		// ##############################################################################################
		/*
		 * var loadInitComboLabelTester = new LoadInitComboLabelTester();
		 * System.out.println(loadInitComboLabelTester.deleteExamsComboRows() +
		 * " deleteExamsComboRows() ksr");
		 * System.out.println(loadInitComboLabelTester.rowCountComboLabels() +
		 * " IT WORKED, rowCountComboLabels() lgoi");
		 */
		// ################################################################################################
	}

	/**
	 * Create the dialog.
	 * 
	 * @throws IOException
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */

	public BrainTest3() throws IOException, ClassNotFoundException, SQLException {
		setBounds(100, 30, 1420, 850);
		getContentPane().setLayout(null);

		var selectionSaver = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Top of ActionListener re previouslySelectedCommand at top of BrainTest3.");
				if (listOfQuestionsSER == null) {
					JOptionPane.showMessageDialog(null, "Before you can select an answer you must first pick \n"
							+ "an exam from the drop-down list and then click 'Begin Exam'.");
					aGroup.clearSelection();
				} else {
					previouslySelectedCommand = e.getActionCommand();
					System.out.println(previouslySelectedCommand + " previouslySelectedCommand jpeoutr94854");
					prevSelectCommandChk = listOfQuestionsSER.get(qIndex).getSelectedCommand();
					System.out.println(prevSelectCommandChk + " prevSelectCommandChk jpeoutdke74854");
					if (prevSelectCommandChk == null) {
						listOfQuestionsSER.get(qIndex).setSelectedCommand(previouslySelectedCommand);
						System.out.println(listOfQuestionsSER.get(qIndex).getSelectedCommand() + " poiet98c45");
					} else {						
						listOfQuestionsSER.get(qIndex).setSelectedCommand(previouslySelectedCommand);
						System.out.println(listOfQuestionsSER.get(qIndex).getSelectedCommand() + " ksjfieur");
					}
				}
			}
		};

		aGroup = new ButtonGroup();
		JRadioButton radioBtn1 = new JRadioButton("");
		radioBtn1.setActionCommand("Option1");
		radioBtn1.addActionListener(selectionSaver);
		radioBtn1.setBackground(new Color(255, 255, 255));
		radioBtn1.setBounds(12, 251, 21, 21);
		aGroup.add(radioBtn1);
		getContentPane().add(radioBtn1);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(39, 626, 350, 70);
		getContentPane().add(scrollPane);

		textAreaExplanation = new JTextArea();
		textAreaExplanation.setWrapStyleWord(true);
		textAreaExplanation.setLineWrap(true);
		DefaultCaret caretExpl = (DefaultCaret) textAreaExplanation.getCaret();
		caretExpl.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		textAreaExplanation.setLocation(39, 0);

		textAreaExplanation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(textAreaExplanation);
		textAreaExplanation.setBackground(new Color(255, 255, 255));
		textAreaExplanation.setMargin(new Insets(10, 10, 10, 10));
	
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_2.setBounds(39, 463, 350, 74);		
		getContentPane().add(scrollPane_2);

		textAreaAns4 = new JTextArea();
		DefaultCaret caret4 = (DefaultCaret) textAreaAns4.getCaret();
		caret4.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		textAreaAns4.setLocation(39, 0);
		textAreaAns4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAns4.setEditable(false);
		textAreaAns4.setWrapStyleWord(true);
		textAreaAns4.setLineWrap(true);
		textAreaAns4.setMargin(new Insets(5, 5, 5, 5));
		scrollPane_2.setViewportView(textAreaAns4);
		textAreaAns4.setBackground(new Color(255, 255, 255));

		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_5.setBounds(39, 383, 350, 74);
		getContentPane().add(scrollPane_5);

		textAreaAns3 = new JTextArea();
		DefaultCaret caret3 = (DefaultCaret) textAreaAns3.getCaret();
		caret3.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		textAreaAns3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAns3.setEditable(false);
		textAreaAns3.setWrapStyleWord(true);
		textAreaAns3.setLineWrap(true);
		textAreaAns3.setMargin(new Insets(5, 5, 5, 5));
		scrollPane_5.setViewportView(textAreaAns3);
		textAreaAns3.setBackground(new Color(255, 255, 255));

		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_4.setBounds(39, 304, 350, 74);
		getContentPane().add(scrollPane_4);

		JScrollPane scrollPane_10 = new JScrollPane();
		scrollPane_10.setBounds(39, 543, 350, 74);
		getContentPane().add(scrollPane_10);

		textAreaAns5 = new JTextArea();
		DefaultCaret caret5 = (DefaultCaret) textAreaAns5.getCaret();
		caret5.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		textAreaAns5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAns5.setEditable(false);
		textAreaAns5.setWrapStyleWord(true);
		textAreaAns5.setLineWrap(true);
		textAreaAns5.setMargin(new Insets(5, 5, 5, 5));
		textAreaAns5.setBackground(new Color(255, 255, 255));
		scrollPane_10.setViewportView(textAreaAns5);

		JRadioButton radioBtn2 = new JRadioButton("");
		radioBtn2.setActionCommand("Option2");
		radioBtn2.addActionListener(selectionSaver);
		radioBtn2.setBackground(new Color(255, 255, 255));
		radioBtn2.setBounds(12, 330, 21, 21);
		aGroup.add(radioBtn2);
		getContentPane().add(radioBtn2);

		textAreaAns2 = new JTextArea(); 
		DefaultCaret caret2 = (DefaultCaret) textAreaAns2.getCaret();
		caret2.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		textAreaAns2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAns2.setEditable(false);
		textAreaAns2.setLocation(0, 297);
		textAreaAns2.setWrapStyleWord(true);
		textAreaAns2.setLineWrap(true);
		textAreaAns2.setMargin(new Insets(5, 5, 5, 5));
		scrollPane_4.setViewportView(textAreaAns2);
		textAreaAns2.setBackground(new Color(255, 255, 255));

		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_3.setBounds(39, 226, 350, 74);
		getContentPane().add(scrollPane_3);

		textAreaAns1 = new JTextArea(); 
		DefaultCaret caret1 = (DefaultCaret) textAreaAns1.getCaret();
		caret1.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		textAreaAns1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaAns1.setEditable(false);
		textAreaAns1.setLocation(0, 225);
		textAreaAns1.setWrapStyleWord(true);
		textAreaAns1.setLineWrap(true);
		textAreaAns1.setMargin(new Insets(5, 5, 5, 5));
		scrollPane_3.setViewportView(textAreaAns1);
		textAreaAns1.setBackground(new Color(255, 255, 255));

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane_1.setBounds(39, 153, 350, 69);
		getContentPane().add(scrollPane_1);

		JRadioButton radioBtn3 = new JRadioButton("");
		radioBtn3.setActionCommand("Option3");
		radioBtn3.addActionListener(selectionSaver);
		radioBtn3.setBackground(new Color(255, 255, 255));
		radioBtn3.setBounds(12, 410, 21, 21);
		aGroup.add(radioBtn3);
		getContentPane().add(radioBtn3);

		JRadioButton radioBtn4 = new JRadioButton("");
		radioBtn4.setActionCommand("Option4");
		radioBtn4.addActionListener(selectionSaver);
		radioBtn4.setBackground(Color.WHITE);
		radioBtn4.setBounds(12, 488, 21, 21);
		aGroup.add(radioBtn4);
		getContentPane().add(radioBtn4);

		JRadioButton radioBtn5 = new JRadioButton("");
		radioBtn5.setActionCommand("Option5");
		radioBtn5.addActionListener(selectionSaver);
		radioBtn5.setBackground(new Color(255, 255, 255));
		radioBtn5.setBounds(12, 568, 21, 21);
		aGroup.add(radioBtn5);
		getContentPane().add(radioBtn5);

		txtAreaQuestion = new JTextArea();
		DefaultCaret caretQue = (DefaultCaret) txtAreaQuestion.getCaret();
		caretQue.setUpdatePolicy(DefaultCaret.NEVER_UPDATE);
		txtAreaQuestion.setEditable(false);
		txtAreaQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtAreaQuestion.setLocation(0, 176);
		txtAreaQuestion.setWrapStyleWord(true);
		txtAreaQuestion.setLineWrap(true);
		scrollPane_1.setViewportView(txtAreaQuestion);
		txtAreaQuestion.setBackground(new Color(255, 255, 255));
		txtAreaQuestion.setMargin(new Insets(5, 5, 5, 5));
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);

		JPanel panelTopDashboard = new JPanel();
		panelTopDashboard.setBackground(new Color(192, 192, 192));
		panelTopDashboard.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"The Charles Stanley Institute Brain-Tester Dashboard", TitledBorder.RIGHT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelTopDashboard.setBounds(34, 0, 1362, 72);
		getContentPane().add(panelTopDashboard);
		panelTopDashboard.setLayout(null);

		JLabel lblStudentLastName = new JLabel("Last Name");
		lblStudentLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentLastName.setBounds(10, 21, 66, 17);
		lblStudentLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panelTopDashboard.add(lblStudentLastName);

		textFieldLastName = new JTextField();
		textFieldLastName.setToolTipText("Required");
		textFieldLastName.setBounds(81, 20, 148, 19);
		panelTopDashboard.add(textFieldLastName);
		textFieldLastName.setColumns(20);

		InputVerifier verifier = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				textFieldLastName = (JTextField) comp;
				try {
					String textLength = textFieldLastName.getText();

					if (textLength.length() > 25 || textFieldLastName.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Last name required. No numbers. Max 25 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textFieldLastName.getText();
						for (int i = 0; i < noDigitsString.length(); i++) {
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \nOnly letters.", null,
										JOptionPane.INFORMATION_MESSAGE);
								return false;
							}
						}
						String lastNameText = textFieldLastName.getText();
						String firstLetter = lastNameText.substring(0, 1);
						firstLetter = firstLetter.toUpperCase();
						String remainingLetters = lastNameText.substring(1);
						String capitalizedString = firstLetter + remainingLetters;
						textFieldLastName.setText(capitalizedString);
						return true;
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}
				return returnValue;
			}
		};
		textFieldLastName.setInputVerifier(verifier);

		JLabel lblStudentFirstName = new JLabel("First Name");
		lblStudentFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStudentFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStudentFirstName.setBounds(239, 21, 67, 17);
		panelTopDashboard.add(lblStudentFirstName);

		textFieldStudentFirstName = new JTextField();
		textFieldStudentFirstName.setToolTipText("Required");
		textFieldStudentFirstName.setBounds(313, 20, 75, 19);
		panelTopDashboard.add(textFieldStudentFirstName);
		textFieldStudentFirstName.setColumns(10);
		// InputValidator
		// Verify first name input is not empty or exceeds 25 characters
		InputVerifier verifierFirstName = new InputVerifier() {
			public boolean verify(JComponent comp) {
				boolean returnValue = false;
				textFieldStudentFirstName = (JTextField) comp;
				try {
					String textLength = textFieldStudentFirstName.getText();
					// Verify no digits
					if (textLength.length() > 25 || textFieldStudentFirstName.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "First name required. No numbers. Max 25 characters.", null,
								JOptionPane.INFORMATION_MESSAGE);
						returnValue = false;
					} else {
						String noDigitsString = textFieldStudentFirstName.getText();
						for (int i = 0; i < noDigitsString.length(); i++) {
							char ch = noDigitsString.charAt(i);
							if (returnValue = Character.isDigit(ch) || !Character.isLetter(ch)) {
								JOptionPane.showMessageDialog(null,
										"No numbers/digits or special characters permitted. \nOnly letters.", null,
										JOptionPane.INFORMATION_MESSAGE);
								return false;
							}
						}
						// Capitalize first letter
						String firstNameText = textFieldStudentFirstName.getText();
						String firstLetter = firstNameText.substring(0, 1);
						firstLetter = firstLetter.toUpperCase();
						String remainingLetters = firstNameText.substring(1);
						String capitalizedString = firstLetter + remainingLetters;
						textFieldStudentFirstName.setText(capitalizedString);
						return true;
					}
				} catch (NumberFormatException e) {
					returnValue = false;
				}
				return returnValue;
			}
		};
		textFieldStudentFirstName.setInputVerifier(verifierFirstName);

		JLabel lblDateTime = new JLabel("Date:");
		lblDateTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblDateTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDateTime.setBounds(565, 21, 49, 17);
		panelTopDashboard.add(lblDateTime);

		textFieldDateTime = new JTextField();
		textFieldDateTime.setEditable(false);
		textFieldDateTime.setBounds(613, 20, 167, 19);
		panelTopDashboard.add(textFieldDateTime);
		textFieldDateTime.setColumns(10);

		JLabel lblStartTime = new JLabel("Start ");
		lblStartTime.setHorizontalAlignment(SwingConstants.RIGHT);
		lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblStartTime.setBounds(10, 48, 66, 17);
		panelTopDashboard.add(lblStartTime);

		textFieldStartTime = new JTextField();
		textFieldStartTime.setEditable(false);
		textFieldStartTime.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldStartTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldStartTime.setBounds(81, 47, 75, 19);
		panelTopDashboard.add(textFieldStartTime);
		textFieldStartTime.setColumns(10);

		JLabel lblEndTime = new JLabel("End");
		lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEndTime.setHorizontalAlignment(SwingConstants.CENTER);
		lblEndTime.setBounds(153, 48, 45, 17);
		panelTopDashboard.add(lblEndTime);

		textFieldEndTime = new JTextField();
		textFieldEndTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldEndTime.setEditable(false);
		textFieldEndTime.setBounds(198, 47, 75, 19);
		panelTopDashboard.add(textFieldEndTime);
		textFieldEndTime.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Time ");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_5.setBounds(267, 48, 49, 17);
		panelTopDashboard.add(lblNewLabel_5);

		textFieldTime = new JTextField();
		textFieldTime.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldTime.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textFieldTime.setEditable(false);
		textFieldTime.setBounds(313, 47, 75, 19);
		panelTopDashboard.add(textFieldTime);
		textFieldTime.setColumns(10);

		JButton btnNewButton_3 = new JButton("Delete Exam ");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					e1.printStackTrace();
				}
				if (outerMasterListofMastersSER == null) {
					JOptionPane.showMessageDialog(null, "You must select an exam to delete, if it exists");
				} else {

					if ((selectedExamIndex != null) && (selectedExamIndex < outerMasterListofMastersSER.size())) {
						innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
					} else {
						JOptionPane.showMessageDialog(null, "You must select an exam to delete, if it exists");
					}
					if (innerMasterListOfQuestionsSER.size() < 1) {
						JOptionPane.showMessageDialog(null, "No exams exist to delete");
					} else {
						DBTesterUtility dBTesterUtility = new DBTesterUtility();
						try {
							innerMasterListOfQuestionsSER = dBTesterUtility.deleteGradedRowInReview(selectedExamIndex,
									innerMasterListOfQuestionsSER);

							if (innerMasterListOfQuestionsSER.size() == 0) {
								// Clear the vertical table to ""
								table.setValueAt("", 0 + 0, 0);
								table.setValueAt("", 1 + 0, 1);
								table.setValueAt("", 2 + 0, 2);
								table.setValueAt("", 3 + 0, 3);

								// Clear the horizontal table to ""
								tableReviewExam.setValueAt("", 1, 0);
								tableReviewExam.setValueAt("", 1, 1);
								tableReviewExam.setValueAt("", 1, 2);
								tableReviewExam.setValueAt("", 1, 3);
								tableReviewExam.setValueAt("", 1, 4);
								tableReviewExam.setValueAt("", 1, 5);
								tableReviewExam.setValueAt("", 1, 6);
								tableReviewExam.setValueAt("", 1, 7);
							}
							NumberOfExams = innerMasterListOfQuestionsSER.size();
							textFieldNumExams.setText(NumberOfExams.toString());
							outerMasterListofMastersSER.set(selectedExamIndex, innerMasterListOfQuestionsSER);
							setOuterMasterListOfMastersSER(selectedExamIndex, outerMasterListofMastersSER);
							outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
						} catch (SQLException e1) {
							e1.printStackTrace();
						} catch (ClassNotFoundException e1) {
							e1.printStackTrace();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});

		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_3.setBounds(663, 46, 117, 21);
		panelTopDashboard.add(btnNewButton_3);

		textFieldNumExams = new JTextField();
		textFieldNumExams.setBounds(619, 47, 32, 19);
		panelTopDashboard.add(textFieldNumExams);
		textFieldNumExams.setColumns(10);

		JButton btnNewButton_4 = new JButton("Number of Exams");
		btnNewButton_4.setToolTipText("Only 10 exams are saved");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null,
							"You must first select an exam from the \n'Review Most Recent Graded Exams' list.");
				} else {
					try {
						outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
					} catch (ClassNotFoundException | IOException | SQLException e1) {
						e1.printStackTrace();
					}
					System.out.println(outerMasterListofMastersSER + " oec5948540");
					if (outerMasterListofMastersSER == null) {
						JOptionPane.showMessageDialog(null, "Nothing to see here; no exams taken");
					} else {

						if (selectedExamIndex < outerMasterListofMastersSER.size()) {
							System.out.println("oxrq3u3mgi9r");
							innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
							System.out.println(";leoei");
							// 7-21 what am I trying to do here?
							if (innerMasterListOfQuestionsSER == null) {
								JOptionPane.showMessageDialog(null, "This exam does not exist yet");
								textFieldNumExams.setText("0");
								System.out.println("53-jirucrcti");

							} else if (innerMasterListOfQuestionsSER.get(0).get(0) == null) {
								System.out.println("53-lpextci49e5");
								NumberOfExams = (innerMasterListOfQuestionsSER.size() - 1);
								System.out.println("53- epit938");

							} else {
								NumberOfExams = innerMasterListOfQuestionsSER.size();
								System.out.println("53-0409jh");

							}
							textFieldNumExams.setText(NumberOfExams.toString());
							System.out.println("53-xw9403dn");
						}
						System.out.println("53-lpe9ct049");
					}
				}
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_4.setBounds(461, 45, 148, 23);
		panelTopDashboard.add(btnNewButton_4);

		JLabel lblNewLabel_4 = new JLabel("Number of Questions in Exam: ");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(790, 45, 209, 23);
		panelTopDashboard.add(lblNewLabel_4);

		textFieldNumQueInExam = new JTextField();
		textFieldNumQueInExam.setBounds(996, 47, 32, 19);
		panelTopDashboard.add(textFieldNumQueInExam);
		textFieldNumQueInExam.setColumns(10);

		JPanel panelfLoginInfo = new JPanel();
		panelfLoginInfo.setBackground(new Color(192, 192, 192));
		panelfLoginInfo.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panelfLoginInfo.setBounds(34, 73, 1362, 55);
		getContentPane().add(panelfLoginInfo);
		panelfLoginInfo.setLayout(null);

		textFieldQuestNum = new JTextField();
		textFieldQuestNum.setEditable(false);
		textFieldQuestNum.setBounds(173, 712, 25, 19);
		getContentPane().add(textFieldQuestNum);
		textFieldQuestNum.setColumns(10);

		JComboBox<String> comboBoxSelectExam = new JComboBox<>();
		comboBoxSelectExam.setToolTipText("Always use the down-arrow to select an exam");
		comboBoxSelectExam.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rowCountComboInt = rowCountComboLabelsB3();

		if (rowCountComboInt == 0) {
			loadComboExamLabsB3();
			var examComboLabelsTester = new ExamComboLabelsTester(); // not necessary
			setComboLabelsB3(examComboLabelsTester);// not necessary
			examComboLabelsTester = getExamComboLabelsB3();

			exam1 = examComboLabelsTester.getExam1Str();
			exam2 = examComboLabelsTester.getExam2Str();
			exam3 = examComboLabelsTester.getExam3Str();
			exam4 = examComboLabelsTester.getExam4Str();
			exam5 = examComboLabelsTester.getExam5Str();
			exam6 = examComboLabelsTester.getExam6Str();
			exam7 = examComboLabelsTester.getExam7Str();
			exam8 = examComboLabelsTester.getExam8Str();
			exam9 = examComboLabelsTester.getExam9Str();
			exam10 = examComboLabelsTester.getExam10Str();

		} else if (rowCountComboInt == 1) {
			examComboLabelsTester = getExamComboLabelsB3();
			exam1 = examComboLabelsTester.getExam1Str();
			exam2 = examComboLabelsTester.getExam2Str();
			exam3 = examComboLabelsTester.getExam3Str();
			exam4 = examComboLabelsTester.getExam4Str();
			exam5 = examComboLabelsTester.getExam5Str();
			exam6 = examComboLabelsTester.getExam6Str();
			exam7 = examComboLabelsTester.getExam7Str();
			exam8 = examComboLabelsTester.getExam8Str();
			exam9 = examComboLabelsTester.getExam9Str();
			exam10 = examComboLabelsTester.getExam10Str();
		}

		comboBoxSelectExam.setModel(new DefaultComboBoxModel<String>(
				new String[] { exam1, exam2, exam3, exam4, exam5, exam6, exam7, exam8, exam9, exam10 }));
		comboBoxSelectExam.setBounds(160, 12, 175, 21);
		panelfLoginInfo.add(comboBoxSelectExam);
		comboBoxSelectExam.addActionListener(e -> {			
			selectedExamIndex = comboBoxSelectExam.getSelectedIndex();
			var builderDBTesterUtility = new BuilderDBTesterUtility();
			try {
				countingRows = builderDBTesterUtility.getRowCount();
				System.out.println(countingRows + " countingRows in the combobox should print 1, and it does");
			} catch (ClassNotFoundException | IOException | SQLException e1) {
				e1.printStackTrace();
			}

			if (selectedExamIndex >= countingRows) {
				JOptionPane.showMessageDialog(null, "This exam does not exist");
			}
		});

		JButton btnNewButton_3_1 = new JButton("Begin Exam");
		btnNewButton_3_1.setBounds(345, 10, 107, 25);
		panelfLoginInfo.add(btnNewButton_3_1);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Top of Begin button");
				isCurrentExamFinished = true;
				EvaluateAnswersLists evaluateAnswersLists = new EvaluateAnswersLists();
				try {
					gradeOnceListOfListsSER = evaluateAnswersLists.getEvaluatedList();
				} catch (ClassNotFoundException | SQLException | IOException e1) {
					e1.printStackTrace();
				}
				try {
					evaluateAnswersLists.deleteRowsEval(selectedExamIndex);
					gradeOnceListOfListsSER = evaluateAnswersLists.getEvaluatedList();
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					e1.printStackTrace();
				}

				textAreaExplanation.setBackground(null);
				textFieldStartTime.setText("");
				textFieldEndTime.setText("");
				textFieldTime.setText("");

				aGroup.clearSelection();
				textPane.setText("");
				textFieldQNum.setText("");
				textFieldQuestNum.setText("");
				nowBegin = LocalTime.now();

				String formattedStartTime = nowBegin.format(FORMATTER);
				textFieldStartTime.setText(formattedStartTime);

				CheckNullSerlist: if (true) {
					if (selectedExamIndex == null) {
						JOptionPane.showMessageDialog(null, "To begin the exam you must first click the down-arrow "
								+ " \n and select an exam from the drop-down list.\n Then, click 'Begin Exam'.");
					} else {
						int whenToGrade = JOptionPane.showConfirmDialog(null,
								"To grade each question immediately upon evaluation (recommended) click 'Yes'\n"
										+ "To grade all evaluated questions once at the end of the exam, click 'No'",
								" Select Grade Evaluation Option", JOptionPane.YES_NO_CANCEL_OPTION);

						if (whenToGrade == 2) {
							textFieldExNumber.setText("");
							textFieldQNum.setText("");
							textFieldExTitle.setText("");
							textFieldTopic.setText("");
							txtAreaQuestion.setText("");
							textAreaAns1.setText("");
							textAreaAns2.setText("");
							textAreaAns3.setText("");
							textAreaAns4.setText("");
							textAreaAns5.setText("");
							textFieldPassOrFail.setText("");
							textAreaExplanation.setText("");
						} else {
							if (whenToGrade == 0) {
								evalGradeImmediately = true;
							} else {
								evalGradeImmediately = false;
							}
							todayDate = LocalDate.now();
							Boolean isExamStarted = false;
							qIndex = 0;
							qNumber = 1;
							currentExamIndex = selectedExamIndex;
							System.out.println(currentExamIndex + " currentExamIndex pe0459");

							// 8-4-26 Grab a copy of the exam in listOfQuestionsSER from table TESTER_EXAMS_LIST_4
							// But why if I just turn around and get it from DisplayExamsAndQuestions? And,
							// I'm not using it!! So, I changed my mind? I'm using the display
							// listOfQuestionsSER instead?
							// And, on 8-1 I tried without it and it works fine. Change the readme file.
							
							try {								
								DisplayExamsAndQuestions displayExamsAndQuestions = new DisplayExamsAndQuestions();
								outerMasterListOfMastersSER = displayExamsAndQuestions.getOuterExamsDisplayed();
								innerMasterListOfMastersSER = outerMasterListOfMastersSER.get(selectedExamIndex);
								listOfQuestionsSER = innerMasterListOfMastersSER.get(0);

								listOfQuestionsSER.get(qIndex).setIsExamStarted(true);
								// Always set this in the first question
								listOfQuestionsSER.get(0).setIsExamFinished(false); 

								sizeOfSerList = listOfQuestionsSER.size();

								for (int j = 0; j < listOfQuestionsSER.size(); j++) {
									if (listOfQuestionsSER.get(j) == null) {
										JOptionPane.showConfirmDialog(null, "Question number " + (j + 1)
												+ " is empty, and no exam may be \n "
												+ "taken if any question is empty (null). \nPlease notify the instructor.",
												"Empty Question", JOptionPane.OK_CANCEL_OPTION);
										break CheckNullSerlist;
									}
								}

								if (sizeOfSerList > 1) {
									sizeOfFirstSerList = listOfQuestionsSER.get(listOfQuestionsSER.size() - 2)
											.getSizeLerListr();
								} else {

									if (listOfQuestionsSER.size() > 1) {
										System.out.println(
												listOfQuestionsSER.get(0).getSizeLerListr() + " Testing moxcer7");
									}
								}

								if (listOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "This exam does not exist");
									break CheckNullSerlist;
								}
								examNumber = selectedExamIndex + 1;
								// Always set this in the first question
								listOfQuestionsSER.get(0).setIsExamFinished(false); 
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							listOfQuestionsSER.get(qIndex).setStudentLastName(textFieldLastName.getText());
							listOfQuestionsSER.get(qIndex).setStudentFirstName(textFieldStudentFirstName.getText());

							String lastNameStudent = listOfQuestionsSER.get(qIndex).getStudentLastName();
							// Seriously Eclipse? Not used?
							// String firstNameStudent =
							// listOfQuestionsSER.get(qIndex).getStudentFirstName();

							System.out.println("Inside the Tester Begin button");
							if (isExamStarted == false) {
								System.out.println(qIndex + " qIndex mketc90484");
								listOfQuestionsSER.get(qIndex).setIsExamStarted(true);
								isExamStarted = listOfQuestionsSER.get(qIndex).getIsExamStarted();
								System.out.println(isExamStarted + " isExamStarted koeir90w4");

								listOfQuestionsSER.get(qIndex).setDateOfExamStr(todayDate.toString());
								textFieldDateTime.setText(listOfQuestionsSER.get(qIndex).getDateOfExamStr());

								textFieldLastName.setText(listOfQuestionsSER.get(qIndex).getStudentLastName());
								textFieldStudentFirstName.setText(listOfQuestionsSER.get(qIndex).getStudentFirstName());

								textFieldExTitle.setText(listOfQuestionsSER.get(qIndex).getTitle());
								textFieldTopic.setText(listOfQuestionsSER.get(qIndex).getQuestionTopic());
								textFieldExNumber.setText(examNumber.toString());
								textFieldQuestNum.setText(qNumber.toString());
								txtAreaQuestion.setText(listOfQuestionsSER.get(qIndex).getQuestion());
								textAreaAns1.setText(listOfQuestionsSER.get(qIndex).getAnswer1());
								textAreaAns2.setText(listOfQuestionsSER.get(qIndex).getAnswer2());
								textAreaAns3.setText(listOfQuestionsSER.get(qIndex).getAnswer3());
								textAreaAns4.setText(listOfQuestionsSER.get(qIndex).getAnswer4());
								textAreaAns5.setText(listOfQuestionsSER.get(qIndex).getAnswer5());

								var updateGradedExams = new UpdateGradedExams();
								try {
									updateGradedExams.updateGradedExam(selectedExamIndex, listOfQuestionsSER,
											lastNameStudent);
								} catch (IOException | SQLException e1) {
									e1.printStackTrace();
								}
							}

							// Retrieve the graded exam and display
							var retrieveGradedExams = new RetrieveGradedExams();
							try {
								listOfQuestionsSER = retrieveGradedExams.getGradedExam(selectedExamIndex);
							} catch (ClassNotFoundException | SQLException | IOException e1) {
								e1.printStackTrace();
							}
							// Say what? 6-28 - Why am I doing this twice, duplicate from above???
							// Probably should be removed.

							textFieldDateTime.setText(todayDate.toString());
							textFieldLastName.setText(listOfQuestionsSER.get(qIndex).getStudentLastName());
							textFieldStudentFirstName.setText(listOfQuestionsSER.get(qIndex).getStudentFirstName());
							textFieldExTitle.setText(listOfQuestionsSER.get(qIndex).getTitle());
							textFieldTopic.setText(listOfQuestionsSER.get(qIndex).getQuestionTopic());
							textFieldQNum.setText(qNumber.toString() + "/" + listOfQuestionsSER.size());

							txtAreaQuestion.setText(listOfQuestionsSER.get(qIndex).getQuestion());
							textAreaAns1.setText(listOfQuestionsSER.get(qIndex).getAnswer1());
							textAreaAns2.setText(listOfQuestionsSER.get(qIndex).getAnswer2());
							textAreaAns3.setText(listOfQuestionsSER.get(qIndex).getAnswer3());
							textAreaAns4.setText(listOfQuestionsSER.get(qIndex).getAnswer4());
							listOfQuestionsSER.get(qIndex).setIsExamStarted(false);
						}
					}
					listOfQuestionsSER.get(0).setTimeExamStarts(formattedStartTime);
				}
			}
		});
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.PLAIN, 12));

		JLabel lblSelectThenBegin = new JLabel("Select exam , then begin: ");
		lblSelectThenBegin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblSelectThenBegin.setHorizontalAlignment(SwingConstants.LEFT);
		lblSelectThenBegin.setBounds(10, 16, 155, 13);
		panelfLoginInfo.add(lblSelectThenBegin);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(232, 232, 234));
		panel_1.setBounds(462, 3, 890, 37);
		panelfLoginInfo.add(panel_1);
		panel_1.setLayout(null);

		tableReviewExam = new JTable();
		tableReviewExam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tableReviewExam.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		tableReviewExam.setModel(new DefaultTableModel(
				new Object[][] {
						{ "Latest Exam #", "Title", "No Topic", "Date of Exam", "# Times Taken", "Latest Score",
								"Average Score", "# Correct Answers" },
						{ null, null, null, null, null, null, null, null }, },
				new String[] { "New column", "New column", "New column", "New column", "New column", "New column",
						"New column", "New column" }));
		tableReviewExam.setBounds(0, 3, 890, 33);
		panel_1.add(tableReviewExam);

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(240, 240, 240));
		tabbedPane.setBounds(405, 130, 990, 570);

		getContentPane().add(tabbedPane);
		JPanel jpanel1 = new JPanel();
		jpanel1.setBounds(EXIT_ON_CLOSE, ABORT, 400, 400);
		jpanel1.setBackground(new Color(192, 192, 192));
		JLabel jLabeltab1 = new JLabel("Question Preview - Exams - Review of Questions");
		JLabel jLabel1 = new JLabel("Evaluated Question Preview");
		jLabel1.setBounds(136, 493, 188, 25);

		JScrollPane scrollPanePreview = new JScrollPane(jpanel1);
		getContentPane().add(scrollPanePreview);

		jLabel1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel1.setBackground(new Color(255, 150, 150));
		JPanel jPanelTab1 = new JPanel();
		jPanelTab1.setBackground(new Color(255, 255, 255));
		jPanelTab1.setLayout(null);
		jPanelTab1.setLayout(null);

		tabbedPane.addTab("Question Preview - Exams - Review of Questions", jPanelTab1);

		JButton btnPrintEvalPreview = new JButton("Print");
		btnPrintEvalPreview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					textPane.print();
				} catch (PrinterException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnPrintEvalPreview.setBounds(22, 495, 70, 21);
		jPanelTab1.add(btnPrintEvalPreview);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(460, 9, 220, 479);
		jPanelTab1.add(panel);
		panel.setLayout(null);

		JLabel lblExamsPanel = new JLabel("Review Most Recent Graded Exams");
		lblExamsPanel.setHorizontalAlignment(SwingConstants.CENTER);
		lblExamsPanel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblExamsPanel.setBounds(448, 499, 244, 13);
		jPanelTab1.add(lblExamsPanel);

		JLabel lblNewLabel_3 = new JLabel("Review of Questions");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(806, 493, 138, 25);
		jPanelTab1.add(lblNewLabel_3);
		jPanelTab1.add(jLabel1);

		JList<String> JListOfExams = new JList<>();
		JListOfExams.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JListOfExams.setBounds(10, 5, 200, 464);
		JListOfExams.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		panel.add(JListOfExams);

		DefaultListModel<String> DLM = new DefaultListModel<>();
		DLM.addElement("Exam 1");
		DLM.addElement("Exam 2");
		DLM.addElement("Exam 3");
		DLM.addElement("Exam 4");
		DLM.addElement("Exam 5");
		DLM.addElement("Exam 6");
		DLM.addElement("Exam 7");
		DLM.addElement("Exam 8");
		DLM.addElement("Exam 9");
		DLM.addElement("Exam 10");
		DLM.addElement("Exam 11");
		DLM.addElement("Exam 12");
		DLM.addElement("Exam 13");
		DLM.addElement("Exam 14");
		DLM.addElement("Exam 15");
		DLM.addElement("Exam 16");
		DLM.addElement("Exam 17");
		DLM.addElement("Exam 18");
		DLM.addElement("Exam 19");
		DLM.addElement("Exam 20");

		JListOfExams.setModel(DLM);
		JListOfExams.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JListOfExams.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				textFieldStartTime.setText("");
				textFieldEndTime.setText("");
				textFieldTime.setText("");
				textFieldNumExams.setText("");
				if (!e.getValueIsAdjusting()) {
					ExamNotFinished: if (JListOfExams.getSelectedIndex() != -1) {
						selectedValue = (String) JListOfExams.getSelectedValue();
						// This is used in the second JList
						selectedExamIndex = JListOfExams.getSelectedIndex();
						selectedExamIndexInteger = selectedExamIndex + 1;
						textFieldExNumber.setText((selectedExamIndexInteger).toString());

						System.out.println(";oei9rct8");
						// If the exam being taken is not finished can't review anything
						if (listOfQuestionsSER != null) {
							System.out.println("joic89454mf9");
							isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
						}
						if (listOfQuestionsSER != null && isCurrentExamFinished == false) {
							System.out.println("lpgprgr ");
							JOptionPane.showMessageDialog(null,
									"You may not review any exams while you \n" + "are currently taking an exam DX.");
							selectedExamIndex = currentExamIndex;
							System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
							break ExamNotFinished;
						}

						for (int ix = 0; ix < 10; ix++) {
							table.setValueAt(ix + 1, ix, 0);
							table.setValueAt("", ix, 1);
							table.setValueAt("", ix, 2);
							table.setValueAt("", ix, 3);
						}

						try {
							outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
						} catch (ClassNotFoundException | IOException | SQLException e1) {
							e1.printStackTrace();
						}
						System.out.println(outerMasterListofMastersSER
								+ " outerMasterListofMastersSER Oh my, what now? po4905894");

						if (outerMasterListofMastersSER != null
								&& outerMasterListofMastersSER.size() > selectedExamIndex) {
							innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
							System.out.println(innerMasterListOfQuestionsSER + " oec9584");

						} else {
							// Eat it?
						}

						if (innerMasterListOfQuestionsSER != null && innerMasterListOfQuestionsSER.size() > 0
								&& outerMasterListofMastersSER.size() > selectedExamIndex) {
							System.out.println(innerMasterListOfQuestionsSER + " peictvr8t");
							listOfQuestionsSER = innerMasterListOfQuestionsSER
									.get(innerMasterListOfQuestionsSER.size() - 1);

							if (listOfQuestionsSER != null && listOfQuestionsSER.size() > 0) {
								System.out.println(innerMasterListOfQuestionsSER + " koe8594");
								Integer QueInExam = listOfQuestionsSER.size();
								textFieldNumQueInExam.setText("  " + QueInExam.toString());
								listOfQuestionsSER.get(0);
								if (listOfQuestionsSER.get(0) != null) {
									textFieldDateTime.setText(listOfQuestionsSER.get(0).getDateOfExamStr());
								}
							} else {
								textFieldNumQueInExam.setText("");
								textFieldDateTime.setText("");
							}
						} else {
							tableReviewExam.setValueAt("", 1, 0);
							tableReviewExam.setValueAt("", 1, 1);
							tableReviewExam.setValueAt("", 1, 2);
							tableReviewExam.setValueAt("", 1, 3);
							tableReviewExam.setValueAt("", 1, 4);
							tableReviewExam.setValueAt("", 1, 5);
							tableReviewExam.setValueAt("", 1, 6);
							tableReviewExam.setValueAt("", 1, 7);

							listOfQuestionsSER = null;
						}

						if (listOfQuestionsSER == null) {
							textFieldNumQueInExam.setText("");
							textFieldDateTime.setText("");
							JOptionPane.showMessageDialog(null, "Exam has not been taken RRW");
						} else {
							aGroup.clearSelection();
							// But it is indeed being used.
							Integer sizeOfInnerMaster;
							String NumberTimesTaken = "Atleast2 - say what?";
							String latestScore = null;
							String averageScore = null;

							for (int i = 0; i < 10; ++i) {
								if (selectedExamIndex == i) {
									System.out.println("3A");
									try {
										outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
										innerMasterListOfQuestionsSER = outerMasterListofMastersSER
												.get(selectedExamIndex);
										if (innerMasterListOfQuestionsSER.size() > 0) {
											listOfQuestionsSER = innerMasterListOfQuestionsSER
													.get(innerMasterListOfQuestionsSER.size() - 1);
										} else {
											for (int j = 0; j < listOfQuestionsSER.size(); j++) {
												table.setValueAt(j + 1, i, 0);
												table.setValueAt("", j, 1);
												table.setValueAt("", j, 2);
												table.setValueAt("", j, 3);
											}
											tableReviewExam.setValueAt("", 1, 0);
											tableReviewExam.setValueAt("", 1, 1);
											tableReviewExam.setValueAt("", 1, 2);
											tableReviewExam.setValueAt("", 1, 3);
											tableReviewExam.setValueAt("", 1, 4);
											tableReviewExam.setValueAt("", 1, 5);
											tableReviewExam.setValueAt("", 1, 6);
											tableReviewExam.setValueAt("", 1, 7);
											JOptionPane.showMessageDialog(null, "Exam has not been taken RX");
										}
									} catch (ClassNotFoundException | IOException | SQLException e1) {
										e1.printStackTrace();
									}

									if (listOfQuestionsSER.get(0) == null) {
										JOptionPane.showMessageDialog(null,
												"This exam has not been taken \n" + "and cannot be reviewed.");
									} else {
										for (int ib = 0; ib < listOfQuestionsSER.size(); ++ib) {

											textFieldLastName.setText(listOfQuestionsSER.get(0).getStudentLastName());
											textFieldStudentFirstName
													.setText(listOfQuestionsSER.get(0).getStudentFirstName());
											topic = listOfQuestionsSER.get(ib).getQuestionTopic();
											String title = listOfQuestionsSER.get(ib).getTitle();
											questionNumber2 = (ib + 1);
											lastName = listOfQuestionsSER.get(0).getStudentLastName();
											firstName = listOfQuestionsSER.get(0).getStudentFirstName();
											passFail = listOfQuestionsSER.get(ib).getPassFail();
											textFieldStartTime.setText(listOfQuestionsSER.get(0).getTimeExamStarts());
											textFieldEndTime.setText(listOfQuestionsSER.get(0).getTimeExamEnds()); // returns
																													// null

											textFieldTime.setText(listOfQuestionsSER.get(0).getTimeDuration());
											textFieldLastName.setText(lastName);
											textFieldStudentFirstName.setText(firstName);

											table.setValueAt(questionNumber2, ib + 0, 0);
											table.setValueAt(passFail.toUpperCase(), ib + 0, 1);
											table.setValueAt(topic, ib + 0, 2);
											// While not being used now, they were and might still be so leave.
											Double gradedFirst;
											Double gradedLast;

											dateOfExamStr = listOfQuestionsSER.get(ib).getDateOfExamStr();
											Double percentageGrade = listOfQuestionsSER.get(ib).getPercentGrade();
											String formattedPercentageGrade = String.format("%.2f", percentageGrade);
											latestScore = formattedPercentageGrade;
											sizeOfInnerMaster = innerMasterListOfQuestionsSER.size();
											NumberOfExams = 0;
											if (outerMasterListofMastersSER != null
													&& selectedExamIndex < outerMasterListofMastersSER.size()) {
												innerMasterListOfQuestionsSER = outerMasterListofMastersSER
														.get(selectedExamIndex);

												for (int k = 0; k < innerMasterListOfQuestionsSER.size(); k++) {
													if (innerMasterListOfQuestionsSER.get(k) != null) {
														NumberOfExams++;
													} else {
														continue;
													}
												}
												NumberTimesTaken = NumberOfExams.toString();
												textFieldNumExams.setText(NumberOfExams.toString());
											} else {
												JOptionPane.showMessageDialog(null, "This exam does not exist yet");
												textFieldNumExams.setText("0");
											}

											if (innerMasterListOfQuestionsSER
													.get(innerMasterListOfQuestionsSER.size() - 1) != null) {
												tableReviewExam.setValueAt(selectedExamIndex + 1, 1, 0);
												tableReviewExam.setValueAt(selectedValue, 1, 1);
												tableReviewExam.setValueAt("", 1, 2);
												tableReviewExam.setValueAt(dateOfExamStr, 1, 3);
												tableReviewExam.setValueAt(NumberTimesTaken, 1, 4);
												tableReviewExam.setValueAt(latestScore, 1, 5);
												tableReviewExam.setValueAt(averageScore, 1, 6);

												numPass = listOfQuestionsSER.get(0).getNumberOfPass();
												tableReviewExam.setValueAt(numPass + "/" + listOfQuestionsSER.size(), 1,
														7);
											} else {
												tableReviewExam.setValueAt("", 1, 0);
												tableReviewExam.setValueAt("", 1, 1);
												tableReviewExam.setValueAt("", 1, 2);
												tableReviewExam.setValueAt("", 1, 3);
												tableReviewExam.setValueAt("", 1, 4);
												tableReviewExam.setValueAt("", 1, 5);
												tableReviewExam.setValueAt("", 1, 6);
												tableReviewExam.setValueAt("", 1, 7);

												table.setValueAt("", ib + 0, 0);
												table.setValueAt("", ib + 0, 1);
												table.setValueAt("", ib + 0, 2);
											}
										}
									}
									prevQTitle = "";
									prevQTopic = "";
									prevQuestion = "";
									prevAns1 = "";
									prevAns2 = "";
									prevAns3 = "";
									prevAns4 = "";
									prevAns5 = "";
									prevExplanation = "";
									prevCorrectAns1 = "";
									prevCorrectAns2 = "";
									prevCorrectAns3 = "";
									prevCorrectAns4 = "";
									prevCorrectAns5 = "";

									textFieldQuestNum.setText("");
									textFieldExTitle.setText("");
									textFieldTopic.setText("");
									txtAreaQuestion.setText("");
									textAreaAns1.setText("");
									textAreaAns2.setText("");
									textAreaAns3.setText("");
									textAreaAns4.setText("");
									textAreaAns5.setText("");
									textPane.setText("");
									textFieldPassOrFail.setText("");

									textFieldQuestNum.setBackground(null);
									textFieldExTitle.setBackground(null);
									textFieldTopic.setBackground(null);
									txtAreaQuestion.setBackground(null);
									textAreaAns1.setBackground(null);
									textAreaAns2.setBackground(null);
									textAreaAns3.setBackground(null);
									textAreaAns4.setBackground(null);
									textAreaAns5.setBackground(null);

								}
							}
						}
					}
				}
			}
		});

		JPanel panel3_QReview = new JPanel();
		panel3_QReview.setBackground(new Color(255, 255, 255));
		panel3_QReview.setBounds(675, 6, 303, 479);
		jPanelTab1.add(panel3_QReview);
		panel3_QReview.setLayout(null);

		JButton btnQReview1 = new JButton("R");
		btnQReview1.setToolTipText("");
		btnQReview1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 0;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934RRR");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 1;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}
								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);

								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 0) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 1) {// throws a null
																									// pointer
									JOptionPane.showMessageDialog(null, "Question 1 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(0);
									qIndex = 0;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}
					}
				}
			}
		});
		btnQReview1.setForeground(new Color(0, 0, 0));
		btnQReview1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview1.setBackground(new Color(255, 255, 255));
		btnQReview1.setBounds(23, 23, 50, 20);
		panel3_QReview.add(btnQReview1);

		JButton btnQReview2 = new JButton("R");
		btnQReview2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 1;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 2;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}

								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 1) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 2) {
									JOptionPane.showMessageDialog(null, "Question 2 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(1);
									qIndex = 1;
									displayReviewQuestion(questionObject, qIndex);

								}
							}
						}
					}
				}
			}
		});
		btnQReview2.setForeground(Color.BLACK);
		btnQReview2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview2.setBackground(Color.WHITE);
		btnQReview2.setBounds(23, 46, 50, 20);
		panel3_QReview.add(btnQReview2);

		JButton btnQReview3 = new JButton("R");
		btnQReview3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 2;
				System.out.println("lc40904dkf");
				if (selectedExamIndex == null) {
					System.out.println("oieeotvrnt");
					JOptionPane.showMessageDialog(null, "You must first select an exam");					
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					System.out.println(" pfglpfv");
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					System.out.println("dofor8t5958");
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi499ht34");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 3;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}
								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 2) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 3) {
									JOptionPane.showMessageDialog(null, "Question 3 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(2);
									qIndex = 2;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}
					}
				}
			}
		});
		btnQReview3.setForeground(Color.BLACK);
		btnQReview3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3.setBackground(Color.WHITE);
		btnQReview3.setBounds(23, 69, 50, 20);
		panel3_QReview.add(btnQReview3);

		JButton btnQReview4 = new JButton("R");
		btnQReview4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 3;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 4;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}

								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 3) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 4) {// throws a null
																									// pointer
									JOptionPane.showMessageDialog(null, "Question 4 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(3);
									qIndex = 3;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}
					}
				}
			}
		});
		btnQReview4.setForeground(Color.BLACK);
		btnQReview4.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview4.setBackground(Color.WHITE);
		btnQReview4.setBounds(23, 90, 50, 20);
		panel3_QReview.add(btnQReview4);

		JButton btnQReview5 = new JButton("R");
		btnQReview5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 4;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 5;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}

								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 4) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 5) {// throws a null
																									// pointer
									JOptionPane.showMessageDialog(null, "Question 5 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(4);
									qIndex = 4;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}
					}
				}
			}
		});
		btnQReview5.setForeground(Color.BLACK);
		btnQReview5.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview5.setBackground(Color.WHITE);
		btnQReview5.setBounds(23, 112, 50, 20);
		panel3_QReview.add(btnQReview5);

		JButton btnQReview6 = new JButton("R");
		btnQReview6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 5;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 6;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}

								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);

								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 5) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 6) {
									JOptionPane.showMessageDialog(null, "Question 6 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(5);
									qIndex = 5;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}

					}
				}
			}
		});
		btnQReview6.setForeground(Color.BLACK);
		btnQReview6.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview6.setBackground(Color.WHITE);
		btnQReview6.setBounds(23, 134, 50, 20);
		panel3_QReview.add(btnQReview6);

		JButton btnQReview7 = new JButton("R");
		btnQReview7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 6;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 7;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}

								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 6) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 7) {
									JOptionPane.showMessageDialog(null, "Question 7 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(6);
									qIndex = 6;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}
					}
				}
			}
		});
		btnQReview7.setForeground(Color.BLACK);
		btnQReview7.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview7.setBackground(Color.WHITE);
		btnQReview7.setBounds(23, 157, 50, 20);
		panel3_QReview.add(btnQReview7);

		JButton btnQReview8 = new JButton("R");
		btnQReview8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 7;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 8;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}

								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);

								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 7) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 8) {// throws a null
																									// pointer
									JOptionPane.showMessageDialog(null, "Question 8 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(7);
									qIndex = 7;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}
					}
				}
			}
		});
		btnQReview8.setForeground(Color.BLACK);
		btnQReview8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview8.setBackground(Color.WHITE);
		btnQReview8.setBounds(23, 179, 50, 20);
		panel3_QReview.add(btnQReview8);

		JButton btnQReview9 = new JButton("R");
		btnQReview9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 8;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 9;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {
								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}
								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 8) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 9) {// throws a null
																									// pointer
									JOptionPane.showMessageDialog(null, "Question 9 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(8);
									qIndex = 8;
									displayReviewQuestion(questionObject, qIndex);

								}
							}
						}
					}
				}
			}
		});
		btnQReview9.setForeground(Color.BLACK);
		btnQReview9.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview9.setBackground(Color.WHITE);
		btnQReview9.setBounds(23, 201, 50, 20);
		panel3_QReview.add(btnQReview9);

		JButton btnQReview10 = new JButton("R");
		btnQReview10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				qNumForButton = 9;
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must first select an exam");
				} else if (listOfQuestionsSER == null || listOfQuestionsSER.size() < qNumForButton + 1) {
					JOptionPane.showMessageDialog(null, "No exam to review");
				} else {
					isCurrentExamFinished = listOfQuestionsSER.get(0).getIsExamFinished();
					ExamNotFinished: if ((listOfQuestionsSER != null && isCurrentExamFinished == false)) {
						JOptionPane.showMessageDialog(null,
								"You may not review any exams while you \n" + "are currently taking an exam.");
						selectedExamIndex = currentExamIndex;
						System.out.println(selectedExamIndex + " selectedExamIndex owi4934");
						break ExamNotFinished;
					} else {
						aGroup.clearSelection();
						if (selectedExamIndex == null) {
							JOptionPane.showMessageDialog(null, "You must first select an exam");
						} else {
							qNumber = 10;
							textFieldQNum.setText(qNumber.toString());
							try {
								outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}

							NoInnerLabel: NoOuterLabel: if (outerMasterListofMastersSER == null) {
								JOptionPane.showMessageDialog(null, "This question is not available because \n"
										+ "No exams have been taken and graded.");
								break NoOuterLabel;
							} else if (outerMasterListofMastersSER.size() < (selectedExamIndex + 1)) {

								for (int ix = 0; ix < 10; ix++) {
									table.setValueAt(ix + 1, ix, 0);
									table.setValueAt("", ix, 1);
									table.setValueAt("", ix, 2);
									table.setValueAt("", ix, 3);
								}

								JOptionPane.showMessageDialog(null,
										"This Exam has not been taken and graded, and therefore \n"
												+ "this question is not available for review.");
								break NoOuterLabel;
							} else {
								innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
								if (innerMasterListOfQuestionsSER == null) {
									JOptionPane.showMessageDialog(null, "Exam has not been taken");
									break NoInnerLabel;
								} else if (innerMasterListOfQuestionsSER != null
										&& innerMasterListOfQuestionsSER.size() > 9) {
									listOfQuestionsSER = innerMasterListOfQuestionsSER
											.get(innerMasterListOfQuestionsSER.size() - 1);
								}

								if (selectedExamIndex != null && listOfQuestionsSER.size() < 10) {// throws a null
																									// pointer
									JOptionPane.showMessageDialog(null, "Question 10 is not available");
								} else if (selectedExamIndex != null) {
									questionObject = listOfQuestionsSER.get(9);
									qIndex = 9;
									displayReviewQuestion(questionObject, qIndex);
								}
							}
						}
					}
				}
			}
		});
		btnQReview10.setForeground(Color.BLACK);
		btnQReview10.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview10.setBackground(Color.WHITE);
		btnQReview10.setBounds(23, 223, 50, 20);
		panel3_QReview.add(btnQReview10);

		JButton btnQReview20 = new JButton("R");
		btnQReview10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});

		btnQReview20.setForeground(Color.BLACK);
		btnQReview20.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview20.setBackground(Color.WHITE);
		btnQReview20.setBounds(23, 442, 50, 20);
		panel3_QReview.add(btnQReview20);

		// These buttons are for numbers 11-20; not hooked up yet
		// Must rename the JButtons and relocate
		JButton btnQReview3_2_1 = new JButton("R");
		btnQReview3_2_1.setForeground(Color.BLACK);
		btnQReview3_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_2_1.setBackground(Color.WHITE);
		btnQReview3_2_1.setBounds(23, 287, 50, 20);
		panel3_QReview.add(btnQReview3_2_1);

		JButton btnQReview3_3_1 = new JButton("R");
		btnQReview3_3_1.setForeground(Color.BLACK);
		btnQReview3_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_3_1.setBackground(Color.WHITE);
		btnQReview3_3_1.setBounds(23, 309, 50, 20);
		panel3_QReview.add(btnQReview3_3_1);

		JButton btnQReview3_4_1 = new JButton("R");
		btnQReview3_4_1.setForeground(Color.BLACK);
		btnQReview3_4_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_4_1.setBackground(Color.WHITE);
		btnQReview3_4_1.setBounds(23, 331, 50, 20);
		panel3_QReview.add(btnQReview3_4_1);

		JButton btnQReview3_5_1 = new JButton("R");
		btnQReview3_5_1.setForeground(Color.BLACK);
		btnQReview3_5_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_5_1.setBackground(Color.WHITE);
		btnQReview3_5_1.setBounds(23, 353, 50, 20);
		panel3_QReview.add(btnQReview3_5_1);

		JButton btnQReview3_6_1 = new JButton("R");
		btnQReview3_6_1.setForeground(Color.BLACK);
		btnQReview3_6_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_6_1.setBackground(Color.WHITE);
		btnQReview3_6_1.setBounds(23, 375, 50, 20);
		panel3_QReview.add(btnQReview3_6_1);

		JButton btnQReview3_7_1 = new JButton("R");
		btnQReview3_7_1.setForeground(Color.BLACK);
		btnQReview3_7_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_7_1.setBackground(Color.WHITE);
		btnQReview3_7_1.setBounds(23, 398, 50, 20);
		panel3_QReview.add(btnQReview3_7_1);

		JButton btnQReview3_8_1 = new JButton("R");
		btnQReview3_8_1.setForeground(Color.BLACK);
		btnQReview3_8_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_8_1.setBackground(Color.WHITE);
		btnQReview3_8_1.setBounds(23, 420, 50, 20);
		panel3_QReview.add(btnQReview3_8_1);

		JButton btnQReview3_9 = new JButton("R");
		btnQReview3_9.setForeground(Color.BLACK);
		btnQReview3_9.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_9.setBackground(Color.WHITE);
		btnQReview3_9.setBounds(23, 265, 50, 20);
		panel3_QReview.add(btnQReview3_9);

		JButton btnQReview3_8 = new JButton("R");
		btnQReview3_8.setForeground(Color.BLACK);
		btnQReview3_8.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnQReview3_8.setBackground(Color.WHITE);
		btnQReview3_8.setBounds(23, 244, 50, 20);
		panel3_QReview.add(btnQReview3_8);

		JScrollPane scrollPane_8 = new JScrollPane();
		scrollPane_8.setBounds(75, 3, 226, 476);
		panel3_QReview.add(scrollPane_8);

		table = new JTable();
		scrollPane_8.setViewportView(table);

		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setRowHeight(22);
		table.setBorder(new LineBorder(new Color(0, 0, 0), 2));

		table.setModel(new DefaultTableModel(new Object[][] { { 1, null, null, null }, { 2, null, null, null },
				{ 3, null, null, null }, { 4, null, null, null }, { 5, null, null, null }, { 6, null, null, null },
				{ 7, null, null, null }, { 8, null, null, null }, { 9, null, null, null }, { 10, null, null, null },
				{ 11, null, null, null }, { 12, null, null, null }, { 13, null, null, null }, { 14, null, null, null },
				{ 15, null, null, null }, { 16, null, null, null }, { 17, null, null, null }, { 18, null, null, null },
				{ 19, null, null, null }, { 20, null, null, null }, },
				new String[] { "Q #", "Grade", "Topic", "Misc" }) {
			Class<?>[] columnTypes = new Class[] { Integer.class, String.class, String.class, Object.class };

			public Class<?> getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(36);
		table.getColumnModel().getColumn(1).setPreferredWidth(55);
		table.getColumnModel().getColumn(2).setPreferredWidth(85);
		table.getColumnModel().getColumn(3).setPreferredWidth(50);
		jPanelTab1.add(panel3_QReview);

		JScrollPane scrollPane_11 = new JScrollPane();
		// ((JTextComponent) scrollPane_11).setCaretPosition(0);
		scrollPane_11.setBounds(20, 12, 420, 475);
		jPanelTab1.add(scrollPane_11);

		textPane = new JTextPane();
		textPane.requestFocusInWindow();		
		DefaultCaret caretPreview = (DefaultCaret) textPane.getCaret();
		caretPreview.setUpdatePolicy(DefaultCaret.UPDATE_WHEN_ON_EDT);
		textPane.setCaretPosition(0);

		textPane.setFont(new Font("Tahoma", Font.BOLD, 14));
		textPane.setBorder(new EmptyBorder(10, 10, 10, 10));		
		scrollPane_11.setViewportView(textPane);

		JButton btnClearTextPane = new JButton("Clear ^");
		btnClearTextPane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPane.setText("");
				aGroup.clearSelection();
			}
		});
		btnClearTextPane.setBounds(333, 494, 87, 23);
		jPanelTab1.add(btnClearTextPane);
		tabbedPane.setTabComponentAt(0, jLabeltab1);

		JPanel jpanel2 = new JPanel();
		jpanel2.setBackground(new Color(192, 192, 192));
		JPanel jPanelExSumReview = new JPanel();
		jPanelExSumReview.setBackground(new Color(224, 224, 224));

		jPanelExSumReview.setLayout(null);
		JPanel panelExSumRev = new JPanel();
		panelExSumRev.setBounds(10, 11, 278, 413);
		jPanelExSumReview.add(panelExSumRev);

		panelExSumRev.setLayout(null);
		JScrollPane scrollPane_6 = new JScrollPane();
		scrollPane_6.setBounds(0, 0, 280, 413);
		panelExSumRev.add(scrollPane_6);

		JScrollPane scrollPaneFAQ = new JScrollPane();
		scrollPaneFAQ.setBounds(298, 10, 280, 414);
		jPanelExSumReview.add(scrollPaneFAQ);

		JTextArea textAreaFAQ = new JTextArea();
		textAreaFAQ.setWrapStyleWord(true);
		scrollPaneFAQ.setViewportView(textAreaFAQ);
		textAreaFAQ.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textAreaFAQ.setMargin(new Insets(10, 10, 10, 10));
		textAreaFAQ.setLineWrap(true);

		JList<String> JListFAQ = new JList<>();
		JListFAQ.setBounds(10, 5, 224, 398);
		JListFAQ.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JListFAQ.setModel(new AbstractListModel<String>() {
			String[] values = new String[] { "THE BRAIN TESTER FAQ", "Select an Exam", "Begin an Exam",
					"Navigating with Next/Previous", "Evaluate/Grade/Finish your Exam", "Review Graded Exams",
					"Individual Exam Details", "Troubleshooting Problems", "Available", "Misc" };

			public int getSize() {
				return values.length;
			}

			public String getElementAt(int index) {
				return values[index];
			}
		});

		JListFAQ.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		JListFAQ.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
					if (JListFAQ.getSelectedIndex() != -1) {
						selectedValue = (String) JListFAQ.getSelectedValue();
						// This is used IN THE SECOND JList
						selectedExamIndex = JListFAQ.getSelectedIndex();
						FAQData faqData = new FAQData();

						if (selectedExamIndex == 0) {
							textAreaFAQ.setText("");
						} else if (selectedExamIndex == 1) {
							// Assign a variable of text to the textAreaFAQ
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 2) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 3) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 4) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 5) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 6) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 7) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 8) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						} else if (selectedExamIndex == 9) {
							textAreaFAQ.setText(faqData.loadFAQData(selectedExamIndex));
						}
					}
				}
			}
		});

		JListFAQ.setFont(new Font("Tahoma", Font.PLAIN, 14));

		scrollPane_6.setViewportView(JListFAQ);
		tabbedPane.addTab("FAQ", jPanelExSumReview);

		JPanel jpanel3 = new JPanel();
		jpanel3.setBackground(new Color(192, 192, 192));
		JPanel jPanelTab3 = new JPanel();
		jPanelTab3.setBackground(new Color(240, 240, 240));
		tabbedPane.addTab("Miscellaneous", jPanelTab3);
		jPanelTab3.setLayout(null);		

		JScrollPane scrollPane_7 = new JScrollPane();
		scrollPane_7.setBounds(10, 10, 319, 441);

		// I won't be using this for FAQ using links. Use the Jlist version
		// for faq instead.
		// But keep it for posterity, and, I can't get it to work properly
		JEditorPane editorPaneFAQ = new JEditorPane();
		editorPaneFAQ.addHyperlinkListener(new HyperlinkListener() {
			@Override
			public void hyperlinkUpdate(HyperlinkEvent e) {
				if (e.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
					System.out.println(" 2 so where is the problem?");
					if (e.getDescription().startsWith("#")) {
						System.out.println(e.getDescription() + " A)  e.getDescription()");
						System.out.println(e.getDescription().substring(1) + " B)  e.getDescription().substring(1)");
						editorPaneFAQ.scrollToReference(e.getDescription().substring(1));
						System.out.println(" 3 so where is the problem?");
					} else {
						try {
							Desktop.getDesktop().browse(e.getURL().toURI());
							System.out.println(" 4 so where is the problem?");
						} catch (IOException | java.net.URISyntaxException ex) {
							ex.printStackTrace();
						}
					}
				}
			}
		});

		scrollPane_7.add(editorPaneFAQ);
		jPanelTab3.add(scrollPane_7);

		scrollPane_7.setViewportView(editorPaneFAQ);
		editorPaneFAQ.setEditable(false);
		editorPaneFAQ.setEditorKit(new HTMLEditorKit());		

		editorPaneFAQ.setContentType("text/html");
		editorPaneFAQ.setBorder(new EmptyBorder(10, 10, 10, 10));
		editorPaneFAQ.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JButton btnNewButton = new JButton("Next  ->");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textAreaExplanation.setBackground(null);
				// DO NOT DELETE THIS COMMENT - countEval = 0; is very important to prevent
				// adding additional radioButtonSelections to the gradeOnceListOfListsSER
				// String previouslySelectedCommand = null;
				// String prevSelectCommandChk = null;

				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must select an exam to review it.");
				} else {
					SERListNull: if (listOfQuestionsSER == null) {
						JOptionPane.showMessageDialog(null, "You must first select an exam to review it.");
						break SERListNull;
					} else {
						if (indexOfSelected == null && listOfQuestionsSER.get(0).getQuestionGraded() == false) {
							JOptionPane.showMessageDialog(null,
									"You must first select an answer and click 'Evaluate' to move on.");
						} else {
							aGroup.clearSelection();
							indexOfSelected = null;
							isCompletedQ = false;
							countEval = 0;
							if (listOfQuestionsSER == null) {
								JOptionPane.showMessageDialog(null, "You cannot click the Next, \n"
										+ "Evaluate or Finish buttons until you begin an exam.");
							} else {
								aGroup.clearSelection();
								prevQTitle = "";
								prevQTopic = "";
								prevQuestion = "";
								prevAns1 = "";
								prevAns2 = "";
								prevAns3 = "";
								prevAns4 = "";
								prevAns5 = "";

								prevCorrectAns1 = "";
								prevCorrectAns2 = "";
								prevCorrectAns3 = "";
								prevCorrectAns4 = "";
								prevCorrectAns5 = "";
								prevExplanation = "";

								textFieldQuestNum.setText("");
								textFieldExTitle.setText("");
								textFieldTopic.setText("");
								txtAreaQuestion.setText("");
								textAreaAns1.setText("");
								textAreaAns2.setText("");
								textAreaAns3.setText("");
								textAreaAns4.setText("");
								textAreaAns5.setText("");
								textPane.setText("");
								textAreaExplanation.setText("");

								textFieldPassOrFail.setText("");

								textFieldQuestNum.setBackground(null);
								textFieldExTitle.setBackground(null);
								textFieldTopic.setBackground(null);
								txtAreaQuestion.setBackground(null);
								textAreaAns1.setBackground(null);
								textAreaAns2.setBackground(null);
								textAreaAns3.setBackground(null);
								textAreaAns4.setBackground(null);
								textAreaAns5.setBackground(null);

								if (qIndex + 1 == listOfQuestionsSER.size()) {
									JOptionPane.showMessageDialog(null,
											"There's no more 'Next'. \nYou have reached the last question, "
													+ listOfQuestionsSER.size() + "/" + listOfQuestionsSER.size()
													+ ".\n" + "Click 'Finish', or if reviewing, click 'Previous', \n"
													+ "or select a review button.");
								} else {
									if (qIndex < listOfQuestionsSER.size() - 1) {
										if ((qIndex < listOfQuestionsSER.size() - 1)) {
											qIndex = qIndex + 1;
											qNumber = qNumber + 1;
											textFieldLastName.setText(listOfQuestionsSER.get(0).getStudentLastName());
											textFieldStudentFirstName
													.setText(listOfQuestionsSER.get(0).getStudentFirstName());
										}
										// When the FIRST next is clicked it
										// should retrieve the second question, on down the line
										questionObject = listOfQuestionsSER.get(qIndex);

										if (questionObject.isQuestionGraded() == false) {
											textFieldLastName.setText(listOfQuestionsSER.get(0).getStudentLastName());
											textFieldStudentFirstName
													.setText(listOfQuestionsSER.get(0).getStudentFirstName());
											textFieldQNum.setText(qNumber.toString() + "/" + listOfQuestionsSER.size());
											textFieldQuestNum.setText(qNumber.toString());
											textFieldExTitle.setText(questionObject.getTitle());
											textFieldTopic.setText(questionObject.getQuestionTopic());
											txtAreaQuestion.setText(questionObject.getQuestion());
											textAreaAns1.setText(questionObject.getAnswer1());
											textAreaAns2.setText(questionObject.getAnswer2());
											textAreaAns3.setText(questionObject.getAnswer3());
											textAreaAns4.setText(questionObject.getAnswer4());
											textAreaAns5.setText(questionObject.getAnswer5());

										} else if (questionObject.isQuestionGraded() == true) {
											restoreSelection();
											textFieldLastName.setText(listOfQuestionsSER.get(0).getStudentLastName());
											textFieldStudentFirstName
													.setText(listOfQuestionsSER.get(0).getStudentFirstName());
											textFieldQNum.setText(qNumber.toString());
											textFieldQuestNum.setText(qNumber.toString());
											textFieldExTitle.setText(questionObject.getTitle());
											textFieldTopic.setText(questionObject.getQuestionTopic());
											txtAreaQuestion.setText(questionObject.getQuestion());
											textAreaAns1.setText(questionObject.getCorrectAnswer1());
											textAreaAns2.setText(questionObject.getCorrectAnswer2());
											textAreaAns3.setText(questionObject.getCorrectAnswer3());
											textAreaAns4.setText(questionObject.getCorrectAnswer4());
											textAreaAns5.setText(questionObject.getCorrectAnswer5());

											// Wrong, try textAreaExplanation
											// textPane.setText(questionObject.getExplanation());
											textAreaExplanation.setText(questionObject.getExplanation());											

											// Previews already evaluated questions in the preview pane
											if (listOfQuestionsSER.get(qIndex).isQuestionGraded() == true) {
												prevQTitle = listOfQuestionsSER.get(qIndex).getTitle();
												prevQTopic = listOfQuestionsSER.get(qIndex).getQuestionTopic();
												prevQuestion = listOfQuestionsSER.get(qIndex).getQuestion();
												prevAns1 = listOfQuestionsSER.get(qIndex).getAnswer1();
												prevCorrectAns1 = listOfQuestionsSER.get(qIndex).getCorrectAnswer1();
												prevAns2 = listOfQuestionsSER.get(qIndex).getAnswer2();
												prevCorrectAns2 = listOfQuestionsSER.get(qIndex).getCorrectAnswer2();
												prevAns3 = listOfQuestionsSER.get(qIndex).getAnswer3();
												prevCorrectAns3 = listOfQuestionsSER.get(qIndex).getCorrectAnswer3();
												prevAns4 = listOfQuestionsSER.get(qIndex).getAnswer4();
												prevCorrectAns4 = listOfQuestionsSER.get(qIndex).getCorrectAnswer4();
												prevAns5 = listOfQuestionsSER.get(qIndex).getAnswer5();
												prevCorrectAns5 = listOfQuestionsSER.get(qIndex).getCorrectAnswer5();
												prevExplanation = listOfQuestionsSER.get(qIndex).getExplanation();
												
												displayReviewQuestion(listOfQuestionsSER.get(qIndex), qIndex);
											}
										}
									}
								}
							}
						}
					}
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(303, 711, 80, 21);
		getContentPane().add(btnNewButton);

		JButton btnNewButton_1 = new JButton("<-  Previous");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (selectedExamIndex == null) {
					JOptionPane.showMessageDialog(null, "You must select an exam to review it.");
				} else {
					PreviousNull: if (listOfQuestionsSER == null) {
						JOptionPane.showMessageDialog(null,
								"You cannot click the Next, Evaluate or \n"
										+ "Finish buttons until you begin an exam. \n"
										+ "'Previous' works only when reviewing graded exams. \n"
										+ "Additionally, if you wish to review a graded exam \n"
										+ "the 'Previous' button works only if you select an exam to review.");
						break PreviousNull;
					} else {

						if (listOfQuestionsSER != null) {
							if (listOfQuestionsSER.get(0).getIsExamFinished() == false) {
								JOptionPane.showMessageDialog(null,
										"You cannot click the 'Previous' button until \nyou review a finished "
												+ "and graded exam. \nClick 'Evaluate', or 'Next' to proceed to the next question, or 'Finish'");
							} else {
								aGroup.clearSelection();
								prevQTitle = "";
								prevQTopic = "";
								prevQuestion = "";
								prevAns1 = "";
								prevAns2 = "";
								prevAns3 = "";
								prevAns4 = "";
								prevExplanation = "";

								prevCorrectAns1 = "";
								prevCorrectAns2 = "";
								prevCorrectAns3 = "";
								prevCorrectAns4 = "";

								textFieldQNum.setText("");
								textFieldExTitle.setText("");
								textFieldTopic.setText("");
								txtAreaQuestion.setText("");
								textAreaAns1.setText("");
								textAreaAns2.setText("");
								textAreaAns3.setText("");
								textAreaAns4.setText("");
								textFieldPassOrFail.setText("");

								textFieldQNum.setBackground(null);
								textFieldExTitle.setBackground(null);
								textFieldTopic.setBackground(null);
								txtAreaQuestion.setBackground(null);
								textAreaAns1.setBackground(null);
								textAreaAns2.setBackground(null);
								textAreaAns3.setBackground(null);
								textAreaAns4.setBackground(null);

								if (qIndex > 0) {
									qIndex = qIndex - 1;
									qNumber = qNumber - 1;
									System.out.println(qIndex + " 3) Previous qIndex is ____ ");
									System.out.println(qNumber + " 4) Previous qNumber is ____");
								}

								if (listOfQuestionsSER.get(qIndex).isQuestionGraded() == false) {
									textFieldLastName.setText(listOfQuestionsSER.get(qIndex).getStudentLastName());

									textFieldStudentFirstName.setText(questionObject.getStudentFirstName());

									textFieldQNum.setText(qNumber.toString());
									textFieldQuestNum.setText(qNumber.toString());
									textFieldExTitle.setText(listOfQuestionsSER.get(qIndex).getTitle());
									textFieldTopic.setText(listOfQuestionsSER.get(qIndex).getQuestionTopic());
									txtAreaQuestion.setText(listOfQuestionsSER.get(qIndex).getQuestion());
									textAreaAns1.setText(listOfQuestionsSER.get(qIndex).getAnswer1());
									textAreaAns2.setText(listOfQuestionsSER.get(qIndex).getAnswer2());
									textAreaAns3.setText(listOfQuestionsSER.get(qIndex).getAnswer3());
									textAreaAns4.setText(listOfQuestionsSER.get(qIndex).getAnswer4());
								} else if (listOfQuestionsSER.get(qIndex).isQuestionGraded() == true) {
									restoreSelection();
									textFieldLastName.setText(listOfQuestionsSER.get(0).getStudentLastName());
									textFieldStudentFirstName.setText(listOfQuestionsSER.get(0).getStudentFirstName());
									textFieldQNum.setText(qNumber.toString());
									textFieldQuestNum.setText(qNumber.toString());
									textFieldExTitle.setText(listOfQuestionsSER.get(qIndex).getTitle());
									textFieldTopic.setText(listOfQuestionsSER.get(qIndex).getQuestionTopic());
									txtAreaQuestion.setText(listOfQuestionsSER.get(qIndex).getQuestion());
									textAreaAns1.setText(listOfQuestionsSER.get(qIndex).getCorrectAnswer1());
									textAreaAns2.setText(listOfQuestionsSER.get(qIndex).getCorrectAnswer2());
									textAreaAns3.setText(listOfQuestionsSER.get(qIndex).getCorrectAnswer3());
									textAreaAns4.setText(listOfQuestionsSER.get(qIndex).getCorrectAnswer4());
								}

								// Set the variables for the preview pane
								// 8-4 But you need to use these variables, and you are not
								// but calling displayReviewQuestion(listOfQuestionsSER.get(qIndex), qIndex); below
								// seems to fix the problem
								if (listOfQuestionsSER.get(qIndex).isQuestionGraded() == true) {
									restoreSelection();
									prevQTitle = listOfQuestionsSER.get(qIndex).getTitle();
									prevQTopic = listOfQuestionsSER.get(qIndex).getQuestionTopic();
									prevQuestion = listOfQuestionsSER.get(qIndex).getQuestion();
									prevAns1 = listOfQuestionsSER.get(qIndex).getAnswer1();
									prevCorrectAns1 = listOfQuestionsSER.get(qIndex).getCorrectAnswer1();
									prevAns2 = listOfQuestionsSER.get(qIndex).getAnswer2();
									prevCorrectAns2 = listOfQuestionsSER.get(qIndex).getCorrectAnswer2();
									prevAns3 = listOfQuestionsSER.get(qIndex).getAnswer3();
									prevCorrectAns3 = listOfQuestionsSER.get(qIndex).getCorrectAnswer3();
									prevAns4 = listOfQuestionsSER.get(qIndex).getAnswer4();
									prevCorrectAns4 = listOfQuestionsSER.get(qIndex).getCorrectAnswer4();
									prevExplanation = listOfQuestionsSER.get(qIndex).getExplanation();
									
									displayReviewQuestion(listOfQuestionsSER.get(qIndex), qIndex);
								}
							}
						}
					}
				}
			}
		});

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_1.setBounds(33, 711, 113, 21);
		getContentPane().add(btnNewButton_1);

		JLabel lblNewLabel = new JLabel("Title");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(68, 133, 30, 13);
		getContentPane().add(lblNewLabel);

		textFieldExTitle = new JTextField();
		textFieldExTitle.setBounds(102, 131, 140, 19);
		getContentPane().add(textFieldExTitle);
		textFieldExTitle.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Topic");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(228, 133, 45, 13);
		getContentPane().add(lblNewLabel_1);

		textFieldTopic = new JTextField();
		textFieldTopic.setBounds(278, 131, 110, 19);
		getContentPane().add(textFieldTopic);
		textFieldTopic.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Exam");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(0, 133, 40, 13);
		getContentPane().add(lblNewLabel_2);

		textFieldExNumber = new JTextField();
		textFieldExNumber.setBounds(44, 131, 30, 19);
		getContentPane().add(textFieldExNumber);
		textFieldExNumber.setColumns(10);

		textFieldQNum = new JTextField();
		textFieldQNum.setBackground(new Color(255, 255, 255));
		textFieldQNum.setEditable(false);
		textFieldQNum.setHorizontalAlignment(SwingConstants.RIGHT);
		textFieldQNum.setFont(new Font("Tahoma", Font.BOLD, 10));
		textFieldQNum.setBounds(3, 163, 35, 48);
		getContentPane().add(textFieldQNum);
		textFieldQNum.setColumns(12);

		JButton btnNewButton_2 = new JButton("Evaluate");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (listOfQuestionsSER == null) {
					JOptionPane.showMessageDialog(null,
							"You may only click 'Evaluate' while "
									+ "taking an exam, \nnot while reviewing a graded exam, \n"
									+ "or before selecting an exam to review, \n" + "or before beginning an exam.");
				} else if (listOfQuestionsSER.get(0).getIsExamFinished() == true) {
					JOptionPane.showMessageDialog(null,
							"This exam has been taken and graded.\n " + "You cannot evaluate a graded exam.");
				} else {
					// Only allow one evaluation
					evalOnceOnly: if (isCompletedQ == true) {
						JOptionPane.showMessageDialog(null, "You may only click 'Evaluate' once per question");
						break evalOnceOnly;
					} else {
						evalJustOnce: if (listOfQuestionsSER == null) {
							JOptionPane.showMessageDialog(null,
									"You cannot click the Previous, Next, \n"
											+ "Evaluate or Finish buttons until you begin an exam. \n"
											+ "Or, if you wish to review an exam you \n " + "must select it first");
						} else {
							if (indexOfSelected != null) {
								JOptionPane.showMessageDialog(null, "You may only make one selection per evaluation. \n"
										+ "click 'Next' to proceed to the next question.");
							} else {
								ArrayList<Boolean> radioButtonSelections = new ArrayList<Boolean>();
								for (int i = 0; i < 5; i++) {
									radioButtonSelections.add(false);
								}

								if (radioBtn1.isSelected()) {
									selected++;
									radioButtonSelections.set(0, true);
									indexOfSelected = 0;
								} else {
									radioButtonSelections.set(0, false);
								}

								if (radioBtn2.isSelected()) {
									selected++;
									radioButtonSelections.set(1, true);
									indexOfSelected = 1;
								} else {
									radioButtonSelections.set(1, false);
								}

								if (radioBtn3.isSelected()) {
									selected++;
									radioButtonSelections.set(2, true);
									indexOfSelected = 2;
									System.out.println();
								} else {
									radioButtonSelections.set(2, false);
								}

								if (radioBtn4.isSelected()) {
									selected++;
									radioButtonSelections.set(3, true);
									indexOfSelected = 3;
									System.out.println();
								} else {
									radioButtonSelections.set(3, false);
								}

								if (radioBtn5.isSelected()) {
									selected++;
									radioButtonSelections.set(4, true);
									indexOfSelected = 4;
									System.out.println();
								} else {
									radioButtonSelections.set(4, false);
								}
								System.out.println("I'm in the Evaluate button?");
								if (indexOfSelected == null) {
									JOptionPane.showMessageDialog(null,
											"You must select an answer, even if its a wild guess");
								} else {
									OuterMasterCorrectAnswers outerMasterCorrectAnswers = new OuterMasterCorrectAnswers();
									try {
										outerMasterCorrectAnswersProfs = outerMasterCorrectAnswers
												.getOuterMasterCorrectAns();
										System.out.println("pocriut948594");
										masterListOfProfsCorrectAnswers = outerMasterCorrectAnswersProfs
												.get(selectedExamIndex);
										System.out.println("l[spcoc0494094");

									} catch (ClassNotFoundException | SQLException | IOException e1) {
										e1.printStackTrace();
									}
									
									theProfsCorrectAnswers = masterListOfProfsCorrectAnswers.get(qIndex);

									listOfQuestionsSER.get(qIndex).setStudentLastName(textFieldLastName.getText());
									if (evalGradeImmediately == true) { // Global set in Begin Exam button
										textFieldLastName.setText(listOfQuestionsSER.get(qIndex).getStudentLastName());
										listOfQuestionsSER.get(qIndex).setQuestionGraded(true);
										isQGraded = listOfQuestionsSER.get(qIndex).getQuestionGraded();
										int indexOfFalseSelected;
										int indexOfTrueSelected;
										// The test whether true or false, comparing
										// student's and instructor's Boolean lists
										if (radioButtonSelections.equals(theProfsCorrectAnswers)) {
											listOfQuestionsSER.get(qIndex).setPassFail("PASS");
											listOfQuestionsSER.get(qIndex).setPassFailMessage("CORRECT");// Used?
											textFieldPassOrFail.setText(listOfQuestionsSER.get(qIndex).getPassFail());
											indexOfTrueSelected = indexOfSelected;
											for (int j = 0; j < theProfsCorrectAnswers.size(); ++j) {
												if (theProfsCorrectAnswers.get(j) == true) {
													indexOfTrueSelected = j;
												}
											}

											switch (indexOfTrueSelected) { // This switch is for the correct answer
																			// displayed
											case 0:
												textAreaAns1.setText(
														"A) CORRECT - " + listOfQuestionsSER.get(qIndex).getAnswer1());
												textAreaAns1.setBackground(Color.green);
												textAreaAns2
														.setText("B) " + listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3
														.setText("C) " + listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns4
														.setText("D) " + listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5
														.setText("E) " + listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 1:
												textAreaAns1
														.setText("A) " + listOfQuestionsSER.get(qIndex).getAnswer1());
												textAreaAns2.setText(
														"B) CORRECT - " + listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns2.setBackground(Color.green);
												textAreaAns3
														.setText("C) " + listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns4
														.setText("D) " + listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5
														.setText("E) " + listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 2:
												textAreaAns1
														.setText("A) " + listOfQuestionsSER.get(qIndex).getAnswer1());
												textAreaAns2
														.setText("B) " + listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3.setText(
														"C) CORRECT - " + listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns3.setBackground(Color.green);
												textAreaAns4
														.setText("D) " + listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5
														.setText("E) " + listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 3:
												textAreaAns1
														.setText("A) " + listOfQuestionsSER.get(qIndex).getAnswer1());
												textAreaAns2
														.setText("B) " + listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3
														.setText("C) " + listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns4.setText(
														"D) CORRECT - " + listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns4.setBackground(Color.green);
												textAreaAns5
														.setText("E) " + listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 4:
												textAreaAns1
														.setText("A) " + listOfQuestionsSER.get(qIndex).getAnswer1());
												textAreaAns2
														.setText("B) " + listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3
														.setText("C) " + listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns4
														.setText("D) " + listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5.setText(
														"E) CORRECT - " + listOfQuestionsSER.get(qIndex).getAnswer5());
												textAreaAns5.setBackground(Color.green);
												break;
											}
										} else if (!radioButtonSelections.equals(theProfsCorrectAnswers)) {
											indexOfFalseSelected = indexOfSelected;
											listOfQuestionsSER.get(qIndex).setPassFail("FAIL");
											listOfQuestionsSER.get(qIndex).setPassFailMessage("INCORRECT");
											textFieldPassOrFail.setText(listOfQuestionsSER.get(qIndex).getPassFail());

											String correctAnswer = "Correct Answer"; // remove?
											boolean selectedCorrect;
											Integer selectedIntIndex = null;
											// Get the index of the boolean true value of the
											// profs correct answers and use it to set the
											// corresponding correctAnswer_ = "CORRECT ANSWER -";
											for (int i = 0; i < 5; i++) {
												if (theProfsCorrectAnswers.get(i) == true) {
													selectedIntIndex = i;
													break;
												}
											}
											// Remember, all these variables are defaulted to value "";
											if (selectedIntIndex == 0) {
												correctAnswer0 = "CORRECT ANSWER -";
											} else if (selectedIntIndex == 1) {
												correctAnswer1 = "CORRECT ANSWER -";
											} else if (selectedIntIndex == 2) {
												correctAnswer2 = "CORRECT ANSWER -";
											} else if (selectedIntIndex == 3) {
												correctAnswer3 = "CORRECT ANSWER -";
											} else if (selectedIntIndex == 4) {
												correctAnswer4 = "CORRECT ANSWER -";
											}

											switch (indexOfFalseSelected) { // This switch is for the FALSE answer
																			// displayed
											case 0:

												textAreaAns1.setText("A) " + correctAnswer0 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer1());
												System.out.println(qIndex + " qIndex k clkurie637");
												textAreaAns1.setBackground(Color.red);
												textAreaAns2.setText("B) " + correctAnswer1 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3.setText("C) " + correctAnswer2 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns4.setText("D) " + correctAnswer3 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5.setText("E) " + correctAnswer4 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 1:
												textAreaAns1.setText("A) " + correctAnswer0 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer1());
												System.out.println(qIndex + " qIndex luri475");
												textAreaAns2.setText("B) " + correctAnswer1 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns2.setBackground(Color.red);
												textAreaAns3.setText("C) " + correctAnswer2 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns4.setText("D) " + correctAnswer3 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5.setText("E) " + correctAnswer4 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 2:
												textAreaAns1.setText("A) " + correctAnswer0 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer1());
												System.out.println(qCount + " qCount oeict984");
												textAreaAns2.setText("B) " + correctAnswer1 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3.setText("C) " + correctAnswer2 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns3.setBackground(Color.red);
												textAreaAns4.setText("D) " + correctAnswer3 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5.setText("E) " + correctAnswer4 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 3:
												textAreaAns1.setText("A) " + correctAnswer0 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer1());
												textAreaAns2.setText("B) " + correctAnswer1 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3.setText("C) " + correctAnswer2 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns4.setText("D) " + " " + correctAnswer3 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns4.setBackground(Color.red);
												textAreaAns5.setText("E) " + correctAnswer4 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer5());
												break;
											case 4:
												textAreaAns1.setText("A) " + correctAnswer0 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer1());
												textAreaAns2.setText("B) " + correctAnswer1 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer2());
												textAreaAns3.setText("C) " + correctAnswer2 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer3());
												textAreaAns4.setText("D) " + correctAnswer3 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer4());
												textAreaAns5.setText("E) " + " " + correctAnswer4 + " "
														+ listOfQuestionsSER.get(qIndex).getAnswer5());
												textAreaAns5.setBackground(Color.red);
												break;
											}
											correctAnswer0 = "";
											correctAnswer1 = "";
											correctAnswer2 = "";
											correctAnswer3 = "";
											correctAnswer4 = "";
											
										}

										// Preview in the preview pane.
										prevQTitle = listOfQuestionsSER.get(qIndex).getTitle();
										prevQTopic = textFieldTopic.getText();
										prevQuestion = txtAreaQuestion.getText();
										prevAns1 = listOfQuestionsSER.get(qIndex).getAnswer1();
										prevCorrectAns1 = listOfQuestionsSER.get(qIndex).getCorrectAnswer1();
										prevAns2 = listOfQuestionsSER.get(qIndex).getAnswer2();
										prevCorrectAns2 = listOfQuestionsSER.get(qIndex).getCorrectAnswer2();
										prevAns3 = listOfQuestionsSER.get(qIndex).getAnswer3();
										prevCorrectAns3 = listOfQuestionsSER.get(qIndex).getCorrectAnswer3();
										prevAns4 = listOfQuestionsSER.get(qIndex).getAnswer4();
										prevCorrectAns4 = listOfQuestionsSER.get(qIndex).getCorrectAnswer4();
										prevAns5 = listOfQuestionsSER.get(qIndex).getAnswer5();
										prevCorrectAns5 = listOfQuestionsSER.get(qIndex).getCorrectAnswer5();
										prevExplanation = listOfQuestionsSER.get(qIndex).getExplanation();
										
										if (prevAns1.equals("True") || prevAns2.equals("False")) {
											System.out.println("ko8547sjey");
											textPane.setCaretPosition(0);
											textPane.setText("Title: " + prevQTitle + "\n" + "Topic:" + prevQTopic
													+ "\n" + "Question: " + prevQuestion + "\n\n" + "A) " + prevAns1
													+ "\n" + "" + prevCorrectAns1 + "\n\n" + "B) " + prevAns2 + "\n"
													+ "" + prevCorrectAns2 + "\n\n");
										} else {
											textPane.setCaretPosition(0);
											textPane.setText("Title: " + prevQTitle + "\n" + "Topic:" + prevQTopic
													+ "\n" + "Question: " + prevQuestion + "\n\n" + "A) " + prevAns1
													+ "\n\n" + "" + prevCorrectAns1 + "\n\n" + "B) " + prevAns2 + "\n\n"
													+ "" + prevCorrectAns2 + "\n\n" + "C) " + prevAns3 + "\n\n" + ""
													+ prevCorrectAns3 + "\n\n" + "D) " + prevAns4 + "\n\n" + ""
													+ prevCorrectAns4 + "\n\n" + "E) " + prevAns5 + "\n\n"
													+ prevCorrectAns5 + "\n\n" + "Explanation: " + prevExplanation);
										}
										// Don't need this either, but double check
										questionNumberBeingEvaluated++;
										selected = 0;
										isCompletedQ = true;

										// BEGIN NON-IMMEDIATE GradeOnce EVALUATION
										// ####################################################################################################

									} else if (evalGradeImmediately == false) {
										textAreaExplanation.setBackground(null);
										var evaluateAnswersLists = new EvaluateAnswersLists();
										try {
											gradeOnceListOfListsSER = evaluateAnswersLists.getEvaluatedList();
											int rowCount = evaluateAnswersLists.getRowCountEvaluated();
											if (gradeOnceListOfListsSER == null && rowCount < 1) {
												gradeOnceListOfListsSER = new ArrayList<ArrayList<Boolean>>();
												evaluateAnswersLists.insertOuterMasterAnswers(gradeOnceListOfListsSER);
												gradeOnceListOfListsSER = evaluateAnswersLists.getEvaluatedList();
											}
										} catch (ClassNotFoundException | SQLException | IOException e1) {
											e1.printStackTrace();
										}

										countEval++;
										if (countEval > 1) {
											JOptionPane.showMessageDialog(null,
													"You may only click 'Evaluate' once per question");
											break evalJustOnce;
											// Add the answer here
										} else if (countEval <= 1) {
											gradeOnceListOfListsSER.add(radioButtonSelections);
											// Now set it in the table
											try {
												evaluateAnswersLists
														.setUpdateOuterMasterAnswers(gradeOnceListOfListsSER);
												gradeOnceListOfListsSER = evaluateAnswersLists.getEvaluatedList();
											} catch (ClassNotFoundException | SQLException | IOException e1) {
												e1.printStackTrace();
											}
										}
									}
									textAreaExplanation.setBackground(Color.LIGHT_GRAY);
								}
							}
						}
					}
				}
			}
		});

		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton_2.setBounds(208, 711, 85, 21);
		getContentPane().add(btnNewButton_2);

		textFieldPassOrFail = new JTextField();
		textFieldPassOrFail.setForeground(new Color(255, 0, 0));
		textFieldPassOrFail.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldPassOrFail.setBackground(new Color(230, 232, 227));
		textFieldPassOrFail.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldPassOrFail.setBounds(498, 707, 96, 25);
		getContentPane().add(textFieldPassOrFail);
		textFieldPassOrFail.setColumns(10);

		JLabel lblQNumber = new JLabel("Q # ");
		lblQNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblQNumber.setBounds(148, 715, 21, 13);
		getContentPane().add(lblQNumber);

		JButton btnFinish = new JButton("Finish");
		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Top of Finish button");
				// Limit the size of saved exams to 10
				try {
					outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
					System.out.println(",OCI94854");
					innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
					System.out.println(",meoci458749");
				} catch (ClassNotFoundException | IOException | SQLException e1) {
					e1.printStackTrace();
				}
				if (innerMasterListOfQuestionsSER.size() >= 10) {
					DBTesterUtility dBTesterUtility = new DBTesterUtility();
					try {
						innerMasterListOfQuestionsSER = dBTesterUtility.deleteGradedRowInReview(selectedExamIndex,
								innerMasterListOfQuestionsSER);
						System.out.println(innerMasterListOfQuestionsSER.size()
								+ " innerMasterListOfQuestionsSER.size() pr90554m");
					} catch (Exception ex) {
					}
					// Now set innerMasterListOfQuestionsSER back in the table
					outerMasterListofMastersSER.set(selectedExamIndex, innerMasterListOfQuestionsSER);
					try {
						setOuterMasterListOfMastersSER(selectedExamIndex, outerMasterListofMastersSER);
					} catch (ClassNotFoundException | SQLException | IOException e1) {
						e1.printStackTrace();
					}
					try {
						outerMasterListofMastersSER = getOuterMasterListOfMastersSER();
					} catch (ClassNotFoundException | IOException | SQLException e1) {
						e1.printStackTrace();
					}
					// And do what with this innerMasterListOfQuestionsSER?
					innerMasterListOfQuestionsSER = outerMasterListofMastersSER.get(selectedExamIndex);
				}

				if (listOfQuestionsSER == null) {
					JOptionPane.showMessageDialog(null, "You may only click 'Finish' while "
							+ "taking an exam, \nnot while reviewing a graded exam.");
				} else if (listOfQuestionsSER.get(0).getIsExamFinished() == true) {
					JOptionPane.showMessageDialog(null,
							"This exam has been taken and graded.\n " + "You cannot 'Finish' a graded exam.");
				} else {
					EvaluateAnswersLists evaluateAnswersLists = new EvaluateAnswersLists();
					try {
						gradeOnceListOfListsSER = evaluateAnswersLists.getEvaluatedList();
					} catch (ClassNotFoundException | SQLException | IOException e1) {
						e1.printStackTrace();
					}

					if ((gradeOnceListOfListsSER == null || gradeOnceListOfListsSER.size() == 0)
							&& evalGradeImmediately == false) {
						JOptionPane.showMessageDialog(null,
								"You answered no questions.\n" + "You must select at least one answer, even if it's \n"
										+ "a wild guess. Then click 'Evaluate', and then 'Finish' \n"
										+ "to exit and have your exam graded.\n");
					} else {
						aGroup.clearSelection();
						indexOfSelected = null;
						isCompletedQ = false;
						countEval = 0;

						if (listOfQuestionsSER == null) {
							JOptionPane.showMessageDialog(null, "You cannot click the Previous, Next, \n"
									+ "Evaluate or Finish buttons until you begin an exam.");
						} else {
							double countPass = 0;
							double countFail = 0; // Really? Not used?
							Integer numPass = 0;
							aGroup.clearSelection();
							prevQTitle = "";
							prevQTopic = "";
							prevQuestion = "";
							prevAns1 = "";
							prevAns2 = "";
							prevAns3 = "";
							prevAns4 = "";
							prevAns5 = "";

							prevCorrectAns1 = "";
							prevCorrectAns2 = "";
							prevCorrectAns3 = "";
							prevCorrectAns4 = "";
							prevCorrectAns5 = "";
							prevExplanation = "";

							LocalDate dateExamTaken = LocalDate.now();
							String dateOfExamStr = dateExamTaken.toString();
							listOfQuestionsSER.get(qIndex).setDateOfExamStr(dateOfExamStr);
							dateOfExamStr = listOfQuestionsSER.get(qIndex).getDateOfExamStr();
							textFieldDateTime.setText(dateOfExamStr);
							textFieldLastName.setText(listOfQuestionsSER.get(0).getStudentLastName());
							textFieldStudentFirstName.setText(listOfQuestionsSER.get(0).getStudentFirstName());

							// Begin Grade Once
							// ####################################################################
							if (evalGradeImmediately == false) {
								listOfQuestionsSER.get(0).setIsExamFinished(true);
								nowEnd = LocalTime.now();
								String formattedEndTime = nowEnd.format(FORMATTER);
								textFieldEndTime.setText(formattedEndTime);
								Duration totalDuration = Duration.between(nowEnd, nowBegin);
								String formattedDuration = String.format("%d%d%d", totalDuration.toHoursPart(),
										totalDuration.toMinutesPart(), totalDuration.toSecondsPart());
								// It leaves me with an unwanted dash -
								textFieldTime.setText(formattedDuration);
								listOfQuestionsSER.get(0).setTimeExamEnds(formattedEndTime);
								listOfQuestionsSER.get(0).setTimeDuration(formattedDuration);
								OuterMasterCorrectAnswers outerMasterCorrectAnswers = new OuterMasterCorrectAnswers();
								try {
									outerMasterCorrectAnswersProfs = outerMasterCorrectAnswers
											.getOuterMasterCorrectAns();
									masterListOfProfsCorrectAnswers = outerMasterCorrectAnswersProfs
											.get(selectedExamIndex);
								} catch (ClassNotFoundException | SQLException | IOException e1) {
									e1.printStackTrace();
								}

								for (int iv = 0; iv < gradeOnceListOfListsSER.size(); iv++) {

									if (masterListOfProfsCorrectAnswers.get(iv)
											.equals(gradeOnceListOfListsSER.get(iv))) {
										listOfQuestionsSER.get(iv).setPassFail("PASS"); // Default is false
										listOfQuestionsSER.get(iv).setQuestionGraded(true);
									} else {
										listOfQuestionsSER.get(iv).setPassFail("FAIL"); // Default is false
										listOfQuestionsSER.get(iv).setQuestionGraded(true);
									}
								}

								for (int zz = 0; zz < listOfQuestionsSER.size(); zz++) {
									if (listOfQuestionsSER.get(zz).getPassFail().equalsIgnoreCase("PASS")) {
										++countPass;
										++numPass;
									} else {
										++countFail;
									}
								}
								listOfQuestionsSER.get(0).setNumberOfPass(numPass);

								// BEGIN IF EVALUATION IS IMMEDIATE
								// ###############################################################################################
							} else { // if grade immediately
								System.out.println(" In the immediate eval else");
								listOfQuestionsSER.get(0).setIsExamFinished(true);
								nowEnd = LocalTime.now();
								String formattedEndTime = nowEnd.format(FORMATTER);
								textFieldEndTime.setText(formattedEndTime);
								Duration totalDuration = Duration.between(nowEnd, nowBegin);
								String formattedDuration = String.format("%d%d%d", totalDuration.toHoursPart(),
										totalDuration.toMinutesPart(), totalDuration.toSecondsPart());
								// It leaves me with an unwanted dash -
								textFieldTime.setText(formattedDuration);
								listOfQuestionsSER.get(0).setTimeExamEnds(formattedEndTime);
								listOfQuestionsSER.get(0).setTimeDuration(formattedDuration);

								for (int i = 0; i < listOfQuestionsSER.size(); i++) {
									if (listOfQuestionsSER.get(i).getPassFail().equalsIgnoreCase("PASS")) {
										++countPass;
										++numPass;
									} else {
										++countFail;
									}
								}
								listOfQuestionsSER.get(0).setNumberOfPass(numPass);
							}
							double numberOfQuestionsPrim = listOfQuestionsSER.size();
							Double numberOfQuestions = numberOfQuestionsPrim;
							Double perc = countPass / numberOfQuestions;
							percentGrade = (perc * 100);
							listOfQuestionsSER.get(0).setNumberOfPass(numPass);// Always in first question?
							listOfQuestionsSER.get(0).setPercentGrade(percentGrade); // Always in first question?
							if (percentGrade < 68) {
								JOptionPane.showMessageDialog(null,
										"You failed. You had " + countPass + " correct answers out of "
												+ numberOfQuestions + " question[s]" + " for a passing grade of "
												+ percentGrade + "% \n" + " 68 percent is required to pass");
								listOfQuestionsSER.get(qIndex).setPercentGrade(percentGrade);
							} else {
								JOptionPane.showMessageDialog(null,
										"You passed. You had " + countPass + " correct answers out of "
												+ numberOfQuestions + " question[s]" + " for a passing grade of "
												+ String.format("%.2f", percentGrade) + "% \n"
												+ " 68 percent is required to pass");
								listOfQuestionsSER.get(qIndex).setPercentGrade(percentGrade);
							}
							numPass = 0;
							var updateFinalStudentExams = new UpdateFinalStudentExams();

							try {
								updateFinalStudentExams.upDateFinalGradedStudentExams(selectedExamIndex,
										listOfQuestionsSER);
								System.out.println(listOfQuestionsSER + " ;slpoeireiu");

							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}
							textFieldExNumber.setText("");
							textFieldQNum.setText("");
							textFieldExTitle.setText("");
							textFieldTopic.setText("");
							txtAreaQuestion.setText("");
							textAreaAns1.setText("");
							textAreaAns2.setText("");
							textAreaAns3.setText("");
							textAreaAns4.setText("");
							textAreaAns5.setText("");
							textFieldPassOrFail.setText("");
							textAreaExplanation.setText("");

							textFieldQNum.setBackground(null);
							textFieldExTitle.setBackground(null);
							textFieldTopic.setBackground(null);
							txtAreaQuestion.setBackground(null);
							textAreaAns1.setBackground(null);
							textAreaAns2.setBackground(null);
							textAreaAns3.setBackground(null);
							textAreaAns4.setBackground(null);
							textAreaAns5.setBackground(null);
							textAreaExplanation.setBackground(null);
							aGroup.clearSelection();

							textFieldDateTime.setText("");
							textFieldStartTime.setText("");
							textFieldEndTime.setText("");
							textFieldTime.setText("");
							textFieldQNum.setText("");
							textFieldQuestNum.setText("");
							textPane.setText("");
							selectedExamIndex = null;
							if (evalGradeImmediately == false) {
								gradeOnceListOfListsSER.clear();
							}
							InsertInitialOuterNestedPlaceholders insertInitialOuterNestedPlaceholders = new InsertInitialOuterNestedPlaceholders();
							try {
								outerMasterListOfMastersSER = insertInitialOuterNestedPlaceholders
										.getOuterMasterListOfMastersSER();
							} catch (ClassNotFoundException | IOException | SQLException e1) {
								e1.printStackTrace();
							}
							// did Iforget to set this back in the outer??? 
							// Makes no sense
							innerMasterListOfQuestionsSER = outerMasterListOfMastersSER.get(0);
							selectedExamIndex = null;
							listOfQuestionsSER.get(qIndex).setIsExamStarted(false);
							isCurrentExamFinished = true;
							System.out.println("Bottom of Finish button");
						}
					}
				}
			}
		});

		btnFinish.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnFinish.setBounds(408, 710, 80, 21);
		getContentPane().add(btnFinish);
		JLabel jLabel2 = new JLabel("Exam Summary & Review - Scores");
		jLabel2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jLabel2.setBounds(806, 709, 249, 21);
		getContentPane().add(jLabel2);
		{
			JButton cancelButton = new JButton("Cancel");
			cancelButton.setBounds(1316, 708, 80, 23);
			getContentPane().add(cancelButton);
			cancelButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					System.exit(0);
				}
			});
			cancelButton.setActionCommand("Cancel");
		}

		JButton btnNewButton_5 = new JButton("Combo Labels");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JPanel setExLabelsPanel = new JPanel();
				int rowInt = 5;
				setExLabelsPanel.setLayout(new GridLayout(10, 3, 10, 10));
				String CORRECT_PASSWORD = "meboss";
				char[] correctPasswordChar = CORRECT_PASSWORD.toCharArray();
				// PASSWORD PROTECT ACCESS
				JPasswordField passwordField = new JPasswordField(15);
				int action = JOptionPane.showConfirmDialog(null, passwordField, "Enter the correct password",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				PassLabel: if (action == JOptionPane.OK_OPTION) {
					char[] input = passwordField.getPassword();
					if (Arrays.equals(input, correctPasswordChar)) {
						JOptionPane.showMessageDialog(null, "Enter");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error", JOptionPane.ERROR_MESSAGE);
						break PassLabel;
					}

					Arrays.fill(input, '0');
					try {
						examComboLabelsTester = getExamComboLabelsB3();
					} catch (ClassNotFoundException | IOException | SQLException e1) {
						e1.printStackTrace();
					}
					setExLabelsPanel.add(new JLabel("Exam 1 ----> "));
					JTextField jTextField1 = new JTextField(20);
					// STRANGE. IT REQUIRES TO BE HANDLED, BUT THE OTHER BLOCKS
					// WHICH ARE IDENTICAL DON'T. GO FIGURE.
					try {
						jTextField1.setText(examComboLabelsTester.getExam1Str());
					} catch (ClassNotFoundException | IOException | SQLException e1) {
						e1.printStackTrace();
					}
					setExLabelsPanel.add(jTextField1);

					setExLabelsPanel.add(new JLabel("Exam 2 ----> "));
					JTextField jTextField2 = new JTextField(20);
					jTextField2.setText(examComboLabelsTester.getExam2Str());
					setExLabelsPanel.add(jTextField2);

					setExLabelsPanel.add(new JLabel("Exam 3 ----> "));
					JTextField jTextField3 = new JTextField(20);
					jTextField3.setText(examComboLabelsTester.getExam3Str());
					setExLabelsPanel.add(jTextField3);

					setExLabelsPanel.add(new JLabel("Exam 4 ----> "));
					JTextField jTextField4 = new JTextField(20);
					jTextField4.setText(examComboLabelsTester.getExam4Str());
					setExLabelsPanel.add(jTextField4);

					setExLabelsPanel.add(new JLabel("Exam 5 ----> "));
					JTextField jTextField5 = new JTextField(20);
					jTextField5.setText(examComboLabelsTester.getExam5Str());
					setExLabelsPanel.add(jTextField5);

					setExLabelsPanel.add(new JLabel("Exam 6 ----> "));
					JTextField jTextField6 = new JTextField(20);
					jTextField6.setText(examComboLabelsTester.getExam6Str());
					setExLabelsPanel.add(jTextField6);

					setExLabelsPanel.add(new JLabel("Exam 7 ----> "));
					JTextField jTextField7 = new JTextField(20);
					jTextField7.setText(examComboLabelsTester.getExam7Str());
					setExLabelsPanel.add(jTextField7);

					setExLabelsPanel.add(new JLabel("Exam 8 ----> "));
					JTextField jTextField8 = new JTextField(20);
					jTextField8.setText(examComboLabelsTester.getExam8Str());
					setExLabelsPanel.add(jTextField8);

					setExLabelsPanel.add(new JLabel("Exam 9 ----> "));
					JTextField jTextField9 = new JTextField(20);
					jTextField9.setText(examComboLabelsTester.getExam9Str());
					setExLabelsPanel.add(jTextField9);

					setExLabelsPanel.add(new JLabel("Exam 10 ---> "));
					JTextField jTextField10 = new JTextField(20);
					jTextField10.setText(examComboLabelsTester.getExam10Str());
					setExLabelsPanel.add(jTextField10);

					getContentPane().add(setExLabelsPanel);
					setVisible(true);

					int applyOption = JOptionPane.showConfirmDialog(null, setExLabelsPanel,
							"Make your changes and click 'Yes' to apply, or 'No' to exit", JOptionPane.YES_NO_OPTION);

					if (applyOption == 0) { // '0' IS YES
						exam1LabelStr = "";
						exam2LabelStr = "";
						exam3LabelStr = "";
						exam4LabelStr = "";
						exam5LabelStr = "";
						exam6LabelStr = "";
						exam7LabelStr = "";
						exam8LabelStr = "";
						exam9LabelStr = "";
						exam10LabelStr = "";

						exam1LabelStr = jTextField1.getText();
						exam2LabelStr = jTextField2.getText();
						exam3LabelStr = jTextField3.getText();
						exam4LabelStr = jTextField4.getText();
						exam5LabelStr = jTextField5.getText();
						exam6LabelStr = jTextField6.getText();
						exam7LabelStr = jTextField7.getText();
						exam8LabelStr = jTextField8.getText();
						exam9LabelStr = jTextField9.getText();
						exam10LabelStr = jTextField10.getText();

						try {
							examComboLabelsTester.setExam1Str(exam1LabelStr);
							jTextField1.setText(examComboLabelsTester.getExam1Str());

							examComboLabelsTester.setExam2Str(exam2LabelStr);
							jTextField2.setText(examComboLabelsTester.getExam2Str());

							examComboLabelsTester.setExam3Str(exam3LabelStr);
							jTextField3.setText(examComboLabelsTester.getExam3Str());

							examComboLabelsTester.setExam4Str(exam4LabelStr);
							jTextField4.setText(examComboLabelsTester.getExam4Str());

							examComboLabelsTester.setExam5Str(exam5LabelStr);
							jTextField5.setText(examComboLabelsTester.getExam5Str());

							examComboLabelsTester.setExam6Str(exam6LabelStr);
							jTextField6.setText(examComboLabelsTester.getExam6Str());

							examComboLabelsTester.setExam7Str(exam7LabelStr);
							jTextField7.setText(examComboLabelsTester.getExam7Str());

							examComboLabelsTester.setExam8Str(exam8LabelStr);
							jTextField8.setText(examComboLabelsTester.getExam8Str());

							examComboLabelsTester.setExam9Str(exam9LabelStr);
							jTextField9.setText(examComboLabelsTester.getExam9Str());

							examComboLabelsTester.setExam10Str(exam10LabelStr);
							jTextField10.setText(examComboLabelsTester.getExam10Str());

							setComboLabelsB3(examComboLabelsTester);

						} catch (ClassNotFoundException | IOException | SQLException e1) {
							e1.printStackTrace();
						}
						Integer counter = null;
						try {
							counter = rowCountComboLabelsB3();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
						JTextField textFieldExamLabelsCount = new JTextField();
						textFieldExamLabelsCount.setText(counter.toString());

						// I need this so I can have something (args) to pass to main() when
						// when shutting down and rebooting to see the changes
						try {
							exam1 = examComboLabelsTester.getExam1Str();
						} catch (ClassNotFoundException | IOException | SQLException e1) {
							e1.printStackTrace();
						}
						String[] exams = new String[] { exam1 };
						try {
							JOptionPane.showMessageDialog(null,
									"To see your changes to the exam labels you must restart the \n"
											+ "application until I figure out how to code this properly\n");
							System.exit(0);
							// Okay, so this simply runs main() again after System.exit(0)?
							BrainBuilder3.main(exams);
						} catch (SQLException | IOException e1) {
							e1.printStackTrace();
						} catch (BackingStoreException e1) {
							e1.printStackTrace();
						}
					} else {
						System.out.println(
								"Selected 'No' and does not want to apply changes, the '1' value returned in applyOption");
					}
				}
			}
		});
		btnNewButton_5.setBounds(1264, 735, 132, 23);
		getContentPane().add(btnNewButton_5);

		JButton btnNewButton_6 = new JButton("DeleteLabs");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CORRECT_PASSWORD = "meboss";
				char[] correctPasswordChar = CORRECT_PASSWORD.toCharArray();
				// PASSWORD PROTECT ACCESS
				JPasswordField passwordField = new JPasswordField(15);
				int action = JOptionPane.showConfirmDialog(null, passwordField, "Enter the correct password",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
				PassLabel: if (action == JOptionPane.OK_OPTION) {
					char[] input = passwordField.getPassword();
					if (Arrays.equals(input, correctPasswordChar)) {
						JOptionPane.showMessageDialog(null, "Enter");
					} else {
						JOptionPane.showMessageDialog(null, "Incorrect Password!", "Error", JOptionPane.ERROR_MESSAGE);
						break PassLabel;
					}
					Arrays.fill(input, '0');
					try {
						deleteExamsComboRowsB3();
						Integer comboRowsIntDel = rowCountComboLabelsB3();
						textFieldComboRows.setText(comboRowsIntDel.toString());
					} catch (SQLException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		btnNewButton_6.setBounds(1140, 735, 114, 23);
		getContentPane().add(btnNewButton_6);

		textFieldComboRows = new JTextField();
		textFieldComboRows.setEditable(false);
		textFieldComboRows.setBounds(1105, 736, 25, 21);
		getContentPane().add(textFieldComboRows);
		textFieldComboRows.setColumns(10);

		JButton btnNewButton_7 = new JButton("ComboTableRows");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Integer comboRowsInt = rowCountComboLabelsB3();
					textFieldComboRows.setText(comboRowsInt.toString());
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_7.setBounds(940, 735, 155, 23);
		getContentPane().add(btnNewButton_7);
	} // End of constructor

	private void restoreSelection() {
		System.out.println("Top of restoreSelection() in BrainTest3");
		if (previouslySelectedCommand != null) {
			System.out.println(previouslySelectedCommand + " previouslySelectedCommand ldkrei");
			for (int i = 0; i < 5; ++i) {
				if (qIndex == i) {
					previouslySelectedCommand = listOfQuestionsSER.get(qIndex).getSelectedCommand();
					System.out.println(previouslySelectedCommand + " previouslySelectedCommand pxw04903");
				} else {
					System.out.println(previouslySelectedCommand + " previouslySelectedCommand podofid");
				}
			}

			System.out.println(aGroup + " aGroup keo85c948");
			// Iterate through the buttons to find the one with the AbstractButton
			Enumeration<AbstractButton> buttons = aGroup.getElements();
			// 8-4 But why is this commented out?
			// while(buttons.hasMoreElements()) {
			// System.out.println(buttons.nextElement() + " buttons.nextElement()
			// kifitori904");
			// }
			// for (Enumeration<E> e = v.elements(); e.hasMoreElements();)
			// System.out.println(e.nextElement());
			
			System.out.println(buttons + " buttons buttons krig");
			Integer count = 0;
			while (buttons.hasMoreElements()) {
				count++;
				System.out.println(count + " count ijik");
				AbstractButton button = buttons.nextElement();
				System.out.println(previouslySelectedCommand + " focit948");
				System.out.println(button.getActionCommand() + " button.getActionCommand() ecu985");
				
				if (previouslySelectedCommand.equalsIgnoreCase(button.getActionCommand())) {
					System.out.println(previouslySelectedCommand + "  moxeore");
					button.setSelected(true);
					System.out.println("kpecpeS");
					break;
				} else {
					System.out.println("No previously selected to restore.");
				}
				System.out.println("Bottom of restoreSelection() in BrainTest3");
			}
		}
	}

	public void displayReviewQuestion(QuestionSuper questionObject, Integer qIndex) {
		System.out.println(" Top of  displayReviewQuestion()");
		String prevQTitle = "";
		String prevQTopic = "";
		String prevQuestion = "";
		String prevAns1 = "";
		String prevAns2 = "";
		String prevAns3 = "";
		String prevAns4 = "";
		String prevAns5 = "";

		String prevExplanation = "";
		String prevCorrectAns1 = "";
		String prevCorrectAns2 = "";
		String prevCorrectAns3 = "";
		String prevCorrectAns4 = "";
		String prevCorrectAns5 = "";

		textFieldQuestNum.setText("");
		textFieldExTitle.setText("");
		textFieldTopic.setText("");
		txtAreaQuestion.setText("");
		textAreaAns1.setText("");
		textAreaAns2.setText("");
		textAreaAns3.setText("");
		textAreaAns4.setText("");
		textAreaAns5.setText("");
		textFieldPassOrFail.setText("");

		textFieldQuestNum.setBackground(null);
		textFieldExTitle.setBackground(null);
		textFieldTopic.setBackground(null);
		txtAreaQuestion.setBackground(null);
		textAreaAns1.setBackground(null);
		textAreaAns2.setBackground(null);
		textAreaAns3.setBackground(null);
		textAreaAns4.setBackground(null);
		textAreaAns5.setBackground(null);

		previouslySelectedCommand = listOfQuestionsSER.get(qIndex).getSelectedCommand();		
		System.out.println(previouslySelectedCommand + " previouslySelectedCommand kxeioeti94t584");

		selectedExamIndexInteger = selectedExamIndex + 1;
		textFieldLastName.setText(listOfQuestionsSER.get(0).getStudentLastName());
		textFieldStudentFirstName.setText(listOfQuestionsSER.get(0).getStudentFirstName());
		textFieldExNumber.setText((selectedExamIndexInteger).toString());
		textFieldExTitle.setText(questionObject.getTitle());
		textFieldQuestNum.setText(questionObject.getQuestionNumber().toString());
		txtAreaQuestion.setText(questionObject.getQuestion());
		textFieldTopic.setText(questionObject.getQuestionTopic());

// ##### For true/false	
		if (questionObject.getAnswer1().equalsIgnoreCase("True")
				|| questionObject.getAnswer2().equalsIgnoreCase("False")) {
			
			if (previouslySelectedCommand.equals("Option1") && questionObject.getAnswer1().equalsIgnoreCase("True")) {
				textAreaAns1.setText("A) " + "CORRECT ANSWER- " + questionObject.getAnswer1());
				textAreaAns2.setText("B) " + questionObject.getAnswer2());

			} else if (previouslySelectedCommand.equals("Option2")
					&& questionObject.getAnswer2().equalsIgnoreCase("False")) {
				textAreaAns1.setText("A) " + "CORRECT ANSWER - " + questionObject.getAnswer1());
				textAreaAns2.setText("B) " + "FALSE - " + questionObject.getAnswer2());

			}
		} else {

// ################# for multiple choice

			Boolean value1 = Boolean.valueOf(true);

			System.out.println(questionObject.getProfsCorrectAnswers().get(1)
					+ " questionObject.getProfsCorrectAnswers().get(0) or85948");

			if (previouslySelectedCommand.equals("Option1")) {
				if (questionObject.getProfsCorrectAnswers().get(0).equals(value1)) {
					System.out.println("peor0e9504-0");
					textAreaAns1.setText("A) " + "CORRECT - " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + questionObject.getAnswer5());
				} else {// determine which is the correct answer
					if (questionObject.getProfsCorrectAnswers().get(0).equals(value1)) {
						trueBool1 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(1).equals(value1)) {
						trueBool2 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(2).equals(value1)) {
						trueBool3 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(3).equals(value1)) {
						trueBool4 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(4).equals(value1)) {
						trueBool5 = "CORRECT ANSWER -";
					}

					textAreaAns1.setText("A) " + "FALSE - " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + trueBool2 + " " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + trueBool3 + " " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + trueBool4 + " " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + trueBool5 + " " + questionObject.getAnswer5());

				}

			} else if (previouslySelectedCommand.equals("Option2")) {
				if (questionObject.getProfsCorrectAnswers().get(1).equals(value1)) {
					System.out.println("lpw0395340-0");
					textAreaAns1.setText("A) " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + "CORRECT - " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + questionObject.getAnswer5());
				} else {
					if (questionObject.getProfsCorrectAnswers().get(0).equals(value1)) {
						trueBool1 = "CORRECT ANSWER -  ";
					} else if (questionObject.getProfsCorrectAnswers().get(1).equals(value1)) {
						trueBool2 = "CORRECT ANSWER - ";
					} else if (questionObject.getProfsCorrectAnswers().get(2).equals(value1)) {
						trueBool3 = "CORRECT ANSWER - ";
					} else if (questionObject.getProfsCorrectAnswers().get(3).equals(value1)) {
						trueBool4 = "CORRECT ANSWER - ";
					} else if (questionObject.getProfsCorrectAnswers().get(4).equals(value1)) {
						trueBool5 = "CORRECT ANSWER - ";
					}

					textAreaAns1.setText("A) " + trueBool1 + " " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + "FALSE - " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + trueBool3 + " " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + trueBool4 + " " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + trueBool5 + " " + questionObject.getAnswer5());
				}
			} else if (previouslySelectedCommand.equals("Option3")) {
				if (questionObject.getProfsCorrectAnswers().get(2).equals(value1)) {
					System.out.println("ldckoeri9-0");
					textAreaAns1.setText("A) " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + "CORRECT - " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + questionObject.getAnswer5());
				} else {
					if (questionObject.getProfsCorrectAnswers().get(0).equals(value1)) {
						trueBool1 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(1).equals(value1)) {
						trueBool2 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(2).equals(value1)) {
						trueBool3 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(3).equals(value1)) {
						trueBool4 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(4).equals(value1)) {
						trueBool5 = "CORRECT ANSWER -";
					}

					textAreaAns1.setText("A) " + trueBool1 + " " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + trueBool2 + " " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + "FALSE - " + " " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + trueBool4 + " " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + trueBool5 + " " + questionObject.getAnswer5());
				}
			} else if (previouslySelectedCommand.equals("Option4")) {
				System.out.println(",iQeiweu3i23029d84-0");
				if (questionObject.getProfsCorrectAnswers().get(3).equals(value1)) {
					System.out.println(",oxe944r0e-0");
					textAreaAns1.setText("A) " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + "CORRECT - " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + questionObject.getAnswer5());
				} else {
					if (questionObject.getProfsCorrectAnswers().get(0).equals(value1)) {
						trueBool1 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(1).equals(value1)) {
						trueBool2 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(2).equals(value1)) {
						trueBool3 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(3).equals(value1)) {
						trueBool4 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(4).equals(value1)) {
						trueBool5 = "CORRECT ANSWER -";
					}

					textAreaAns1.setText("A) " + trueBool1 + " " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + trueBool2 + " " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + trueBool3 + " " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + "FALSE - " + " " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + trueBool5 + " " + questionObject.getAnswer5());
				}

			} else if (previouslySelectedCommand.equals("Option5")) {
				System.out.println(previouslySelectedCommand + " previouslySelectedCommand koriu94d58");
				System.out.println(",kodti9crt58-0");
				if (questionObject.getProfsCorrectAnswers().get(4).equals(value1)) {
					System.out.println(",09exr9ce4tn-0");
					textAreaAns1.setText("A) " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + "CORRECT - " + questionObject.getAnswer5());
				} else {
					if (questionObject.getProfsCorrectAnswers().get(0).equals(value1)) {
						trueBool1 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(1).equals(value1)) {
						trueBool2 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(2).equals(value1)) {
						trueBool3 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(3).equals(value1)) {
						trueBool4 = "CORRECT ANSWER -";
					} else if (questionObject.getProfsCorrectAnswers().get(4).equals(value1)) {
						trueBool5 = "CORRECT ANSWER -";
					}

					textAreaAns1.setText("A) " + trueBool1 + " " + questionObject.getAnswer1());
					textAreaAns2.setText("B) " + trueBool2 + " " + questionObject.getAnswer2());
					textAreaAns3.setText("C) " + trueBool3 + " " + questionObject.getAnswer3());
					textAreaAns4.setText("D) " + trueBool4 + " " + questionObject.getAnswer4());
					textAreaAns5.setText("E) " + "FALSE -" + " " + questionObject.getAnswer5());
				}
			}
		}
		

		textAreaExplanation.setText(questionObject.getExplanation());
		textFieldPassOrFail.setText(questionObject.getPassFail().toUpperCase());

		// Now for the preview code
		prevQTitle = questionObject.getTitle();
		prevQTopic = questionObject.getQuestionTopic();
		prevQuestion = questionObject.getQuestion();
		prevAns1 = questionObject.getAnswer1();
		prevCorrectAns1 = questionObject.getCorrectAnswer1();
		prevAns2 = questionObject.getAnswer2();
		prevCorrectAns2 = questionObject.getCorrectAnswer2();
		prevAns3 = questionObject.getAnswer3();
		prevCorrectAns3 = questionObject.getCorrectAnswer3();
		prevAns4 = questionObject.getAnswer4();
		prevCorrectAns4 = questionObject.getCorrectAnswer4();
		prevAns5 = questionObject.getAnswer5();
		prevCorrectAns5 = questionObject.getCorrectAnswer5();
		prevExplanation = questionObject.getExplanation();

		String titlePrev = prevQTitle;
		String topicPrev = "\nTopic: " + prevQTopic;
		String questionPrev = "\nQuestion: " + prevQuestion + "\n\n";
		String ans1Prev = "A) " + prevAns1;
		String ans2Prev = "B) " + prevAns2 + "\n";
		String ans3Prev = "C) " + prevAns3 + "\n";
		String ans4Prev = "D) " + prevAns4 + "\n";
		String ans5Prev = "E) " + prevAns5;

		int lengthToCorrectAnsA = titlePrev.length() + topicPrev.length() + questionPrev.length() + ans1Prev.length();
		int lengthToCorrectAnsB = lengthToCorrectAnsA + prevCorrectAns1.length() + ans2Prev.length();
		int lengthToCorrectAnsC = (lengthToCorrectAnsB + 2) + prevCorrectAns2.length() + ans3Prev.length();
		int lengthToCorrectAnsD = lengthToCorrectAnsC + prevCorrectAns3.length() + ans4Prev.length();
		int lengthToCorrectAnsE = lengthToCorrectAnsD + prevCorrectAns4.length() + ans5Prev.length();

		// Add if-else for TrueFalse option
		if (prevAns1.equals("True") || prevAns2.equals("False")) {
			System.out.println("ko8547sjey");

			textPane.setText("Title: " + prevQTitle + "\n" + "Topic:" + prevQTopic + "\n" + "Question: " + prevQuestion
					+ "\n\n" + "A) " + prevAns1 + "\n" + "" + prevCorrectAns1 + "\n\n" + "B) " + prevAns2 + "\n" + ""
					+ prevCorrectAns2 + "\n\n" + "Explanation: " + prevExplanation);

			JRadioButton radButtonA = new JRadioButton();
			radButtonA.setBackground(Color.white);
			radButtonA.setAlignmentY(.70F);
			radButtonA.setPreferredSize(new Dimension(15, 15));

			JRadioButton radButtonB = new JRadioButton();
			radButtonB.setBackground(Color.white);
			radButtonB.setAlignmentY(.70F);
			radButtonB.setPreferredSize(new Dimension(15, 15));

			textPane.setCaretPosition(lengthToCorrectAnsA + 7);
			textPane.insertComponent(radButtonA);

			textPane.setCaretPosition((lengthToCorrectAnsB + 10));
			textPane.insertComponent(radButtonB);
			
			for (int i = 0; i < listOfQuestionsSER.size(); i++) {
				if (previouslySelectedCommand.equals("Option1")) {
					radButtonA.setSelected(true);
					System.out.println(previouslySelectedCommand + " 1 previouslySelectedCommand in my new loop");
				} else if (previouslySelectedCommand.equals("Option2")) {
					radButtonB.setSelected(true);
					System.out.println(previouslySelectedCommand + " 2 previouslySelectedCommand in my new loop");
				}
			}

		} else {
			textPane.setText(prevQTitle + "\n" + "Topic: " + prevQTopic + "\n" + "Question: " + prevQuestion + "\n\n"
					+ "A) " + prevAns1 + "\n\n" + prevCorrectAns1 + "\n\n" + "B) " + prevAns2 + "\n\n" + prevCorrectAns2
					+ "\n\n" + "C) " + prevAns3 + "\n\n" + prevCorrectAns3 + "\n\n" + "D) " + prevAns4 + "\n\n"
					+ prevCorrectAns4 + "\n\n" + "E) " + prevAns5 + "\n\n" + prevCorrectAns5 + "\n\n" + "Explanation: "
					+ prevExplanation);

			
			JRadioButton radButtonA = new JRadioButton();
			radButtonA.setBackground(Color.white);
			radButtonA.setAlignmentY(.70F);
			radButtonA.setPreferredSize(new Dimension(15, 15));

			JRadioButton radButtonB = new JRadioButton();
			radButtonB.setBackground(Color.white);
			radButtonB.setAlignmentY(.70F);
			radButtonB.setPreferredSize(new Dimension(15, 15));

			JRadioButton radButtonC = new JRadioButton();
			radButtonC.setBackground(Color.white);
			radButtonC.setAlignmentY(.70F);
			radButtonC.setPreferredSize(new Dimension(15, 15));

			JRadioButton radButtonD = new JRadioButton();
			radButtonD.setBackground(Color.white);
			radButtonD.setAlignmentY(.70F);
			radButtonD.setPreferredSize(new Dimension(15, 15));

			JRadioButton radButtonE = new JRadioButton();
			radButtonE.setBackground(Color.white);
			radButtonE.setAlignmentY(.70F);
			radButtonE.setPreferredSize(new Dimension(15, 15));

			System.out.println("Restored selection top of Preview Correct Answers button: " + previouslySelectedCommand
					+ " XCXCXCXC");
		

			textPane.setCaretPosition(lengthToCorrectAnsA + 2);
			textPane.insertComponent(radButtonA);

			textPane.setCaretPosition((lengthToCorrectAnsB + 6)); // why does 4 work?
			textPane.insertComponent(radButtonB);

			textPane.setCaretPosition((lengthToCorrectAnsC + 8));
			textPane.insertComponent(radButtonC);

			textPane.setCaretPosition((lengthToCorrectAnsD + 12)); //
			textPane.insertComponent(radButtonD);

			textPane.setCaretPosition((lengthToCorrectAnsE + 17)); //
			textPane.insertComponent(radButtonE);
			textPane.setCaretPosition(0);

			for (int i = 0; i < listOfQuestionsSER.size(); i++) {
				if (previouslySelectedCommand.equals("Option1")) {
					radButtonA.setSelected(true);
					System.out.println(previouslySelectedCommand + " 1 previouslySelectedCommand in my new loop");
				} else if (previouslySelectedCommand.equals("Option2")) {
					radButtonB.setSelected(true);
					System.out.println(previouslySelectedCommand + " 2 previouslySelectedCommand in my new loop");
				} else if (previouslySelectedCommand.equals("Option3")) {
					radButtonC.setSelected(true);
					System.out.println(previouslySelectedCommand + " 3 previouslySelectedCommand in my new loop");
				} else if (previouslySelectedCommand.equals("Option4")) {
					radButtonD.setSelected(true);
					System.out.println(previouslySelectedCommand + " 4 previouslySelectedCommand in my new loop");
				} else if (previouslySelectedCommand.equals("Option5")) {
					radButtonE.setSelected(true);
					System.out.println(previouslySelectedCommand + " 5 previouslySelectedCommand in my new loop");
				}				
			}			
		}
		restoreSelection();
		trueBool1 = "";
		trueBool2 = "";
		trueBool3 = "";
		trueBool4 = "";
		trueBool5 = "";
	}

	public void setOuterMasterListOfMastersSER(Integer selectedExamIndex,
			ArrayList<ArrayList<ArrayList<QuestionSuper>>> outerMasterListofMastersSER)
			throws SQLException, IOException, ClassNotFoundException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(outerMasterListofMastersSER);
		byte[] serializedOuterMasterBytes = baos.toByteArray();
		oos.close();

		String updateSQL = "UPDATE STUDENTS_OUTERNESTED_TABLE4  SET id = ?, STUDENTLASTNAME = ?, STUDENTFIRSTNAME = ?, OUTERNESTEDMASTERS = ?, LISTOFGRADEDEXAMSLISTS = ?  WHERE id=?";

		Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
		PreparedStatement stmt = conn.prepareStatement(updateSQL);

		stmt.setInt(1, 1); // shouldn't this be 1 always? It's one when set with initial placehoder
		stmt.setString(2, "StudentLastName");
		stmt.setString(3, "StudentFirstName");
		stmt.setObject(4, serializedOuterMasterBytes);
		stmt.setObject(5, null);
		stmt.setInt(6, 1);
		Integer rowsEffectedFinalStudent = stmt.executeUpdate();
		System.out.println(rowsEffectedFinalStudent + " rowsEffectedFinalStudent prints ____");
	}

	@SuppressWarnings("unchecked")
	public ArrayList<ArrayList<ArrayList<QuestionSuper>>> getOuterMasterListOfMastersSER()
			throws ClassNotFoundException, IOException, SQLException {

		System.out.println("Top of getOuterMasterListOfMastersSER() in the Tester class at bottom of BrainTest3 class");

		String sqlRS = " SELECT id, STUDENTLASTNAME,  STUDENTFIRSTNAME, OUTERNESTEDMASTERS, LISTOFGRADEDEXAMSLISTS FROM STUDENTS_OUTERNESTED_TABLE4 ";

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(sqlRS);
				ResultSet rSet = stmt.executeQuery()) {

			byte[] listOfOuterMasterBytes = null;

			if (rSet.next() == false) {
				JOptionPane.showMessageDialog(null, "No such exam has been graded for review");
			} else {

				String studentLastName = rSet.getString("STUDENTLASTNAME");
				// Don't really need these
				System.out.println(studentLastName + " studentLastName or creator printed");
				listOfOuterMasterBytes = rSet.getBytes("OUTERNESTEDMASTERS");

				if (listOfOuterMasterBytes != null) {
					try (ByteArrayInputStream bais = new ByteArrayInputStream(listOfOuterMasterBytes);
							ObjectInputStream ois = new ObjectInputStream(bais)) {

						deserializedOuterMasterObject = (ArrayList<ArrayList<ArrayList<QuestionSuper>>>) ois
								.readObject();
						outerMasterListofMastersSER = deserializedOuterMasterObject;
					}
					System.out
							.println("Bottom of getOuterMasterListOfMastersSER in the Tester class at bottom of class");
				}
			}
			return outerMasterListofMastersSER;
		}
	}

	// Necessary? Maybe not as I'm pulling the listoflistsprofbooleans from the
	// first anon object
	public void setGradedOnceListOfLists(ArrayList<ArrayList<Boolean>> gradeOnceListOfListsSER) {
		this.gradeOnceListOfListsSER = gradeOnceListOfListsSER;
	}

	public ArrayList<ArrayList<Boolean>> getGradedOnceListOfLists() {
		return gradeOnceListOfListsSER;
	}

	public void loadComboExamLabsB3() throws SQLException, IOException {
		var examComboLabelsTester = new ExamComboLabelsTester();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(examComboLabelsTester);
		byte[] serializedObjectBytes = baos.toByteArray();
		oos.close();

		String insertSQL = "INSERT INTO EXAMS_COMBO_LABELS_1 (id, EXAMCOMBOLABELS ) VALUES(?, ?)";

		try (Connection conn2 = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt2 = conn2.prepareStatement(insertSQL)) {
			stmt2.setInt(1, 1);
			stmt2.setObject(2, serializedObjectBytes);
			int rowsEffected27 = stmt2.executeUpdate();
			System.out.println(rowsEffected27 + " Number of rowsEffected27 ");
		}
	}

	public ExamComboLabelsTester setComboLabelsB3(ExamComboLabelsTester examComboLabelsTester)
			throws IOException, SQLException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(examComboLabelsTester);
		byte[] serializedObjectBytes = baos.toByteArray();
		oos.close();

		String updateSQL = "UPDATE EXAMS_COMBO_LABELS_1  SET id = ?, EXAMCOMBOLABELS =?  WHERE id=?";

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(updateSQL)) {

			stmt.setInt(1, 1);
			stmt.setObject(2, serializedObjectBytes);
			stmt.setInt(3, 1);
			int rowsEffected248 = stmt.executeUpdate();
			System.out.println(rowsEffected248 + " rowsEffected248 updating ");
			return examComboLabelsTester;
		}
	}

	public ExamComboLabelsTester getExamComboLabelsB3() throws IOException, SQLException, ClassNotFoundException {
		String sqlRS = " SELECT id, EXAMCOMBOLABELS FROM EXAMS_COMBO_LABELS_1 ";

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(sqlRS);
				ResultSet rs = stmt.executeQuery()) {
			byte[] listComboEXLABBytes = null;

			while (rs.next()) {
				listComboEXLABBytes = rs.getBytes("EXAMCOMBOLABELS");
				if (listComboEXLABBytes != null) {
					try (ByteArrayInputStream bais = new ByteArrayInputStream(listComboEXLABBytes);
							ObjectInputStream ois = new ObjectInputStream(bais)) {
						examComboLabelsTester = (ExamComboLabelsTester) ois.readObject();
					} catch (EOFException ef) {
						System.out.println("EOFException in getExamComboLabels() method");
					}
				}
			}
		}
		return examComboLabelsTester;
	}

	public Integer rowCountComboLabelsB3() throws SQLException {

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(" SELECT COUNT(*) AS rowcount FROM EXAMS_COMBO_LABELS_1")) {
			rs.next();
			System.out.println(rs.getInt(1) + " What rs.getInt(1) returns, ie XXX567XXXX the rowCountComboLabels()");
			Integer rowCountComboInt = rs.getInt(1);
			System.out.println("This EXAMS_COMBO_LABELS_1 table contains " + rowCountComboInt + " rows dgfre@@@");
			return rowCountComboInt;
		}
	}

	public Integer deleteExamsComboRowsB3() throws SQLException {
		String sqlDeleteRow1 = " DELETE FROM EXAMS_COMBO_LABELS_1 WHERE ID = 1";

		try (Connection conn = DriverManager.getConnection("jdbc:h2:~/test", "sa", "");
				PreparedStatement stmt = conn.prepareStatement(sqlDeleteRow1)) {
			Integer affectedRows5xy = stmt.executeUpdate();
			System.out.println(affectedRows5xy + " Number of affectedRows5xy deleted");
			return affectedRows5xy;
		}
	}

	public String printForMark() {
		return "Testing!!!";
	}
}
