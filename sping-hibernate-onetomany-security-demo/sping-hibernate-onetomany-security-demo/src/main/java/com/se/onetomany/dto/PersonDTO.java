/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.dto;

import com.se.onetomany.entity.CreditCard;
import com.se.onetomany.entity.Person;
import java.util.List;

/**
 *
 * @author TriPham
 */
public class PersonDTO {
    private Person person;
    private List<CreditCard> creditCards;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public List<CreditCard> getCreditCards() {
        return creditCards;
    }

    public void setCreditCards(List<CreditCard> creditCards) {
        this.creditCards = creditCards;
    }
    
    
}
