package edu.touro.cs.mcon364;

import java.util.List;
class WordleResponse{
    char c;
    int index;
    LetterResponse resp;
}
enum LetterResponse {
    CORRECT_LOCATION, // Green
    WRONG_LOCATION,   // Yellow
    WRONG_LETTER }    // Gray

/*
if users guesses "TRAIN" (and target is "SHLEP") resposne would be 5 WordleResponses,
first would be a WordleReponse object with the following values
c='T'
index = 0
LetterResponse = LetterRespnse.WRONG_LETTER
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
