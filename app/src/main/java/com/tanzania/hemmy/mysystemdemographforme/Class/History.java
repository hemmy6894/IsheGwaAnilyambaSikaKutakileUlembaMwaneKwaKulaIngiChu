package com.tanzania.hemmy.mysystemdemographforme.Class;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "history",primaryKeys = {"company_id","bus_id","seat_id"})
public class History {
    private  String sch_departure_time;
    private  String sch_arrival_time;
    private  String sch_fare;
    private  String sch_discount;
    private  boolean sch_visible;
    private  String estimated_time;
    private  String help_line_no;
    private  String bus_name;
    private  String bus_model;
    private  int bus_max_seat_no;
    private  String bus_phone;
    private  boolean bus_visible;
    private  String bus_from;
    private  String bus_to;
    private  String booking_id;
    @NonNull
    private  String seat_id;
    @NonNull
    private String bus_id;
    @NonNull
    private String company_id;
    private String state;

    public History(String sch_departure_time, String sch_arrival_time, String sch_fare, String sch_discount, boolean sch_visible, String estimated_time, String help_line_no, String bus_name, String bus_model, int bus_max_seat_no, String bus_phone, boolean bus_visible, String bus_from, String bus_to, String booking_id, String seat_id, String bus_id, String company_id,String state) {
        this.sch_departure_time = sch_departure_time;
        this.sch_arrival_time = sch_arrival_time;
        this.sch_fare = sch_fare;
        this.sch_discount = sch_discount;
        this.sch_visible = sch_visible;
        this.estimated_time = estimated_time;
        this.help_line_no = help_line_no;
        this.bus_name = bus_name;
        this.bus_model = bus_model;
        this.bus_max_seat_no = bus_max_seat_no;
        this.bus_phone = bus_phone;
        this.bus_visible = bus_visible;
        this.bus_from = bus_from;
        this.bus_to = bus_to;
        this.booking_id = booking_id;
        this.seat_id = seat_id;
        this.bus_id = bus_id;
        this.company_id = company_id;
        this.state = state;
    }

    public String getState() {
        return state;
    }

    public String getSch_departure_time() {
        return sch_departure_time;
    }

    public String getSch_arrival_time() {
        return sch_arrival_time;
    }

    public String getSch_fare() {
        return sch_fare;
    }

    public String getSch_discount() {
        return sch_discount;
    }

    public boolean isSch_visible() {
        return sch_visible;
    }

    public String getEstimated_time() {
        return estimated_time;
    }

    public String getHelp_line_no() {
        return help_line_no;
    }

    public String getBus_name() {
        return bus_name;
    }

    public String getBus_model() {
        return bus_model;
    }

    public int getBus_max_seat_no() {
        return bus_max_seat_no;
    }

    public String getBus_phone() {
        return bus_phone;
    }

    public boolean isBus_visible() {
        return bus_visible;
    }

    public String getBus_from() {
        return bus_from;
    }

    public String getBus_to() {
        return bus_to;
    }

    public String getBooking_id() {
        return booking_id;
    }

    public String getSeat_id() {
        return seat_id;
    }

    public String getBus_id() {
        return bus_id;
    }

    public String getCompany_id() {
        return company_id;
    }
}
