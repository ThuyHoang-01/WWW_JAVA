/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.service;

/**
 *
 * @author TriPham
 */
import com.se.onetomany.entity.CreditCard;
import com.se.onetomany.entity.Person;
import java.util.List;


public interface PersonService {
    public List<Person> getPersons();
    public List<CreditCard> getCreditCards(int personId);
    public CreditCard getCreditCard(int personId, int creditCardId);
    public void savePerson(Person thePerson);
    public Person getPerson(int personId);
    public void deletePerson(int personId);
}
