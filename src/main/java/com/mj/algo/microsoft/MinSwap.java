package com.mj.algo.microsoft;

public class MinSwap {

    static int min(int x,int y,int z)
    {
        if (x<=y && x<=z) return x;
        if (y<=x && y<=z) return y;
        else return z;
    }

    private int editDistance(String s1, String s2, int m, int n){
        if(m==s1.length()){
            return 0;
        }
        if(n==s1.length()){
            return 0;
        }
        if(s1.charAt(m) == s2.charAt(n)){
            return editDistance(s1, s2, m+1, n-1);
        }
        else {
            return 1 + editDistance(s1, s2, m+1, n-1);
        }
    }

    public static void main(String args[]){
        MinSwap ms = new MinSwap();
        String s = "ntiin";
        int mid;
        mid = Math.abs(s.length() / 2);
        String s1 = s.substring(0, mid);
        String s2;
        if (s.length() %2==0){
            s2 = s.substring(mid, s.length());
        }
            s2 = s.substring(mid+1, s.length());
        int changes = ms.editDistance(s1, s2, 0, s2.length()-1);
        System.out.print("Changes is " + changes );
    }
}
