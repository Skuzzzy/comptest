package com.seriouscompany.longpackagename.means.business.lexer;

/**
 * Created by dan on 10/19/15.
 */
public class Num extends Token{
    public final int value;
    public Num(int v)
    {
        super(Tag.NUM);
        value = v;
    }

    public String toString()
    {
        return "<NUM, "+value+">";
    }
}
