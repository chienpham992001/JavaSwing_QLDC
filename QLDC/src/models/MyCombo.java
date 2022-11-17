/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author pc
 */
public class MyCombo {
    Object value;
    Object text;
    
    public MyCombo(Object value, Object text){
        this.value = value;
        this.text = text;
    }
    
    @Override
    public String toString(){
        return text.toString();
    }
    public int MaInt(){
        return Integer.parseInt(value.toString());
    }
    public String maString(){
        return value.toString();
    }
}
            