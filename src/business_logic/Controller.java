/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

import business_logic.CarSpec.carSize;
import business_logic.Rental.rentStatus;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 *
 * @author Kris
 */
public class Controller {
    
    public enum Add { SUCCESS, KEYEXISTS, FAILURE };
    
    private int tab = 0;
    private int available_cars = 0;
    private Map<String, Customer> customers;
    private Map<String, Car> cars;
    private Map<String, CarSpec> specs;
    
    private static Controller singleton;
    
    public void setTab(int tabNum) {
        tab = tabNum;
    }
    
    public int getTab() {
        return tab;
    }
    
    public static Controller Instance(){
        if(singleton==null)
            singleton=new Controller(0);
        return singleton;
    }
    
    protected Controller() throws Exception {
        if(getClass().getName().equals("Controller")){
            throw new Exception();
        }
    }

    private Controller(int i) {
        customers = new HashMap();
        cars = new HashMap();
        specs = new HashMap();        
    }
    
    public Add addCustomer(String ID, String name, String phone, String address) {
        if (customers.containsKey(ID)) {
            return Add.KEYEXISTS;
        } else {
            customers.put(ID, new Customer(ID, name, phone, address));
            return Add.SUCCESS;
        }
    }
    
    public Add addSpecs(String ID, String make, String model, int year, carSize size) {
         if (specs.containsKey(ID)) {
            return Add.KEYEXISTS;
        } else {
            specs.put(ID, new CarSpec(ID, make, model, year, size));
        }
        return Add.SUCCESS;
    }
    
    public Add addCar(String ID, String specsID) {
        if (cars.containsKey(ID)) {
            return Add.KEYEXISTS;
        }
        
        CarSpec spec = specs.get(specsID);
        cars.put(ID, new Car(ID, spec));
        available_cars++;

        return Add.SUCCESS;
    }
   
    
    public Object[][] findCustomers(String data) {
        Collection<Customer> customers = this.customers.values().stream()
                                               .filter(item->item.contains(data))
                                               .collect(Collectors.toList());
        
        Object[][] result = new Object[customers.size()][3];
        int count = 0;
        for (Customer customer : customers) {
            Object[] cus_array = {customer.getName(), customer.getPhone(), customer.getAddress()};
            result[count++] = cus_array;
        }
        return result;
    }
    
    //find cars todo
    public Object[][] findCars(String data) {
        Collection<Car> cars = this.cars.values().stream()
                                               .filter(item->item.contains(data))
                                               .collect(Collectors.toList());
        
        Object[][] result = new Object[available_cars][6];
        int count = 0;
        for (Car car : cars) {
        //    if (car.getStatus() != rentStatus.RENTED) {
                Object[] car_array = {false, car.getID(), car.getMake(), car.getModel(), car.getYear(), car.getSize()};
                result[count++] = car_array;
        //    }
        }
        return result;
    }
}
