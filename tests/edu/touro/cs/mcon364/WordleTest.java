package edu.touro.cs.mcon364;

import org.junit.jupiter.api.Assertions;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class WordleTest {

    @org.junit.jupiter.api.Test
    void checkGuess() {
        WordleModel wm = new WordleModel();
        wm.target = "CRANE";
        List<WordleResponse> resp = wm.checkGuess("TRAIN");

        Assertions.assertEquals(new WordleResponse('T',0, LetterResponse.WRONG_LETTER),resp.get(0));
    }


}