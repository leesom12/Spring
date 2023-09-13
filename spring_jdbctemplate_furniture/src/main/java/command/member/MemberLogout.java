package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;

public class MemberLogout implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		String sessionName = (String) session.getAttribute("sessionName");
		
		String msg = sessionName+"님 로그아웃 되었습니다";
		if(sessionName == null) msg ="로그아웃 되었습니다";
		
		session.invalidate();
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Home");
	}

}
