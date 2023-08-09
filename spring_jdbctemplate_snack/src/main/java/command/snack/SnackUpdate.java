package command.snack;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackUpdate implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = new SnackDao();
		
		String p_code = request.getParameter("t_p_code");
		String p_name = request.getParameter("t_p_name");
		String s_price = request.getParameter("t_price");
		s_price = s_price.replaceAll(",", "");
		s_price = s_price.replaceAll(" ", "");
		int price = Integer.parseInt(s_price);
		String m_code = request.getParameter("t_m_code");
		
		SnackDto dto = new SnackDto(p_code, p_name, m_code, price);
		int result = dao.updateSnack(dto);
		String msg = "수정 성공";
		if(result != 1) msg="수정 실패!!";
		
		request.setAttribute("t_msg", msg);
		request.setAttribute("t_url", "Snack");
		
	}

}
