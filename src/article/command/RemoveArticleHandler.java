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

}
