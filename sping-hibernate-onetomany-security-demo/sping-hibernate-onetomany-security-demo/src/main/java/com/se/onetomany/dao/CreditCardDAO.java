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
public interface CreditCardDAO {
    public CreditCard getCreditCard(int creditCardId);
    public void saveCreditCard(CreditCard theCard, int personId);
    public void updateCreditCard(CreditCard theCard, int personId);
    public void deleteCreditCard(int creditCardId);
}
