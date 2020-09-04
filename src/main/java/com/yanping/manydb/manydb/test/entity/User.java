
package com.yanping.manydb.manydb.test.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @ClassName: User
 * @Description: 用户实体
 * @date 2018年11月9日 下午5:12:39
 * @version 1.0.0
 */
@Table(name = "user")
@Data
public class User implements Serializable {
    private static final long serialVersionUID = -2786301994259082323L;
    @Id
    @GeneratedValue(generator = "UUID")
    private String id;

    private String username;

    private String password;

    private String name;
    
    @Column(name = "id_no")
    private String idNo;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
