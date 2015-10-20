package com.seriouscompany.longpackagename.means.business.env;

import java.util.Hashtable;

/**
 * Created by dan on 10/19/15.
 */
public class Env {

    public Env above;
    private Hashtable table;

    public Env(Env upPointer)
    {
        this.above = upPointer;
        this.table = new Hashtable();
    }

    public Symbol get(String symbolName)
    {
        Env currentEnv = this;
        while(currentEnv != null)
        {
            Symbol searchSym = (Symbol)currentEnv.table.get(symbolName);
            if (searchSym != null) {
                return searchSym;
            }
            else
            {
                currentEnv = currentEnv.above;
            }
        }

        return null;
    }

    public void put(Symbol sym)
    {
        table.put(sym.symname, sym);
    }

    // Dummy symbol class
    private static int symid = 0;
    public class Symbol
    {
       public int id;
       public String symname;
       public Symbol(String symname)
       {
           this.id = symid++;
           this.symname = symname;
       }
    }
}
