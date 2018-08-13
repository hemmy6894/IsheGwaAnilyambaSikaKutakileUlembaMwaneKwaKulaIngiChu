package com.tanzania.hemmy.mysystemdemographforme.Class;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "buses", primaryKeys = {"id","company"})
public class Buses {
        private String bus_name;
        private String seat_type;
        private String model;
        private String max_seat_no;
        private String last_seat_filled;
        private String driver_incharge;
        private String phone;
        private String schedulling_type;
        private String visible;
        private String status;
        private String profile;
        private String images;
        private String services;
        @NonNull
        private String id;
        @NonNull
        private String company;
        private String __v;

    public Buses(String bus_name, String seat_type, String model, String max_seat_no, String last_seat_filled, String driver_incharge, String phone, String schedulling_type, String visible, String status, String profile, String images, String services, String id, String company, String __v) {
        this.bus_name = bus_name;
        this.seat_type = seat_type;
        this.model = model;
        this.max_seat_no = max_seat_no;
        this.last_seat_filled = last_seat_filled;
        this.driver_incharge = driver_incharge;
        this.phone = phone;
        this.schedulling_type = schedulling_type;
        this.visible = visible;
        this.status = status;
        this.profile = profile;
        this.images = images;
        this.services = services;
        this.id = id;
        this.company = company;
        this.__v = __v;
    }

    public String getBus_name() {
        return bus_name;
    }

    public String getSeat_type() {
        return seat_type;
    }

    public String getModel() {
        return model;
    }

    public String getMax_seat_no() {
        return max_seat_no;
    }

    public String getLast_seat_filled() {
        return last_seat_filled;
    }

    public String getDriver_incharge() {
        return driver_incharge;
    }

    public String getPhone() {
        return phone;
    }

    public String getSchedulling_type() {
        return schedulling_type;
    }

    public String getVisible() {
        return visible;
    }

    public String getStatus() {
        return status;
    }

    public String getProfile() {
        return profile;
    }

    public String getImages() {
        return images;
    }

    public String getServices() {
        return services;
    }

    public String getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public String get__v() {
        return __v;
    }
}
