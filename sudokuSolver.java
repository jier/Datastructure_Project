/*
 *This Class will contain three Objects.
 *These Objects are the representation of the matrix that is the Sudoku.
 *With these objects we will be able to use solve techniques at the Sudoku.
 */
import java.util.*;
import java.lang.*;

public class sudokuSolver extends Matrix {

	private final static int matrixLength = 9;
	private Matrix[] row;
	private Matrix[] column;
	private Matrix[][] region;

	public void run(){
		boolean requested = false;
		while(requested == true){
			if(row.length !=0){
				row();
			}else if (column.length !=0){
				column();
			}else if (region.length !=0){
				region();
			}else{
				row();
				column();
				region();
			}
		}
	}

	public Matrix[] row(){
		int n = 9;
		row = new Matrix[n];
		Matrix[] generatedRow = new Matrix[0];
		for(int i= 0; i<matrixLength;i++){
			row[i]= generatedRow[i];
		}
		return generatedRow;
	}

	public Matrix[] column(){
		int n = 9;
		column = new Matrix[n];
		Matrix[] generatedColumn = new Matrix[0];
		for(int i= 0; i<matrixLength;i++){
			column[i]= generatedColumn[i];
		}
		return generatedColumn;
	}

	public Matrix[][] region(){
		int r = 3;
		region = new Matrix[r][r];
		Matrix[][] generatedRegion= new Matrix[0][0];
		for(int i=0; i<matrixLength;i++){
			for (int j=0; j<matrixLength; j++){
				region[i][j]= generatedRegion[i][j];	
			}
		}
		return generatedRegion;
	}	

}
