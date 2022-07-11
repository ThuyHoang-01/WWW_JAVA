/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.service;

import com.se.onetomany.dao.PersonDAO;
import com.se.onetomany.entity.CreditCard;
import com.se.onetomany.entity.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriPham
 */
@Service
public class PersonServiceImpl implements PersonService{
    @Autowired
    private PersonDAO personDAO;
    
    @Override
    @Transactional
    public List<Person> getPersons()
    {
        return personDAO.getPersons();
     }
    @Override
    @Transactional
    public List<CreditCard> getCreditCards(int thePersonId)
    {
        return personDAO.getCreditCards(thePersonId);
    }
     @Override
    @Transactional
    public CreditCard getCreditCard(int personId, int creditCardId)
    {
        return personDAO.getCreditCard(personId, creditCardId);
    }
    @Override
    @Transactional
    public void savePerson(Person thePerson)
    {
        personDAO.savePerson(thePerson);
    }
    @Override
    @Transactional
    public Person getPerson(int thePersonId)
    {
        return personDAO.getPerson(thePersonId);
    }
    @Override
    @Transactional
    public void deletePerson(int thePersonId)
    {
        personDAO.deletePerson(thePersonId);
    }
    
}
