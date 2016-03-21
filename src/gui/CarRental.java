/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import static business_logic.CarSpec.carSize.*;
import business_logic.Controller;

/**
 *
 * @author Kris
 */
public class CarRental {
    
    public static void main(String[] args) {
        Controller controller=Controller.Instance();
        
        // add customers, name, phone, address
        controller.addCustomer("123", "Bob", "816-111-1111", "8100 E 88 ST");
        controller.addCustomer("456", "Joe", "816-222-2222", "8200 E 88 ST");
        controller.addCustomer("789", "Ted", "816-333-3333", "8300 E 88 ST");
        
        // add car specifications, make, model, year, size
        controller.addSpecs("11111","Nissan","Altima",2000, SMALL);
        controller.addSpecs("22222","Mercedes","Passat",2001, MIDSIZE);
        controller.addSpecs("33333","Volks Wagen","Benz",2002, LARGE);
        
        // add cars, ID, specsID
        controller.addCar("1001", "11111");
        controller.addCar("1002", "22222");
        controller.addCar("1003", "33333");
        
        customersFrame frame=new customersFrame(controller);
        frame.setVisible(true);
    }
}
