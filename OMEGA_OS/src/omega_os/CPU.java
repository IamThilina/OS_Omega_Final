package omega_os;
import java.util.Random;

public class CPU {
 
   int timeCount=10; 
   int num1; // I/O interrupt variable
   Random randomGenerator; //random value variable reference
   PROCESS process; //process reference
   DISPATCHER dis;  //dispatcher reference
   
   public void getDispatcher(DISPATCHER dispatcher){
       this.dis = dispatcher; 
   }
   
    
    public void execution(){
    
        while(!dis.ready.Is_Queue_Empty() || !dis.block.Is_Queue_Empty()){
            if(!dis.ready.Is_Queue_Empty()){
                 process = dis.dequeueReady();
            }
            else{
                process = dis.dequeueBlock();
                dis.ready.Enqueue(process);
                process=dis.dequeueReady();
            }
                
        while(timeCount!=0){
         
          // num1 = 1 + ( randomGenerator.nextInt(timeCount+1) );
           num1 = 1 + ( new Random(timeCount+1).nextInt(timeCount+1) );
           if(num1==process.getPid()){
           
               dis.block.Enqueue(process);
               System.out.println("Process"+process.getPid()+"is blocked");
               break;
           }
           else{
               timeCount--;
               process.setExtime(process.getExtime() - 1);
               System.out.println("Process"+process.getPid()+"is running");
           }
         
        }
        if(dis.block.Is_Queue_Empty()){
          continue;
        }
        else{
            num1 = 1 + randomGenerator.nextInt(timeCount+1);
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
