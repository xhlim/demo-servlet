package com.xhlim.demo.servlet.entity;

/**
 * 用户实体
 *
 * @author xhlim@outlook.com
 * @version 1.0
 * @date 2018-11-28
 */
public class UserEntity {

    /**
     * 主键
     */
    private Long id;
    /**
     * 名称
     */
    private String name;
    /**
     * 密码
     */
    private String password;
    /**
     * 性别【0 保密，1 男，2 女】
     */
    private byte sex;
    /**
     * 年龄【0 保密】
     */
    private Integer age;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
