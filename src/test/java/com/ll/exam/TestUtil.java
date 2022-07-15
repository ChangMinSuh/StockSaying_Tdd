package com.ll.exam;

import java.io.*;
import java.util.Scanner;

public class TestUtil {
    // generate 생성하다
    public static Scanner genScanner(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());

        return new Scanner(in);
    }

    public static ByteArrayOutputStream setOutToByteArray(){
        final ByteArrayOutputStream output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output)); // system.out되는 부분을 output 변수에 출력하라.

        return output;
    }

    public static void clearSetOutToByteArray(ByteArrayOutputStream output){
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        try{
            output.close();
        } catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
