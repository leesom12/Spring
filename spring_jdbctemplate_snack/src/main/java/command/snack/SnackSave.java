package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackSave implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = new SnackDao();
		SnackDto dto = null;
		
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String s_price = request.getParameter("t_price");
		s_price = s_price.replaceAll(",", "");
		int price = Integer.parseInt(s_price);
		String m_code = request.getParameter("t_m_code");
		
		SnackDto code_dto = dao.checkPCode(p_code);
		int count = code_dto.getCode_count();
		String msg="";
		String url="Snack";
		
		if(count != 0) {
			msg="이미 존재하는 제품 번호입니다";
		}else {
			dto= new SnackDto(p_code, p_name, m_code, price);
			int result= dao.snackSave(dto);
			if(result == 1) {
				msg="등록 성공";
			}else {
				msg="등록 실패!!";
			}
		}
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", url);
	}

}
