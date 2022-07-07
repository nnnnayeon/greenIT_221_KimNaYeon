package exWeb;

public class BoardDTO {
	
	private int no, code;
	private String title, contents;
	private int viewCnt, likeCnt;
	private int year, month, day;
	
	private int createAt, modifiedAt;
	
	public BoardDTO(int no, int code, String title, String contents, int viewCnt, int likeCnt, int year, int month, int day) {
		this.no = no;
		this.code = code;
		this.title = title;
		this.contents = contents;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.year = year;
		this.month = month;
		this.day = day;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getCreateAt() {
		return createAt;
	}

	public void setCreateAt(int createAt) {
		this.createAt = createAt;
	}

	public int getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(int modifiedAt) {
		this.modifiedAt = modifiedAt;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getViewCnt() {
		return viewCnt;
	}

	public void setViewCnt(int viewCnt) {
		this.viewCnt = viewCnt;
	}

	public int getLikeCnt() {
		return likeCnt;
	}

	public void setLikeCnt(int likeCnt) {
		this.likeCnt = likeCnt;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}


	
	

}
