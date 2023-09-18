package co.kr.furni;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.member.MemberLogin;
import command.member.MemberLogout;
import command.member.MemberMyinfo;
import command.member.MemberPwUpdate;
import command.member.MemberSave;
import command.member.MemberUpdate;
import common.CommonExecute;
import dao.MemberDao;

@Controller
public class MemberController {
	
	@RequestMapping("Member")
	public String member(HttpServletRequest request) {
		String gubun = request.getParameter("t_gubun");
		if(gubun==null) gubun="login";
		String viewPage = "";
		
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("sessionId");
		
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
			if(id==null) {
				request.setAttribute("t_msg", "로그인 시간 만료. 다시 로그인 해 주세요");
				request.setAttribute("t_url", "Member");
				viewPage="common_alert";
			}else {
				CommonExecute ce = new MemberMyinfo();
				ce.execute(request);
				viewPage="/member/member_myinfo";
			}
		}else if(gubun.equals("updateForm")) {
			if(id==null) {
				request.setAttribute("t_msg", "로그인 시간 만료. 다시 로그인 해 주세요");
				request.setAttribute("t_url", "Member");
				viewPage="common_alert";
			}else {
				CommonExecute ce = new MemberMyinfo();
				ce.execute(request);
				viewPage="/member/member_update";
			}
		}else if(gubun.equals("memberUpdate")) {
			CommonExecute ce = new MemberUpdate();
			ce.execute(request);
			viewPage="common_alert";
		}else if(gubun.equals("pwUpdateForm")) {
			viewPage="/member/member_pwUpdate";
		}else if(gubun.equals("pwUpdate")) {
			if(id==null) {
				request.setAttribute("t_msg", "로그인 시간 만료. 다시 로그인 해 주세요");
				request.setAttribute("t_url", "Member");
				viewPage="common_alert";
			}else {
				CommonExecute ce = new MemberPwUpdate();
				ce.execute(request);
				viewPage="common_alert";
			}
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
	
	@RequestMapping("MemberCheckPassword")
	public void memberCheckPassword(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("t_id");
		String pw = request.getParameter("t_password");
		
		MemberDao dao = new MemberDao();
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		
		try {
			pw = dao.encryptSHA256(pw);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg = "";
		String name = dao.memberLogin(id, pw);
		if(name.equals("")) {
			msg="no";
		}else {
			msg="yes";
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







