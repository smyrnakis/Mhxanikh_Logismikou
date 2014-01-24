import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestControl {

	private TestView theView;
	private TestModel theModel;
	private Menu Menu = new Menu();
	
	public TestControl(TestView theView, TestModel theModel) {
		this.theView = theView;
		this.theModel = theModel;

		this.theView.addLoginListener(new Listener());
	}
	
	class Listener implements ActionListener{
		 
		public void actionPerformed(ActionEvent e) {
				 
			String name, pass, respond;

			try{
					 
				name = theView.getName();
				pass = theView.getPass();
			 
				theModel.getArguments(name, pass);
				theModel.Ask();
				respond = theModel.getRespond();
				theView.setRespond(respond);
				
				if(respond=="Correct"){
					theView.setVisible(false);
					Menu.Adia = theModel.getAdia();
					System.out.println(Menu.Adia);
					Menu.setVisible(true);
				}
					 
			}
		 
			catch(NumberFormatException ex){
						 
				System.out.println(ex);
					 
				theView.displayErrorMessage("You Need to Enter 2 Integers");
						 
			}
				 
		}
				 
	}
	
}
