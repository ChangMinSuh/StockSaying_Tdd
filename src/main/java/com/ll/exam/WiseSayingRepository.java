package com.ll.exam;

import java.util.List;

public class WiseSayingRepository {
    private final WiseSayingTable wiseSayingTable;
    public WiseSayingRepository(){
        wiseSayingTable = new WiseSayingTable(App.getBaseDir());
    }

    public WiseSaying save(String content, String author) {
        return wiseSayingTable.save(content, author);
    }

    public List<WiseSaying> findAll() {
        return wiseSayingTable.findAll();
    }

    public WiseSaying findById(int id) {
        return wiseSayingTable.findById(id);
    }

    public void remove(int id) {
        wiseSayingTable.removeById(id);
    }

    public void update(int id, String newContent, String newAuthor) {
        wiseSayingTable.save(id, newContent, newAuthor);
    }

    public void saveDataArr(String dataArr){
        wiseSayingTable.saveDataArr(dataArr);
    }
}
