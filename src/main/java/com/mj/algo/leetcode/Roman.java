package com.mj.algo.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

Symbol       Value
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

I can be placed before V (5) and X (10) to make 4 and 9.
X can be placed before L (50) and C (100) to make 40 and 90.
C can be placed before D (500) and M (1000) to make 400 and 900.
Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman {

    public String intToRoman(int num) {
        Map<Integer, String> val_sample_map = new LinkedHashMap<>();
        val_sample_map.put(1000, "M");
        val_sample_map.put(500, "D");
        val_sample_map.put(100, "C");
        val_sample_map.put(50, "L");
        val_sample_map.put(10, "X");
        val_sample_map.put(5, "V");
        val_sample_map.put(1, "I");

        StringBuffer roman = new StringBuffer("");
        int rem_num = num;
        Iterator<Integer> itr = val_sample_map.keySet().iterator();
        while (itr.hasNext()){
            int key = itr.next();
            String symbol = val_sample_map.get(key);
            if (symbol.equals("I") && rem_num == 4){
                rem_num = rem_num-4;
                roman.append("IV");
            }
            else if (rem_num == 9){
                rem_num = rem_num -9;
                roman.append("IX");
            }
            else if (40<=rem_num && rem_num <=49){
                rem_num = rem_num -40;
                roman.append("XL");
            }
            else if (90<=rem_num && rem_num <=99){
                rem_num = rem_num -90;
                roman.append("XC");
            }
            else if (400<=rem_num && rem_num<=499){
                rem_num = rem_num -400;
                roman.append("CD");
            }
            else if (900<=rem_num && rem_num<=999){
                rem_num = rem_num -900;
                roman.append("CM");
            }
            else if(rem_num>=key) {
                int mul= (int)rem_num/key;
                rem_num = rem_num % key;
                roman.append(constructRoman(mul, symbol));
            }
        }
        return roman.toString();
    }

    private String constructRoman(int count, String symbol){
        StringBuffer roman = new StringBuffer("");
        if (symbol.equals("I") && count == 4){
            roman.append("IV");
        }
        else if (symbol.equals("X") && count == 9){
            roman.append("IX");
        }
        else if (symbol.equals("L") && count == 4){
            roman.append("XL");
        }
        else if (symbol.equals("C") && count == 9){
            roman.append("XC");
        }
        else if (symbol.equals("D") && count == 4){
            roman.append("CD");
        }
        else if (symbol.equals("M") && count == 9){
            roman.append("CM");
        }
        else {
            for(int index = 0; index<count; index++){
                roman.append(symbol);
            }
        }
        return roman.toString();
    }

    public static void main(String args[]){

        Roman roman = new Roman();
        System.out.println(roman.intToRoman(
                1994));


    }
}
