package com.springboot.exceptions.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@Controller("error")
public class AllExceptionsHandler {

	@ExceptionHandler(value = Exception.class)
	public ModelAndView handleException(HttpServletRequest req, HttpServletResponse res, Exception exception) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("exception details", exception.getStackTrace());
		mv.addObject("url", req.getRequestURL());
		mv.setViewName("error");
		return mv;
	}
}
