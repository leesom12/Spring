package com.kr.track;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.member.MemberDelete;
import command.member.MemberList;
import command.member.MemberUpdate;
import command.member.MemberView;
import command.member.MemberWrite;
import common.CommonExecute;
import common.CommonTemplate;
import dto.MemberDto;

@Controller
public class MemberController {
	
	//@Autowired: 자동으로 연결해준다. servlet-context.xml에서 설정한 것을 이 클래스에서 쓰겠다.
	@Autowired
	MemberDto memDto;
	@Autowired
	JdbcTemplate template;
	//어떠한 메소드를 실행시키는 기능도 있다
	@Autowired
	public void setTemplate(){
		CommonTemplate.setTemplate(template);
	}
	
	@RequestMapping("Member")
	public String member(HttpServletRequest request) {
		
		String gubun= request.getParameter("t_gubun");
		if(gubun == null) gubun="list";
		String viewPage="";
		
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
//		String query="select id, name, age,\r\n" + 
//					 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
//					 "from h_이소민_member\r\n"+
//					 "where id ='101'";
//		
//		//데이터가 한 줄일 떄
//		RowMapper<MemberDto> memDto = new BeanPropertyRowMapper<MemberDto>(MemberDto.class);
//		MemberDto dto = template.queryForObject(query, memDto);
//		
//		System.out.println("id: "+dto.getId());
//		System.out.println("name: "+dto.getName());
//		System.out.println("age: "+dto.getAge());
//		System.out.println("reg_date: "+dto.getReg_date());
//		
//		String query2 = "select id, name, age,\r\n" + 
//					 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
//					 "from h_이소민_member\r\n"+
//					 "where id like '%%'"+
//					 "order by reg_date desc";
//		
//		//데이터가 한 줄 이상일 때
//		RowMapper<MemberDto> memDtoList = new BeanPropertyRowMapper<MemberDto>(MemberDto.class);
//		ArrayList<MemberDto> arr = (ArrayList<MemberDto>) template.query(query2, memDtoList);
//		System.out.println("회원수: "+arr.size());
//		
//		String query3= "delete from h_이소민_member\r\n" + 
//				 	   "where id='101'";
//		
//		//return 값이 int일 때
//		int result = template.update(query3);
//		System.out.println("delete: "+result);
//		
//		return "home";
	}
}
