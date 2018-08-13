package com.tanzania.hemmy.mysystemdemographforme.Class;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "route",primaryKeys = {"schedule_id"})
public class Route {
    private String departure_time;
    private String arrival_time;
    private String fare;
    private String discount;
    private String tax;
    private String processing_fee;
    @NonNull
    private String schedule_id;
    private String sch_date;
    private String period_session;

    private String estimated_time;
    private String min_booking_hrs;
    private String help_line_no;

    private String bus_name;
    private String seat_type;
    private String model;
    private String max_seat_no;
    private String last_seat_filled;
    private String driver_incharge;
    private String phone;
    private String status;
    private String bus_visible;
    private String profile;
    private String bus_id;
    private String company;
    private int left_seat;
    private int right_seat;

    public Route(String departure_time, String arrival_time, String fare, String discount, String tax, String processing_fee, @NonNull String schedule_id, String sch_date, String period_session, String estimated_time, String min_booking_hrs, String help_line_no, String bus_name, String seat_type, String model, String max_seat_no, String last_seat_filled, String driver_incharge, String phone, String status, String bus_visible, String profile, String bus_id, String company, int left_seat, int right_seat) {
        this.departure_time = departure_time;
        this.arrival_time = arrival_time;
        this.fare = fare;
        this.discount = discount;
        this.tax = tax;
        this.processing_fee = processing_fee;
        this.schedule_id = schedule_id;
        this.sch_date = sch_date;
        this.period_session = period_session;
        this.estimated_time = estimated_time;
        this.min_booking_hrs = min_booking_hrs;
        this.help_line_no = help_line_no;
        this.bus_name = bus_name;
        this.seat_type = seat_type;
        this.model = model;
        this.max_seat_no = max_seat_no;
        this.last_seat_filled = last_seat_filled;
        this.driver_incharge = driver_incharge;
        this.phone = phone;
        this.status = status;
        this.bus_visible = bus_visible;
        this.profile = profile;
        this.bus_id = bus_id;
        this.company = company;
        this.left_seat = left_seat;
        this.right_seat = right_seat;
    }

    public String getDeparture_time() {
        return departure_time;
    }

    public String getArrival_time() {
        return arrival_time;
    }

    public String getFare() {
        return fare;
    }

    public String getDiscount() {
        return discount;
    }

    public String getTax() {
        return tax;
    }

    public String getProcessing_fee() {
        return processing_fee;
    }

    @NonNull
    public String getSchedule_id() {
        return schedule_id;
    }

    public String getSch_date() {
        return sch_date;
    }

    public String getPeriod_session() {
        return period_session;
    }

    public String getEstimated_time() {
        return estimated_time;
    }

    public String getMin_booking_hrs() {
        return min_booking_hrs;
    }

    public String getHelp_line_no() {
        return help_line_no;
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

    public String getStatus() {
        return status;
    }

    public String getBus_visible() {
        return bus_visible;
    }

    public String getProfile() {
        return profile;
    }

    public String getBus_id() {
        return bus_id;
    }

    public String getCompany() {
        return company;
    }

    public int getLeft_seat() {
        return left_seat;
    }

    public int getRight_seat() {
        return right_seat;
    }
}
