package org.example;

import org.example.operations.BinOpsFacade;

public class Main {
    public static void main(String[] args) {

        BinOpsFacade execute = new BinOpsFacade();
        System.out.println(execute.sum("1", "1111"));
        System.out.println(execute.mult("10000000", "10"));
    }
}