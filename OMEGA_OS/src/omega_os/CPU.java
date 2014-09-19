package omega_os;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class CPU {//extends TimerTask {
 
   int timeCount=10; 
   int num1;
   int time;
   Timer timer= new Timer();
   Random randomVal = new Random();
   PROCESS currentProcess;
   DISPATCHER dis;
   
   public void getDispatcher(DISPATCHER dispatcher){   //Dispatcher reference created 
       this.dis = dispatcher; 
   }
   
    
    public void execution(){ 
    
        while(!dis.readyQueue.Is_Queue_Empty() || !dis.blockQueue.Is_Queue_Empty()){  //Is both Ready and Block queues empty 
            timeCount =10;                                   
            if(!dis.readyQueue.Is_Queue_Empty()){   //Is readyQueue queue empty 
                 currentProcess = dis.dequeueReady();
            }
            else{                              //If Ready queue is empty then dequeue from Block queue 
                currentProcess = dis.dequeueBlock();                               
                dis.readyQueue.Enqueue(currentProcess);                                 
                currentProcess=dis.dequeueReady();
            }
                
        while(timeCount!=0){
         
           num1 = 1 + randomVal.nextInt(5);     //Random number generate to blockQueue the currentProcess
           
           if(num1==currentProcess.getPID()){          //Running currentProcess blocked
           
               dis.blockQueue.Enqueue(currentProcess);
               System.out.println("Process"+currentProcess.getPID()+"is blocked"+"The time -"+currentProcess.getExecutionTime());
               break;
           }
           else{                                                            //If Runiing Process not blocked
               timeCount--;
               time = currentProcess.getExecutionTime() - 1;
               currentProcess.setExecutionTime(time);
               System.out.println("Process"+currentProcess.getPID()+"is running"+"The time -"+currentProcess.getExecutionTime());
               if(currentProcess.getExecutionTime()==0){
                  System.out.println("The Process"+currentProcess.getPID()+"Execution complete!!!!!");
                  break;
               }
           }
         
        }
        if(timeCount==0){                                         //Process ends execution  
           dis.readyQueue.Enqueue(currentProcess);
        }
        if(dis.blockQueue.Is_Queue_Empty()){                           //Block queue empty
          continue;
        }
        else{
            num1 = 1 + randomVal.nextInt(5);                //Random number generate to dequeue from blockQueue queue
            if(num1==dis.blockQueue.getElement().getPID()){
                currentProcess = dis.dequeueBlock();
                dis.readyQueue.Enqueue(currentProcess);
            }
            else
                ;//continue;
        }
        
    } 

    
    }
}   
