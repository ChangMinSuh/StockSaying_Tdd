package com.ll.exam;

import java.util.ArrayList;
import java.util.List;

public class WiseSayingRepository {
    private int newWiseSayingId;
    private ArrayList<WiseSaying> wiseSayings;
    public WiseSayingRepository(){
        newWiseSayingId = 1;
        wiseSayings = new ArrayList<>();
    }

    public WiseSaying save(String content, String author) {
        WiseSaying wiseSaying = new WiseSaying(newWiseSayingId++, content, author);
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }
}
