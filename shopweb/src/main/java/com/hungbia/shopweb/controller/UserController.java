package com.hungbia.shopweb.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hungbia.shopweb.model.UserDTO;
import com.hungbia.shopweb.service.UserSevice;
import com.hungbia.shopweb.validator.UserValidator;

@Controller
public class UserController implements ErrorController {

	@Autowired
	UserSevice userSevice;
	@Autowired
	UserValidator userValidator;

	@GetMapping(value = "/home")
	public String Home(HttpServletRequest request) {
		return "home/home";
	}

	@RequestMapping(value = "/user/add", method = RequestMethod.GET)
	public String addUser(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO) {
		request.setAttribute("user", userDTO);
		return "user/addUser";

	}

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addUSer(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO) {
		userSevice.addUser(userDTO);
		return "redirect:/user/list";
	}

	@GetMapping(value = "/user/list")
	public String listUser(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO) {
		request.setAttribute("users", userSevice.getAllUserDTO());
		return "user/listUser";
	}

	@GetMapping(value = "user/search")
	public String searchKeyWord(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO,
			@RequestParam(value = "keyword") String keyword) {
		request.setAttribute("users", userSevice.searchName(keyword));
		return "user/listUser";
	}

	@GetMapping(value = "user/searchId")
	// required= true bat buoc clien gui len phai co param id kia
	// @RequestParam doc o thanh trinh duyet
	public String getUSerById(HttpServletRequest request, @RequestParam(value = "id", required = true) int id) {
		request.setAttribute("user", userSevice.getUserIdDTO(id));
		return "user/user";
	}

	@GetMapping(value = "user/delete")
	// @PathVariable(value = "id") int id doc gia tri tu duong dan /{id} gan cho
	// int id
	public String deteleUser(HttpServletRequest request, @RequestParam(value = "id", required = true) int id) {
		userSevice.deleteUserDTO(id);
		return "redirect:/user/list";
	}

	@GetMapping(value = "user/update")
	// RequestParam tuong duong voi request.param ơ servlet
	public String updateUser(HttpServletRequest request, @RequestParam(value = "id") int id) {
		return "user/updateUser";
	}

	@PostMapping(value = "user/update")
	public String updateUser(HttpServletRequest request, @ModelAttribute("user") UserDTO userDTO) {
//		userValidator.validate(userDTO, bindingResult);
		// kiem tra xem co loi k
//		if (bindingResult.hasErrors()) {
//			return "user/updateUser";
//		}
		userSevice.updateUserDTO(userDTO);
		System.out.println("ok");
		return "redirect:/user/list";
	}

	@GetMapping(value = "user/login")
	public String loGin(HttpServletRequest request) {
		return "user/loGin";
	}

	@PostMapping(value = "user/login")
	public String loGin(HttpServletRequest request, @RequestParam(value = "username") String username,
			@RequestParam(value = "password") String password) {
		System.out.println("a");
		UserDTO u = userSevice.searchUsername(username);
		System.out.println("u=" + u.getUsername() + "pass" + u.getPassword());
		if (u != null && u.getPassword().equals(password)) {
			return "redirect:/user/list";
		} else {
			return "user/loGin";
		}

	}

	@RequestMapping("/error")
	public String handleError(HttpServletRequest request) {
		Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
		if (status != null) {
			Integer statusCode = Integer.valueOf(status.toString());
			if (statusCode == HttpStatus.NOT_FOUND.value()) {
				// loi 404 tra ve trang HTML.
				return "erro/404";
//			} else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
//				return "error-500";
//			}
//		}
//		return "error";
			}
		}
		return "error";
	}

	@Override
	public String getErrorPath() {
		return "/error";
	}
}
