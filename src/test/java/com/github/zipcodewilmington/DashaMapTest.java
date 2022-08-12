package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public class DashaMapTest {
    @Test
    public void dashaTestSize() {
        //given
        DashaMap map = new DashaMap();
        Integer expectedMapSize = 3;
        Integer expectedCatBucketSize = 2;

        //when
        map.set("cat", 5);
        map.set("catch", 5);
        map.set("cat", 7);
        map.set("dog", 32);
        Integer actualMapSize = map.size();
        Integer actualCatBucketSize = map.bucketSize("cat");

        //then
        Assert.assertEquals(expectedMapSize, actualMapSize);
        Assert.assertEquals(expectedCatBucketSize, actualCatBucketSize);
    }

    @Test
    public void dataTestGet() {
        //given
        DashaMap map = new DashaMap();
        int expected = 1;

        //when
        map.set("monkey", 1);
        map.set("mankey", 3);
        int actual = map.get("monkey");

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dashaTestBucketSize() {
        //given
        DashaMap map = new DashaMap();
        int expected = 3;


        //when
        map.set("dog", 3);
        map.set("donkey", 5);
        map.set("duck", 7);
        map.set("cat", 1);
        int actual = map.bucketSize("d");

        //then
        Assert.assertEquals(expected, actual );
    }

    @Test
    public void dashaTestDelete() {
        //given
        DashaMap map = new DashaMap();
        int expected = 2;


        //when
        map.set("dog", 3);
        map.set("donkey", 5);
        map.set("duck", 7);
        map.delete("donkey");
        int actual = map.bucketSize("d");

        //then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void dashaTestGet() {
        //given
        DashaMap map = new DashaMap();
        int expected = 6;

        //when
        map.set("a", 2);
        map.set("b", 4);
        map.set("c", 6);
        int actual = map.get("c");

        //then
        Assert.assertEquals(expected, actual);
    }
}
