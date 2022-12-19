package com.temario.m2poo;


public class Externa {
    
    public int k=5;
    public static int f=5;
    
    public void metodoExt(){
        int num = 8;
        //num++;
        class IntMethod{
            int num2 = 8;
            public void metodoIntMethod(){
                num2++;
                k = num;
                f++;
            }
        }
        //num++;
        IntMethod im = new IntMethod();
        im.num2 = 10;
    }
    public static void metodoExtStatic(){
    }
    
    public class Interna{
        public int k=10;
        
        public void metodoInt(){
            Externa ext = new Externa();
            System.out.println(k+" "+this.k+" "+ext.k);
        }
        public class Interna2{
            public class Interna3{
                public class Interna4{
                    
                }
            }
        }
    }
    
    public static class InternaStatic{
        public void metodoStaticInt(){
            System.out.println(new Externa().k+" "+f);
            new Externa().metodoExt();
            metodoExtStatic();
        }   
    }
}
