package project1;

public class Start {
	private DBcon myDBcon;
	LoginView loginView;
	MainFrame mainFrame;

	public static void main(String[] args) {
		Start start = new Start();
		
		start.loginView = new LoginView(); // 로그인창 보이기 
		start.loginView.setMain(start); // 로그인창에게 메인 클래스 보내기
	}
	
	// 로그인 된 계정 받아와서 myDBcon에 넘겨주기
	public void setDBcon(DBcon dbcon) {
		this.myDBcon=dbcon;
	}
	
	public void showMainFrame() {
		loginView.dispose(); // loginView close
		this.mainFrame = new MainFrame(myDBcon); // mainFrame show
	}
}

/*
 * 주석 한글/영어 통일
 * 메서드명(동사),변수(명사) 이름 통일 
 * 
 * 로그인 창 떠있으면 더 못뜨게 하기
 * 로그아웃 하면 로그인 화면으로 돌아가게 하기
 * 
 * 판매등록-총판매금액 계산 들어가게,
 * 			테이블 행 누르고 수정, 삭제 가능하게 버튼, 메소드
 * 판매현황-기간 combobox 연/월 나누기
 * 			데이터 없는 날은 '조회된 정보가 없습니다.' or 판매현황 테이블에 날짜 있는 달만..?
 * 			조회 시 월별 데이터 뿌리기
 * 			테이블 행 누르면 일별데이터 팝업창 뜨기
 * 재고조회-매장:본인 매장 재고 빨간색, 본사:본사창고 재고 빨간색
 * 			+)본인매장 혹은 전체 상품 재고 모두 볼 수 있게 조회
 * 			+)색상,사이즈 선택 가능하게 조회
 * 
 */
