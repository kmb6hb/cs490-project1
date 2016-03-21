/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import java.util.Vector;

/**
 *
 * @author Kris
 */
public class CarSpec implements Searchable<String> {
    private final String make;
    private final String model;
    private final int year;
    
    private final String ID;

    public enum carSize { SMALL, MIDSIZE, LARGE };
    private final carSize size; 

    CarSpec(String ID, String make, String model, int year, carSize size) {
        this.ID = ID;
        
        this.make = make;
        this.model = model;
        this.year = year;
        this.size = size;
    }
    
    @Override
    public boolean contains(String data) {
        return make.toLowerCase().contains(data.toLowerCase()) ||
                model.toLowerCase().contains(data.toLowerCase()) ||
                String.valueOf(year).toLowerCase().contains(data.toLowerCase()) ||
                ID.toLowerCase().contains(data.toLowerCase()) ||
                carSize.valueOf(data.toUpperCase()).toString().toLowerCase().contains(data.toLowerCase());
                
    }
    
    public String getID(){
        return ID;
    }
    
    public String getMake(){
        return make;
    }
 
    public String getModel() {
        return model;
    }
    
    public int getYear(){
        return year;
    }
    
    public carSize getSize() {
        return size;
    }
   
}
