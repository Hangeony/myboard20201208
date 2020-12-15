package reply.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reply {
	private int id;
	private String memberId;
	private int articleNum;
	private String body;
	private Date regDate;

	public int getId() {
		return id;
	}
	public String getMemberId() {
		return memberId;
	}
	public int getArticleNum() {
		return articleNum;
	}
	public String getBody() {
		return body;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public List<Reply> listReply(Connection conn, int articleNum2) throws SQLException {
		String sql = "SELECT replyid, memberid, article_no, body, regdate FROM reply"  
				+"WHERE article_no=? ORDER BY replyid DESC";
		List<Reply> list = new ArrayList<Reply>();
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setInt(1, articleNum);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Reply r= new Reply();
				r.setId(rs.getInt(1));
				r.setMemberId(rs.getString(2));
				r.setArticleNum(rs.getInt(3));
				r.setBody(rs.getString(4));
				r.setRegDate(rs.getTime(5));

				list.add(r);
			}
		}
		return list;
	}
}
