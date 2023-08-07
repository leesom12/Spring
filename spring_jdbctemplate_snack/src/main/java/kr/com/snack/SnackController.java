package kr.com.snack;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import command.snack.SnackDelete;
import command.snack.SnackList;
import command.snack.SnackSave;
import command.snack.SnackUpdate;
import command.snack.SnackView;
import command.snack.SnackWriteForm;
import common.CommonExecute;
import common.CommonTemplate;

@Controller
public class SnackController {
	
	@Autowired
	JdbcTemplate template;
	
	@Autowired
	public void setTemplate(){
		CommonTemplate.setTemplate(template);
	}
	
	@RequestMapping
	public String member(HttpServletRequest request) {
		String gubun= request.getParameter("t_gubun");
		if(gubun == null) gubun="list";
		String viewPage="";
		
		//목록
		if(gubun.equals("list")) {
			CommonExecute ce = new SnackList();
			ce.execute(request);
			viewPage="/snack/snack_list";
		// 등록폼
		}else if(gubun.equals("writeForm")) {
			CommonExecute ce = new SnackWriteForm();
			ce.execute(request);
			viewPage="/snack/snack_write";
		//등록	
		}else if(gubun.equals("write")) {
			CommonExecute ce = new SnackSave();
			ce.execute(request);
			viewPage="/common_alert";
		//뷰	
		}else if(gubun.equals("view")) {
			CommonExecute ce = new SnackView();
			ce.execute(request);
			viewPage= "/snack/snack_view";
		//업데이트 폼	
		}else if(gubun.equals("updateForm")) {
			CommonExecute ce = new SnackView();
			ce.execute(request);
			CommonExecute ce2 = new SnackWriteForm();
			ce2.execute(request);
			viewPage="/snack/snack_update";
		//업데이트	
		}else if(gubun.equals("update")) {
			CommonExecute ce = new SnackUpdate();
			ce.execute(request);
			viewPage="/common_alert";
		//삭제	
		}else if(gubun.equals("delete")) {
			CommonExecute ce = new SnackDelete();
			ce.execute(request);
			viewPage="/common_alert";
		}
		
		return viewPage;
	}
	
}
