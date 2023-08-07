package command.snack;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import common.CommonExecute;
import dao.SnackDao;
import dto.SnackDto;

public class SnackWriteForm implements CommonExecute {

	@Override
	public void execute(HttpServletRequest request) {
		SnackDao dao = new SnackDao();
		ArrayList<SnackDto> arr = dao.getComapanyList();
		request.setAttribute("t_arr", arr);
	}

}
