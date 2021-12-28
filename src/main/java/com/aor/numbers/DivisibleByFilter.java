package com.aor.numbers;

public class DivisibleByFilter implements GenericListFilter{
    private int n;
    DivisibleByFilter(int n) {
        this.n=n;
    }


    @Override
    public boolean accept(Integer number) {
        return number % n == 0;
    }
}
