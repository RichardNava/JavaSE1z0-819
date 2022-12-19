package com.temario.m1datatypes;


import java.util.Arrays;
import java.util.Scanner; // Acceso a la libreria que contiene la clase Scanner

public class StringVSStringBuilder { // String es inmutable - StringBuilder es mutable

    public void show() {

        String texto = "  Luke, yo soy tu padre. "; // Instancia = new

        // M�todo length() -> Devuelve el n�mero de caracteres que tiene el texto
        // (String)
        int textSize = texto.length();
        p("Mi frase tiene " + textSize + " caracteres.");
        // M�todo toLowerCase() / toUpperCase() -> M�todos que sirven para pasar a
        // minisculas o mayusculas respectivamente
        p("toUpperCase()-> " + texto.toUpperCase()); // Ejemplo de la inmutabilidad de String
        p(texto); // A pesar de haber utilizado un m�todo en la linea anterior el texto no ha sido modificado
        String textoUpper = texto.toUpperCase(); //Asignando el valor a una nueva variable si notamos el cambio
        p(textoUpper);
        String textoLower = texto.toLowerCase();
        p("toLowerCase()-> " + textoLower);

        // M�todo substring(int a, int b) -> Devuelve una subcadena comprendida entre
        // los valores pasados (Inicio "Inclusivo" - Final "Exclusivo")
        String subTexto = texto.substring(6);
        p("substring(a)-> " + subTexto);
        String subTexto2 = texto.substring(6, 12);
        p("substring(a,b)-> " + subTexto2);
        // M�todo charAt(int pos) -> Devuelve el char(caracter) que corresponde a la
        // posici�n que le damos como argumento
        char letra = texto.charAt(texto.length() - 6); // -> Todos los iterables parten de la posici�n 0(inicio) a //
        // length -1(fin)
        p("charAt()-> " + letra);

        // M�todo indexOf(String expresion) -> Nos devuelve un int que corresponde al
        // valor de la posici�n donde comienza la expresi�n buscada
        int indexPos = texto.indexOf("y"); // Al no encontrar coincidencia con la busqueda nos devuelve -1
        p("indexOf()-> " + indexPos);

        // M�todo replace(String c1, String c2) sustituye c1 por c2
        String textoRemplazado = texto.replace("Luke", "Mark");
        p("replace() 1-> " + textoRemplazado);
        String textoRemplazadoChar = textoRemplazado.replace('o', 'a');
        textoRemplazadoChar = textoRemplazadoChar.replace('u', 'i');
        p("replace() 2-> " + textoRemplazadoChar);
        textoRemplazado = texto.replace(texto.substring(6, 8), "tu");
        p("replace() 3-> " + textoRemplazado);

        // M�todo startWith(String s1)/endsWith(String s2) Nos devuelve true/false
        // despues de comprobar si el texto empieza o termina
        // con el argumento que le pasemos
        p("startsWith()-> " + texto.trim().startsWith("Luke"));
        p("endsWith()-> " + texto.endsWith("Luke"));
        // M�todo trim() nos quita espacios al principio y al final
        p("trim()-> " + texto.trim());
        // System.out.println(texto.replace("yo","nosotros").toUpperCase().trim().substring(2));

        // M�todo concat(String s) concatena el texto original con el nuevo texto
        // (argumento)
        p("concat()-> " + texto.concat("Y adem�s eres muy feo."));

        // M�todo isEmpty() nos dice si la cadena de caracteres esta vacia
        p("isEmpty()-> " + texto.isEmpty());
        String textoVacio = "";
        p("isEmpty() 2" + textoVacio.isEmpty());

        System.out.println("Introduzca una nueva frase: ");
        Scanner sc = new Scanner(System.in); // Instancia de la clase que permite entrada por teclado
        String nuevaFrase = sc.nextLine();
        // M�todo isBlank() nos dice si el texto esta en blanco
        p("isBlank()-> " + nuevaFrase.isBlank());
        p("isEmpty()-> " + nuevaFrase.isEmpty());
        // M�todo equals(String textoParaComparar) compara el texto original con el texto que le pasamos por argumento
        p("equals()-> " + nuevaFrase.equals(texto.trim())); // (5 == 8)
        // M�todo repeat(int count) repetimos el texto concatenandolo el n?mero de veces que le digamos por argumento
        p("repeat()-> " + nuevaFrase.repeat(10));
        // M�todo strip() similar a trim pero reconoce m�s espacios en blanco
        p("trim()-> " + nuevaFrase.trim());
        p("strip()-> " + nuevaFrase.strip());
        // M�todo split() nos devuelve un array de char suprimiendo los argumentos que especifiquemos
        p("split()-> " + Arrays.toString(texto.split("y")));

        //STRINGBUILDER
        //StringBuilder sbTexto2 = new StringBuilder("Que la fuerza te acompa?e");
        System.out.println("Introduzca una nueva frase: ");
        StringBuilder sbTexto = new StringBuilder(sc.nextLine());
        p("STRINGBUILDER\n" + sbTexto);
        // M�todo append(Dato nombreDato) a?ade al final de nuestro String el argumento que le pasemos (Concatena).
        sbTexto.append(" fin.");
        p(sbTexto);
        // M�todo insert(int pos, Dato nombreDato) introduce en la posici?n especificada el dato que le pasamos
        p("insert()-> " + sbTexto.insert(4, "algoNuevo"));
        // M�todo replace(int posInicial, int posFinal, String nuevoTexto) similar al replace de String
        // pero en este caso intercambia por posici�n en lugar de por valor 
        p("replace()-> " + sbTexto.replace(4, 13, "Remplazo"));
        // M�todo delete(int posInicial, int posFinal) elimina el contenido del rango de posiciones indicado
        p("delete()-> " + sbTexto.delete(4, 13));
        // M�todo reverse() invierte el orden de nuestro texto
        p("reverse()-> " + sbTexto.reverse());

        // compareTo(StringBuilder sb2) compara los dos stringbuilder lexicogr�ficamente
        StringBuilder sb = new StringBuilder("Frase uno");
        StringBuilder sb2 = new StringBuilder("hrase uno");
        p("compareTo()-> " + sb.compareTo(sb2));

    }

    // [MODIFICADOR DE ACCESO][TIPO DE DEVOLUCI�N][NOMBRE][()][{ BLOQUE DE
    // INSTRUCCIONES }]
    public void p(String text) { // Podemos sobrecargar un m�todo (tener distintas versiones con el mismo nombre)
        // Instrucciones				
        System.out.println(text);
    }

    public void p(StringBuilder text) {
        // Instrucciones
        System.out.println(text);
    }

//    public void p(CharSequence text){ 
//        System.out.println(text);
//    }
//    public void p(boolean text) { // Para sobrecargar un m�todo tenemos que cambiar el n�mero y/o tipo de parametros que 
//        // Instrucciones				// el m�todo recibe
//        System.out.println(text);
//    }
//
//    public void p(int text) {
//        // Instrucciones
//        System.out.println(text);
//    }
//    
    
}
