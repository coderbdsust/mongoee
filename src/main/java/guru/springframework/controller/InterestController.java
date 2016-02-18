package guru.springframework.controller;

import java.beans.PropertyEditorSupport;

import javax.validation.Valid;


import guru.springframework.domain.Interest;
import guru.springframework.editor.ObjectIdEditor;

import guru.springframework.service.InterestService;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/interest")
public class InterestController {

	@Autowired
	private InterestService interestService;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(ObjectId.class, "id", new ObjectIdEditor());
	}

	@RequestMapping("/create")
	public String createInterest(Model model) {
		System.out.println("[DEBUG] [/interest/create]");
		model.addAttribute("interest", new Interest());
		return "create";
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String createInformation(@Valid Interest interest,
			BindingResult bindingErrors) {
		System.out.println("[DEBUG] [/interest/save]");
		System.out.println(interest);

		if (bindingErrors.hasErrors()) {
//			for (ObjectError er : bindingErrors.getAllErrors()) {
//				System.out.println(er);
//			}
			return "create";
		}

		interestService.saveOrUpdate(interest);
		return "redirect:/interest";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editInterest(@PathVariable String id, Model model) {
		System.out.println("[DEBUG] [/interest/edit/{id}" + id + "]");
		Interest interest = interestService.getInterestById(new ObjectId(id));
		model.addAttribute("interest", interest);
		return "create";
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteInterest(@PathVariable String id) {
		System.out.println("[DEBUG] [/interest/delete/{id}]");
		interestService.deleteInterestById(new ObjectId(id));
		return "redirect:/interest";
	}
}
