package com.ll.exam;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WiseSayingControllerTest {
//    @BeforeAll
//    public void beforeAll(){
//        App.mode = "test";
//    }

//    @BeforeEach
//    public void beforeEach(){
//        Util.file.deleteDir(App.getBaseDir());
//    }

    @Test
    public void 등록_하면_명언과_작가를_물어본다(){
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                종료
                """).stripIndent();

        assertTrue(rs.contains("명언 : "));
        assertTrue(rs.contains("작가 : "));
    }

    @Test
    public void 등록을_하면_생성된_명언의_번호가_출력되어야_한다() {
        String rs = AppTestRunner.run("""
                등록
                나의 죽음을 적들에게 알리지 말라
                이순신
                등록
                나에게 불가능이란 없다.
                나폴레옹
                종료
                """);
        assertTrue(rs.contains("1번 명언이 등록되었습니다."));
        assertTrue(rs.contains("2번 명언이 등록되었습니다."));
    }
}
