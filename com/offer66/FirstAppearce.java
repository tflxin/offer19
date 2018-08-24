package com.offer66;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class FirstAppearce {

    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    ArrayList<Character> list = new ArrayList<Character>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
        list.add(ch);
    }

    public char FirstAppearingOnce() {
        for (int i = 0; i < list.size(); i++) {
            if (map.get(list.get(i)) == 1) {
                return list.get(i);
            }
        }
        return '#';
    }




}
