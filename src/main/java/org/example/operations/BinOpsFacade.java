package org.example.operations;

public class BinOpsFacade {
    private final BinOps binOps;
    public BinOpsFacade() {
        this.binOps = new BinOps();
    }

    public String sum(String a, String b) {
        return binOps.sum(a, b);
    }

    public String mult(String a, String b) {
        return binOps.mult(a, b);
    }
}
