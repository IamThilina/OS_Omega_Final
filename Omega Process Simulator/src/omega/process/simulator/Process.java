
package omega.process.simulator;

public class Process {
    private int PID;    //process ID
    private String name;    //name of the process
    private int duration;   //user define process execution time
    
    public Process(int PID,String name, int duration){
        this.PID=PID;
        this.name=name;
        this.duration=duration;
    }
    
    public void instruction(){ //the instructions of the process to execute
        
    }
    
    public int getPID(){
        return PID;
    }
    
    public String getName(){
        return name;
    }
    
    public int getDuration(){
        return duration;
    }
}
