package com.mj.algo.bits;

public class BinaryNumber {

    private static String convertToBinary(float number, int prec){

        StringBuilder binaryNumber = new StringBuilder("");
        StringBuilder decBinaryNumber = new StringBuilder("");


        int intPart = (int)number;
        float decPart =   number -  intPart;

        int mod = 0;
        while(intPart>0){
            mod = intPart % 2;
            binaryNumber.append(""+ mod);
            intPart = intPart/2;
        }

        binaryNumber = binaryNumber.reverse();
        binaryNumber.append(".");

        while(prec-->0){
            decPart = decPart * 2;
            if (decPart>1){
                binaryNumber.append("1");
                decPart = decPart - 1;
            }
            else {
                binaryNumber.append("0");
            }

        }
        return binaryNumber.toString();

    }


    public static void main(String args[]){
        System.out.println(convertToBinary(37.56735f, 4));

    }
}
