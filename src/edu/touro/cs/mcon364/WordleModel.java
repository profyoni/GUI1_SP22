package edu.touro.cs.mcon364;

import java.util.List;
import java.util.Objects;

class WordleResponse{

    char c;
    int index;
    LetterResponse resp;

    public WordleResponse(char c, int index, LetterResponse resp) {
        this.c = c;
        this.index = index;
        this.resp = resp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WordleResponse that = (WordleResponse) o;
        return c == that.c && index == that.index && resp == that.resp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(c, index, resp);
    }
}
enum LetterResponse {
    CORRECT_LOCATION, // Green
    WRONG_LOCATION,   // Yellow
    WRONG_LETTER }    // Gray

/*
if users guesses "TRAIN" (and target is "SHLEP") response would be 5 WordleResponses,
first would be a WordleReponse object with the following values
c='T'
index = 0
LetterResponse = LetterResponse.WRONG_LETTER
 */
// enum WordleResponse {CORRECT, WRONG, WRONG_POSITION}
public class WordleModel {

    String target;
    List<String> wordList;
    //sets wordList reads file once
    public WordleModel()
    {
    }
    /**
     * reset target
     */
    public void newGame(){}

    /**
     *
     * @param s
     * @return List of 5 entries if legal. empty list or something else  if not legal word
     */
    public List<WordleResponse> checkGuess(String s)
    {
        return null;
    }

}
