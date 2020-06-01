package com.loca.stu01;


import java.util.Objects;

/**
 * @author wangHeng
 * @date  2020-05-27 11:09
 */

public class User {
    private Integer id;
    private Integer schoolId;
    private String userName;
    private String edu;
    private double price;

    public User() {
    }

    public User(Integer id, Integer schoolId, String userName, String edu, double price) {
        this.id = id;
        this.schoolId = schoolId;
        this.userName = userName;
        this.edu = edu;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEdu() {
        return edu;
    }

    public void setEdu(String edu) {
        this.edu = edu;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Double.compare(user.price, price) == 0 &&
                id.equals(user.id) &&
                schoolId.equals(user.schoolId) &&
                userName.equals(user.userName) &&
                edu.equals(user.edu);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, schoolId, userName, edu, price);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", schoolId=" + schoolId +
                ", userName='" + userName + '\'' +
                ", edu='" + edu + '\'' +
                ", price=" + price +
                '}';
    }
}
