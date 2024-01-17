package com.unionistashop.crud_app_1.rest;

import com.unionistashop.crud_app_1.entities.Student;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("thymeleafs")
public class ThymeLeafController {

    @InitBinder()
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }


    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;

    public ThymeLeafController() {
    }

    @GetMapping("/showform")
    public String showForm(Model model) {
        Student student = new Student();
        student.setFirstName("mohamed");
        student.setLastName("ben khouya");
        model.addAttribute("student", student);
        model.addAttribute("countries", this.countries);
        model.addAttribute("languages", this.languages);
        model.addAttribute("systems", this.systems);
        return "form";
    }

//    @RequestMapping(path="/processform", method= RequestMethod.POST, consumes= MediaType.APPLICATION_FORM_URLENCODED_VALUE,
//    produces= {
//            MediaType.TEXT_XML_VALUE
//    })
    @PostMapping("processform")
    public String  processForm(
           // Model theModel,
            @Valid @ModelAttribute("student") Student student,
//            @Valid @RequestParam Map<Object, String> paramMap,
//            @Valid @RequestParam(value = "sys[]") String[] systems,
//            HttpServletRequest req,
            BindingResult bindingResult
    )
    {

        System.out.println("binding results: " + bindingResult.toString());
        if(bindingResult.hasErrors()) {
            return "form";
        }
//        theModel.addAttribute("firstName", paramMap.get("firstName").toUpperCase());
//        theModel.addAttribute("lastName", paramMap.get("lastName").toUpperCase());
//        theModel.addAttribute("country", paramMap.get("country"));
//        theModel.addAttribute("lng", paramMap.get("lng"));
//        theModel.addAttribute("sys", Arrays.stream(systems).toList());
//        theModel.addAttribute("student", student);

        return "success-notif";
    }
}
