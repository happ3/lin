package com.ssm.repository;

import java.io.Serializable;

/**
 * 
 *
 * @author lin
 * @date 2017-4-30
 *
 */
public class User implements Serializable {
    /**  */
    private Integer id;

    /**  */
    private String userName;

    /**  */
    private String password;

    /**  */
    private Integer age;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}