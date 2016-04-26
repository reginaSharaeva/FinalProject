package org.itis.gr404;

import org.springframework.stereotype.Component;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by Регина on 04.04.2016.
 */
@Component
public class HashMake {

    public String md5Apache(String str) {
        return DigestUtils.md5Hex(str);
    }
}

