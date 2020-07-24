package org.example;

import org.junit.Test;
import org.junit.Assert;

public class ClockTest {

    @Test
    public void getTime() {
        // Given
        int givenTime = 545;
        Clock clock = new Clock(givenTime);

        //  When
        int actualTime = clock.getTime();

        // Then
        Assert.assertEquals(givenTime, actualTime);
    }
}