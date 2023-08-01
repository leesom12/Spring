package command.member;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberWrite implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
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
		request.setAttribute("t_url", "Member");

	}

}
