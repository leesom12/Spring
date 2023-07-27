package kr.com.sts;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.member.MemberDelete;
import command.member.MemberList;
import command.member.MemberUpdate;
import command.member.MemberView;
import command.member.MemberWrite;
import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

@Controller
public class Member {
	
	//Member-MVC 패턴
	@RequestMapping("Member")
	public String member(HttpServletRequest request) {
		String gubun = request.getParameter("t_gubun");
		if(gubun == null) gubun="list";
		String viewPage= "";
		
		//목록
		if(gubun.equals("list")) {
			CommonExecute ce = new MemberList();
			ce.execute(request);
			viewPage="/memberMvc/member_list";
		// 등록폼
		}else if(gubun.equals("writeForm")) {
			viewPage="/memberMvc/member_write";
		//등록	
		}else if(gubun.equals("write")) {
			CommonExecute ce = new MemberWrite();
			ce.execute(request);
			viewPage="/common_alert";
		//뷰	
		}else if(gubun.equals("view")) {
			CommonExecute ce = new MemberView();
			ce.execute(request);
			viewPage= "/memberMvc/member_view";
		//업데이트 폼	
		}else if(gubun.equals("updateForm")) {
			CommonExecute ce = new MemberView();
			ce.execute(request);
			viewPage="/memberMvc/member_update";
		//업데이트	
		}else if(gubun.equals("update")) {
			CommonExecute ce = new MemberUpdate();
			ce.execute(request);
			viewPage="/common_alert";
		//삭제	
		}else if(gubun.equals("delete")) {
			CommonExecute ce = new MemberDelete();
			ce.execute(request);
			viewPage="/common_alert";
		}
		return viewPage;
	}
	
	//등록 폼
	@RequestMapping("memberWrite")
	public String memberWrite() {
		return "/member/member_write";
	}
	
	//조회
	@RequestMapping("memberList")
	public String memberList(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String select = request.getParameter("t_select");
		String search = request.getParameter("t_search");
		if(select == null) {
			select = "id";
			search = "";
		}
		ArrayList<MemberDto> arr = dao.memberList(select, search);
		request.setAttribute("t_arr", arr);
		request.setAttribute("t_select", select);
		request.setAttribute("t_search", search);
		
		return "/member/member_list";
	}
	
	//등록
	@RequestMapping("memberSave")
	public String memberSave(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		String id= request.getParameter("t_id");
		String name = request.getParameter("t_name");
		String s_age = request.getParameter("t_age");
		int age = Integer.parseInt(s_age);
		String reg_date = request.getParameter("t_reg_date");
		
		MemberDto dto = new MemberDto(id, name, age, reg_date);
		int result = dao.memberSave(dto);
		String msg="등록 완료";
		if(result != 1) msg="등록 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "memberList");
		
		return "/common_alert";
	}
	
	//뷰
	@RequestMapping("memberView")
	public String memberView(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		String id = request.getParameter("t_id");
		MemberDto dto = dao.memberView(id);
		request.setAttribute("t_dto", dto);
		return "/member/member_view";
	}
	
	//업데이트 폼
	@RequestMapping("memberUpdateForm")
	public String memberUpdateForm(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		
		String id = request.getParameter("t_id");
		MemberDto dto = dao.memberView(id);
		request.setAttribute("t_dto", dto);
		return "/member/member_update";
	}
	
	//수정
	@RequestMapping("memberUpdate")
	public String memberUpdate(HttpServletRequest request) {
		String id= request.getParameter("t_id");
		String name= request.getParameter("t_name");
		String s_age= request.getParameter("t_age");
		int age= Integer.parseInt(s_age);
		String reg_date= request.getParameter("t_reg_date");
		
		MemberDto dto = new MemberDto(id, name, age, reg_date);
		MemberDao dao = new MemberDao();
		
		int result = dao.memberUpadate(dto);
//		String msg="수정 성공";
//		if(result != 1) msg="수정 실패!!";
		
		String msg= result == 1? "수정 성공" : "수정 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "memberList");
		
//		return "/common_alert";
		return "redirect:memberList";	//mapping 명을 찾아라
	}
	
	//삭제
	@RequestMapping("memberDelete")
	public String memberDelete(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		String id = request.getParameter("t_id");
		int result = dao.memberDelete(id);
		String msg="삭제 성공";
		if(result != 1) msg="삭제 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "memberList");
		return "/common_alert";
	}
	
}













