package com.example.entity;


/**
 * @Author:zrs
 * @Date: 2018/9/26 0026
 * @Time: 14:39
 */
public class User {
	private int id;

    private String accid;

    private String username;

    private String password;

    private String userPhoto;

    private String sex;

    private String birthday;

    private String phone;

    private String province;
    
    private String city;

    private String signDesc;

    private String email;
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid == null ? null : accid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
/**
    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }*/

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }
    
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city== null ? null : city.trim();
    }

    public String getSignDesc() {
        return signDesc;
    }

    public void setSignDesc(String signDesc) {
        this.signDesc = signDesc == null ? null : signDesc.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

}