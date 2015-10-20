package com.seriouscompany.longpackagename.means.business.lexer;

/**
 * Created by dan on 10/19/15.
 */
public class Word extends Token{
    public final String lexeme;
    public Word(int t, String s)
    {
        super(t);
        lexeme = s;
    }
}
