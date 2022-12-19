package com.temario.m8others;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UseAnnotation {

    public void use(MostrarFecha mostrarFecha) {
        Method[] methods = mostrarFecha.getClass().getMethods();
        for (Method method : methods) {
            try {
                useMethods(method,mostrarFecha);
            } catch (IllegalAccessException | InvocationTargetException ex) {
                Logger.getLogger(UseAnnotation.class.getName()).log(Level.SEVERE, "Error invocando el método", ex);
            }
        }

    }

    public void useMethods(Method m, MostrarFecha mostrarFecha) throws IllegalAccessException, InvocationTargetException {
        MyAnnotation annotation = m.getAnnotation(MyAnnotation.class);
        if (annotation != null) {
            FormatDate fd = annotation.value();
            String name = annotation.name();
            m.invoke(mostrarFecha, fd.getDt(), name);

        }
    }

}
