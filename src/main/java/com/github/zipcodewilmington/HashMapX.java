package com.github.zipcodewilmington;

/**
 * @author xtofer
 * @version 1.0.0
 * @date 10/21/19 9:05 AM
 */
public interface HashMapX {
    // fundamentals
    void set(String key, String value);
    String delete(String key);
    String get(String key);
    boolean isEmpty();
    long size();

    // testing access
    boolean bucketSize(String key); // used for tests
}
