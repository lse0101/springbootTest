package com.crazysalaryman.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by lse0101 on 2017-01-23.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private Integer id;
    private String firstName;
    private String lastName;
}
