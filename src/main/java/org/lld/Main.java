package org.lld;

import org.lld.parts.Game;
import org.lld.parts.GameBoard;
import org.lld.parts.Player;

public class Main {
    public static void main(String[] args) {

        Player player1 = new Player("Jayita",'X');
        Player player2 = new Player("Sourav",'O');

        GameBoard gameBoard = new GameBoard(3,3);

        Game game = new Game(player1,player2,gameBoard);
        System.out.println(game.startGame());
    }
}