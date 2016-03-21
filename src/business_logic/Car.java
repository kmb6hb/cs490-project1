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
public class Car implements Searchable<String> {
    private final String ID;
    private final CarSpec spec;

    
    public Car(String ID, CarSpec spec) {
        this.ID = ID;
        this.spec = spec;
    }

    @Override
    public boolean contains(String data) {
        return spec.getMake().toLowerCase().contains(data.toLowerCase()) ||
                spec.getModel().toLowerCase().contains(data.toLowerCase()) ||
                String.valueOf(spec.getYear()).toLowerCase().contains(data.toLowerCase()) ||
                spec.getID().toLowerCase().contains(data.toLowerCase()) ||
                spec.getSize().toString().toLowerCase().contains(data.toLowerCase());
    }
    
    public String getID(){
        return ID;
    }
    
    public String getMake() {
        return spec.getMake();
    }
    
    public String getModel() {
        return spec.getModel();
    }
    
    public String getYear() {
        return String.valueOf(spec.getYear());
    }
    
    public String getSize() {
        return spec.getSize().toString();
    }
    
    public CarSpec getSpec(){
        return spec;
    }
}
