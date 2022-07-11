package com.se.onetomany.controller;

import com.se.onetomany.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.se.onetomany.service.PersonService;
import com.se.onetomany.entity.Person;
import java.util.List;

@Controller

public class PersonController {

    @Autowired
    // need to inject our customer service
    private PersonService personService;

    @PostMapping("/savePerson")
    public String savePerson(@ModelAttribute("person") Person thePerson) {
        // save the customer using our service
//        List<CreditCard> creditCards = personService.getCreditCards(thePerson.getId());
        List<CreditCard> creditCards = null;
        if (thePerson.getId() != 0) {
            creditCards = personService.getCreditCards(thePerson.getId());
        }
        thePerson.setCreditCards(creditCards);
        personService.savePerson(thePerson);
        return "redirect:/person/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("personId") int theId,
            Model theModel) {
        // get the customer from our service
        Person thePerson = personService.getPerson(theId);
        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("person", thePerson);

        // send over to our form		
        return "person-form";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Person thePerson = new Person();
        theModel.addAttribute("person", thePerson);
        //theModel.addAttribute("update", false);
        return "person-form";
    }

    @GetMapping("/delete")
    public String deletePerson(@RequestParam("personId") int theId) {

        // delete the customer
        personService.deletePerson(theId);

        return "redirect:/person/list";
    }

    @GetMapping("/")
    public String listPersons(Model theModel) {
        // get persons from the service
        List<Person> thePersons = personService.getPersons();
        // add the customers to the model
        theModel.addAttribute("persons", thePersons);
        return "list-persons";
    }

}
