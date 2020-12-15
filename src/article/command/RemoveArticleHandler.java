package article.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleNotFoundException;
import article.service.PermissionDeniedException;
import article.service.RemoveArticleService;
import article.service.RemoveRequest;
import auth.service.User;
import mvc.command.CommandHandler;

public class RemoveArticleHandler implements CommandHandler{
	private RemoveArticleService removeService = new RemoveArticleService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String noVal = req.getParameter("no");
		int no = Integer.parseInt(noVal);
		
		User user = (User) req.getSession(false).getAttribute("authUser");
		RemoveRequest rmr = new RemoveRequest(no, user.getId());
		
		try {
			removeService.delete(rmr);
			return "deleteSucess";
		}catch(ArticleNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}catch(PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}
	/*private static final String FORM_VIEW = "deleteArticleForm";
	
	private ReadArticleService readService = new ReadArticleService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {

		if (req.getMethod().equalsIgnoreCase("get")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("post")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		// 현재 로그인 한 사용자
		// 삭제하려는 게시물의 작성자
		HttpSession session = req.getSession();
		User authUser = (User) session.getAttribute("authUser");
		
		int no = Integer.parseInt(req.getParameter("no"));
		String password = req.getParameter("password");
		
		ArticleData articleData = readService.getArticle(no, false);
		
		// 가 같으면 삭제함
		//    암호가 일치하는 지 확인 해서
		//           일치하면 삭제
		//           아니면 throw exception
		
		// 안 같으면 throw exception
		if (!authUser.getId().equals(articleData.getArticle().getWriter().getId())) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
		
		try {
			deleteArticleService.delete(no, authUser, password);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
		return "deleteArticleSuccess";
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		
		return FORM_VIEW;
	}
}

	 * 
	 * 
	 */

}
