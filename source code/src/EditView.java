import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class EditView extends JFrame {

	private JPanel contentPane;
	private JTextField ID;
	private JTextField NameR;
	private JTextField SurnameR;
	private JTextField OA;
	private JTextField Piesh;
	private JTextField AFM;
	private JTextField Thl;
	private JTextField Temp;
	private JButton Search;
	private JSeparator separator_1;
	private JButton Back;
	private JButton Save;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditView frame = new EditView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EditView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 246);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("Id");
		lblId.setBounds(218, 11, 17, 14);
		contentPane.add(lblId);
		
		ID = new JTextField();
		ID.setBounds(248, 8, 86, 20);
		contentPane.add(ID);
		ID.setColumns(10);
		
		Search = new JButton("\u0391\u03BD\u03B1\u03B6\u03B7\u03C4\u03B7\u03C3\u03B7");
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		Search.setBounds(359, 7, 100, 23);
		contentPane.add(Search);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 709, 20);
		contentPane.add(separator);
		
		JLabel label_2 = new JLabel("\u039F\u03BD\u03BF\u03BC\u03B1");
		label_2.setBounds(22, 83, 37, 14);
		contentPane.add(label_2);
		
		NameR = new JTextField();
		NameR.setColumns(10);
		NameR.setBounds(80, 80, 86, 20);
		contentPane.add(NameR);
		
		JLabel label_3 = new JLabel("\u0395\u03C0\u03BF\u03BD\u03C5\u03BC\u03BF");
		label_3.setBounds(182, 83, 53, 14);
		contentPane.add(label_3);
		
		SurnameR = new JTextField();
		SurnameR.setColumns(10);
		SurnameR.setBounds(248, 80, 86, 20);
		contentPane.add(SurnameR);
		
		JLabel label_4 = new JLabel("\u039F. \u0391\u03B9\u03BC\u03B1\u03C4\u03BF\u03C2");
		label_4.setBounds(10, 111, 60, 14);
		contentPane.add(label_4);
		
		OA = new JTextField();
		OA.setColumns(10);
		OA.setBounds(80, 108, 86, 20);
		contentPane.add(OA);
		
		JLabel label_5 = new JLabel("\u03A0\u03B9\u03B5\u03C3\u03B7");
		label_5.setBounds(190, 111, 37, 14);
		contentPane.add(label_5);
		
		Piesh = new JTextField();
		Piesh.setColumns(10);
		Piesh.setBounds(248, 108, 86, 20);
		contentPane.add(Piesh);
		
		JLabel label_6 = new JLabel("\u0391.\u03A6.\u039C.");
		label_6.setBounds(359, 83, 48, 14);
		contentPane.add(label_6);
		
		AFM = new JTextField();
		AFM.setColumns(10);
		AFM.setBounds(428, 80, 86, 20);
		contentPane.add(AFM);
		
		JLabel label_7 = new JLabel("\u03A4\u03B7\u03BB\u03B5\u03C6\u03C9\u03BD\u03BF");
		label_7.setBounds(530, 83, 69, 14);
		contentPane.add(label_7);
		
		Thl = new JTextField();
		Thl.setColumns(10);
		Thl.setBounds(604, 80, 86, 20);
		contentPane.add(Thl);
		
		JLabel label_8 = new JLabel("\u0398\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03B9\u03B1");
		label_8.setBounds(343, 111, 80, 14);
		contentPane.add(label_8);
		
		Temp = new JTextField();
		Temp.setColumns(10);
		Temp.setBounds(428, 108, 86, 20);
		contentPane.add(Temp);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 136, 709, 20);
		contentPane.add(separator_1);
		
		Back = new JButton("\u0391\u03BA\u03B7\u03C1\u03BF");
		Back.setBounds(10, 155, 80, 23);
		contentPane.add(Back);
		
		Save = new JButton("\u0391\u03C0\u03BF\u03B8\u03B7\u03BA\u03B5\u03C5\u03C3\u03B7");
		Save.setBounds(95, 155, 114, 23);
		contentPane.add(Save);
	}

	public String GetSearch(){
		String search = null;
		search = ID.getText();
		return search;
		
	}
	
	void addSearch (ActionListener listenForSearButton){
		Search.addActionListener(listenForSearButton);        
    }
	
	void addBack (ActionListener listenForBack){
		Back.addActionListener(listenForBack);        
    }
	
	void addSave (ActionListener listenForSave){
		Save.addActionListener(listenForSave);        
    }

	public void SetResult(String[] result){
		NameR.setText(result[1]);
		SurnameR.setText(result[2]);
		OA.setText(result[3]);
		Piesh.setText(result[4]);
		AFM.setText(result[6]);
		Thl.setText(result[7]);
		Temp.setText(result[5]);
		
	}

	public String[] GetResult(){
		String info[] = new String[7];
		info[0] = NameR.getText();
		info[1] = SurnameR.getText();
		info[2] = OA.getText();
		info[3] = Piesh.getText();
		info[5] = AFM.getText();
		info[6] = Thl.getText();
		info[4] = Temp.getText();
		return info;
	}

	
}
