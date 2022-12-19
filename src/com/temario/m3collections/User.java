package com.temario.m3collections;

import java.util.Objects;

public class User implements Comparable<User> {

    private String nickName, password, email;

    public User(String nickName, String password, String email) {
        this.nickName = nickName;
        this.password = password;
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "nickName=" + nickName + ", password=" + password + ", email=" + email + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nickName);
        hash = 43 * hash + Objects.hashCode(this.email);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof User) {
            final User other = (User) obj;
            if (!this.getNickName().equals(other.getNickName())) {
                return false;
            }
            return this.getEmail().equals(other.getEmail());
        }
        return false;
    }

    @Override
    public int compareTo(User o) {
        if(this.nickName.compareTo(o.getNickName())!=0){
            return this.email.compareTo(o.getEmail());
        }
//        return this.nickName.compareTo(o.getNickName());
        return compareASCII(this.getNickName(),o.getNickName());
    }

    public int compareASCII(String str1, String str2) {
        int count = str1.length() < str2.length() ? str1.length() : str2.length();
        if (!str1.equals(str2)) {
            for (int i = 0; i < count; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    return str2.charAt(i) - str1.charAt(i);
                }
            }
        }
        return 0;
    }

}
