package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    // isCellEmpty – positive: fresh cell is empty
    @Test
    void isCellEmpty_returnsTrueForEmptyCell() {
        assertTrue(board.isCellEmpty(0, 0));
    }

    // isCellEmpty – negative: cell occupied after place()
    @Test
    void isCellEmpty_returnsFalseAfterPlace() {
        board.place(1, 1, 'X');
        assertFalse(board.isCellEmpty(1, 1));
    }

    // isCellEmpty – negative: out-of-bounds coordinates
    @Test
    void isCellEmpty_returnsFalseForOutOfBoundsCoordinates() {
        assertFalse(board.isCellEmpty(-1, 0));
        assertFalse(board.isCellEmpty(0, 3));
    }

    // place – positive: marker is stored at the given position
    @Test
    void place_storesMarkerAtPosition() {
        board.place(2, 2, 'O');
        assertEquals('O', board.getCell(2, 2));
    }

    // place – negative: placing in one cell does not affect another cell
    @Test
    void place_doesNotAffectOtherCells() {
        board.place(0, 0, 'X');
        assertEquals(' ', board.getCell(0, 1));
        assertEquals(' ', board.getCell(1, 0));
    }

    // isFull – positive: board is full after filling all cells
    @Test
    void isFull_returnsTrueWhenAllCellsOccupied() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        assertTrue(board.isFull());
    }

    // isFull – negative: board is not full when one cell is empty
    @Test
    void isFull_returnsFalseWhenOneCellIsEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        board.clear();
        board.place(0, 0, 'X'); // only one cell occupied
        assertFalse(board.isFull());
    }

    // clear – positive: all cells are empty after clear()
    @Test
    void clear_setsAllCellsToEmpty() {
        board.place(0, 0, 'X');
        board.place(1, 1, 'O');
        board.clear();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals(' ', board.getCell(i, j));
            }
        }
    }

    // clear – negative: board is no longer full after clear()
    @Test
    void clear_boardIsNoLongerFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }
        board.clear();
        assertFalse(board.isFull());
    }

    // getCell – positive: returns correct marker after place()
    @Test
    void getCell_returnsCorrectMarker() {
        board.place(0, 2, 'O');
        assertEquals('O', board.getCell(0, 2));
    }

    // getCell – negative: returns space character for untouched cell
    @Test
    void getCell_returnsSpaceForUntouchedCell() {
        assertEquals(' ', board.getCell(2, 0));
    }
}
