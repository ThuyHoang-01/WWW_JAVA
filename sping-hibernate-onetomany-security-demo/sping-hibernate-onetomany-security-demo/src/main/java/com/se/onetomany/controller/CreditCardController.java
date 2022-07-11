package com.se.onetomany.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.se.onetomany.service.PersonService;
import com.se.onetomany.service.CreditCardService;
import com.se.onetomany.entity.Person;
import com.se.onetomany.entity.CreditCard;

@Controller
@RequestMapping("/creditcard")
public class CreditCardController {

    @Autowired
    // need to inject our customer service
    private CreditCardService creditCardService;
    
    @Autowired
    private PersonService service;
    
    @PostMapping("/saveCard")
    public String saveCreditCard(@ModelAttribute("creditCardAttribute") CreditCard theCard,
            @RequestParam("personId") int personId) {
        // save the customer using our service
        creditCardService.saveCreditCard(theCard, personId);
        return "redirect:/creditcard/list?personId=" + personId;
    }

    @PostMapping("/updateCard")
    public String updateCreditCard(@ModelAttribute("creditCardAttribute") CreditCard theCard,
            @RequestParam("personId") int personId) {
        // save the customer using our service
        creditCardService.updateCreditCard(theCard, personId);
        return "redirect:/creditcard/list?personId=" + personId;
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel, @RequestParam("personId") int personId) {
        // create model attribute to bind form data
        CreditCard theCard = new CreditCard();
        theModel.addAttribute("creditCardAttribute", theCard);
        theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", false);
        return "credit-form";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("personId") int personId,
            @RequestParam("creditCardId") int creditCardId,
            Model theModel) {
        // get the creditcard from our service
        CreditCard theCreditCard = creditCardService.getCreditCard(creditCardId);
        // set creditcard as a model attribute to pre-populate the form
        theModel.addAttribute("creditCardAttribute", theCreditCard);
        theModel.addAttribute("personId", personId);
        theModel.addAttribute("isUpdate", true);

        // send over to our form		
        return "credit-form";
    }

    @GetMapping("/delete")
    public String deleteCreditCard(@RequestParam("creditCardId") int theId, int personId) {

        // delete the customer
        creditCardService.deleteCreditCard(theId);
        return "redirect:/creditcard/list?personId=" + personId;
    }
    
    @GetMapping("/list")
    public String listPersons(@RequestParam("personId") int personId, Model theModel) {
        // get persons from the service
        
        Person person = service.getPerson(personId);
        // add the customers to the model
        theModel.addAttribute("person", person);
        return "credit-card-list";
    }
}