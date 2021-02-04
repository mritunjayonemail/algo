package com.mj.java8;

import java.io.BufferedReader;
import java.io.IOException;

@FunctionalInterface
public interface BufferedReaderProcessor {

    String process(BufferedReader br) throws IOException;
}
