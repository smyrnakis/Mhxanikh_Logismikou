import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class AddView extends JFrame {

	private JPanel contentPane;
	private JTextField Name;
	private JTextField BloodT;
	private JTextField Temp;
	private JTextField Surname;
	private JTextField AFM;
	private JTextField Tel;
	private JTextField Press;
	private JButton Back;
	private JButton Save;
	private JButton MSave;
	private String[] Info = new String[7];

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddView frame = new AddView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 720, 158);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("\u039F\u03BD\u03BF\u03BC\u03B1");
		label.setBounds(30, 25, 46, 14);
		contentPane.add(label);
		
		Name = new JTextField();
		Name.setBounds(86, 22, 86, 20);
		contentPane.add(Name);
		Name.setColumns(10);
		
		BloodT = new JTextField();
		BloodT.setColumns(10);
		BloodT.setBounds(86, 47, 86, 20);
		contentPane.add(BloodT);
		
		JLabel label_7 = new JLabel("\u039F. \u0391\u03B9\u03BC\u03B1\u03C4\u03BF\u03C2");
		label_7.setBounds(18, 50, 70, 14);
		contentPane.add(label_7);
		
		Temp = new JTextField();
		Temp.setColumns(10);
		Temp.setBounds(422, 47, 86, 20);
		contentPane.add(Temp);
		
		JLabel label_1 = new JLabel("\u0398\u03B5\u03C1\u03BC\u03BF\u03BA\u03C1\u03B1\u03C3\u03B9\u03B1");
		label_1.setBounds(346, 50, 86, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u0395\u03C0\u03BF\u03BD\u03C5\u03BC\u03BF");
		label_2.setBounds(182, 25, 61, 14);
		contentPane.add(label_2);
		
		Surname = new JTextField();
		Surname.setColumns(10);
		Surname.setBounds(238, 22, 86, 20);
		contentPane.add(Surname);
		
		JLabel label_4 = new JLabel("\u0391.\u03A6.\u039C");
		label_4.setBounds(366, 25, 46, 14);
		contentPane.add(label_4);
		
		AFM = new JTextField();
		AFM.setColumns(10);
		AFM.setBounds(422, 22, 86, 20);
		contentPane.add(AFM);
		
		Tel = new JTextField();
		Tel.setColumns(10);
		Tel.setBounds(595, 22, 86, 20);
		contentPane.add(Tel);
		
		Press = new JTextField();
		Press.setColumns(10);
		Press.setBounds(238, 47, 86, 20);
		contentPane.add(Press);
		
		JLabel label_5 = new JLabel("\u03A4\u03B7\u03BB\u03B5\u03C6\u03C9\u03BD\u03BF");
		label_5.setBounds(521, 25, 70, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("\u03A0\u03B9\u03B5\u03C3\u03B7");
		label_6.setBounds(193, 50, 38, 14);
		contentPane.add(label_6);
		
		Back = new JButton("\u0391\u03BA\u03B7\u03C1\u03BF");
		Back.setBounds(18, 86, 70, 23);
		contentPane.add(Back);
		
		Save = new JButton("\u039C\u03B9\u03B1 \u0395\u03B3\u03C1\u03B1\u03C6\u03B7");
		Save.setBounds(95, 86, 114, 23);
		contentPane.add(Save);
		
		MSave = new JButton("\u03A0\u03BF\u03BB\u03BB\u03B1\u03C0\u03BB\u03B5\u03C2");
		MSave.setBounds(219, 86, 105, 23);
		contentPane.add(MSave);
	}
	
	void addBack (ActionListener listenForBack){
		Back.addActionListener(listenForBack);        
    }
	
	void addSave (ActionListener listenForSave){
		Save.addActionListener(listenForSave);        
    }
	
	void addMSave (ActionListener listenForMSave){
		MSave.addActionListener(listenForMSave);        
    }
	
	public String[] sendInf(){
		Info[0] = Name.getText();
		Info[1] = Surname.getText();
		Info[5] = AFM.getText();
		Info[6] = Tel.getText();
		Info[2] = BloodT.getText();
		Info[3] = Press.getText();
		Info[4] = Temp.getText();
		
		return Info;
	}
	
	public void res(){
		Name.setText(null);
		Surname.setText(null);
		AFM.setText(null);
		Tel.setText(null);
		BloodT.setText(null);
		Press.setText(null);
		Temp.setText(null);
	}

}
