/***************************************
 * SudokuBoard.java
 * 
 * @author wagnern17, milovic
 * @version 9/13/2016
 * @description Generates a Sudoku board that can then be changed to create new boards.
 * 				Generates through a hardcoded base board which then switches it's rows
 * 				and cols randomly, creating a completely new (valid) Sudoku board. 
 * 				
 *
 */

public class SudokuBoard {
	
	public static void main(String[] args) {
		
		int[][] board = new int[9][9]; //inits 9x9 board
		board[1][1] = 5; //nums for 2nd row
		board[1][2] = 6;
		board[1][3] = 7;
		board[1][4] = 8;
		board[1][5] = 9;
		board[1][6] = 1;
		board[1][7] = 2;
		board[1][8] = 3;
		board[1][0] = 4;
		board[2][1] = 2; //nums for 3rd row
		board[2][2] = 3;
		board[2][3] = 4;
		board[2][4] = 5;
		board[2][5] = 6;
		board[2][6] = 7;
		board[2][7] = 8;
		board[2][8] = 9;
		board[2][0] = 1;
		board[3][1] = 4; //nums for 4th row
		board[3][2] = 5;
		board[3][3] = 6;
		board[3][4] = 7;
		board[3][5] = 8;
		board[3][6] = 9;
		board[3][7] = 1;
		board[3][8] = 2;
		board[3][0] = 3;
		board[4][1] = 7; //nums for 5th row
		board[4][2] = 8;
		board[4][3] = 9;
		board[4][4] = 1;
		board[4][5] = 2;
		board[4][6] = 3;
		board[4][7] = 4;
		board[4][8] = 5;
		board[4][0] = 6;
		board[5][1] = 1; //nums for 6th row
		board[5][2] = 2;
		board[5][3] = 3;
		board[5][4] = 4;
		board[5][5] = 5;
		board[5][6] = 6;
		board[5][7] = 7;
		board[5][8] = 8;
		board[5][0] = 9;
		board[6][1] = 3; //nums for 7th row
		board[6][2] = 4;
		board[6][3] = 5;
		board[6][4] = 6;
		board[6][5] = 7;
		board[6][6] = 8;
		board[6][7] = 9;
		board[6][8] = 1;
		board[6][0] = 2;
		board[7][1] = 6; //nums for 8th row
		board[7][2] = 7;
		board[7][3] = 8;
		board[7][4] = 9;
		board[7][5] = 1;
		board[7][6] = 2;
		board[7][7] = 3;
		board[7][8] = 4;
		board[7][0] = 5;
		board[8][1] = 9; //nums for 9th row
		board[8][2] = 1;
		board[8][3] = 2;
		board[8][4] = 3;
		board[8][5] = 4;
		board[8][6] = 5;
		board[8][7] = 6;
		board[8][8] = 7;
		board[8][0] = 8;
		board[0][1] = 8; //nums for 1st row
		board[0][2] = 9;
		board[0][3] = 1;
		board[0][4] = 2;
		board[0][5] = 3;
		board[0][6] = 4;
		board[0][7] = 5;
		board[0][8] = 6;
		board[0][0] = 7;
		
		int[][] randBoard = new int[9][9];
		randBoard = newBoard(board);
		
		for(int i = 0; i<9; i++){
			for(int j = 0; j<9; j++){
				System.out.println(randBoard[i][j]);
			}
		}
	}
	
	
	/****
	 * rowCheck:
	 * 			checks for conflicts in a row
	 * @param tester
	 * @param row
	 * @return boolean, true if not conflicts
	 */
	public boolean rowCheck(int tester, int[] row){
		if (tester > 9 || tester < 1){ //error checking
			return false;
		}
		if (row.length < 1){ //if no nums in the row
			return true;
		}
		for(int i=0; i<row.length; i++){ //iterate over every num in the row
			if(row[i]==tester){ //if the test num is in the row already
				return false;
			}
		}
		return true;
	}
	
	
	/****
	 * colCheck:
	 * 			checks for conflicts in a col
	 * @param tester
	 * @param col
	 * @return boolean, true if no conflicts
	 */
	public boolean colCheck(int tester, int[] col){
		if (tester > 9 || tester < 1){ //error checking
			return false;
		}
		if (col.length < 1){ //if no nums in the col
			return true;
		}
		for(int i=0; i<col.length; i++){ //iterate over every num in the col
			if(col[i]==tester){ //if the test num is in the col already
				return false;
			}
		}
		return true;
	}
	
	
	/*****
	 * newBoard:
	 * 			generates a new (random) board
	 * @param originalBoard
	 * @return int[][], a new board
	 */
	public static int[][] newBoard(int[][] originalBoard ){
		//creates a board of all zero's for error output
		int[][] fill = new int[9][9];
		for(int i = 0; i<9; i++){
			for(int j = 0; j<0; j++){
				fill[i][j]=0;
			}
		}
		
		//loop to prove originalBoards existence as a 9x9 matrix
		for(int i = 0; i>9; i++){
			for(int j = 0; j>9; j++){
				try{
					if(originalBoard[i][j] != -1){} //there will never by a -1 entry, checks existence
				} catch(Exception e) { //if originalBoard get's out of bounds, go to the catch
					System.out.println("-----ERROR------");
					return fill; //if originalBoard isn't 9x9, output a board of zero's
				}
			}
		}
		
		//randomize the rows
		int rowSwitches = randGen(1,3); //generates a random int from 1-3
		for(int i = 0; i<rowSwitches; i++){ //switches rows in the 1st 3 rows
			int[] temp;
			int row1 = randGen(0,2); //0-2 due to array indexing
			int row2 = randGen(0,2);
			
			if(row1 == row2){} else { //if row1 != row2, switch them
				temp = originalBoard[row1];
				originalBoard[row1] = originalBoard[row2];
				originalBoard[row2] = temp;
			}
		}
		
		for(int i = 0; i<rowSwitches; i++){ //switches rows in the 2nd 3 rows
			int[] temp;
			int row1 = randGen(3,5); //3-5 due to array indexing
			int row2 = randGen(3,5);
			
			if(row1 == row2){} else { //if row1 != row2, switch them
				temp = originalBoard[row1];
				originalBoard[row1] = originalBoard[row2];
				originalBoard[row2] = temp;
			}
		}
		
		for(int i = 0; i<rowSwitches; i++){ //switches rows in the last 3 rows
			int[] temp;
			int row1 = randGen(6,8); //6-8 due to array indexing
			int row2 = randGen(6,8);
			
			if(row1 == row2){} else { //if row1 != row2, switch them
				temp = originalBoard[row1];
				originalBoard[row1] = originalBoard[row2];
				originalBoard[row2] = temp;
			}
		}
		
		//randomize the columns
		int colSwitches = randGen(1,3); //random num 1-3
		for(int i = 0; i<colSwitches; i++){ //switches cols in the 1st 3 cols
			int temp[] = new int[9]; //9 = len of cols
			int col1 = randGen(0,2); //0-2 for array indexing
			int col2 = randGen(0,2);
			
			if(col1 == col2){} else { //if col1 != col2, switch them
				for(int j = 0; j<9; j++){
					temp[j] = originalBoard[j][col1];
					originalBoard[j][col1]=originalBoard[j][col2];
					originalBoard[j][col2] = temp[j];
				}
			}
		}
		
		for(int i = 0; i<colSwitches; i++){ //switches cols in the 2nd 3 cols
			int[] temp = new int[9]; //9 = len of cols
			int col1 = randGen(3,5); //3-5 for array indexing
			int col2 = randGen(3,5);
			
			if(col1 == col2){} else { //if col1 != col2, switch them
				for(int j = 0; j<9; j++){
					temp[j] = originalBoard[j][col1];
					originalBoard[j][col1]=originalBoard[j][col2];
					originalBoard[j][col2]=temp[j];
				}
			}
		}
		
		for(int i = 0; i<colSwitches; i++){ //switches cols in the last 3 cols
			int[] temp = new int[9]; //9 = len of cols
			int col1 = randGen(6,8); //6-8 for array indexing
			int col2 = randGen(6,8);
			
			if(col1 == col2){} else { //if col1 != col2, switch them
				for(int j = 0; j<9; j++){
					temp[j] = originalBoard[j][col1];
					originalBoard[j][col1]=originalBoard[j][col2];
					originalBoard[j][col2]= temp[j];
				}
			}
		}
		return originalBoard;
	}
	
	
	/*****
	 * randGen
	 * 			generates a random number in the range [Min, Max]
	 * @param Min
	 * @param Max
	 * @return int, the random num
	 */
	public static int randGen(int Min, int Max){
		int randNum = Min + (int)(Math.random() * ((Max - Min) + 1)); //algorithm ensures inclusivity of the range
		return randNum;
	}
}
