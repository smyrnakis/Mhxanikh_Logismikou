import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddControl {

	AddView AddView = new AddView();
	AddModel AddModel = new AddModel(AddView);
	
	public AddControl(){
		
	}
	
	public void View(){
		AddView.setVisible(true);
		AddView.addBack(new Back());   
		AddView.addSave(new Save());   
		AddView.addMSave(new MSave());   
	}

	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				AddView.setVisible(false);		 
			}
		 	catch(NumberFormatException ex){}
		}
	}

	class Save implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				AddModel.info();
				AddModel.insert();
				AddView.setVisible(false);		 
			}
		 	catch(NumberFormatException ex){}
		}
	}
	
	class MSave implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				AddModel.info();
				AddModel.insert();
				AddView.setVisible(false);
				AddView.setVisible(true);
			}
		 	catch(NumberFormatException ex){}
		}
	}
	
	
	
}
