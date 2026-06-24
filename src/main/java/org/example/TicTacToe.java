package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {

        player1 = new Player('X');
        player2 = new Player('O');

        currentPlayer = player1;

        board = new Board();
    }

    public void start() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Willkommen bei TicTacToe ===");

        while (true) {

            board.print();

            System.out.println(
                    "Spieler "
                            + currentPlayer.getMarker()
                            + " ist am Zug.");

            int x;
            int y;

            while (true) {

                try {

                    System.out.print("Zeile eingeben (0-2): ");
                    x = scanner.nextInt();

                    System.out.print("Spalte eingeben (0-2): ");
                    y = scanner.nextInt();

                    if (x < 0 || x > 2 || y < 0 || y > 2) {
                        System.out.println("Bitte nur Werte von 0 bis 2 eingeben.");
                        continue;
                    }

                    if (!board.isCellEmpty(x, y)) {
                        System.out.println("Dieses Feld ist bereits belegt.");
                        continue;
                    }

                    break;

                } catch (InputMismatchException e) {

                    System.out.println("Bitte nur ganze Zahlen eingeben.");
                    scanner.nextLine();
                }
            }

            board.place(x, y, currentPlayer.getMarker());

            if (hasWinner()) {

                board.print();

                System.out.println(
                        "Spieler "
                                + currentPlayer.getMarker()
                                + " hat gewonnen!");

                break;
            }

            if (board.isFull()) {

                board.print();

                System.out.println("Unentschieden!");

                break;
            }

            switchCurrentPlayer();
        }

        scanner.close();
    }

    private void switchCurrentPlayer() {

        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    private boolean hasWinner() {

        char m = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {

            if (board.getCell(i, 0) == m
                    && board.getCell(i, 1) == m
                    && board.getCell(i, 2) == m) {
                return true;
            }
        }

        for (int j = 0; j < 3; j++) {

            if (board.getCell(0, j) == m
                    && board.getCell(1, j) == m
                    && board.getCell(2, j) == m) {
                return true;
            }
        }

        if (board.getCell(0, 0) == m
                && board.getCell(1, 1) == m
                && board.getCell(2, 2) == m) {
            return true;
        }

        if (board.getCell(0, 2) == m
                && board.getCell(1, 1) == m
                && board.getCell(2, 0) == m) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        TicTacToe game = new TicTacToe();
        game.start();
    }
}