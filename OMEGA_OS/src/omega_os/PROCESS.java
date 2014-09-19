package omega_os;

public class PROCESS {
    private int pid;
    //private String name;
    private int extime; 
    
    public PROCESS(int pid,int extime){
   // this.name = name;
    this.pid = pid;
    this.extime = extime;
    }

    public int getExtime() {
        return extime;
    }

    public void instruction(){
    }
 
    public int getPid() {
        return pid;
    }
    
    public void setExtime(int time){
    
        //time=extime;   // @Pravinda: this should be other way around,nah?
        extime=time;
    }

   /* public String getName() {
        return name;
    }*/

}
