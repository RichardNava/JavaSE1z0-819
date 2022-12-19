package com.temario.m1datatypes;

public class DatosPrimitivos {
    //int 4num = 10; //Error de compilaci�n los nombres no pueden empezar con n�meros
    //var var = 5; //Este identificador es legal, pero no es una buena pr�ctica

    //Estructura de un m�todo
    //[modificador de acceso][tipo de retorno][indentificador][(argumentos si los hubiera)][{}]
    public void showMaxValuesPrimitives(int factor) {

        //Datos primitivos n�mericos enteros de menor a mayor
        byte numByte = Byte.MAX_VALUE; //Autounboxing
        short numShort = Short.MAX_VALUE;
        int numInt = Integer.MAX_VALUE;
        long numLong = Long.MAX_VALUE + factor; // se pone 'L' al final del n�mero que asignemos para diferenciarlo de int

        //Datos primitivos n�mericos con punto flotante (decimales) de menor a mayor
        float numFloat = Float.MAX_VALUE; // se pone 'f' o 'F' al final del n�mero que asignemos para diferenciarlo de double
        double numDouble = Double.MAX_VALUE;

        System.out.println("N�mero m�ximo byte= " + numByte
                + "\nN�mero m�ximo short= " + numShort
                + "\nN�mero m�ximo int= " + numInt
                + "\nN�mero m�ximo long=" + numLong
                + "\nN�mero m�ximo float=" + String.format("%.2f", numFloat)
                + "\nN�mero m�ximo double=" + String.format("%.2f", numDouble));
    }

    public void showPracticesDP() {
        //Pr�cticas
        long numLong = 9_223_372_036_854_775_807L;
        numLong = (long) 56.5f;
        float numFloat = 9f;
        int numInt = 2;
        float result = (int) numFloat / numInt; // 4.0
        System.out.println(result);
        System.out.print(1 + 2 + " ");
        System.out.println("" + (1 + 2));
        byte numB = 1;
        numInt = numB;

        //Datos primitivos no n�mericos
        char caracter = 'C'; //Character -> Clase Wrapper (Clase Envoltorio)
        caracter = 65;
        caracter++; // caracter
        caracter = (char) 127;
        caracter = '\u0041';
        System.out.println(caracter);

        boolean condicional = true;
        condicional = numInt == numFloat;
        System.out.println(condicional);

        String numeroEnTexto = String.valueOf(numLong);
        String numeroEnTexto2 = "" + numLong;
    }

    // Sobrecarga de un m�todo. El requesito es que cambiemos los argumentos en su tipo y/o cantidad
    public int sumar(int num1, int num2) {
        //Palabra reservada que se usa para devolver un tipo de dato 
        return num1 + num2 + 10;
    }

    public int sumar(Integer num1, Integer num2) {
        //Palabra reservada que se usa para devolver un tipo de dato 
        return num1 + num2 + 100;
    }

    public int sumar(long num1, long num2) {
        //Palabra reservada que se usa para devolver un tipo de dato 
        return (int) (num1 + num2 + 1000);
    }

    public int sumar(Long num1, Long num2) {
        //Palabra reservada que se usa para devolver un tipo de dato 
        return (int) (num1 + num2 + 10_000);
    }

    public char charEnMinusculas(char charCase) {
        if (Character.isLetter(charCase) && Character.isUpperCase(charCase)) {
            return (char) (charCase + 32);
        }

//        if(charCase>=65 && charCase<=90){
//           return (char) (charCase + 32);
//        }
        return charCase;

    }

    // (CONDICIONAL) ? BLOQUE_IF : BLOQUE_ELSE
    public char charEnMinusculas(int charCase) {
        return (char) (Character.isUpperCase(charCase) ? (charCase + 32) : charCase);
    }

