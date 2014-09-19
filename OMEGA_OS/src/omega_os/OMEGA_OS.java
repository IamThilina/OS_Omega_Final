
package omega_os;
import java.util.Scanner;
import java.util.Random;


public class OMEGA_OS {


    public static void main(String[] args) {
       // EXQUEUE<PROCESS> myq = new EXQUEUE();
       // int num=0, val=0;
        int timeSlice =10;
        
       // Scanner newinp = new Scanner(System.in);
       // Integer nn = new Integer(val);
       
        CPU myCPU = new CPU();
        EXQUEUE<PROCESS> ready = new EXQUEUE();
        EXQUEUE<PROCESS> block = new EXQUEUE();
        
        DISPATCHER dispatcher = new DISPATCHER(ready, block);
        dispatcher.startup();
        
        myCPU.getDispatcher(dispatcher);
        //dispatcher.startup();
        myCPU.execution();
        
          /*  Random randomGenerator = new Random();
               ss = 0 + randomGenerator.nextInt(2);
                System.out.println(ss); */
        
       /* System.out.println("==================================");
        System.out.println("1-Enqueue");
        System.out.println("2-Dequwue");
        System.out.println("3-Print queue");
        System.out.println("4-exit");
        
        while(num!=4){
        
        System.out.print("Input menu number>>  ");
        num = newinp.nextInt();
        
        switch(num){
            case 1:
              System.out.print("value>>  ");
                val = newinp.nextInt();
                nn = Integer.valueOf(val);
                myq.Enqueue(nn);
                break;
                
            case 2:
                
                System.out.println(myq.Dequeue());
                break;
                
             case 3:
                 
                myq.Print();
                break;
            
            
            case 4:
                break;
    }
    } */
    }
}
