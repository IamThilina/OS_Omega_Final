package omega_os;
import java.util.Scanner;
import java.util.Random;

public class OMEGA_OS {
    public static long timeQuantum=1;  //timeQuantum of a process in milliseconds
    public static float speedOfTheExecution=0.5f; //this is the time taken to execute one instruction of a process
    
   
    public static void main(String[] args) {
        int timeSlice =10;  //Value of the time quantum provided
        
        /*   how declare the following two variables as public variables   */
        
        int numOfInstructions=50; //this is the variable which is considered as "the execution time" in Kotiya's Project
        
        CPU omegaCPU = new CPU();                   //New CPU object
        EXQUEUE<PROCESS> readyQueue = new EXQUEUE();     //Ready Queue
        EXQUEUE<PROCESS> blockQueue = new EXQUEUE();     //Block Queue
        
        DISPATCHER dispatcher = new DISPATCHER(readyQueue, blockQueue);   //New dispatcher object
        
        omegaCPU.getDispatcher(dispatcher);             //Dispacther reference in CPU
        dispatcher.startup();                        //All processes enqueued to the Ready Queue
        omegaCPU.execution();                           //Execution starts
        
         
    }
}
