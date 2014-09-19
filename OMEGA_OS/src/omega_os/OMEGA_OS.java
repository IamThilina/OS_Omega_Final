/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package omega_os;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Pravinda Perera
 */
public class OMEGA_OS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int timeSlice =10;                          //Value of the time quantum provided
        
       
        CPU myCPU = new CPU();                      //New CPU object
        EXQUEUE<PROCESS> ready = new EXQUEUE();     //Ready Queue
        EXQUEUE<PROCESS> block = new EXQUEUE();     //Block Queue
        
        DISPATCHER dispatcher = new DISPATCHER(ready, block);   //New dispatcher object
        
        myCPU.getDispatcher(dispatcher);             //Dispacther reference in CPU
        dispatcher.startup();                        //All processes enqueued to the Ready Queue
        myCPU.execution();                           //Execution starts
        
         
    }
}
