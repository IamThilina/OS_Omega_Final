package omega_os;


public class DISPATCHER {
    
    EXQUEUE ready;
    EXQUEUE block;
    private PROCESS[] task;
    /* there is an array of processes in the dispatcher
    *those processes are the user defined processes
    */
    
    public DISPATCHER(EXQUEUE ready, EXQUEUE block){
    
        task = new PROCESS[5];  //@Pravi: this line is corrected by Peniya
        task[0] = new PROCESS(1,76);
        task[1] = new PROCESS(2,88);
        task[2] = new PROCESS(3,55);
        task[3] = new PROCESS(4,99);
        task[4] = new PROCESS(5,66);
        this.ready = ready;
        this.block = block;
       /* 
        task[5] = new PROCESS(1,76);
        task[6] = new PROCESS(1,76);
        task[7] = new PROCESS(1,76);
        task[8] = new PROCESS(1,76);
        task[9] = new PROCESS(1,76);
        task[10] = new PROCESS(1,76);
        
        */
    }
    
    
    /* processes are being loaded to ready queue */
    public void startup(){
        for(int i=0;i<5;i++){
            ready.Enqueue( task[i]);
        }
       
    }
    
    public PROCESS dequeueReady(){
        if(!ready.Is_Queue_Empty()){
            return (PROCESS) ready.Dequeue();
        }
        else
            return null;
    }
    
    public void enqueueBlock(PROCESS pro){
        block.Enqueue(pro);
    }
    
    public PROCESS dequeueBlock(){
        if(!block.Is_Queue_Empty()){
            return (PROCESS) block.Dequeue();
        }
        else
            return null;
    }
    
    public void enqueueReady(PROCESS pro){
        ready.Enqueue(pro);
    }
}
