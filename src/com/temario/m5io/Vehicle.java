package com.temario.m5io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Vehicle implements Serializable {

    private String carBrand;
    private String model;
    private transient Long id;

    public Vehicle(String carBrand, String model, long id) {
        this.carBrand = carBrand;
        this.model = model;
        this.id = id;
    }

    public Vehicle() {
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Vehicle{" + "carBrand=" + carBrand + ", model=" + model + ", id=" + id + '}';
    }

    public void serializeVehicle(Vehicle v1) {
        try (FileOutputStream fos = new FileOutputStream("C:\\Prueba\\car.obj");
                ObjectOutputStream out = new ObjectOutputStream(fos)) {
            out.writeObject(v1);
        } catch (IOException ex) {
            Logger.getLogger(Vehicle.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deserializeVehicle() {
        try (FileInputStream fos = new FileInputStream("C:\\Prueba\\car.obj");
                ObjectInputStream out = new ObjectInputStream(fos)) {
            Vehicle v1 = (Vehicle) out.readObject();
            System.out.println(v1);
        } catch (IOException ex) {
            System.out.println("Error en la ruta del archivo");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error de casteo");
        }
    }

}
