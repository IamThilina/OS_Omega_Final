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
public class PROCESS {
    private int pid;                       //Process ID
    private int extime;                    //Process total execution time
    
    public PROCESS(int pid,int extime){    //Process Constructor
    this.pid = pid;
    this.extime = extime;
    }

    public int getExtime() {              
        return extime;
    }

    public int getPid() {        
        return pid;
    }
    
    public void setExtime(int time){
    
        extime=time;
    }

}
