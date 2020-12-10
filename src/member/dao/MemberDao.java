package member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.JdbcUtil;
import member.model.Member;

public class MemberDao {
	public Member selectById(Connection con, String id) throws SQLException {

		Member member= null;

		String sql = "SELECT memberId, name, password, regdate "
				+"FROM member "
				+"WHERE memberid = ? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member = new Member();
				member.setId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setPassword(rs.getString(3));
				member.setRegDate(rs.getTimestamp(4));
			}
			//각 컬럼의값을 멤버에 넣어준거임 rs가 없으면 
			//null로 남는거고 새로운객체가 있을때 들어감
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(rs, pstmt);
		}
		return member;
	}

	public void insert(Connection con, Member member) throws SQLException {
		String sql = "INSERT INTO member "
					+"(memberid, name, password, regdate) "
					+"VALUES(?, ?, ?, SYSDATE) ";
		PreparedStatement pstmt = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getPassword());
			
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			JdbcUtil.close(pstmt);
		}
		
	}
	
	public void upadte(Connection conn, Member member) throws SQLException{
		String sql = "UPDATE member "
				+ "SET name=?, password=? "
				+ "WHERE memberid=? ";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getPassword());
			pstmt.setString(3, member.getId());
			
			pstmt.executeUpdate();
		}
	}
	
	public void delete(Connection conn, String id) throws SQLException{
		//삭제 쿼리를 실행
		System.out.println(id);
		String sql = "DELETE FROM member "
					+"WHERE memberid =? ";
		try(PreparedStatement pstmt = conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			pstmt.executeUpdate();
		}
	}

}
