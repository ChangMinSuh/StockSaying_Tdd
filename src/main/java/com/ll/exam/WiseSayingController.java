package com.ll.exam;

import java.util.List;
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

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("----------------------");
        List<WiseSaying> wiseSayings = wiseSayingService.list();
        for(WiseSaying wiseSaying: wiseSayings){
            System.out.println(wiseSaying.getId() + " / "
                    + wiseSaying.getAuthor() + " / "
                    + wiseSaying.getContent()
            );
        }
    }

    public void remove(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if (id < 0){
            System.out.println("id 값을 입력해 주세요.");
            return;
        }
        WiseSaying wiseSaying = wiseSayingService.findById(id);
        if(wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        wiseSayingService.remove(id);
        System.out.println(id + "번 명언이 삭제되었습니다.");
    }

    public void update(Rq rq) {
        int id = rq.getIntParam("id", -1);
        if (id < 0){
            System.out.println("id 값을 입력해주세요.");
            return;
        }
        WiseSaying wiseSaying = wiseSayingService.findById(id);
        if(wiseSaying == null) {
            System.out.println(id + "번 명언은 존재하지 않습니다.");
            return;
        }
        System.out.println("명언(기존) : " + wiseSaying.getContent());
        String newContent = sc.nextLine();

        System.out.println("작가(기존) : " + wiseSaying.getAuthor());
        String newAuthor = sc.nextLine();

        wiseSayingService.update(id, newContent, newAuthor);
        System.out.println(id + "번 명언이 수정되었습니다.");
    }
}
