package edu.touro.cs.mcon364;

import java.util.List;

enum WordleResponse {CORRECT, WRONG, WRONG_POSITION}
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
