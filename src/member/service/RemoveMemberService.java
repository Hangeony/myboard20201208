package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import auth.service.User;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class RemoveMemberService {
	private MemberDao memberDao = new MemberDao();
//0 커넥션 얻기

	//1 selectById로 아이디를 얻어서  있으면 계속진행하고 없으면  MemberNotFoundException 발쌩
	
	//2 password와 memeber.password가 같은지 확인 다르면 InvalidPasswrodException발생

	//3 delete() 메소드를 실행
	public void removeMember(User user, String password){
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			Member member = memberDao.selectById(conn, user.getId());
			
			if(member == null) {
				throw new MemberNotFoundException();
			}
			if(!member.matchPassword(password)) {
				throw new InvalidPasswordException();
			}
			memberDao.delete(conn, user.getId());
			conn.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(conn);
		}
	}

}
