package ex07_jstl;

import java.time.LocalDate;

public class Webtoon {
	
	private int webtoonNo;
	private String title;
	private double star;
	private LocalDate uploadDate;
	
	public Webtoon() {
	
	}

	public Webtoon(int webtoonNo, String title, double star, LocalDate uploadDate) {
		super();
		this.webtoonNo = webtoonNo;
		this.title = title;
		this.star = star;
		this.uploadDate = uploadDate;
	}

	public int getWebtoonNo() {
		return webtoonNo;
	}

	public void setWebtoonNo(int webtoonNo) {
		this.webtoonNo = webtoonNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getStar() {
		return star;
	}

	public void setStar(double star) {
		this.star = star;
	}

	public LocalDate getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(LocalDate uploadDate) {
		this.uploadDate = uploadDate;
	}
	
	
	
	
	


}
