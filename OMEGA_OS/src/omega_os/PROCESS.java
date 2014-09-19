package omega_os;

public class PROCESS {
    private int PID;            //Process ID
    private int executionTime;  //Process total execution time
    
    private int ioStatus=0;  /* to keep track of the I/O instruction status 
                              * 0 = no I/O instructions to be execute
                              * 1 = I/O instructions in being executed
                              */
    
    public PROCESS(int pid,int executionTime){    //Process Constructor
    this.PID = pid;
    this.executionTime = executionTime;
    }

    public int getExecutionTime() {              
        return executionTime;
    }
    
    public void setExecutionTime(int executionTime){
        this.executionTime=executionTime;
    }
    
    public int getPID() {        
        return PID;
    }
    
    public void setIoStatus(int ioStatus) {
        this.ioStatus = ioStatus;
    }

    public int getIoStatus() {
        return ioStatus;
    }
    

}
