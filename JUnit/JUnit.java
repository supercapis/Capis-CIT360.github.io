/**
 * This program incorporates all of the different assert methods.
 **/

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Create main JUnit class.
 * JUnit is used to create functional tests in addition to unit tests.
 **/
public class JUnit {
    private Object String;
    private java.lang.String Null;

    @Test
    /**assertArrayEquals - Asserts that two arrays are equal**/
    public void assertArrayEquals() {
        int[] expectedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] actualArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Assert.assertArrayEquals(expectedArray, actualArray);
    }

    @Test
    /**assertEquals - Asserts that two objects are equal**/
    public void assertEquals() {
        String expectedEquals;
        String actualEquals;
        String = expectedEquals = "Equals";
        String = actualEquals = "Equals";
        Assert.assertEquals(expectedEquals, actualEquals);
    }

    @Test
    /**assertSame - Asserts that two objects refer to the same object**/
    public void assertSame() {
        String expectedSame;
        String actualSame;
        String = expectedSame = "Same";
        String = actualSame = "Same";
        Assert.assertSame(expectedSame, actualSame);
    }

    @Test
    /**assertNotSame - Asserts that two objects do not refer to the same object**/
    public void assertNotSame() {
        String expectedNotSame;
        String actualNotSame;
        String = expectedNotSame = "Same";
        String = actualNotSame = "Samee";
        Assert.assertNotSame(expectedNotSame, actualNotSame);
    }

    @Test
    /**assertNull - Asserts that an object is null**/
    public void assertNull() {
        /*String expectedNull;*/
        String input = Null;
        Assert.assertNull(input);
    }

    @Test
    /**assertNotNull - Asserts that an object isn't null**/
    public void assertNotNull() {
        String expectedNotNull;
        String = expectedNotNull = "It is expected to be not Null";
        Assert.assertNotNull(expectedNotNull);
    }

    @Test
    /**assertThat - Asserts that actual satisfies the condition specified by matcher**/
    public void equalToTest() {
        String mySchool = "BYU-Idaho";
        assertThat(mySchool, is("BYU-Idaho"));

    }

    @Test
    /**assertTrue - Asserts that a condition is true**/
    public void assertTrue() {
        Assert.assertTrue(2 > 1);
    }

    @Test
    /**assertFalse - Asserts that a condition is false**/
    public void assertFalse() {
        Assert.assertFalse(2 > 3);
    }

}


