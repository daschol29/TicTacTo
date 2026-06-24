package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;
    private Board board;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
        board = game.getBoard();
    }

    // hasWinner – positive: row win detected
    @Test
    void hasWinner_returnsTrueForRowWin() {
        // Player X fills row 0
        board.place(0, 0, 'X');
        board.place(0, 1, 'X');
        board.place(0, 2, 'X');
        assertTrue(game.hasWinner());
    }

    // hasWinner – positive: column win detected
    @Test
    void hasWinner_returnsTrueForColumnWin() {
        board.place(0, 1, 'X');
        board.place(1, 1, 'X');
        board.place(2, 1, 'X');
        assertTrue(game.hasWinner());
    }

    // hasWinner – positive: diagonal win detected
    @Test
    void hasWinner_returnsTrueForDiagonalWin() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'X');
        board.place(2, 2, 'X');
        assertTrue(game.hasWinner());
    }

    // hasWinner – positive: anti-diagonal win detected
    @Test
    void hasWinner_returnsTrueForAntiDiagonalWin() {
        board.place(0, 2, 'X');
        board.place(1, 1, 'X');
        board.place(2, 0, 'X');
        assertTrue(game.hasWinner());
    }

    // hasWinner – negative: no winner on empty board
    @Test
    void hasWinner_returnsFalseForEmptyBoard() {
        assertFalse(game.hasWinner());
    }

    // hasWinner – negative: mixed markers in a row are not a win
    @Test
    void hasWinner_returnsFalseForMixedRow() {
        board.place(0, 0, 'X');
        board.place(0, 1, 'O');
        board.place(0, 2, 'X');
        assertFalse(game.hasWinner());
    }

    // switchCurrentPlayer – positive: starts with player X
    @Test
    void switchCurrentPlayer_initialPlayerIsX() {
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    // switchCurrentPlayer – positive: switches from X to O
    @Test
    void switchCurrentPlayer_switchesFromXToO() {
        game.switchCurrentPlayer();
        assertEquals('O', game.getCurrentPlayer().getMarker());
    }

    // switchCurrentPlayer – positive: switches back to X after two switches
    @Test
    void switchCurrentPlayer_switchesBackToX() {
        game.switchCurrentPlayer();
        game.switchCurrentPlayer();
        assertEquals('X', game.getCurrentPlayer().getMarker());
    }

    // switchCurrentPlayer – negative: current player is not O before any switch
    @Test
    void switchCurrentPlayer_currentPlayerIsNotOAtStart() {
        assertNotEquals('O', game.getCurrentPlayer().getMarker());
    }
}
