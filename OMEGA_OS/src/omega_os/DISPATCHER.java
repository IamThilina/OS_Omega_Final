/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package omega_os;

/**
 *
 * @author Pravinda Perera
 */
public class DISPATCHER {
    
    EXQUEUE ready;
    EXQUEUE block;
    private PROCESS[] task;
    
    
    public DISPATCHER(EXQUEUE ready, EXQUEUE block){
    
        task = new PROCESS[5];
        task[0] = new PROCESS(1,76);
        task[1] = new PROCESS(2,88);
        task[2] = new PROCESS(3,55);
        task[3] = new PROCESS(4,99);
        task[4] = new PROCESS(5,66);
        this.ready = ready;
        this.block = block;
       /* task[5] = new PROCESS(1,76);
        task[6] = new PROCESS(1,76);
        task[7] = new PROCESS(1,76);
        task[8] = new PROCESS(1,76);
        task[9] = new PROCESS(1,76);
        task[10] = new PROCESS(1,76);*/
    }
    public void startup(){                              //Enqueue processes to the ready queue
        for(int i=0;i<5;i++){
            ready.Enqueue(task[i]);
        }
       
    }
    
    /**
     *
     * @return
     */
    public PROCESS dequeueReady(){                    //Dequeue Proceess from Ready Queue
        if(!ready.Is_Queue_Empty()){
        return (PROCESS) ready.Dequeue();
        }
        else
            return null;
    }
    
    public void enqueueBlock(PROCESS pro){            //Enqueue Proceess from Block Queue
        block.Enqueue(pro);
    }
    
    public PROCESS dequeueBlock(){                    //Dequeue Proceess from Block Queue
        if(!block.Is_Queue_Empty()){
        return (PROCESS) block.Dequeue();
        }
        else
            return null;
    }
    
    public void enqueueReady(PROCESS pro){            //Enqueue Proceess from Ready Queue
        ready.Enqueue(pro);
    }
}
