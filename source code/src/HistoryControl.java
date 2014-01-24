import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoryControl {

	private HistoryView theView = new HistoryView();
	private HistoryModel theModel = new HistoryModel(theView);
	public int Adia=0;
	
	public void View(){
		theView.Adia = Adia;
		theView.setVisible(true);
		theView.addSearch(new Search());
		theView.addBack(new Back());
		theView.addAdd(new Add());
	}
	
	class Search implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				theView.reset();
				theModel.getId();
				theModel.Ask();
				
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

	class Add implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			try{
				theModel.Exams();
				theView.reset();
				theModel.Ask();
				
			}
			catch(NumberFormatException ex){
				System.out.println(ex);
			}	 
		}			 
	}
	
}