    public void showPrimitiveData() {
        // Tipos de datos primitivos:
        // Datos n�mericos enteros
        //[tipo] [nombre] [=] [valor]  ;
        byte numByteMax = 127; // Esto es el dato n�mero entero m�s peque�o basado en 8 bits...
        byte numByteMin = -128;
        p("Byte", numByteMax, numByteMin);
        short numShortMax = 32767;
        short numShortMin = -32768;
        p("Short", numShortMax, numShortMin);
        int numIntMax = Integer.MAX_VALUE; // Class Wrapped - Unboxed/boxed
        int numIntMin = Integer.MIN_VALUE;
        p("Integer", numIntMax, numIntMin);
        long numLongMax = Long.MAX_VALUE;
        long numLongMin = Long.MIN_VALUE;
        p("Long", numLongMax, numLongMin);

        // N�mero decimales
        float numFloatMax = Float.MAX_VALUE;
        float numFloatMin = Float.MIN_VALUE;
        p("Float", numFloatMax, numFloatMin);
        double numDoubleMax = Double.MAX_VALUE;
        double numDoubleMin = Double.MIN_VALUE;
        p("Double", numDoubleMax, numDoubleMin);

        // Boolean - tipo de dato pensado para expresiones condicionales. Basado en un bit (true,false)
        int age = 24;
        boolean isAdult = false;
        isAdult = age >= 18;
        System.out.println(isAdult);

        // Char 
        char letter = 'D';
        letter += 32;
        System.out.println(letter);

        // String
        String text = "�Que la fuerza te acompa�e!";
        text = text.toLowerCase();
        System.out.println(text.toUpperCase());

        // Conversi�n tipos de dato
        // Parse
        String volume = "15"; // 15
        var volumeInt = Byte.parseByte(volume);
        String numberText = String.valueOf(25); // "25"

        System.out.println(numberText + 10);
        // Cast
        int n1 = 10;
        byte n2 = (byte) n1;
        double decimal = 33.98;
        float nf = n1;
        int n3 = (int) nf;
        System.out.println((long) decimal);
    }
// Datos primitivos
    // Declaraci�n e inicializaci�n de variables sintaxis:
    //[tipo][identificador][=][valor][;]
    // Restricciones en los nombres de variables
//        byte @nombreVariable; // Error de compilaci�n no admite caracteres especiales salvo; monedas y _
//        byte 1nombreVariable; // No podemos poner n�mero por delante del nombre
//        byte nombre variable; // No podemos separar el nombre (Usaremos camel case por convenci�n)
    //NUMEROS ENTEROS
    //M�todo o funci�n es un elemento del lenguaje de programaci�n en el encapsulas l�gica para su reutilizaci�n
    //[modificador de acceso][tipo de devoluci�n][nombre][(parametros)][{ Bloque de instrucciones}]

    public void showByteMaxMinValues() {
        //byte -> n�mero entero que almacena comprendidos en un byte
        byte maxByte = 127, minByte = -128;
        print(maxByte, minByte);
    }

    public void showShortMaxMinValues() {
        //short -> REPRESENTA UN TIPO DE DATO DE 16 BITS CON SIGNO.DE ESTA MANERA ALMACENA VALORES NUM�RICOS DE -32.768 A 32.767
        short maxShort = 32767, minShort = -32768;
        print(maxShort, minShort);
    }

    public void showIntMaxMinValues() {
        //int -> ES UN TIPO DE DATO DE 32 BITS CON SIGNO PARA ALMACENAR VALORES NUM�RICOS. CUYO VALOR M�NIMO ES -2 Y EL VALOR M�XIMO 2 -1.
        int maxInt = Integer.MAX_VALUE, minInt = Integer.MIN_VALUE; // Clases Wrapped (Envoltorio)
        //Integer in = 200; // Autoboxing - boxed
//        Integer in2 = new Integer(200); // Instancia normal 
//        Integer in3 = Integer.valueOf(12); // M�todo factoria
//        int n = new Integer(19); // Unboxing - unboxed
//        n = in;
//        in++; // Integer -> Unboxing -> int -> + 1 -> Autoboxing -> Integer 
        print(maxInt, minInt);
    }

