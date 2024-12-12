package org.lld.parts;

public class GameBoard
{
    private char[][] board;
    private int rowSize;
    private int columnSize;
    private int movesCount;

    public GameBoard(int rowSize,int columnSize){
        this.rowSize =  rowSize;
        this.columnSize = columnSize;
        board = new char[rowSize][columnSize];
        initializeBoard();

    }
    public int getRowSize(){
        return rowSize;
    }
    public int getColumnSize(){
        return columnSize;
    }

    private void initializeBoard(){
        for(int i = 0;i<rowSize;i++){
            for(int j = 0;j<columnSize;j++){
                board[i][j] = '-';
            }
        }
        movesCount = 0;
    }

    public void addMove(int row,int col,char symbol){
       if( (row>=0) && (row<rowSize) && (col>=0) && (col<columnSize) && (board[row][col] == '-')){
           board[row][col] = symbol;
           movesCount ++;
       }
       else {
        throw new IllegalArgumentException("Invalid move!");
       }
    }

    public  boolean  isFull(){
        return movesCount == 9;
    }

    public void printBoard(){
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < columnSize; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean isWinner(int row,int col,char symbol){
        boolean rowFill = true;
        boolean colFill = true;
        boolean diagonalFill = true;
        boolean antiDiagonalFill = true;

        //Row wise check
        for(int i = 0;i<columnSize;i++){
            if(board[row][i] != symbol){
                rowFill = false;
            }
        }

        //column wise check
        for(int i = 0;i<rowSize;i++){
            if(board[i][col] != symbol){
                colFill = false;
            }
        }

        //diagonal check
        for(int i = 0,j=0;(i<rowSize) && (j<columnSize);i++,j++){
            if(board[i][j] != symbol){
                diagonalFill = false;
            }
        }

        //Anti - diagonal check
        for(int i = 0,j=columnSize-1;(i<rowSize) && (j>=0);i++,j--){
            if(board[i][j] != symbol){
                antiDiagonalFill = false;
            }
        }
        return rowFill || colFill || diagonalFill || antiDiagonalFill;


    }
}
