import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.JMenuBar;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;

public class Menu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JScrollPane scrollPane;
	private DefaultTableModel model;
	private String[] columns = { "A/A", "Onoma", "Eponumo", "O.A.", "Piesh",
			"Temp", "AFM", "Thl" };
	private String data[][];
	private JMenuBar menuBar;
	private JButton Add;
	private JButton Edit;
	private JButton History;
	private AddControl AddControl = new AddControl();
	private EditControl EditControl = new EditControl();
	private HistoryControl HistControl = new HistoryControl();
	public int Adia = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings("deprecation")
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 906, 530);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		Add = new JButton("Add Patient"); // Eisagwgh as8enous
		Add.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				AddControl.View();
			}
		});

		Edit = new JButton("Edit"); // Allagh stoixeiwn as8enous
		Edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditControl.View();
			}
		});
		History = new JButton("History"); // Istoriko as8enous
		History.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HistControl.View();
			}
		});

		menuBar.add(Add);
		menuBar.add(Edit);
		menuBar.add(History);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		model = new DefaultTableModel(data, columns);

		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);

		Ask();

		scrollPane = new JScrollPane(table);
		scrollPane.setSize(679, 482);
		scrollPane.setLocation(5, 5);
		contentPane.add(scrollPane);

		HistControl.Adia = Adia;
	}

	public void Ask() {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			String connectionUrl = "jdbc:mysql://127.0.0.1:3306/iatrikos_fakelos";
			String connectionUser = "root";
			String connectionPassword = "GogasG";
			conn = DriverManager.getConnection(connectionUrl, connectionUser,
					connectionPassword);
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT * FROM patience");
			while (rs.next()) {
				model.insertRow(
						table.getRowCount(),
						new Object[] { rs.getString("Id"),
								rs.getString("Onoma"), rs.getString("Eponumo"),
								rs.getString("Blood"), rs.getString("Piesh"),
								rs.getString("Temp"), rs.getString("AFM"),
								rs.getString("Tel") });
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
