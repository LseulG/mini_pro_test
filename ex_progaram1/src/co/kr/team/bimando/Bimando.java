package co.kr.team.bimando;

import java.util.*;
import java.util.Date;
import java.text.*;
import java.awt.EventQueue;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import co.kr.team.main.JoinDto;

public class Bimando extends JInternalFrame implements ActionListener {
	private JTextField tfId;
	private JTextField tfHeight;
	private JTextField tfWeight;
	private JTextField tfBimando;
	private JTextField tfBimando_e;
	private JTextField tfHeight_e;
	private JTextField tfWeight_e;
	private JTextField tfFood;
	private JTextField tfSports;
	private JTextField tfTotal;
	private JTextField tfPanjung;
	private JTextField tfPanjung_e;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;

	String b;

	public static void main(String[] args) {
		Bimando frame = new Bimando();
	}

	public Bimando() {
		init();
	}

	public void init() {
		setBounds(100, 100, 600, 400);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(12, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);

		JLabel lblNewLabel = new JLabel("기 본   정 보");
		panel_1.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		panel.add(panel_2);

		JLabel lblNewLabel_1 = new JLabel("I D :");
		panel_2.add(lblNewLabel_1);

		tfId = new JTextField();
		panel_2.add(tfId);
		tfId.setColumns(10);
		tfId.setText(b);
		tfId.setEditable(false);

		JPanel panel_3 = new JPanel();
		panel.add(panel_3);

		JLabel lblNewLabel_2 = new JLabel("키 : ");
		panel_3.add(lblNewLabel_2);

		tfHeight = new JTextField();
		panel_3.add(tfHeight);
		tfHeight.setColumns(10);
		tfHeight.setEditable(false);

		JPanel panel_4 = new JPanel();
		panel.add(panel_4);

		JLabel lblNewLabel_3 = new JLabel("체 중 :");
		panel_4.add(lblNewLabel_3);

		tfWeight = new JTextField();
		panel_4.add(tfWeight);
		tfWeight.setColumns(10);
		tfWeight.setEditable(false);

		JPanel panel_5 = new JPanel();
		panel.add(panel_5);

		JLabel lblNewLabel_4 = new JLabel("비만도 :");
		panel_5.add(lblNewLabel_4);

		tfBimando = new JTextField();
		panel_5.add(tfBimando);
		tfPanjung = new JTextField();
		panel_5.add(tfPanjung);
		tfBimando.setColumns(10);
		tfPanjung.setColumns(4);
		tfBimando.setEditable(false);
		tfPanjung.setEditable(false);

		JPanel panel_6 = new JPanel();
		panel.add(panel_6);

		JLabel lblNewLabel_5 = new JLabel("추 가   정 보");
		panel_6.add(lblNewLabel_5);

		JPanel panel_7 = new JPanel();
		panel.add(panel_7);

		JLabel lblNewLabel_6 = new JLabel("키 :");
		panel_7.add(lblNewLabel_6);

		tfHeight_e = new JTextField();
		panel_7.add(tfHeight_e);
		tfHeight_e.setColumns(5);

		JLabel lblNewLabel_7 = new JLabel("cm");
		panel_7.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("  체 중 :");
		panel_7.add(lblNewLabel_8);

		tfWeight_e = new JTextField();
		panel_7.add(tfWeight_e);
		tfWeight_e.setColumns(5);

		JLabel lblKg = new JLabel("kg");
		panel_7.add(lblKg);

		btnNewButton_2 = new JButton("비만도계산");
		btnNewButton_2.addActionListener(this);
		panel_7.add(btnNewButton_2);

		btnNewButton = new JButton("저 장");
		btnNewButton.addActionListener(this);
		panel_7.add(btnNewButton);

		JPanel panel_8 = new JPanel();
		JLabel lblNewLabel_e = new JLabel("비만도 :");
		panel_8.add(lblNewLabel_e);
		tfBimando_e = new JTextField();
		panel_8.add(tfBimando_e);
		tfPanjung_e = new JTextField();
		panel_8.add(tfPanjung_e);
		tfBimando_e.setColumns(10);
		tfPanjung_e.setColumns(4);
		tfBimando_e.setEditable(false);
		tfPanjung_e.setEditable(false);
		panel.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel.add(panel_9);
		JLabel lblNewLabel_9 = new JLabel("섭취량 :");
		panel_9.add(lblNewLabel_9);

		tfFood = new JTextField();
		panel_9.add(tfFood);
		tfFood.setColumns(5);
		tfFood.setEditable(false);

		JLabel lblNewLabel_10 = new JLabel("Kcal");
		panel_9.add(lblNewLabel_10);

		JLabel lblNewLabel_11 = new JLabel("  운동 소모량 :");
		panel_9.add(lblNewLabel_11);

		tfSports = new JTextField();
		panel_9.add(tfSports);
		tfSports.setColumns(5);
		tfSports.setEditable(false);

		JLabel lblKcal = new JLabel("Kcal");
		panel_9.add(lblKcal);

		JPanel panel_10 = new JPanel();
		panel.add(panel_10);

		JLabel lblNewLabel_12 = new JLabel("칼로리 차이 :");
		panel_10.add(lblNewLabel_12);

		tfTotal = new JTextField();
		panel_10.add(tfTotal);
		tfTotal.setColumns(5);
		tfTotal.setEditable(false);

		JLabel lblKcla = new JLabel("Kcal");
		panel_10.add(lblKcla);

		JPanel panel_11 = new JPanel();
		panel.add(panel_11);
		setVisible(true);
	}

