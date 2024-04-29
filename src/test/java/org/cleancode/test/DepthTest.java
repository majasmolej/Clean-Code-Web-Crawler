package org.cleancode.test;

import org.junit.jupiter.api.Test;
import org.cleancode.Depth;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;

public class DepthTest {

    public byte getDepthFromInputStream (String number){
        InputStream originalSystemInput = System.in;
        String testCrawlingDepth = number+"\n";
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(testCrawlingDepth.getBytes());
        System.setIn(byteArrayInputStream);

        Depth depth = new Depth();
        byte depthFromUser;
        try {
            depthFromUser = depth.getDepthFromUser();
        } catch (NoSuchElementException e) {
            depthFromUser = -1; // Set depthFromUser to -1 for out of range input
        }

        System.setIn(originalSystemInput);

        return depthFromUser;
    }

    @Test
    public void getCorrectDepthFromUser() {
        byte crawlingDepthFromUser = getDepthFromInputStream("1");
        assertEquals(1, crawlingDepthFromUser);
    }

    @Test
    public void getIncorrectDepthFromUser() {
        byte crawlingDepthFromUser = getDepthFromInputStream("3");
        assertEquals(-1, crawlingDepthFromUser);
    }

    @Test
    public void isValidDepth() {
        Depth depth = new Depth();

        assertTrue(depth.isValidDepth("0"));
        assertTrue(depth.isValidDepth("1"));
        assertTrue(depth.isValidDepth("2"));

        assertFalse(depth.isValidDepth("hi"));
        assertFalse(depth.isValidDepth("-1"));
        assertFalse(depth.isValidDepth("10"));
    }
}
