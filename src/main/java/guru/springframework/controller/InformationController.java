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
@RequestMapping("/information")
public class InformationController {

	@Autowired
	private InformationService informationService;

	@RequestMapping("/create")
	public String createInformation(Model model) {
		System.out.println("[DEBUG] [/information/create]");
		model.addAttribute("information", new Information());
		return "new-create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createInformation(Information information) {
		System.out.println("[DEBUG] [/information/save]");
		System.out.println(information);
		informationService.saveOrUpdate(information);
		return "redirect:/";
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editInformation(@PathVariable String id, Model model) {
		System.out.println("[DEBUG] [/information/edit/{id}" + id + "]");
		Information information = informationService.getInformationById(id);
		model.addAttribute("information", information);
		return "new-create";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteInformation(@PathVariable String id) {
		System.out.println("[DEBUG] [/information/delete/{id}]");
		informationService.deleteInformationById(id);
		return "redirect:/";
	}
}
