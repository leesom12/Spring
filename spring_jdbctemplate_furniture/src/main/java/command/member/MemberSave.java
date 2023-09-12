package command.member;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import common.CommonUtil;
import dao.MemberDao;
import dto.MemberDto;

public class MemberSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String id = request.getParameter("t_id");
		String name = request.getParameter("t_name");
		
		String password = request.getParameter("t_password");
		int pass_len = password.length();
		try {
			password = dao.encryptSHA256(password);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		
		String area = request.getParameter("t_area");
		String address = request.getParameter("t_address");
		String mobile_1 = request.getParameter("t_mobile1");
		String mobile_2 = request.getParameter("t_mobile2");
		String mobile_3 = request.getParameter("t_mobile3");
		String gender = request.getParameter("t_gender");
		String travel = request.getParameter("t_hobby_travel");
		String reading = request.getParameter("t_hobby_reading");
		String sports = request.getParameter("t_hobby_sports");
		String reg_date = CommonUtil.getTodayTime();
		
		if(reading==null) reading="N";
		if(travel==null) travel="N";
		if(sports==null) sports="N";
		
		MemberDto dto = new MemberDto(id, name, password, area, address, mobile_1, mobile_2, mobile_3, gender, 
				travel, reading, sports, reg_date, pass_len);
		
		String msg = name+"님 회원가입이 완료되었습니다";
		int result = dao.saveMember(dto);
		if(result != 1) msg ="가입 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Member");
	}

}








