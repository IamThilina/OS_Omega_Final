package omega_os;
/*siri is fucker*/
public class PROCESS {
    private int PID;            //Process ID
    private int numOfInstructions;  //Process total execution time
    /*Note: in our project we are allocating an equal time for all theprocesses 
            to execute an instruction
    */
    
    private int elapsedTime_currentInstruction;
    
    private int ioStatus=0;  /* to keep track of the I/O instruction status 
                              * 0 = no I/O instructions to be execute
                              * 1 = I/O instructions in being executed
                              */
    
    public PROCESS(int pid,int executionTime){    //Process Constructor
    this.PID = pid;
    this.numOfInstructions = executionTime;
    }


    public int getNumOfInstructions() {              
        return numOfInstructions;
    }
    
    public void setNumOfInstructions(int numOfInstructions){
        this.numOfInstructions=numOfInstructions;
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
