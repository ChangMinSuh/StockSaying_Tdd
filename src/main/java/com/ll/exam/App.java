package com.ll.exam;

import java.util.Scanner;

public class App {
    private Scanner sc;
    private WiseSayingController wiseSayingController;
    public App(Scanner sc) {
        this.sc = sc;
        wiseSayingController = new WiseSayingController(sc);
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
                case "종료":
                    break outer;
            }
        }

    }




}
