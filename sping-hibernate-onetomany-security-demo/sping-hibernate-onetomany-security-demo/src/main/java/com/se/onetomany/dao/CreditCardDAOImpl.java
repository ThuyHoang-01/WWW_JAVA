/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.dao;

import com.se.onetomany.entity.CreditCard;
import com.se.onetomany.entity.Person;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author TriPham
 */
@Repository
public class CreditCardDAOImpl implements CreditCardDAO {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public CreditCard getCreditCard(int theId)
    {
         Session currentSession = sessionFactory.getCurrentSession();
          // now retrieve/read from database using the primary key
          CreditCard theCredicCard = currentSession.get(CreditCard.class, theId);
            return theCredicCard;
    }
    @Override
    public void saveCreditCard(CreditCard theCard, int personId)
    {
          Session currentSession = sessionFactory.getCurrentSession();
          Person person= currentSession.get(Person.class, personId);
          person.addCreditCard(theCard);
          currentSession.saveOrUpdate(theCard);
    }
    @Override
    public void updateCreditCard(CreditCard tempCard, int personId)
    {
        Session currentSession = sessionFactory.getCurrentSession();
        Person person= currentSession.get(Person.class, personId);
        CreditCard theCard=person.getCreditCard(tempCard.getId());
        setValueCreditCard(theCard, tempCard);
         currentSession.saveOrUpdate(theCard);
      }
    @Override
    public void deleteCreditCard(int creditCardId)
    {
         Session currentSession = sessionFactory.getCurrentSession();
            // delete object with primary key
         CreditCard tempCCard = currentSession.get(CreditCard.class, creditCardId);
            currentSession.delete(tempCCard);
    }
    
    //-----------------------------------Private methods
    private void setValueCreditCard(CreditCard theCard, CreditCard tempCard)
    {
        theCard.setNumber(tempCard.getNumber());
        theCard.setType(tempCard.getType());
    }
    
}
