package eu.kudljo.sec8_more_oop.ex7;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChessMapTest {

    @Test
    public void testCoordinatesA8() {
        ChessMap chessMap = new ChessMap();
        int[] coordinates = chessMap.getCoordinates("a8");

        assertEquals(0, coordinates[0]);
        assertEquals(0, coordinates[1]);
    }

    @Test
    public void testCoordinatesH1() {
        ChessMap chessMap = new ChessMap();
        int[] coordinates = chessMap.getCoordinates("h1");

        assertEquals(7, coordinates[0]);
        assertEquals(7, coordinates[1]);
    }

    @Test
    public void testCoordinatesG5() {
        ChessMap chessMap = new ChessMap();
        int[] coordinates = chessMap.getCoordinates("g5");

        assertEquals(6, coordinates[0]);
        assertEquals(3, coordinates[1]);
    }

    @Test
    public void testCoordinatesD4() {
        ChessMap chessMap = new ChessMap();
        int[] coordinates = chessMap.getCoordinates("d4");

        assertEquals(3, coordinates[0]);
        assertEquals(4, coordinates[1]);
    }
}
