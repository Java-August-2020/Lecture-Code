package com.matthew.weddings.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.matthew.weddings.models.Wedding;
import com.matthew.weddings.services.UserService;
import com.matthew.weddings.services.WeddingService;

@Controller
@RequestMapping("/weddings")
public class WeddingController {
	@Autowired
	private WeddingService wService;
	@Autowired
	private UserService uService;
	
	
	@RequestMapping("")
	public String dashboard(HttpSession session, Model viewModel) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("user", this.uService.getOneUser(userId));
		viewModel.addAttribute("weddings", this.wService.getWeddings());
		return "dashboard.jsp";
	}
	
	@RequestMapping("/new")
	private String newWedding(@ModelAttribute("wedding") Wedding wedding, HttpSession session, Model viewModel){
	Long userId = (Long)session.getAttribute("user_id");
	// Put in the viewModel
	viewModel.addAttribute("userId", userId);
	return "new.jsp";
	}
	
	@PostMapping("")
	public String create(@Valid @ModelAttribute("wedding") Wedding wedding, BindingResult result, HttpSession session, Model viewModel) {
	if(result.hasErrors()) {
		Long userId = (Long)session.getAttribute("user_id");
		viewModel.addAttribute("userId", userId);
		return "new.jsp";
	}
	this.wService.create(wedding);
	return "redirect:/weddings";
	}
	
	@RequestMapping("{id}")
	public String show(@PathVariable("id") Long id, Model viewModel) {
		viewModel.addAttribute("wedding", this.wService.getById(id));
		return "show.jsp";
	}

}
