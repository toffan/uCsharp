package mcs.tds;

import java.util.ArrayList;

public class Logger {

    ///   Attributs   ///
    private ArrayList<String> log;
    private int num;
    public boolean print;

    static private int nb = 0;

    ///   Constructeurs   ///
    public Logger(boolean print) {
        this.log = new ArrayList<String>();
        this.num = ++nb;
        this.print = print;
    }

    ///   Methodes   ///
    public void entry(String msg) {
        String entry = "[" + this.num + "] " + msg;
        log.add(entry);
        if (this.print) {
            System.out.println(entry);
        }
    }

    public void print() {
        for (String line: log) {
            System.out.println(line);
        }
    }
}
