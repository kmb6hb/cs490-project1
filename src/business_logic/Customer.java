/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;



/**
 *
 * @author Kris
 */
public class Customer implements Searchable<String> {
    private final String name;
    private final String phone;
    private final String address;
    
    private final String ID;

    Customer(String ID, String name, String phone, String address) {
        this.ID = ID;
        
        this.name = name;
        this.phone = phone;
        this.address = address;
    }
    
    @Override
    public boolean contains(String data){
        return name.toLowerCase().contains(data.toLowerCase()) || phone.toLowerCase().contains(data.toLowerCase()) || address.toLowerCase().contains(data.toLowerCase());
    }
   
    public String getID(){
        return ID;
    }
    
    public String getName(){
        return name;
    }
 
    public String getPhone() {
        return phone;
    }
    
    public String getAddress(){
        return address;
    }
}
