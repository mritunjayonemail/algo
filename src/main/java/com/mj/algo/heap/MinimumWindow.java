package com.mj.algo.heap;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".

Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.



Example 1:

Input: s = "ADOBECODEBANC", t = "ABC"
Output: "BANC"
Example 2:

Input: s = "a", t = "a"
Output: "a"


Constraints:

1 <= s.length, t.length <= 105
s and t consist of English letters.
 */
public class MinimumWindow {

    private boolean isContains(Map<String, Integer> window, Map<String, Integer> tWindow ){
        int count = 0;
        for(Map.Entry<String, Integer> tset: tWindow.entrySet()){;
            boolean found = window.containsKey(tset.getKey()) && window.get(tset.getKey()) >= tset.getValue();
            if(!found) return false;
        }
        return true;
    }
    public String minWindow(String s, String t) {

        Map<String, Integer> tWindow = new HashMap<>();
        Map<String, Integer> window = new HashMap<String, Integer>();
        for(int i = 0; i<t.length(); i++){
            String ch = String.valueOf(t.charAt(i));
            tWindow.put(ch, tWindow.getOrDefault(ch, 0) + 1);
        }
        int j = 0;
        int left = 0, right=0;
        int maxlen = Integer.MAX_VALUE;
        for(int i = 0; i<s.length(); i++){
            String ch = String.valueOf(s.charAt(i));
            window.put(ch, window.getOrDefault(ch, 0) + 1);
            if(isContains(window, tWindow)){
                while(isContains(window, tWindow)){
                    String jch = String.valueOf(s.charAt(j));
                    window.put(jch, window.get(jch) - 1);
                    j++;
                }
                int newlen = i-j+1;
                if(newlen<maxlen){
                    maxlen = newlen;
                    left =j-1;
                    right=i+1;

                }
            }
        }
        return s.substring(left, right);

    }

    public static void main(String args[]){
        MinimumWindow mw = new MinimumWindow();
        String s = "a";
        String t = "a";
        String minstr = mw.minWindow(s, t);
        System.out.println("Minimum str " + minstr);
    }
}
