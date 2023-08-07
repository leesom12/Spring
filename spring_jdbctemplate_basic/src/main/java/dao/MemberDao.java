package dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import common.CommonTemplate;
import dto.MemberDto;

public class MemberDao {
	
	JdbcTemplate template = CommonTemplate.getTemplate();
	
	//등록
	public int memberSave(MemberDto dto) {
		String query="insert into h_이소민_member\r\n" + 
					 "(id, name, age, reg_date)\r\n" + 
					 "values\r\n" + 
					 "('"+dto.getId()+"', '"+dto.getName()+"',"+dto.getAge()+",'"+dto.getReg_date()+"')";
		return template.update(query);
	}
	
	//조회
	public ArrayList<MemberDto> memberList(String select, String search){
		String query="select id, name, age,\r\n" + 
					 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
					 "from h_이소민_member\r\n"+
					 "where "+select+" like '%"+search+"%'"+
					 "order by reg_date desc";
		
		RowMapper<MemberDto> memdtoList = new BeanPropertyRowMapper<MemberDto>(MemberDto.class);
		ArrayList<MemberDto> dtos = (ArrayList<MemberDto>) template.query(query, memdtoList);
		
		return dtos;
	}
	
	//뷰
	public MemberDto memberView(String id) {
		String query="select id, name, age,\r\n" + 
				 "to_char(reg_date, 'yyyy-mm-dd') as reg_date\r\n" + 
				 "from h_이소민_member\r\n"+
				 "where id ='"+id+"'";
		RowMapper<MemberDto> memDto = new BeanPropertyRowMapper<MemberDto>(MemberDto.class);
		MemberDto dto = template.queryForObject(query, memDto);
		
		return dto;
	}
	
	//수정
	public int memberUpadate(MemberDto dto) {
		String query="update h_이소민_member\r\n" + 
					 "set name='"+dto.getName()+"', age="+dto.getAge()+", reg_date='"+dto.getReg_date()+"'\r\n" + 
					 "where id='"+dto.getId()+"'";
		return template.update(query);
	}
	
	//삭제
	public int memberDelete(String id) {
		String query="delete from h_이소민_member\r\n" + 
					 "where id='"+id+"'";
		return template.update(query);
	}
}
