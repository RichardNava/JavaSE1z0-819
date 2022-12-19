
package com.temario.m2poo;

public enum Clase {
    
    PALADIN(ArmourType.MALLA),
    GUERRERO(ArmourType.PLACAS),
    MAGO(ArmourType.TELA),
    CLERIGO(ArmourType.TELA_ROBUSTA),
    BRIBON(ArmourType.CUERO);
    
   // int armour;
    public ArmourType armourType;
    
    private Clase(ArmourType armourType){
        //this.armour = armour;
        this.armourType = armourType;
    }

    @Override
    public String toString() {
        return " Tipo de armadura= " + armourType;
    }

    public ArmourType getArmourType() {
        return armourType;
    }

    public void setArmourType(ArmourType armourType) {
        this.armourType = armourType;
    }
    
}
