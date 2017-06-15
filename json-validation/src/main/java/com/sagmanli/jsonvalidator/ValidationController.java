package com.sagmanli.jsonvalidator;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {

    @GetMapping("/validation")
    public String greetingForm(Model model) {
        model.addAttribute("validation", new Validation());
        return "validation";
    }

    @PostMapping("/validation")
    public String greetingSubmit(@ModelAttribute Validation validation) {
    	if(ValidationService.isJSONValid(validation)){
    		return "tree";
    	}
    	return "validation";

    }
}
