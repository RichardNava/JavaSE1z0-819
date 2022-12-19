/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package com.temario.m2poo;

/**
 *
 * @author richa
 */
public enum ArmourType {
    MALLA(8), PLACAS(10), TELA(2), TELA_ROBUSTA(4), CUERO(6);
    int armour;

    private ArmourType(int armour) {
        this.armour = armour;
    }
    
}
