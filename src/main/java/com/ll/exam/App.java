package com.ll.exam;

import java.util.Scanner;

public class App {
    public static String mode = "main";
    private Scanner sc;
    private WiseSayingController wiseSayingController;
    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingController = new WiseSayingController(sc);
    }

    public static String getBaseDir() {
        return mode + "_data";
    }

    public void run(){
        System.out.println("== 명언 SSG ==");
        outer:
        while(true){
            System.out.print("명령) ");
            String url = sc.nextLine();
            Rq rq = new Rq(url);
            switch(rq.getPath()){
                case "등록":
                    wiseSayingController.write();
                    break;
                case "목록":
                    wiseSayingController.list();
                    break;
                case "삭제":
                    wiseSayingController.remove(rq);
                    break;
                case "수정":
                    wiseSayingController.update(rq);
                    break;
                case "빌드":
                    wiseSayingController.build();
                    break;
                case "종료":
                    break outer;
            }
        }

    }




}
