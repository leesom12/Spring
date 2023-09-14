package command.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import common.CommonExecute;
import dao.MemberDao;
import dto.MemberDto;

public class MemberMyinfo implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		MemberDao dao = new MemberDao();
		HttpSession session = request.getSession();
		
		String id = (String) session.getAttribute("sessionId");
		MemberDto dto = dao.memberInfo(id);
		
		request.setAttribute("t_dto", dto);
	}

}
