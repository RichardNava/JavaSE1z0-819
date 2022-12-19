package com.temario.m7concurrency;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings({"CallToPrintStackTrace","SleepWhileInLoop"})
public class ESFixedExample {
    // En este ejemplo el método newFixedThreadPool,
    // la sobrecarga de submit que devuelve un resultado y el shutdownNow() que termina la tarea de forma inmediata
    public void fixedThreadPool() {

        Runnable runnableTask = () -> {
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
                System.out.println("Current Time :: " + LocalDateTime.now());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ExecutorService executor = Executors.newFixedThreadPool(10);
        
        executor.execute(runnableTask);
        
        Future<String> result = executor.submit(runnableTask, "DONE");
        
        while(result.isDone()==false) {            
            try {
                System.out.println("The method return value: "+result.get());
                break;
            } catch (InterruptedException | ExecutionException e) {
               e.printStackTrace();
            } 
            try{
                Thread.sleep(1000);
            }
            catch(InterruptedException e){
                e.printStackTrace();
            }
        }
        executor.shutdownNow();
    }
    // En este ejemplo el método newFixedThreadPool, usamos el invokeAll que recibe como parametro una coleccion
    // de tareas (cualquier clase que implemente callable) 
    public void allFixedThreadPool() {
        
        Callable<String> callableTask = () ->{
            TimeUnit.MILLISECONDS.sleep(1000);          
            return "Current time :: " +LocalDateTime.now();
        };
        
        ExecutorService executor = Executors.newFixedThreadPool(1);
        
        List<Callable<String>> tasksList = Arrays.asList(callableTask, callableTask, callableTask);
        
        try {
            List<Future<String>> results = executor.invokeAll(tasksList);
            
            for (Future<String> result : results) {
                System.out.println(result.get());
            }
            
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } 
        
        Future<String> result = executor.submit(callableTask);
        
        while (!result.isDone()) {

            try {
                System.out.println("The method return value : "+result.get());
                break;
            } catch (InterruptedException | ExecutionException ex) {
                Logger.getLogger(ESFixedExample.class.getName()).log(Level.SEVERE, null, ex);
            } 
            try{
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        executor.shutdownNow();
    }

}
