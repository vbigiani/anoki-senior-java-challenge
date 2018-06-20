package it.techgap.challenge.java.senior;

import org.junit.Assert;
import org.junit.Test;

public class Challenge06ExtraTest {


    @Test
    public void splitAndReverseTest() {
        /*
         * Split and reverse.
		 */
        Assert.assertEquals("kram", Challenge06Extra.splitAndReverse("mark", 1));
        Assert.assertEquals("krma", Challenge06Extra.splitAndReverse("mark", 2));
        Assert.assertEquals("kmar", Challenge06Extra.splitAndReverse("mark", 3));
        Assert.assertEquals("enirehcat", Challenge06Extra.splitAndReverse("catherine", 3));
        Assert.assertEquals("enirecath", Challenge06Extra.splitAndReverse("catherine", 4));
        Assert.assertEquals("enircathe", Challenge06Extra.splitAndReverse("catherine", 5));
    }

}