package com.crazysalaryman.app;

import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.Scanner;

/**
 * Created by lse0101 on 2017-01-23.
 */
@Component
public class ScannerArgumentResolver implements ArgumentResolver {
    @Override
    public Argument resolve(InputStream stream) {
        Scanner scanner = new Scanner(stream);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        return new Argument(a, b);
    }
}
