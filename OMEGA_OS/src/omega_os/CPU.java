package omega_os;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

//long start = System.currentTimeMillis();
//long end = start + 60*1000; // 60 seconds * 1000 ms/sec
//while (System.currentTimeMillis() < end)
//{
//    // run
//}

public class CPU extends TimerTask {
 
   int instructionCount=10; 
   int num1; //the number which will be needed to generate I/O interrupt 
   int time;
   Timer timer= new Timer();
   Random randomVal = new Random();
   PROCESS currentProcess;
   DISPATCHER dis;
   
   public void getDispatcher(DISPATCHER dispatcher){   //Dispatcher reference created 
       this.dis = dispatcher; 
   }
   
//    long start =System.currentTimeMillis();
//    long end= start + instructionCount*1000; 
    
   public void execution(){
       try {
           
           timer.schedule(this,0, OMEGA_OS.timeQuantum * 1000);
       }catch (NullPointerException e) {
       
       }
   } 
   
   
   @Override
   public void run() throws NullPointerException{

   //public void execution(){ 
    
        while(!dis.readyQueue.Is_Queue_Empty() || !dis.blockQueue.Is_Queue_Empty()){  //Is both Ready and Block queues empty 
            //instructionCount =10;  //@Pravi: this won't be needed, as we are assigning a value 
                                     //to this variable after 3 lines from this point :)
            if(!dis.readyQueue.Is_Queue_Empty()){   //Is readyQueue queue empty 
                 currentProcess = dis.dequeueReady();
                 instructionCount =currentProcess.getNumOfInstructions();
            }
            else{                              //If Ready queue is empty then dequeue from Block queue 
                currentProcess = dis.dequeueBlock();                               
                dis.readyQueue.Enqueue(currentProcess);                                 
                currentProcess=dis.dequeueReady();
                instructionCount =currentProcess.getNumOfInstructions();
            }
                
//        while(instructionCount!=0){
          
          while(currentProcess.getNumOfInstructions()!=0){  
         //while(true){
//              long startTime = System.currentTimeMillis();
//              long endTime = startTime + OMEGA_OS.timeQuantum*1000; // eg: 60 seconds * 1000 ms/sec
//              //while (System.currentTimeMillis() < endTime/OMEGA_OS.speedOfTheExecution){
//              while (System.currentTimeMillis() < endTime){
                num1 = 1 + randomVal.nextInt(5);     //Random number generate to blockQueue the currentProcess
           
                if(num1==currentProcess.getPID()){          //Running currentProcess blocked
           
                    dis.blockQueue.Enqueue(currentProcess);
                    System.out.println("Process "+currentProcess.getPID()+" is blocked"+" The time - "+currentProcess.getNumOfInstructions());
                    break;
                }
                else{                                                            //If Runiing Process not blocked
               //instructionCount--;
               //time = currentProcess.getNumOfInstructions() - 1;
               //currentProcess.setNumOfInstructions(time);
//                long startTime = System.currentTimeMillis();
//                long endTime = start + OMEGA_OS.timeQuantum*1000; // eg: 60 seconds * 1000 ms/sec
//                while (System.currentTimeMillis() < end/OMEGA_OS.speedOfTheExecution){
                    currentProcess.setNumOfInstructions(currentProcess.getNumOfInstructions() - 1); //@Pravi: removed "time" variable
                    System.out.println("Process "+currentProcess.getPID()+" is running"+" The time - "+currentProcess.getNumOfInstructions());
                    if(currentProcess.getNumOfInstructions()==0){
                        System.out.println("The Process "+currentProcess.getPID()+" Execution complete!!!!!");
                        break;
                    }
                
                }
              
         
            }
          
        
          
          
          
        if(instructionCount==0){                                         //Process ends execution  
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
                continue;
        }
        
    } 

    
    }
}   
