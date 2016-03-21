/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import java.util.Calendar;

/**
 *
 * @author Kris
 */
public class Rental {
    private Calendar rentDate;
    private Calendar returnDate;
    
    public enum rentStatus { RENTED, RETURNED};
    private rentStatus status;
    
    public Rental(Calendar rentDate, rentStatus status) {
        this.rentDate = rentDate;
        this.status = status;
    }
    
    public Calendar getRentDate() {
        return this.rentDate;
    }
    
    public Calendar getReturnDate() {
        return this.returnDate;
    }
    
    public rentStatus getStatus() {
        return this.status;
    }
    
    public void returnRental(Calendar returnDate) {
        this.returnDate = returnDate;
        this.status = rentStatus.RETURNED;
    }
}
