package com.kr.track;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dto.MemberDto;

@Controller
public class MemberController {
	
	//@Autowired: 자동으로 연결해준다. servlet-context.xml에서 설정한 것을 이 클래스에서 쓰겠다.
	@Autowired
	MemberDto memDto;
	@Autowired
	JdbcTemplate template;
	
	@RequestMapping("Member")
	public String member() {
		String query="select id, name, age,\r\n" + 
					 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
					 "from h_이소민_member\r\n"+
					 "where id ='101'";
		
		RowMapper<MemberDto> memDto = new BeanPropertyRowMapper<MemberDto>(MemberDto.class);
		//데이터가 한 줄일 떄
		MemberDto dto = template.queryForObject(query, memDto);
		
//		System.out.println("id: "+dto.getId());
//		System.out.println("name: "+dto.getName());
//		System.out.println("age: "+dto.getAge());
//		System.out.println("reg_date: "+dto.getReg_date());
		
		String sql = "select id, name, age,\r\n" + 
					 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
					 "from h_이소민_member\r\n"+
					 "where id like '%%'"+
					 "order by reg_date desc";
		
		RowMapper<MemberDto> memDtoList = new BeanPropertyRowMapper<MemberDto>(MemberDto.class);
		//데이터가 한 줄 이상일 때
		ArrayList<MemberDto> arr = (ArrayList<MemberDto>) template.query(sql, memDtoList);
		for(int i=0; i<arr.size(); i++) {
			System.out.print("id: "+arr.get(i).getId());
			System.out.print(" name: "+arr.get(i).getName());
			System.out.print(" age: "+arr.get(i).getAge());
			System.out.println(" reg_date: "+arr.get(i).getReg_date());
		}
		
		return "home";
	}
}
