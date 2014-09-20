
package omega_os;

public class DISPATCHER {
    
    EXQUEUE readyQueue;
    EXQUEUE blockQueue;
    private PROCESS[] task;
    
    
    public DISPATCHER(EXQUEUE ready, EXQUEUE block){
    
        task = new PROCESS[5];
        task[0] = new PROCESS(1,76);
        task[1] = new PROCESS(2,88);
        task[2] = new PROCESS(3,55);
        task[3] = new PROCESS(4,99);
        task[4] = new PROCESS(5,66);
        this.readyQueue = ready;
        this.blockQueue = block;
       /* task[5] = new PROCESS(1,76);
        task[6] = new PROCESS(1,76);
        task[7] = new PROCESS(1,76);
        task[8] = new PROCESS(1,76);
        task[9] = new PROCESS(1,76);
        task[10] = new PROCESS(1,76);*/
    }
    public void startup(){                              //Enqueue processes to the readyQueue queue
        for(int i=0;i<5;i++){
            readyQueue.Enqueue(task[i]);
        }
       
    }
    

    public PROCESS dequeueReady(){                    //Dequeue Proceess from Ready Queue
        if(!readyQueue.Is_Queue_Empty()){
            return (PROCESS) readyQueue.Dequeue();
        }
        else
            return null;
    }
    
    public void enqueueBlock(PROCESS pro){            //Enqueue Proceess from Block Queue
        blockQueue.Enqueue(pro);
    }
    
    public PROCESS dequeueBlock(){                    //Dequeue Proceess from Block Queue
        if(!blockQueue.Is_Queue_Empty()){
        return (PROCESS) blockQueue.Dequeue();
        }
        else
            return null;
    }
    
    public void enqueueReady(PROCESS pro){            //Enqueue Proceess from Ready Queue
        readyQueue.Enqueue(pro);
    }
}
