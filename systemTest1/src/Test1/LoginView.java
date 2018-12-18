package Test1;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginView extends JFrame {

	private JPanel contentPane;
	private JTextField idField;
	private JPasswordField pwField;
	private MainStart main;

	public LoginView() {
		//layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 650, 450);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		// label, field
		JLabel lblId = new JLabel("ID :");
		lblId.setBounds(228, 134, 57, 15);
		contentPane.add(lblId);
		
		JLabel lblPw = new JLabel("PW :");
		lblPw.setBounds(228, 191, 36, 15);
		contentPane.add(lblPw);
		
		idField = new JTextField();
		idField.setBounds(263, 131, 116, 21);
		contentPane.add(idField);
		idField.setColumns(10);
		
		pwField = new JPasswordField();
		pwField.setBounds(263, 188, 116, 21);
		contentPane.add(pwField);
		
		// button
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				loginCheck();
			}
		});
		btnNewButton.setBounds(251, 252, 97, 23);
		contentPane.add(btnNewButton);
		
		// show
		setVisible(true);
	}
	
	// login check
	public void loginCheck() {
		if(idField.getText().equals("a") && new String(pwField.getPassword()).equals("a")) {
			JOptionPane.showMessageDialog(null, "로그인 되었습니다.");
			
			main.showMainFrame();			
		} else {
			JOptionPane.showMessageDialog(null, "ID/PW를 확인해주세요.");			
		}
	}
	
	// main conn
	public void setMain(MainStart main) {
		this.main = main;
	}
}
