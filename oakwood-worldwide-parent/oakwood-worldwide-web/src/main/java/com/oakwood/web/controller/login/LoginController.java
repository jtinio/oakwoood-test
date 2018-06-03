package com.oakwood.web.controller.login;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author jtinio
 * @since 06/02/2018
 */
@Controller
public class LoginController {

	private static final String INDEX_PAGE = "index";

	@GetMapping("/")
	public ModelAndView redirectToMainPage() {
		return new ModelAndView("redirect:/login");
	}

	@GetMapping(value = { "/login" })
	public String index() {
		return INDEX_PAGE;
	}

}
