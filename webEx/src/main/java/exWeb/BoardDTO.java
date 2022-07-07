package exWeb;

public class BoardDTO {
	
	private int no, code;
	private String title, contents;
	private int viewCnt, likeCnt;
	private String createAt, modifiedAt;
	
	public BoardDTO(int no, int code, String title, String contents, int viewCnt, int likeCnt) {
		this.no = no;
		this.code = code;
		this.title = title;
		this.contents = contents;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
	}
	
	public BoardDTO(int no, int code, String title, String contents, int viewCnt, int likeCnt, String createAt, String modifiedAt) {
		this.no = no;
		this.code = code;
		this.title = title;
		this.contents = contents;
		this.viewCnt = viewCnt;
		this.likeCnt = likeCnt;
		this.createAt = createAt;
		this.modifiedAt = modifiedAt;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCreateAt() {
		return createAt;
	}

	public void setCreateAt(String createAt) {
		this.createAt = createAt;
	}

	public String getModifiedAt() {
		return modifiedAt;
	}

	public void setModifiedAt(String modifiedAt) {
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

}