	public Bimando(String date, String a) {
		this.b = a;
		init();
		PiDto dto = PiDao.selectId(b);
		PiDto food = PiDao.selectFood(date, b);
		PiDto sports = PiDao.selectSports(date, b);
		viewSetData(dto);
		if (PiDao.selectFood(date, b) == null) {
			JOptionPane.showMessageDialog(this, "상위메뉴FOOD에서 값을 입력해주세요~");
			dispose();
		} else {
			viewSetData_1(food);
		}

		if (PiDao.selectSports(date, b) == null) {
			JOptionPane.showMessageDialog(this,
					"데이터가 없습니다. 상위메뉴SPORTS에서 값을 입력해주세요~");
			dispose();
		} else {
			viewSetData_2(sports);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 저장버튼
		if (e.getSource() == btnNewButton) {
			boolean ok = checkData();

			if (ok) {
				double ClickA = JOptionPane
						.showConfirmDialog(this, "저장하시겠습니까?");
				if (ClickA == JOptionPane.YES_OPTION) {
					insertPi();
				}
			}
		}

		if (e.getSource() == btnNewButton_2) {
			boolean ok1 = checkData();
			if (ok1) {
				double result = Double.parseDouble(tfWeight_e.getText())
						/ Math.pow(
								Double.parseDouble(tfHeight_e.getText()) / 100,
								2);
				tfBimando_e.setText(Double.toString(Double.parseDouble(String
						.format("%.2f", result))));

				if (result < 18.6) {
					tfPanjung_e.setText("저체중");
					JOptionPane.showMessageDialog(this, "저체중입니다! ㅠㅠ", "비만도정보",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
									"./image/juche.png"));
					return;
				} else if (result < 23) {
					tfPanjung_e.setText("정상");
					JOptionPane.showMessageDialog(this, "정상입니다!! ^.^", "비만도정보",
							JOptionPane.INFORMATION_MESSAGE, new ImageIcon(
									"./image/jungsang.png"));
					return;
				} else if (result < 24) {
					tfPanjung_e.setText("과체중");
					JOptionPane.showMessageDialog(this, "과체중입니다!!!^.^;",
							"비만도정보", JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon("./image/gwa.png"));
					return;
				} else {
					tfPanjung_e.setText("비만");
					JOptionPane.showMessageDialog(this, "비만입니다!!!!! @.@ ",
							"비만도정보", JOptionPane.INFORMATION_MESSAGE,
							new ImageIcon("./image/biman.png"));
				}
			}
		}
	}// actionPerformed

