package com.temario.m7concurrency;

import java.time.Duration;
import java.time.Instant;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CyclicBarrier;

@SuppressWarnings({"Convert2Lambda", "SleepWhileInLoop", "CallToPrintStackTrace"})
public class TestConcurrency {

    public static final Instant INICIO = Instant.now();

    public void testConcurrency() {
        Tarea tarea1 = new Tarea("hilo1");
        Thread hilo = new Thread(tarea1);

        Thread hilo2 = new Thread(new Tarea("hilo2"));
        Tarea2 hilo3 = new Tarea2("hilo3");
        Tarea2 hilo4 = new Tarea2("hilo4");

        Thread hilo5 = new Thread(
                new Runnable() {
            @Override

            public void run() {
                for (int i = 0; i < 5; i++) {
                    System.out.println("tarea: hilo5");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread hilo6 = new Thread(() -> {
            System.out.println("Cacahuete");
        });

        hilo.start();
        hilo2.start();
        hilo3.start();
        hilo4.start();
        hilo5.start();
        hilo6.start();
        //tarea1.start(); // Error de compilación, la clase Tarea no dispone del método start()

        var fixed = new ESFixedExample();
        fixed.fixedThreadPool();
        fixed.allFixedThreadPool();

        var singleAwait = new ESSingleAwaitTermination();
        singleAwait.execAwait(1, 2);

        var schedule = new ScheduledExecutorServiceExample();
        schedule.scheduledExec(1, 8);

        var callable = new ExecutorServiceCallable();
        callable.executorCall();

        CyclicBarrier barrier = new CyclicBarrier(4);
        var first = new CyclicBarrierExample(1000, barrier, "Party-1");
        var second = new CyclicBarrierExample(1000, barrier, "Party-2");
        var third = new CyclicBarrierExample(1000, barrier, "Party-3");
        var fourth = new CyclicBarrierExample(1000, barrier, "Party-4");

        first.start();
        second.start();
        third.start();
        fourth.start();
        List<Integer> list = new CopyOnWriteArrayList<>(); // Variante de ArrayList Thread safe
        CyclicBarrier barrier2 = new CyclicBarrier(3, () -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println(list.stream()
                    .mapToInt(n -> n)
                    .sum());
        });

        new Thread(new Lector(barrier, list, "C:\\Prueba\\Textos\\numeros.txt", 3000)).start();
        new Thread(new Lector(barrier, list, "C:\\Prueba\\Textos\\numeros.txt", 2000)).start();
        new Thread(new Lector(barrier, list, "C:\\Prueba\\Textos\\numeros.txt", 1000)).start();

        BuscarPalabra buscarPalabra = new BuscarPalabra("turquesa");
        BuscarPalabra buscarPalabra1 = new BuscarPalabra("verde");
        BuscarPalabra buscarPalabra2 = new BuscarPalabra("azul");
        BuscarPalabra buscarPalabra3 = new BuscarPalabra("rojo");
        BuscarPalabra buscarPalabra4 = new BuscarPalabra("negro");

        var le = new LockExample();
        le.practiceLock();
        var atFixedRate = new AtFixedVSWithFixedExample();
        atFixedRate.atFixedRateExample();
        atFixedRate.withFixedDelayExample();

        System.out.println(Thread.currentThread().getName() + " has finished.");
    }

    public static void Log(Object mensaje) {
        System.out.println(String.format("%s [%s] %s",
                Duration.between(INICIO,
                        Instant.now()),
                Thread.currentThread().getName(),
                mensaje.toString()));
    }
}
