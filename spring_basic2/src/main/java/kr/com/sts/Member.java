package kr.com.sts;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Member {

	@RequestMapping("memberWrite")
	public String memberWrite() {
		
		return "/member/member_write";
	}
	
	@RequestMapping("memberList")
	public String memberList() {
		return "/member/member_list";
	}
}