    public void showLongMaxMinValues() {
        //long -> ES UN TIPO DE DATO DE 64 BITS CON SIGNO QUE ALMACENA VALORES NUM�RICOS ENTRE -2 A 2 -1
        long maxLong = Long.MAX_VALUE, minLong = Long.MIN_VALUE;
        print("long", maxLong, minLong);
    }

    // DECIMALES (PUNTO FLOTANTE)
    public void showFloatMaxMinValues() {
        //float -> ES UN TIPO DATO PARA ALMACENAR N�MEROS EN COMA FLOTANTE CON PRECISI�N SIMPLE DE 32 BITS.
        float maxFloat = Float.MAX_VALUE, minFloat = Float.MIN_VALUE;
        //float numFloat = 2.2f; // int -> float // Es necesario poner la f al final del n�mero porque por defecto el compilador entiende el n�mero como un double
        //System.out.println(numFloat);
        print("float", maxFloat, minFloat);
    }

    public void showDoubleMaxMinValues() {
        //double -> ES UN TIPO DE DATO PARA ALMACENAR N�MEROS EN COMA FLOTANTE CON DOBLE PRECISI�N DE 64 BITS.
        double maxDouble = Double.MAX_VALUE, minDouble = Double.MIN_VALUE;
        print("double", maxDouble, minDouble);
    }

    public void print(String type, byte val1, byte val2, int rep) {
        System.out.println(type + ":\n\tN�mero m�ximo del " + type + ": " + val1
                + "\n\tN�mero minimo del " + type + ": " + val2);
        System.out.println("-".repeat(rep));
    }

    // Sobrecarga de m�todos (Overload): Regla -> tiene que tener distinto tipo y/o n�mero de par�metros     
//    public void print(String type, short val1, short val2) {
//        System.out.println(type + ":\n\tN�mero m�ximo del " + type + ": " + val1
//                + "\n\tN�mero minimo del " + type + ": " + val2);
//        System.out.println("-".repeat(40));
//    }
//
//    public void print(String type, int val1, int val2) {
//        System.out.println(type + ":\n\tN�mero m�ximo del " + type + ": " + val1
//                + "\n\tN�mero minimo del " + type + ": " + val2);
//        System.out.println("-".repeat(40));
//    }
//
//    public void print(String type, long val1, long val2) {
//        System.out.println(type + ":\n\tN�mero m�ximo del " + type + ": " + val1
//                + "\n\tN�mero minimo del " + type + ": " + val2);
//        System.out.println("-".repeat(40));
//    }
//
//    public void print(String type, float val1, float val2) {
//        System.out.println(type + ":\n\tN�mero m�ximo del " + type + ": " + val1
//                + "\n\tN�mero minimo del " + type + ": " + val2);
//        System.out.println("-".repeat(40));
//    }
//
//    public void print(String type, Double val1, double val2) {
//        System.out.println(type + ":\n\tN�mero m�ximo del " + type + ": " + val1
//                + "\n\tN�mero minimo del " + type + ": " + val2);
//        System.out.println("-".repeat(40));
//    }
    public void print(String type, Number val1, Number val2) {
        System.out.println(type + ":\n\tN�mero m�ximo del " + type + ": " + val1
                + "\n\tN�mero minimo del " + type + ": " + val2);
        System.out.println("-".repeat(40));
    }

    public void print(Number val1, Number val2) {
        String name = val1.getClass().getSimpleName();
        System.out.println(name + ":\n\tN�mero m�ximo del " + name + ": " + val1
                + "\n\tN�mero minimo del " + name + ": " + val2);
        System.out.println("-".repeat(40));
    }

    public static void p(String type, Number var1, Number var2) {
        System.out.println(type + ":\n\tN�mero m�ximo " + var1
                + "\n\tN�mero m�nimo " + var2);
    }
}
