package co.kr.furni;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import common.CommonTemplate;


@Controller
public class IndexController {
	
	@Autowired
	public JdbcTemplate template;
	@Autowired
	public void setTemplate() {
		CommonTemplate.setTemplate(template);
	}
	
	@RequestMapping("Home")
	public String index() {
		return "index";
	}
	
}
