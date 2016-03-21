/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business_logic;

/**
 *
 * @author Kris
 * @param <T>
 */
public interface Searchable<T> {
    
    public boolean contains(T data);
}
