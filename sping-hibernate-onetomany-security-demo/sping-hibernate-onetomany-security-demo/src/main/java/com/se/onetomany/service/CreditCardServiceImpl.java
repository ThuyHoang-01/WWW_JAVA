/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.service;

import com.se.onetomany.dao.CreditCardDAO;
import com.se.onetomany.entity.CreditCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author TriPham
 */
@Service
public class CreditCardServiceImpl implements CreditCardService {
     @Autowired
    private CreditCardDAO creditCardDAO;
    
    @Override
    @Transactional
     public CreditCard getCreditCard(int theId)
     {
         return creditCardDAO.getCreditCard(theId);
     }
     @Override
    @Transactional
    public void saveCreditCard(CreditCard theCard, int personId)
    {
        creditCardDAO.saveCreditCard(theCard, personId);
    }
     @Override
    @Transactional
    public void updateCreditCard(CreditCard theCard,  int personId)
    {
        creditCardDAO.updateCreditCard(theCard, personId );
    }
    @Override
    @Transactional
    public void deleteCreditCard(int theId)
    {
        creditCardDAO.deleteCreditCard(theId);
    }
}
