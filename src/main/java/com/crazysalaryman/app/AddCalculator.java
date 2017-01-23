package com.crazysalaryman.app;

import org.springframework.stereotype.Component;

/**
 * Created by lse0101 on 2017-01-23.
 */
@Component
public class AddCalculator implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a + b;
    }
}
