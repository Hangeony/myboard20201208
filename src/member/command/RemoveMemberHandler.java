package member.command;


import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import member.service.InvalidPasswordException;

import member.service.MemberNotFoundException;
import member.service.RemoveMemberService;
import mvc.command.CommandHandler;

public class RemoveMemberHandler implements CommandHandler{
	private static final String FORM_VIEW = "removeMemberForm";
	private RemoveMemberService removeMemberSvc = new RemoveMemberService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception{
		if(req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		}else if(req.getMethod().equalsIgnoreCase("POST")){
			return processSubmit(req, res);
		}else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}	
		//이전의 핸들러 메소드 내용 참조
		//get요청이면 processForm
		//post요청이면 processSubmit메소드
		//둘다아니면 에러로 응답
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		//**이전 HandlerForm메소드 참조
		//form의 이름 jsp view의 이름을 리턴함.
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException {
		//password 파라미터를 얻어와서
	
		//--errors 맵을 만들어서
		Map<String, Boolean> errors = new HashMap<String, Boolean>();
		req.setAttribute("errors", errors);
		//request attribute에 넣고 

		//--error에 코드와 트루  키벨류 쌍을 넣어서 리턴
		//FormView로 리턴
		String password = req.getParameter("password");
		if(password == null || password.isEmpty()) {
			errors.put("password", true);
		}
		if(!errors.isEmpty()) {
			return FORM_VIEW;
		}
		//password가 null 이거나 비어 있으면 (empty)면  다시

		//세션에서 user 객체 얻기(authUser attribute)
		User user = (User) req.getSession().getAttribute("authUser");

		//removeMemberService 에게 일을시킴
		try {
			//세션을 invalide()코드 추가
			removeMemberSvc.removeMember(user, password);
			req.getSession().invalidate();
			return "removeMemberSuccess";
		}catch(InvalidPasswordException e) {
			errors.put("noPw", true);
			return FORM_VIEW;
		}catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}
}

	//각문제마다 catch문이 2개 있어야함.
	//문제1 사용자가 없는경우  문제 2 패스워드가 틀린경우
	//--errors 맵에 코드추가
	//문제가 생기면 form으로 return하도록 view이름 
	//문제가 생기면 


