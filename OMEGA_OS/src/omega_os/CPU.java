/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package omega_os;
import java.util.Random;

/**
 *
 * @author Pravinda Perera
 */
public class CPU {
 
   int timeCount=10, num1, time;
   Random randomGenerator = new Random();
   PROCESS process;
   DISPATCHER dis;
   
   public void getDispatcher(DISPATCHER dispatcher){              //Dispatcher reference created 
       this.dis = dispatcher; 
   }
   
    
    public void execution(){ 
    
        while(!dis.ready.Is_Queue_Empty() || !dis.block.Is_Queue_Empty()){  //Is both Ready and Block queues empty 
            timeCount =10;                                   
            if(!dis.ready.Is_Queue_Empty()){                                //Is ready queue empty 
                 process = dis.dequeueReady();
            }
            else{                                                           //If Ready queue is empty dequeue from Block queue 
                process = dis.dequeueBlock();                               
                dis.ready.Enqueue(process);                                 
                process=dis.dequeueReady();
            }
                
        while(timeCount!=0){
         
           num1 = 1 + randomGenerator.nextInt(5);                           //Random number generate to block the process
           
           if(num1==process.getPid()){                                      //Running process blocked
           
               dis.block.Enqueue(process);
               System.out.println("Process"+process.getPid()+"is blocked"+"The time -"+process.getExtime());
               break;
           }
           else{                                                            //If Runiing Process not blocked
               timeCount--;
               time = process.getExtime() - 1;
               process.setExtime(time);
               System.out.println("Process"+process.getPid()+"is running"+"The time -"+process.getExtime());
               if(process.getExtime()==0){
                  System.out.println("The Process"+process.getPid()+"Execution complete!!!!!");
                  break;
               }
           }
         
        }
        if(timeCount==0){                                         //Process ends execution  
           dis.ready.Enqueue(process);
        }
        if(dis.block.Is_Queue_Empty()){                           //Block queue empty
          continue;
        }
        else{
            num1 = 1 + randomGenerator.nextInt(5);                //Random number generate to dequeue from block queue
            if(num1==dis.block.getElement().getPid()){
                process = dis.dequeueBlock();
                dis.ready.Enqueue(process);
            }
            else
                continue;
        }
        
    } 

    
    }
}   
