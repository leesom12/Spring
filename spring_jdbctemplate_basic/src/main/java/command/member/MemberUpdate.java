package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
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
		request.setAttribute("t_url", "Member");

	}

}
