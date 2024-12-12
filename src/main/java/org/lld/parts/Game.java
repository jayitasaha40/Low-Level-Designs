package org.lld.parts;

import java.util.Scanner;

public class Game
{
    private Player player1;
    private Player player2;
    private GameBoard gameBoard;
    private Player currentPlayer;

    public Game(Player p1,Player p2, GameBoard gameBoard){
        this.player1 = p1;
        this.player2 = p2;
        this.gameBoard = gameBoard;
        this.currentPlayer = p1;
    }

    public String startGame(){
        System.out.println("========= TIC TAC TOE==========");
        while (!gameBoard.isFull()){
            System.out.println(currentPlayer.getName()+"'s turn.....");
            int inputRow = getValidInput("Enter row: ",gameBoard.getRowSize());
            int inputColumn = getValidInput("Enter Column: ",gameBoard.getColumnSize());
            try {
                gameBoard.addMove(inputRow, inputColumn, currentPlayer.getSymbol());
                gameBoard.printBoard();
                if(gameBoard.isWinner(inputRow,inputColumn,currentPlayer.getSymbol())){
                    return currentPlayer.getName()+" Wins!!!!";
                }
                switchPlayer();
            }
            catch (IllegalArgumentException ex){
                System.out.println(ex);
            }

        }
        return "It's a Tie!!";

    }

    private void switchPlayer(){
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private int getValidInput(String message,int limit){
        Scanner sc = new Scanner(System.in);
        int input;
        while(true){
            System.out.println(message);
            if(sc.hasNextInt()){
                input = sc.nextInt();
                if((input>=0) && (input<limit)) {
                    return input;
                }
                System.out.println("Please enter valid input: ");
                }
            }
        }
    }

