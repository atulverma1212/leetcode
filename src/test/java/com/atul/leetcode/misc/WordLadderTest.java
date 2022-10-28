package com.atul.leetcode.misc;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordLadderTest {

    @Test
    void wordLadder() {
        String beginWord = "hit";
        String endWord = "cog";
        String[] arr = new String[]{"hot","dot","dog","lot","log","cog"};
        int i = new WordLadder().ladderLength(beginWord, endWord, Arrays.asList(arr));
        Assertions.assertEquals(i, 5);
    }
}