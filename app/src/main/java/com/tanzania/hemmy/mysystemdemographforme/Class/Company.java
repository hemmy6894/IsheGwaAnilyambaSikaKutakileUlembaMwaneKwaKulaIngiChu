package com.tanzania.hemmy.mysystemdemographforme.Class;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "company")
public class Company {
    private String company_name;
    private String  phone;
    private String  email;
    private String  website_url;
    private String  transportation_types;
    private String  help_line_no;
    private String  addresses;
    private String  agents_offices;
    private String  imgs;
    private String  profile;
    @PrimaryKey
    @NonNull
    private String  _id;
    private String  __v;

    public Company(String company_name, String phone, String email, String website_url, String transportation_types, String help_line_no, String addresses, String agents_offices, String imgs, String profile, String _id, String __v) {
        this.company_name = company_name;
        this.phone = phone;
        this.email = email;
        this.website_url = website_url;
        this.transportation_types = transportation_types;
        this.help_line_no = help_line_no;
        this.addresses = addresses;
        this.agents_offices = agents_offices;
        this.imgs = imgs;
        this.profile = profile;
        this._id = _id;
        this.__v = __v;
    }

    public String getCompany_name() {
        return company_name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite_url() {
        return website_url;
    }

    public String getTransportation_types() {
        return transportation_types;
    }

    public String getHelp_line_no() {
        return help_line_no;
    }

    public String getAddresses() {
        return addresses;
    }

    public String getAgents_offices() {
        return agents_offices;
    }

    public String getImgs() {
        return imgs;
    }

    public String getProfile() {
        return profile;
    }

    public String get_id() {
        return _id;
    }

    public String get__v() {
        return __v;
    }
}
