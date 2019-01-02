package project1;

public class Start {
	private DBcon myDBcon;
	LoginView loginView;
	MainFrame mainFrame;

	public static void main(String[] args) {
		Start start = new Start();
		
		start.loginView = new LoginView(); // �α���â ���̱� 
		start.loginView.setMain(start); // �α���â���� ���� Ŭ���� ������
	}
	
	// �α��� �� ���� �޾ƿͼ� myDBcon�� �Ѱ��ֱ�
	public void setDBcon(DBcon dbcon) {
		this.myDBcon=dbcon;
	}
	
	public void showMainFrame() {
		loginView.dispose(); // loginView close
		this.mainFrame = new MainFrame(myDBcon); // mainFrame show
	}
}

/*
 * �ּ� �ѱ�/���� ����
 * �޼����(����),����(���) �̸� ���� 
 * 
 * �α��� â �������� �� ���߰� �ϱ�
 * �α׾ƿ� �ϸ� �α��� ȭ������ ���ư��� �ϱ�
 * 
 * �Ǹŵ��-���Ǹűݾ� ��� ����,
 * 			���̺� �� ������ ����, ���� �����ϰ� ��ư, �޼ҵ�
 * �Ǹ���Ȳ-�Ⱓ combobox ��/�� ������
 * 			������ ���� ���� '��ȸ�� ������ �����ϴ�.' or �Ǹ���Ȳ ���̺� ��¥ �ִ� �޸�..?
 * 			��ȸ �� ���� ������ �Ѹ���
 * 			���̺� �� ������ �Ϻ������� �˾�â �߱�
 * �����ȸ-����:���� ���� ��� ������, ����:����â�� ��� ������
 * 			+)���θ��� Ȥ�� ��ü ��ǰ ��� ��� �� �� �ְ� ��ȸ
 * 			+)����,������ ���� �����ϰ� ��ȸ
 * 
 */
