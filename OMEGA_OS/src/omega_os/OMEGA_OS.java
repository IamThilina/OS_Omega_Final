package omega_os;
import java.util.Scanner;
import java.util.Random;

public class OMEGA_OS {

    public static void main(String[] args) {
        int timeSlice =10;                          //Value of the time quantum provided
        
        CPU omegaCPU = new CPU();                   //New CPU object
        EXQUEUE<PROCESS> readyQueue = new EXQUEUE();     //Ready Queue
        EXQUEUE<PROCESS> blockQueue = new EXQUEUE();     //Block Queue
        
        DISPATCHER dispatcher = new DISPATCHER(readyQueue, blockQueue);   //New dispatcher object
        
        omegaCPU.getDispatcher(dispatcher);             //Dispacther reference in CPU
        dispatcher.startup();                        //All processes enqueued to the Ready Queue
        omegaCPU.execution();                           //Execution starts
        
         
    }
}
