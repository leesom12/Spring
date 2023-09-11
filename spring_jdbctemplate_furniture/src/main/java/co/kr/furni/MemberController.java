package co.kr.furni;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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
		}
		
		return viewPage;
	}
}
