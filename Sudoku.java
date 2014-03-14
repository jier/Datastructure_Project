import java.util.*;
import java.lang.*;
import java.io.*;

public class Sudoku{

	long start = 0;
	long end = 0;
	//ArrayList<Integer> list = new ArrayList<Integer>();
	static int[] sudokuStringArray = new int[81];
	
	public Sudoku(){
		
	}
	
	public Sudoku(int [][] org){
		
	}
	
	public void read(){
		 try {
            BufferedReader file = new BufferedReader(new FileReader("single.txt"));
            //start = System.currentTimeMillis();
            String str, copy;
            while ((str = file.readLine()) != null) {
            	//int sudokuStream = Integer.parseInt(src.toString());
  
                for(int i = 0; i < str.length(); i++)
					{
					char c = str.charAt(i);
				   	int f = Character.digit(c,10); 
				   	//System.out.printf("%s\n", c);
				   	//list.add(f);
				   	sudokuStringArray[i] = f;
				}	

				printBoard();			
            }

            ///end = System.currentTimeMillis();
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


	}
	
	public void benchmark(){
	}
	
	public void update (){
	}
	
	public void solve(){
		SudokuSolver solver = new SudokuSolver(sudokuStringArray);

	}
	
	public boolean isSolved(){
		return false;
	}
	 
	public int getCount(){
		return 5 ;
	}
	
	public int getOrg(){
		return 5;
	}
	
	public int getGen(){
		return 5;
	}
	
	public int getTurn(){
		return 5;
	}
	
	public int getStartCount(){
		return 6;
	}

	

	public void printBoard() {
	
		    for (int i = 0; i < sudokuStringArray.length; i++) {
		    	
		        if(i%9==0 && i != 0)
		        	System.out.println("|");
		        if(i%27==0)
		            System.out.println(" -----------------------");
		        if(i%3==0)
		        	System.out.print("| ");
		    	
		    	System.out.print(sudokuStringArray[i]);
		    	System.out.print(' ');
		  	        
		    }
		    System.out.println("|");
		    System.out.println(" -----------------------");

		    System.out.print('\n');
	}
	
	public int[][] printMatrix(){
		 int[][] temp = new int[9][9];
		
		 return temp;
	}
	public int printResults(){

		System.out.println("this is the end");
		//int size = list.size();
		//System.out.println(size);
		return 6;
	}

	public static void main(String[] args) {
		System.out.println("Begin of program");
	    Sudoku sudoku = new Sudoku();
	    sudoku.read();
	    sudoku.solve();
	    //System.out.println(Arrays.toString(sudokuStringArray));
	    
	    
	}
	
	
}