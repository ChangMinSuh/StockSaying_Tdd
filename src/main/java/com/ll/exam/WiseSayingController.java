package com.ll.exam;

import java.util.Scanner;

public class WiseSayingController {
    private Scanner sc;
    private final WiseSayingService wiseSayingService;

    public WiseSayingController(Scanner sc){
        this.sc = sc;
        wiseSayingService = new WiseSayingService();
    }
    public void write() {
        System.out.print("명언 : ");
        String content = sc.nextLine();
        System.out.print("작가 : ");
        String author = sc.nextLine();

        WiseSaying wiseSaying = wiseSayingService.write(content, author);

        System.out.println(wiseSaying.getId() + "번 명언이 등록되었습니다.");
    }
}
