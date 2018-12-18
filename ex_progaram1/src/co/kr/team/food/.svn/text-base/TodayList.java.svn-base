package co.kr.team.food;
import javax.swing.JFrame;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class TodayList extends JFrame {
	JTable table;
	JScrollPane pane;
	Vector vData; // 데이터
	Vector vCols; // 컬럼 제목
	DefaultTableModel model; // 테이블모델
	KcalMain m;
	public TodayList() {
		String[] arrCols = {"No", "아침식단", "아침Kcal", "점심식단", "점심Kcal", "저녁식단", "저녁Kcal", "최종Kcal"};

		vCols = new Vector();
		for (int i = 0; i < arrCols.length; i++) { // 반복문 돌면서 컬럼 제목 넣기
			vCols.add(arrCols[i]);
		}//for
		vData = TodayDao.todayList();
		model = new DefaultTableModel(vData, vCols);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일선택
		pane = new JScrollPane(table);
		add(pane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}//생성자
	public TodayList(KcalMain m) {
		String[] arrCols = {"No", "아침식단", "아침Kcal", "점심식단", "점심Kcal", "저녁식단", "저녁Kcal", "최종Kcal"};

		vCols = new Vector();
		for (int i = 0; i < arrCols.length; i++) { // 반복문 돌면서 컬럼 제목 넣기
			vCols.add(arrCols[i]);
		}//for
		vData = TodayDao.todayList();
		model = new DefaultTableModel(vData, vCols);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일선택
		pane = new JScrollPane(table);
		add(pane);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(500, 300);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new TodayList();
	}//main

}//end