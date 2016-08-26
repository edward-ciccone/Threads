/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author edward
 */
public class Threads {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws InterruptedException {
        // Delay, in milliseconds before interruption (default 1 hour)
        long patience = 1000 * 60 * 60;
        
        // If cmd line arg present, gives patience in seconds
        if (args.length > 0) {
            try {
                patience = Long.parseLong(args[0]) * 1000;
            } catch (NumberFormatException e) {
                System.err.println("Argument must be an integer");
                System.exit(1);
            }
        }
        
        Runnable r1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("Haaaa");
                try {
                    Thread.sleep(2000L);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Threads.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            
        };
        
        Thread t1 = new Thread(r1);
        t1.start();
        
        threadMessage("Starting MessageLoop thread");
    }
    
    static void threadMessage(String message) {
        String threadName = Thread.currentThread().getName();
        int threadCount = Thread.activeCount();
        
        System.out.format("%s: %s%n", threadName, message);
        System.out.format("%s: %s%n", threadName, threadCount);
    }

}
