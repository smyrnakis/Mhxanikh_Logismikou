public class Main {

	public static void main(String[] args) {
		Check Check = new Check();
		db DB = new db();
		table Table = new table();
		Initialize Init = new Initialize();
		TestView theView = new TestView();
		TestModel theModel = new TestModel();
		TestControl theController = new TestControl(theView, theModel);

		Check.Check();
		if (Check.onoma != "Root") {
			DB.create_db();
			Table.create_table();
			Init.Insert();
		}
		theView.setVisible(true);

	}
}
