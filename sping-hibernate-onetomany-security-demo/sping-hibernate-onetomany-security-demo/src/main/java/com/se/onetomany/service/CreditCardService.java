/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.se.onetomany.service;

import com.se.onetomany.entity.CreditCard;

/**
 *
 * @author TriPham
 */
public interface CreditCardService {
    public CreditCard getCreditCard(int theId);
    public void saveCreditCard(CreditCard theCard, int personId);
    public void updateCreditCard(CreditCard theCard,  int personId);
    public void deleteCreditCard(int theId);    
}