	// ★★★★★DTO정보를 화면에 불러오기★★★★★
	private void viewSetData(PiDto dto) {
		tfId.setText(dto.getId());

		double height = dto.getHeight();
		tfHeight.setText(Double.toString(height));

		double weight = dto.getWeight();
		tfWeight.setText(Double.toString(weight));

		double result = weight / Math.pow(height / 100, 2);
		tfBimando.setText(Double.toString(Double.parseDouble(String.format(
				"%.2f", result))));

		if (result < 18.6) {
			tfPanjung.setText("저체중");
			return;
		} else if (result < 23) {
			tfPanjung.setText("정상");
			return;
		} else if (result < 24) {
			tfPanjung.setText("과체중");
			return;
		} else {
			tfPanjung.setText("비만");
		}
	}// viewSetData

	double food;
	double sports;

	private Double viewSetData_1(PiDto dto) {
		food = dto.getFood();
		tfFood.setText(Double.toString(food));
		return food;
	}// viewSetData_1

	private Double viewSetData_2(PiDto dto) {
		sports = dto.getSports();
		tfSports.setText(Double.toString(sports));
		double result1 = food - sports;
		tfTotal.setText(Double.toString(Double.parseDouble(String.format(
				"%.2f", result1))));
		return sports;
	}// viewSetData_2

	private void insertPi() {
		PiDto dto = getDto();
		boolean ok = PiDao.insertPi(dto);
		System.out.println("asd");
		if (ok) {
			JOptionPane.showMessageDialog(this, "저장되었습니다.");
		} else {
			JOptionPane.showMessageDialog(this, "저장은 하루에 한번!");
		}
	}// insertPi

	private boolean checkData() {
		// boolean ok = false;
		String height_1 = tfHeight_e.getText();
		String weight_1 = tfWeight_e.getText();
		Double height_e = (double) 0;
		Double weight_e = (double) 0;
		if (height_1.length() == 0) {
			JOptionPane.showMessageDialog(this, "키를 꼭 입력하세요!");
			tfHeight_e.requestFocus(); // 아이디에 커서를 둔다
			return false;
		}
		try {
			height_e = Double.parseDouble(height_1); // 숫자로 바꾼다.
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "키는 숫자만 입력하세요!");
			tfHeight_e.setText("");
			tfHeight_e.requestFocus();
			return false;
		}

		if (weight_1.length() == 0) {
			JOptionPane.showMessageDialog(this, "체중를 꼭 입력하세요!");
			tfWeight_e.requestFocus(); // 아이디에 커서를 둔다
			return false;
		}
		try {
			weight_e = Double.parseDouble(weight_1); // 숫자로 바꾼다.
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "체중은 숫자만 입력하세요!");
			tfWeight_e.setText("");
			tfWeight_e.requestFocus();
			return false;
		}
		return true;
	}// checkData

	private PiDto getDto() {
		// 화면에서 값들을 가지고 온다.

		String id = tfId.getText();
		String biman_r = tfPanjung_e.getText();
		Double height = Double.parseDouble(tfHeight.getText());
		Double weight = Double.parseDouble(tfWeight.getText());
		Double biman = Double.parseDouble(tfBimando.getText());

		Double weight_e = Double.parseDouble(tfWeight_e.getText());
		Double height_e = Double.parseDouble(tfHeight_e.getText());
		Double biman_e = Double.parseDouble(tfBimando_e.getText());

		Double food = Double.parseDouble(tfFood.getText());
		Double sports = Double.parseDouble(tfSports.getText());

		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd",
				Locale.KOREA);
		String dTime = formatter.format(currentTime);

		PiDto dto = new PiDto();

		dto.setH_Day(dTime);
		dto.setId(id);
		dto.setHeight(height);
		dto.setWeight(weight);
		dto.setFood(food);
		dto.setSports(sports);
		dto.setBiman(biman);
		dto.setHeight_e(height_e);
		dto.setWeight_e(weight_e);
		dto.setBiman_e(biman_e);
		dto.setBiman_r(biman_r);
		return dto;
	}// getDto

}// end
