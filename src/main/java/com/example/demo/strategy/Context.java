package com.example.demo.strategy;

public class Context {
    CrevasseCrossingStrategy crevasseCrossingStrategy;

    public CrevasseCrossingStrategy getCrevasseCrossingStrategy (Integer distance) {
        if (distance < 3){
            crevasseCrossingStrategy = new JumpCrossStrategy();
        } else {
            crevasseCrossingStrategy = new RopeCrossStrategy();
        }
        return crevasseCrossingStrategy;
    }
}
