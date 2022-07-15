package com.ll.exam;

import java.io.ByteArrayOutputStream;
import java.util.Scanner;

public class AppTestRunner {
    public static String run(String input) {
        // 문자열 입력받는 스캐너
        Scanner sc = TestUtil.genScanner(input);

        // 모니터에 출력될 내용을 ByteStream에 쌓이도록 한다.
        ByteArrayOutputStream output = TestUtil.setOutToByteArray();

        new App(sc).run();
        String rs = output.toString();

        TestUtil.clearSetOutToByteArray(output);

        return rs;
    }


}
