package co.kr.furni;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.member.MemberLogin;
import command.member.MemberLogout;
import command.member.MemberSave;
import common.CommonExecute;
import dao.MemberDao;

@Controller
public class MemberController {
	
	@RequestMapping("Member")
	public String member(HttpServletRequest request) {
		String gubun = request.getParameter("t_gubun");
		if(gubun==null) gubun="login";
		String viewPage = "";
		
		if(gubun.equals("join")) {
			viewPage = "/member/member_join";
		}else if(gubun.equals("login")) {
			viewPage = "/member/member_login";
		}else if(gubun.equals("memberSave")) {
			CommonExecute ce = new MemberSave();
			ce.execute(request);
			viewPage = "common_alert";
		}else if(gubun.equals("memberLogin")) {
			CommonExecute ce = new MemberLogin();
			ce.execute(request);
			viewPage = "common_alert";
		}else if(gubun.equals("logout")) {
			CommonExecute ce = new MemberLogout();
			ce.execute(request);
			viewPage = "common_alert";
		}else if(gubun.equals("myInfo")) {
			
		}
		
		return viewPage;
	}
	
	@RequestMapping("MemberCheckID")
	public void memberCheckId(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("t_id");
		MemberDao dao = new MemberDao();
		
		int count = dao.checkId(id);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		
		String msg = "";
		if(count == 0) {
			msg = "사용가능한 아이디입니다";
		}else {
			msg = "이미 존재하는 아이디입니다";
		}
		
		try {
			out = response.getWriter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.print(msg);
		
	}
}
