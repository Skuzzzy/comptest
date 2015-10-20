package com.seriouscompany.longpackagename.means.business;

import com.seriouscompany.longpackagename.means.business.lexer.Lexer;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Lexer lex = new Lexer();
        try
        {
            while(true)
            {
                System.out.println(lex.scan());
            }
        } catch (IOException io)
        {
            io.printStackTrace();
        }

    }
}
