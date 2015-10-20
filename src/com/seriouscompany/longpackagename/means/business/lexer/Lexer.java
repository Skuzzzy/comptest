package com.seriouscompany.longpackagename.means.business.lexer;

import java.io.IOException;
import java.util.Hashtable;

/**
 * Created by dan on 10/19/15.
 */
public class Lexer {
   public int line = 1;
   private char peek = ' ';
   private Hashtable words = new Hashtable();

   public Lexer()
   {
      reserve(new Word(Tag.TRUE, "true"));
      reserve(new Word(Tag.FALSE, "false"));
   }

   public Token scan() throws IOException
   {
      handleWhitespace();

      // Handle integers
      if (Character.isDigit(peek))
      {
         return handleNumber();
      }

      // Handle identifiers
      if(Character.isLetter(peek))
      {
         return handleWord();
      }

      Token t = new Token(peek);
      peek = ' ';
      return t;
   }

   private char readStdIn() throws IOException
   {
      peek = (char)System.in.read();
      return peek;
   }

   private Token handleNumber() throws IOException
   {
      int accumulator = 0;
      do
      {
         accumulator = 10*accumulator + Character.digit(peek, 10);
         readStdIn();
      }
      while(Character.isDigit(peek));
      return new Num(accumulator);
   }

   private Token handleWord() throws IOException
   {
      StringBuilder wordBuilder = new StringBuilder();
      do
      {
         wordBuilder.append(peek);
         readStdIn();
      }
      while(Character.isLetterOrDigit(peek));

      String wordString = wordBuilder.toString();
      Word newWord = new Word(Tag.ID, wordString);
      words.put(newWord.lexeme, newWord);
      return newWord;
   }

   private void handleWhitespace() throws IOException
   {
      // Handle whitespace
      while(true)
      {
         readStdIn();

         // Handle whitespace
         if(isWhitespace(peek))
         {
            continue; // Ignore it
         }
         else if(peek == '\n')
         {
            line += 1;
            continue;
         }
         else
         {
            break; // When a non-whitespace character is encountered move on
         }
      }
   }

   private boolean isWhitespace(char c)
   {
     return c == ' ' || c == '\t';
   }

   private void reserve(Word w)
   {
      words.put(w.lexeme, w);
   }
}
