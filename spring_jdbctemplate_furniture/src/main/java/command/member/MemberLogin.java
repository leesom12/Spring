package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;

public class MemberLogin implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		String id = request.getParameter("t_id");
		String pw = request.getParameter("t_pw");
		try {
			pw= dao.encryptSHA256(pw);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg = "";
		String url= "";
		
		String name = dao.memberLogin(id, pw);
		if(name.equals("")) {
			msg = "아이디나 비밀번호가 맞지 않습니다.";
			url = "Member";
		}else {
			msg= name+"님 환영합니다!";
			url= "Home";
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionId", id);
			session.setAttribute("sessionName", name);
			if(id.equals("manager")) session.setAttribute("sessionLevel", "top");
			
			session.setMaxInactiveInterval(60*60);
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
	}

}
