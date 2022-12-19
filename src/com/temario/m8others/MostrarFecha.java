
package com.temario.m8others;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class MostrarFecha {
    private final LocalDate date = LocalDate.now();
    
    @MyAnnotation(value=FormatDate.FULL, name="Pepito")
    public LocalDate mostrarFecha(DateTimeFormatter dt, String name){
        System.out.println(name+" hoy es "+date.format(dt));
        return date;
    }
    
}
