package com.offer66;

import java.util.HashMap;

/**
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)
 * 中找到第一个只出现一次的字符
 * ,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */

public class FirstNotRepeatingChar
{
    public int FirstNotRepeatingChar(String str)
    {

        HashMap<Character,Integer> map=new HashMap<Character,Integer>();
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(map.containsKey(c))
            {
                int time=map.get(c);
                time++;
                map.put(c,time);
            }
            else
            {
                map.put(c,1);
            }
        }
        for(int i=0;i<str.length();i++)
        {
            char c=str.charAt(i);
            if(map.get(c)==1)
                return i;
        }
        return -1;
    }
}

/**
 public class Solution {
 public int FirstNotRepeatingChar(String str) {
 if(str == null) return -1;
 char[] chars = str.toCharArray();
 int[] character = new int['z'+1];
 for(char c : chars){
 character[(int) c]++;
 }
 int i = 0;
 for(; i < chars.length; i++){
 if(character[(int)chars[i]]==1)
 return i;
 }

 return -1;
 }
 }
 **/