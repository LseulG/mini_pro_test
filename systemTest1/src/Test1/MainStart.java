package Test1;

public class MainStart {
	LoginView loginView;
	MainFrame mainFrame;

	public static void main(String[] args) {
		MainStart main = new MainStart();
		main.loginView = new LoginView();
		main.loginView.setMain(main);
	}
	
	public void showMainFrame() {
		loginView.dispose();
		this.mainFrame = new MainFrame();
	} 
}
