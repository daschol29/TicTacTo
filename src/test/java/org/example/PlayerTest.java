package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    // getMarker – positive: returns X for player created with X
    @Test
    void getMarker_returnsXForPlayerX() {
        Player player = new Player('X');
        assertEquals('X', player.getMarker());
    }

    // getMarker – positive: returns O for player created with O
    @Test
    void getMarker_returnsOForPlayerO() {
        Player player = new Player('O');
        assertEquals('O', player.getMarker());
    }

    // getMarker – negative: X player does not return O
    @Test
    void getMarker_xPlayerDoesNotReturnO() {
        Player player = new Player('X');
        assertNotEquals('O', player.getMarker());
    }

    // getMarker – negative: O player does not return X
    @Test
    void getMarker_oPlayerDoesNotReturnX() {
        Player player = new Player('O');
        assertNotEquals('X', player.getMarker());
    }
}
