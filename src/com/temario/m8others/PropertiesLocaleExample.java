package com.temario.m8others;

import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

public class PropertiesLocaleExample {

    private final ResourceBundle resource;
    private final Locale locale;

    public PropertiesLocaleExample(Locale locale) {
        this.locale = locale;
        resource = ResourceBundle.getBundle("com.temario.m8others.ejemplos", locale);
    }

    public PropertiesLocaleExample() {
        Locale.setDefault(Locale.US);
        this.locale = Locale.getDefault();
        resource = ResourceBundle.getBundle("com.temario.m8others.ejemplos", locale);
    }

    public void saludar() {
        System.out.println(resource.getString("saludo"));
    }

    public void saludar(String name) {
        String mensaje = MessageFormat.format(resource.getString("saludo.personalizado"), name);
        System.out.println(mensaje);
    }

    public void despedir() {
        System.out.println(resource.getString("despedida"));
    }

    public void despedir(String name) {
        String mensaje = MessageFormat.format(resource.getString("despedida.personalizada"), name);
        System.out.println(mensaje);
    }

    public void fecha(LocalDate date) {
        String mensaje = MessageFormat.format(resource.getString("fecha"),
                DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).localizedBy(locale).format(date));
        System.out.println(mensaje);
    }

    public void moneda(double precio) {
        String mensaje = MessageFormat.format(resource.getString("moneda"),
                NumberFormat.getCurrencyInstance(locale).format(precio));
        System.out.println(mensaje);
    }

    public void region() {
        String mensaje = MessageFormat.format(resource.getString("locale"),
                locale.getCountry(),
                locale.getLanguage());
        System.out.println(mensaje);
    }
}
