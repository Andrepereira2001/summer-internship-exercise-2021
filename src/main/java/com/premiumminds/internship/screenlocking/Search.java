package com.premiumminds.internship.screenlocking;

import java.util.concurrent.Callable;

public class Search implements Callable<Integer> {
    private final Pattern pattern;
    public Search(Pattern pattern){
        this.pattern = pattern;
    }

    @Override
    public Integer call() {
        return searchPattern();
    }

    public int searchPattern(){
        int ret = 0;

        if(pattern.validPattern()){
            System.out.println(pattern.getPattern());
            return ret + 1;
        }

        for (int i = 1; i <= 9; i++){
            if(pattern.addNumber(i)){
                ret += searchPattern();
                pattern.removeLast();
            }
        }

        return ret;
    }
}
