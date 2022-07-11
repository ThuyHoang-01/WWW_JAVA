/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.dao;

import com.se.onetomany.entity.CreditCard;
import com.se.onetomany.entity.Person;
import java.util.List;

/**
 *
 * @author TriPham
 */
public interface PersonDAO {
    public List<Person> getPersons();
    public List<CreditCard> getCreditCards(int thePersonId);
    public CreditCard getCreditCard(int personId, int creditCardId);
    public void savePerson(Person thePerson);
    public Person getPerson(int theId);
    public void deletePerson(int theId);
    
}
