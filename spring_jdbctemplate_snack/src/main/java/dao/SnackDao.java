package dao;

import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import common.CommonTemplate;

import dto.SnackDto;

public class SnackDao {

	
	JdbcTemplate template = CommonTemplate.getTemplate();
	
	//등록
	public int snackSave(SnackDto dto) {
		String query="insert into h_이소민_snack\r\n" + 
					 "(p_code, p_name, m_code, price)\r\n" + 
					 "values \r\n" + 
					 "('"+dto.getP_code()+"', '"+dto.getP_name()+"', '"+dto.getM_code()+"', "+dto.getPrice()+")";
		return template.update(query);
	}
	
	//제조사 코드, 제조사 명 조회
	public ArrayList<SnackDto> getComapanyList() {
		String query="select m_name, m_code\r\n" + 
					 "from commonsnack\r\n" + 
					 "order by m_name";
		RowMapper<SnackDto> dtoList = new BeanPropertyRowMapper<SnackDto>(SnackDto.class);
		ArrayList<SnackDto> arr= (ArrayList<SnackDto>) template.query(query, dtoList);
		return arr;
	}
	
	//전체 조회
	public ArrayList<SnackDto> getSnackList(String gubun, String search){
		String query="select h.p_code, h.p_name, c.m_name, \r\n" + 
					 "to_char(h.price, '999,999') as strPrice, h.price\r\n" + 
					 "from h_이소민_snack h, commonsnack c\r\n" + 
					 "where h.m_code = c.m_code\r\n" + 
					 "and "+gubun+" like '%"+search+"%'\r\n"+
					 "order by p_code asc";
		RowMapper<SnackDto> dtoList = new BeanPropertyRowMapper<SnackDto>(SnackDto.class);
		ArrayList<SnackDto> arr= (ArrayList<SnackDto>) template.query(query, dtoList);
		return arr;
	}
	
	//상세 조회
	public SnackDto snackSearch(String p_code) {
		String query="select h.p_code, h.p_name, h.m_code ,c.m_name, to_char(h.price, '999,999') as strPrice, h.price\r\n" + 
					 "from h_이소민_snack h, commonsnack c\r\n" + 
					 "where h.m_code = c.m_code\r\n" + 
					 "and p_code='"+p_code+"'";
		RowMapper<SnackDto> snackdto = new BeanPropertyRowMapper<SnackDto>(SnackDto.class);
		SnackDto dto = template.queryForObject(query, snackdto);
		return dto;
	}
	
	//수정
	public int updateSnack(SnackDto dto) {
		String query="update h_이소민_snack\r\n" + 
					 "set p_name='"+dto.getP_name()+"', m_code='"+dto.getM_code()+"', price="+dto.getPrice()+"\r\n" + 
					 "where p_code='"+dto.getP_code()+"'";
		return template.update(query);
	}

	//삭제
	public int deleteSnack(String p_code) {
		String query="delete from h_이소민_snack\r\n" + 
					 "where p_code='"+p_code+"'";
		return template.update(query);
	}
	
	//제품코드 중복 검사
	public int checkPCode(String p_code) {
		String query="select count(*) as count\r\n" + 
					 "from h_이소민_snack\r\n" + 
					 "where p_code='"+p_code+"'";
		return template.update(query);
	}
}
