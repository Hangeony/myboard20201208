package article.service;

import java.sql.Connection;
import java.sql.SQLException;

import article.dao.ArticleContentDao;
import article.dao.ArticleDao;
import article.model.Article;
import jdbc.ConnectionProvider;
import jdbc.JdbcUtil;

public class RemoveArticleService {
	private ArticleDao articleDao = new ArticleDao();
	private ArticleContentDao contentDao = new ArticleContentDao();

	public void delete(RemoveRequest rmr) {
		Connection conn = null;

		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);

			Article article =articleDao.selectById(conn, rmr.getNo());
			if(article == null) {
				throw new ArticleContentNotFoundException();
			}
			if(!Delete(rmr.getUserId(), article)) {
				throw new PermissionDeniedException();
			}
			articleDao.delet(conn, rmr.getNo());
			contentDao.delet(conn, rmr.getNo());
			conn.commit();
		
		}catch(SQLException e) {
			JdbcUtil.rollback(conn);
			throw new RuntimeException(e);
		} catch (PermissionDeniedException e) {
			JdbcUtil.rollback(conn);
			throw e;
		} finally {
			JdbcUtil.close(conn);
		}
	}

	private boolean Delete(String userId, Article article) {
	
		return article.getWriter().getId().equals(userId);
	}
}

