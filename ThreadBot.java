import kareltherobot.*;

import java.awt.Color;
import java.util.Random;
public class ThreadBot extends Robot implements Directions
{
    static int x;
    static int y;
    static int x1;
    static int y1;
    static int turno;
    int n;
    
    
	public ThreadBot(int avenue, int street, Direction direction, int beepers, Color color,int n)
    	{
        super(avenue, street, direction, beepers,color);   
        this.n=n;
        setCoordinates(street,avenue);
        turno=0;
    	}
    

	public void run()
	{
        Random r = new Random();
        while(true){
            
            int rand = r.nextInt(10); 
            if(turno==n){
                if(rand >4 ){
                    if(frontIsClear() && !crash()){
                        move();
                        moved();
                    }else{
                        turnLeft();
                    }                 
                }else{
                    turnLeft();
                }
                turno = (turno==0)?1:0;
                
            }else{
                while(turno!=n){
                    try{
                    Thread.sleep(1);
                    }catch(InterruptedException ie){}
                }    
            }
        
        }
    }

    public void setCoordinates(int street, int avenue){
        if(n==0){
            y=street;
            x=avenue;
        }else{
            y1=street;
            x1=avenue;
        }   
    }

    public void moved(){
        if(n==0){
            if(facingEast()){
                y--;
            }else if(facingWest()){
                y++;
            }else if(facingSouth()){
                x--;
            }else{
                x++;
            }
        }else{
            if(facingEast()){
                y1--;
            }else if(facingWest()){
                y1++;
            }else if(facingSouth()){
                x1--;
            }else{
                x1++;
            }
        }
    }
    
    public boolean crash(){
        int mx=n==0?x:x1;
        int my=n==0?y:y1;
        int ox=n==0?x1:x;
        int oy=n==0?y1:y;
        if(mx==ox){
            if((facingEast() && my+1==oy) || (facingWest() && my-1==oy) ){              
                return true;
            }
        }else if(my==oy){
            if((facingNorth() && mx+1==ox) || (facingSouth() && mx-1==ox) ){
                return true;
            }
        }
        return false;
    }	
}