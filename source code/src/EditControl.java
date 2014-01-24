import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditControl {

	private EditView theView = new EditView();
	private EditModel theModel = new EditModel(theView);
	private Menu Menu;
	
	public void View(){
		theView.setVisible(true);
		theView.addSearch(new Search());
		theView.addSave(new Save());
		theView.addBack(new Back());

	}
	
	class Search implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				theModel.Inp();
				theModel.Ask();
				theModel.Result();
			}
			catch(NumberFormatException ex){
				System.out.println(ex);
			}
				 
		}
				 
	}
	
	class Back implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				theView.setVisible(false);
			}
			catch(NumberFormatException ex){
				System.out.println(ex);
			}
				 
		}
				 
	}
	
	class Save implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				theModel.Edit();
				theView.setVisible(false);
			}
			catch(NumberFormatException ex){
				System.out.println(ex);
			}
				 
		}
				 
	}
	 
	
}
