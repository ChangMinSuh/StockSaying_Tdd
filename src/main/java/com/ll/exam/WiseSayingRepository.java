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

    public WiseSaying findById(int id) {
        try{
            for(WiseSaying wiseSaying: wiseSayings){
                if(wiseSaying.getId() == id) return wiseSaying;
            }
            throw new NullPointerException();
        } catch(Exception e){
            return null;
        }
    }

    public void remove(WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }

    public void update(int id, String newContent, String newAuthor) {
        for(WiseSaying wiseSaying: wiseSayings){
            if(wiseSaying.getId() == id) {
                wiseSaying.setAuthor(newAuthor);
                wiseSaying.setContent(newContent);
                return;
            }
        }
    }
}
