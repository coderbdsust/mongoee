package guru.springframework.controller;

import guru.springframework.domain.Information;
import guru.springframework.service.InformationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

	@Autowired
	private InformationService informationService;

	@RequestMapping({"","/"})
	public String showIndex(Model model) {
		System.out.println("[DEBUG] [/]");
		model.addAttribute("informations", informationService.getInformations());
		return "new-index";
	}
}
