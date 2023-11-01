package eu.kudljo.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SpoonerismTest {

    private Spoonerism spoonerism = new Spoonerism();

    @Test
    public void testNull() {
        try {
            spoonerism.create(null);
        } catch (RuntimeException runtimeException) {
            assertEquals("Input for spoonerism cannot be empty or null!", runtimeException.getMessage());
        }
    }

    @Test
    public void testEmpty() {
        try {
            spoonerism.create("");
        } catch (RuntimeException runtimeException) {
            assertEquals("Input for spoonerism cannot be empty or null!", runtimeException.getMessage());
        }
    }

    @Test
    public void testBlank() {
        try {
            spoonerism.create(" ");
        } catch (RuntimeException runtimeException) {
            assertEquals("Input for spoonerism cannot be empty or null!", runtimeException.getMessage());
        }
    }

    @Test
    public void testOneWord() {
        try {
            spoonerism.create("One");
        } catch (RuntimeException runtimeException) {
            assertEquals("Wrong count of words for spoonerism. Count of words was: 1", runtimeException.getMessage());
        }
    }

    @Test
    public void testThreeWords() {
        try {
            spoonerism.create("Three words input");
        } catch (RuntimeException runtimeException) {
            assertEquals("Wrong count of words for spoonerism. Count of words was: 3", runtimeException.getMessage());
        }
    }

    @Test
    public void testCrushingBlow() {
        String spoonerismResult = spoonerism.create("Crushing blow");

        assertEquals("Blushing crow", spoonerismResult);
    }

    @Test
    public void testSoundBite() {
        String spoonerismResult = spoonerism.create("Sound bite");

        assertEquals("Bound site", spoonerismResult);
    }

    @Test
    public void testFlatCap() {
        String spoonerismResult = spoonerism.create("Flat cap");

        assertEquals("Cat flap", spoonerismResult);
    }

    @Test
    public void testSadBallad() {
        String spoonerismResult = spoonerism.create("Sad ballad");

        assertEquals("Bad sallad", spoonerismResult);
    }

    @Test
    public void testMasterPlan() {
        String spoonerismResult = spoonerism.create("Master plan");

        assertEquals("Plaster man", spoonerismResult);
    }

    @Test
    public void testTrailSnacks() {
        String spoonerismResult = spoonerism.create("Trail snacks");

        assertEquals("Snail tracks", spoonerismResult);
    }
}
