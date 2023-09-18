package command.member;

import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;

public class MemberPwUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionId");
		String now_pw = request.getParameter("t_pw");
		String new_pw = request.getParameter("t_new_pw");
		int pw_len = new_pw.length();
		
		
		try {
			now_pw = dao.encryptSHA256(now_pw);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			new_pw = dao.encryptSHA256(new_pw);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg="";
		
		String name = dao.memberLogin(id, now_pw);
		if(name.equals("")) {
			msg="현재 비밀번호가 맞지 않습니다";
		}else {
			
			int result = dao.passwordUpdate(id, new_pw, pw_len);
			if(result == 1) {
				msg="비밀번호가 변경되었습니다. 변경된 비밀번호로 다시 로그인해 주세요";
				session.invalidate();
			}else {
				msg="변경 실패!!";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
		
		
	}

}
















