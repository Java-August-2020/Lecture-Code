package com.matthew.ninjaGold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@RequestMapping("/")
	public String index(HttpSession session, Model viewModel) {
		ArrayList<String> activity = new ArrayList<String>();
		if(session.getAttribute("gold") == null) {
			session.setAttribute("gold", 0);
		}
		if(session.getAttribute("activityLog") == null){
			session.setAttribute("activityLog", activity);
		}
		viewModel.addAttribute("totalGold", session.getAttribute("gold"));
		viewModel.addAttribute("activityLog", session.getAttribute("activityLog"));
		System.out.println(session.getAttribute("activityLog"));
		return "index.jsp";
	}
	
	@PostMapping("/activity")
	public String activity(@RequestParam("building") String building, HttpSession session) {
		int gold = (int)session.getAttribute("gold");
		Random r = new Random();
		ArrayList<String> activities = (ArrayList<String>)session.getAttribute("activityLog");
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd YYYY h:mma");
		if(building.equals("farm")) {
			int farmGold = r.nextInt((20 - 10) + 1) + 10;
			gold += farmGold;
			session.setAttribute("gold", gold);
			// maximum - minimum + 1 + minimum
			activities.add("You entered a farm and earned " + farmGold + " gold! " + formatter.format(now) +  "");
		}
		if(building.equals("cave")) {
			// do cave stuff
			int caveGold = r.nextInt((10 - 5) + 1) + 5;
			gold += caveGold;
			session.setAttribute("gold", gold);
			activities.add("You entered a cave and earned " + caveGold + " gold! " + formatter.format(now) + "");
		}		
		if(building.equals("house")) {
			// do house stuff
			int houseGold = r.nextInt((5 - 2) + 1) + 2;
			gold += houseGold;
			session.setAttribute("gold", gold);
			activities.add("You entered a house and earned " + houseGold + " gold " + formatter.format(now) + "");
		}		
		if(building.equals("casino")) {
			// do casino stuff
			int casinoGold = r.nextInt((50 + 50) + 1) + -50;
			gold += casinoGold;
			session.setAttribute("gold", gold);
			if(casinoGold > 0) {
				activities.add("You entered a casino and earned " + casinoGold + " gold!" + formatter.format(now) + ")");
			} else {
				activities.add("You entered a casino and lost " + casinoGold + " gold! " + formatter.format(now) + ")");
			}
		}

		return "redirect:/";
	}
}
