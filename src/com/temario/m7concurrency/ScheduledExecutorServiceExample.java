package com.temario.m7concurrency;



import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduledExecutorServiceExample {

    private static final Logger LOG = Logger.getLogger(ScheduledExecutorServiceExample.class.getName());
    // En este ejemplo estamos utilizando la versi�n agendada de ExecutorService, podemos pasarle un tiempo de retraso
    // delay y nuestro hilo, comenzará una vez transcurrido ese tiempo.
    public void scheduledExec(int sleep, int delay) {
        var scheduledExecutor = Executors.newScheduledThreadPool(2);
        
        @SuppressWarnings("CallToPrintStackTrace")
        Runnable tarea = () -> {
            try {
//                System.out.println("Estoy en el run. Antes del sleep");
                TimeUnit.SECONDS.sleep(5);
//                System.out.println("Estoy saliendo del run");
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            TestConcurrency.Log("Ejecución de tarea");
        };
        scheduledExecutor.schedule(tarea, delay, TimeUnit.SECONDS);
//        scheduledExecutor.scheduleAtFixedRate(tarea, 2, 3, TimeUnit.HOURS);
//        scheduledExecutor.scheduleWithFixedDelay(tarea,2, 3, TimeUnit.SECONDS);
    
        
        TestConcurrency.Log("Antes de esperar 5 segundos");

        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException ex) {
            LOG.log(Level.INFO, "He interrupido la tarea,"
                    + "no puedo esperar más.", ex);
        }

        TestConcurrency.Log("Después de esperar 5 segundos");
        scheduledExecutor.shutdown();

    
    
    }
    

}
