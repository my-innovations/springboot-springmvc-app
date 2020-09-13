package com.springboot.mvccontroller;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springboot.model.User;
import com.springboot.service.UserService;

@Controller
//@SessionAttributes("username")
public class UserMvcController {

	@Autowired
	// @esource
	// @Inject
	UserService userService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		binder.registerCustomEditor(Date.class, "dob", new CustomDateEditor(dateFormat, false));
	}

	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String homePage(ModelMap map) {
		map.put("username", "punya");
		return "redirect:/users";
	}

	@RequestMapping("/locale")
	public String locale() {
		return "locale";
	}
	// http://localhost:8081/locale
	// http://localhost:8081/locale?language=fr

	/**
	 * ######################################################################################
	 * User INSERT operns
	 * ######################################################################################
	 */

	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public String showUserRegisterform(Model m) {
		m.addAttribute("user", new User());
		return "userRegistrationForm";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveUserRegistaration(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "userRegistrationForm";
		}
		userService.saveUser(user);
		return "redirect:/users";
	}
	
	/**
	 * ######################################################################################
	 * User SELECT operns
	 * ######################################################################################
	 */

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public String viewUsers(Model model) {
		// public String viewUsers(ModelMap map) { //OK
		List<User> list = userService.getAllUsers();
		model.addAttribute("list", list);
		// map.put("list",list);

		return "viewUsers";
	}
	
	/**
	 * ######################################################################################
	 * User UPDATE operns
	 * ######################################################################################
	 */

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editUserForm(@PathVariable Long id, Model m) {
		// public String editUserForm(@PathVariable Long id, ModelMap map) { //OK
		User u = userService.getUserByUserId(id);
		m.addAttribute("user", u);
		// map.put("user",u);
		return "userEditForm";
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public String updateUser(@Valid @ModelAttribute("user") User user, BindingResult result) {
		if (result.hasErrors()) {
			return "userEditForm";
		}
		userService.updateUser(user);
		return "redirect:/users";
	}
	
	/**
	 * ######################################################################################
	 * User DELETE operns
	 * ######################################################################################
	 */

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
	}
	
	/**
	 * ######################################################################################
	 * User LOGIN operns
	 * ######################################################################################
	 */

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showLoginPage() {
		return "userLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String showWelcomePage(@RequestParam("username") String username, @RequestParam("password") String password,
			ModelMap map) {

		boolean isSuccess = userService.validateUserLogin(username, password);
		if (isSuccess) {
			map.put("username", username);
			map.put("msg", username);
			return "userWelcome";

		} else {
			map.put("msg", "Invalid credentials");
			return "userLogin";
		}
	}

	/**
	 * ########################################### REST end points
	 * ###########################################
	 */

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	@ResponseBody
	public String hello() {
		return "Hello Spring Boot";
	}
}
