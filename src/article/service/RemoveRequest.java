package article.service;

public class RemoveRequest {
	private int no;
	private String userId;
	
	public int getNo() {
		return no;
	}
	public String getUserId() {
		return userId;
	}
	public RemoveRequest(int no, String userId) {
		super();
		this.no = no;
		this.userId = userId;
	}

}
