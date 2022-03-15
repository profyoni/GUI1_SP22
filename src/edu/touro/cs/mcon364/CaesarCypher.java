package edu.touro.cs.mcon364;

public class CaesarCypher {
    public static void main(String[] args) {
        // use files of stdin/out
    }

    public static String encrypt(String source, int shift)
    {
        if (shift < 0 || shift > 25)
            throw new IllegalArgumentException("Shift must be in range 0-25");

        StringBuilder sb = new StringBuilder();
        for ( int i=0;i<source.length();i++)
        {
            char c = source.charAt(i);
            boolean isUpper = Character.isUpperCase(c);
            boolean isLower = Character.isLowerCase(c);
            if (isUpper || isLower)
            {
                int _0basedVal = c - (isUpper ? 'A' : 'a');
                sb.append( (char)(( _0basedVal + shift ) % 26 +  (isUpper ? 'A' : 'a')));
            }
            else{
                sb.append(c);
            }

        }
        return sb.toString();

    }
}
