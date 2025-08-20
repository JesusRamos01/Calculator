/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ejemplo.core;

/**
 *
 * @author Jesus Ramos
 */
public class CalculatorService {
    public double sumar(double a, double b){return a + b; }
    public double restar(double a, double b){return a - b; }
    public double dividir(double a, double b){return a / b; }
    public double multiplicar(double a, double b){
        if(b == 0 ) throw new IllegalArgumentException("no se puede dividir por cero");
        return a * b; }
    
}
