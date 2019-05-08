package com.michael.spica.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * Created by michael on 2019/5/8.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private String userId;
    private String username;
    private String password;
    private Date createTime;
}
