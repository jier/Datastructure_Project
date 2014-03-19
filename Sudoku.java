import java.util.*;
import java.lang.*;
import java.io.*;

public class Sudoku{

	private long start = 0;
	private long end = 0;
	private double totalSudoku = 0;
	private double totalSolved = 0;
	private double successRate = 0;
	static int[] sudokuStringArray = new int[81];
	
	public Sudoku(){
		
	}
	
	public Sudoku(int [][] org){
		
	}
	
	public void processFile(){
		 try {
            BufferedReader file = new BufferedReader(new FileReader("subig20.txt"));
            String str, copy;
            while ((str = file.readLine()) != null) {
                for(int i = 0; i < str.length(); i++)
					{
					char c = str.charAt(i);
				   	int f = Character.digit(c,10); 
				   	sudokuStringArray[i] = f;
				}
				totalSudoku ++;
				solve(sudokuStringArray);						
            }
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


	}
	
	public void benchmark(){
	}
	
	public void solve( int[] sudokoToSolve){
		boolean succesOrFailure = false;
		SudokuSolver solver = new SudokuSolver(sudokoToSolve);
		succesOrFailure = solver.result();
		if(succesOrFailure == true){
			isSolved();
		}else{
			notSolved();
		}
	}
	
	public void isSolved(){
		totalSolved ++; 
		System.out.println("yeah!");
	}

	public void notSolved(){
		System.out.println("too bad");
	}

	public void printResults(){

		successRate = (totalSolved/totalSudoku)*100;
 		successRate = Math.round(successRate * 100.0) / 100.0;

		System.out.println("The program is done, we will now present the results.");
		System.out.println("Total amount of sudoku's that are processed:");
		System.out.println(totalSudoku);
		System.out.println("Total amount of sudoku's that is succesfully solved:");
		System.out.println(totalSolved);
		System.out.println("This result in a succes rate of:");
		System.out.printf("%.2f %%\n", successRate);
		
	}

	public static void main(String[] args) {
		System.out.println("Begin of program");
	    Sudoku sudoku = new Sudoku();
	    sudoku.processFile();
	    sudoku.printResults();
	    //System.out.println(Arrays.toString(sudokuStringArray));
	    
	    
	}
	
	
}