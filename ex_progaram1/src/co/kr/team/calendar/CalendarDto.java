package co.kr.team.calendar;

public class CalendarDto {

	private String h_day;
	private Double weight_e;
	private Double food;
	private Double sports;
	private Double biman_e;
	private String biman_r;
	
	
	
	public Double getBiman_e() {
		return biman_e;
	}
	public void setBiman_e(Double biman_e) {
		this.biman_e = biman_e;
	}
	public String getBiman_r() {
		return biman_r;
	}
	public void setBiman_r(String biman_r) {
		this.biman_r = biman_r;
	}
	public String getH_day() {
		return h_day;
	}
	public void setH_day(String h_day) {
		this.h_day = h_day;
	}
	public Double getWeight_e() {
		return weight_e;
	}
	public void setWeight_e(Double weight_e) {
		this.weight_e = weight_e;
	}
	public Double getFood() {
		return food;
	}
	public void setFood(Double food) {
		this.food = food;
	}
	public Double getSport() {
		return sports;
	}
	public void setSport(Double sport) {
		this.sports = sport;
	}
	@Override
	public String toString() {
		return "CalendarDto [h_day=" + h_day + ", weight_e=" + weight_e
				+ ", food=" + food + ", sports=" + sports + ", biman_e="
				+ biman_e + ", biman_r=" + biman_r + "]";
	}
}
