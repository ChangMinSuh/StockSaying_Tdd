package com.ll.exam;

import java.util.List;

public class WiseSayingService {

    private final WiseSayingRepository wiseSayingRepository;

    public WiseSayingService(){
        wiseSayingRepository = new WiseSayingRepository();
    }
    public WiseSaying write(String content, String author) {
        return wiseSayingRepository.save(content, author);
    }

    public List<WiseSaying> list() {
        return wiseSayingRepository.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingRepository.findById(id);
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayingRepository.remove(wiseSaying);
    }
}
