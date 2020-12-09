package member.service;

import java.sql.Connection;
import java.sql.SQLException;

import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;
import member.dao.MemberDao;
import member.model.Member;

public class JoinService {
	private MemberDao memberDao = new MemberDao();

	public void join(JoinRequest joinReq) {
		//실제로 적절한 일을 하고 테이블에 사용자가 입력한 것을 insert 
		//요업무를 Dao가함 jdbc에 관련된 업무를 보내줌 결국 Dao , Member을 만들어줘야함.
    
		Connection con = null;
		try{
			con = ConnectionProvider.getConnection();
			con.setAutoCommit(false);
			Member m = memberDao.selectById(con, joinReq.getId());
			
			if (m != null) {
				JdbcUtil.rollback(con);
				throw new DuplicateIdException();
			}

			Member member = new Member();
			member.setId(joinReq.getId());
			member.setName(joinReq.getName());
			member.setPassword(joinReq.getPassword());
			
			memberDao.insert(con, member); // 주하는일
			
			con.commit();
		}catch(SQLException e) {
			JdbcUtil.rollback(con);
			throw new RuntimeException(e);
		}finally {
			JdbcUtil.close(con);
		}
	}
}
