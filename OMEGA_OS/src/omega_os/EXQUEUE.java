
package omega_os;

import java.util.*;

public class EXQUEUE<E>{
  
    private ArrayList<E> e;

    public EXQUEUE() {
         e = new ArrayList<>();
        
    } 
    public boolean Is_Queue_Empty()
    {
        return e.isEmpty();
    }
    
    public void Enqueue(E element)
    {
       {
            e.add(element);
        }  
    }
    
    public E Dequeue()
    {   
        if(Is_Queue_Empty())
        {
            System.out.println("The Queue is empty");
            return null;
        }
        else
        {
            E element;
            element= e.remove(0);
            return element;
        }   
        
    }
    
    public void print()
    {
        int i;
        for(i=0;i<e.size();i++)
        {
            System.out.print(e.get(i)+" ");
        }
        System.out.println();
    }
    
    public PROCESS getElement(){
        return  (PROCESS)e.get(0);
    }

}
