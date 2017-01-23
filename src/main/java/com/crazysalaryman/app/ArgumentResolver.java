package com.crazysalaryman.app;

import java.io.InputStream;

/**
 * Created by lse0101 on 2017-01-23.
 */
public interface ArgumentResolver {
    Argument resolve(InputStream stream);
}
