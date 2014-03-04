/* 
*This class is an abstract class that will contains contains common methods 
that will be used in the classes of the previous named objects.
*/
import java.util.*;
import java.lang.*;

public abstract class Matrix{
	
	public abstract void remove(int elem);
	public abstract void getGrid(int elem);
	public abstract void checkSpot(int elem);
	public abstract Matrix[] row();
	public abstract Matrix[] column();
	public abstract Matrix[][] region();
		
	public boolean isStuck(){
		boolean legal = true;
		int [] possibilities = new int[new ArrayList();new ArrayList(); 
		new ArrayList();new ArrayList();new ArrayList(); 
		new ArrayList();];
		int lengthMatrix = 9;
		for(int i = 0;  i< lengthMatrix;i++){
			if(possibilities[i] == possibilities[i+1]){
				legal = false;
			}else if (possibilities[i] == possibilities[i-1]){
				legal = false;
			}else{
				legal = true;
			}
		}
		return legal;
	}
		
	/*public void time(){
	}*/
	
	
	
	
}
