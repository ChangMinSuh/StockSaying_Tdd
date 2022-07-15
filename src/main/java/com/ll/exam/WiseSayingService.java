package com.ll.exam;

import java.util.List;
import java.util.stream.Collectors;

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

    public void remove(int id) {
        wiseSayingRepository.remove(id);
    }

    public void update(int id, String newContent, String newAuthor) {
        wiseSayingRepository.update(id, newContent, newAuthor);
    }

    public void build() {
        List<WiseSaying> wiseSayings = wiseSayingRepository.findAll();
        String datum = wiseSayings.stream().map(wiseSaying -> wiseSaying.toJson()).collect(Collectors.joining(","));
        String dataArr = "[\n" + datum + "]";
        wiseSayingRepository.saveDataArr(dataArr);
    }
}
