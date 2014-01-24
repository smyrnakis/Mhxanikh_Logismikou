import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.event.ActionEvent;


public class HistoryView extends JFrame {

	private JPanel contentPane;
	private JTextField Id;
	public JTable table;
	private DefaultTableModel model;
	private String[] columns = {"A/A", "Εξεταση", "Αποτελεσμα", "Ημερομηνια"};
	private String data[][];
	private JScrollPane scrollPane;
	private JButton search;
	private JTextField Exam;
	private JTextField Results;
	private JTextField Date;
	private JButton Add;
	private JButton Back;
	public int row = 0;
	public int Adia = 0;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HistoryView frame = new HistoryView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HistoryView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1038, 568);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(34, 11, 21, 14);
		contentPane.add(lblId);
		
		Id = new JTextField();
		Id.setBounds(57, 8, 86, 20);
		contentPane.add(Id);
		Id.setColumns(10);
		
		search = new JButton("\u0391\u03BD\u03B1\u03B6\u03B7\u03C4\u03B7\u03C3\u03B7");
		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		search.setBounds(153, 7, 99, 23);
		contentPane.add(search);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(12, 37, 1000, 11);
		contentPane.add(separator);

		model = new DefaultTableModel(data,columns);
		
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(500, 50));
		table.setFillsViewportHeight(true);

		scrollPane = new JScrollPane(table);
		scrollPane.setSize(679, 327);
		scrollPane.setLocation(27, 54);
		contentPane.add(scrollPane);
		
		JLabel label = new JLabel("\u0395\u03BE\u03B5\u03C4\u03B1\u03C3\u03B7");
		label.setBounds(746, 59, 46, 14);
		contentPane.add(label);
		
		Exam = new JTextField();
		Exam.setBounds(822, 59, 86, 20);
		contentPane.add(Exam);
		Exam.setColumns(10);
		
		JLabel label_1 = new JLabel("\u0391\u03C0\u03BF\u03C4\u03B5\u03BB\u03B5\u03C3\u03BC\u03B1");
		label_1.setBounds(730, 139, 79, 14);
		
		Results = new JTextField();
		Results.setBounds(822, 90, 164, 113);
		contentPane.add(Results);
		Results.setColumns(10);
		
		JLabel label_2 = new JLabel("\u0397\u03BC\u03B5\u03C1\u03BF\u03BC\u03B7\u03BD\u03B9\u03B1");
		label_2.setBounds(733, 214, 73, 14);
		
		
		Date = new JTextField();
		Date.setColumns(10);
		Date.setBounds(822, 214, 86, 20);
		
		
		Add = new JButton("\u039A\u03B1\u03C4\u03B1\u03C7\u03C9\u03C1\u03B9\u03C3\u03B7");
		Add.setFont(new Font("Tahoma", Font.PLAIN, 11));
		Add.setBounds(720, 239, 107, 23);
				
		Back = new JButton("\u0391\u03BA\u03C5\u03C1\u03BF");
		Back.setBounds(832, 239, 89, 23);
		contentPane.add(Back);
		
		System.out.println(Adia);
		if(Adia<=2){
			contentPane.add(label_1);
			contentPane.add(Add);
			contentPane.add(Date);
			contentPane.add(label_2);
			
		}

	}
	
	public String retId(){
		return Id.getText();
	}
	
	public void insert(Object[] res){
		row = table.getRowCount()+1;
		model.insertRow(table.getRowCount(), new Object[]{
			row,
			res[0],
			res[1],
			res[2],
			}
		);
	}
	
	public void reset(){
		model.setRowCount(0);
	}
	
	public String[] Exam(){
		String[] exam = new String[3];
		exam[0] = Exam.getText();
		exam[1] = Results.getText();
		exam[2] = Date.getText();
		return exam;
	}

	void addSearch(ActionListener listenForSearch){
		search.addActionListener(listenForSearch);        
    }
	
	void addBack(ActionListener listenForBack){
		Back.addActionListener(listenForBack);        
    }
	
	void addAdd(ActionListener listenForAdd){
		Add.addActionListener(listenForAdd);        
    }
}
