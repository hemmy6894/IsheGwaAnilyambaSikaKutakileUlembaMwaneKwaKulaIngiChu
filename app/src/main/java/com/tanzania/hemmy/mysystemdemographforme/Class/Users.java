package com.tanzania.hemmy.mysystemdemographforme.Class;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "users")
public class Users {
        private String first_name;
        private String last_name;
        private String email;
        private String password;
        private String gender;
        private String address;
        private String role;
        private String phone_verified;
        @PrimaryKey
        @NonNull
        private String _id;
        private String phone_no;
        private String __v;

    public Users(String first_name, String last_name, String email, String password, String gender, String address, String role, String phone_verified, String _id, String phone_no, String __v) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.email = email;
        this.password = password;
        this.gender = gender;
        this.address = address;
        this.role = role;
        this.phone_verified = phone_verified;
        this._id = _id;
        this.phone_no = phone_no;
        this.__v = __v;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getGender() {
        return gender;
    }

    public String getAddress() {
        return address;
    }

    public String getRole() {
        return role;
    }

    public String getPhone_verified() {
        return phone_verified;
    }

    public String get_id() {
        return _id;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String get__v() {
        return __v;
    }
}
