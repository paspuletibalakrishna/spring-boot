package com.bala.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.bala.models.DateContainer;
import java.time.temporal.ChronoUnit;

import javax.validation.Valid;


@Controller
public class WelcomeController implements WebMvcConfigurer {

    // inject via application.properties
    @Value("${error.message}")
    private String errorMessage;
    
    @RequestMapping(value = "/", method=RequestMethod.GET)
    public String showForm(Model model) {
    	DateContainer dateContainer = new DateContainer();
    	model.addAttribute("dateContainer", dateContainer);
        return "welcome";
    }
    
   
    @RequestMapping(value = "/dateRange", method = RequestMethod.POST)
    public String dateTest(@ModelAttribute @Valid DateContainer dateContainer,
    		BindingResult errors, Model model) {
    	if (errors.hasErrors()) {
    		return "welcome";
    	}
        final long days = ChronoUnit.DAYS.between(dateContainer.getStartDate(), dateContainer.getEndDate());
	       
        if ( days > 0) {
        	 model.addAttribute("message", "Number of Days between Start Date and End Date are :: " + days);
        } else {
        	ObjectError error = new ObjectError("message", errorMessage);
        	errors.addError(error);
        }
        return "welcome";
    }

}