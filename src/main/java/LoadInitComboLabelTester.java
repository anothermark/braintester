
// Class LoadInitExamLabsJList modifies the exam labels JList.
// This class has five (5) methods, 1) loads the initial loadJListExamLabs, 
// 2) setExamLabelsJlist1(), and 3) getExamLabelsJlist1(), 4) rowCountExamsLab() 
// and 5) deleteExamsLablsRows()

package main.java;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoadInitComboLabelTester implements AutoCloseable {
	ExamComboLabelsTester examComboLabelsTester;
	ExamComboLabelsTester deserializedObject;

	public void close() {
		System.out.println("Closed LoadInitComboLabelTester");
	}

	public void loadComboExamLabs() throws SQLException, IOException, ClassNotFoundException {
		var examComboLabelsTester = new ExamComboLabelsTester();

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(examComboLabelsTester);
		byte[] serializedObjectBytes = baos.toByteArray();

		String insertSQL = "INSERT INTO EXAMS_COMBO_LABELS_1 (id, EXAMCOMBOLABELS ) VALUES(?, ?)";

		try (Connection conn2 = DatabaseConfig.getConnection();
				PreparedStatement stmt2 = conn2.prepareStatement(insertSQL)) {

			stmt2.setInt(1, 1);
			stmt2.setObject(2, serializedObjectBytes);
			int rowsEffected27 = stmt2.executeUpdate();
			// conn2.close();
			System.out.println(rowsEffected27 + " Number of rowsEffected27 ");
		}
	}

	public ExamComboLabelsTester setComboLabels(ExamComboLabelsTester examComboLabelsTester)
			throws IOException, SQLException, ClassNotFoundException {

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(examComboLabelsTester);
		byte[] serializedObjectBytes = baos.toByteArray();
		oos.close();

		String updateSQL = "UPDATE EXAMS_COMBO_LABELS_1  SET id = ?, EXAMCOMBOLABELS =?  WHERE id=?";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement(updateSQL)) {

			stmt.setInt(1, 1);
			stmt.setObject(2, serializedObjectBytes);
			stmt.setInt(3, 1);
			int rowsEffected248 = stmt.executeUpdate();
			System.out.println(rowsEffected248 + " rowsEffected248 updating ");
			// conn.close();
			return examComboLabelsTester;
		}
	}

	public ExamComboLabelsTester getExamComboLabels() throws IOException, SQLException, ClassNotFoundException {

		String sqlRS = " SELECT id, EXAMCOMBOLABELS FROM EXAMS_COMBO_LABELS_1 ";

		try (Connection conn = DatabaseConfig.getConnection();
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

	public Integer rowCountComboLabels() throws SQLException, ClassNotFoundException {
		try (Connection conn = DatabaseConfig.getConnection();
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(" SELECT COUNT(*) AS rowcount FROM EXAMS_COMBO_LABELS_1")) {
			rs.next();
			System.out.println(rs.getInt(1) + " What rs.getInt(1) returns, ie XXXXXXX the rowCountComboLabels()");
			Integer rowCountComboInt = rs.getInt(1);
			System.out.println("This EXAMS_COMBO_LABELS_1 table contains " + rowCountComboInt + " rows dgfre@@@");
			return rowCountComboInt;
		}
	}

	public Integer deleteExamsComboRows() throws SQLException, ClassNotFoundException {

		String sqlDeleteRow1 = " DELETE FROM EXAMS_COMBO_LABELS_1 WHERE ID = 1";

		try (Connection conn = DatabaseConfig.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sqlDeleteRow1)) {
			Integer affectedRows5xy = stmt.executeUpdate();
			System.out.println(affectedRows5xy + " Number of affectedRows5xy deleted");
			return affectedRows5xy;
		}
	}
}
