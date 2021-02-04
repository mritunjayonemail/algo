package com.mj.java8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedProcessorExample {

    public static String processFile(BufferedReaderProcessor p) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    public static void main(String args[]){
        try {
            processFile((BufferedReader br) -> br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
