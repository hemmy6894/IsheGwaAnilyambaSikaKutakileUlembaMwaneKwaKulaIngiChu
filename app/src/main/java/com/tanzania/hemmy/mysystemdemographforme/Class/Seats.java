package com.tanzania.hemmy.mysystemdemographforme.Class;

import android.arch.persistence.room.Entity;
import android.support.annotation.NonNull;

@Entity(tableName = "seats", primaryKeys = {"bus_id","company_id","seat_number"})
public class Seats {
         private String _id;
         private String for_date;
         @NonNull
         private String company_id;
         @NonNull
         private String bus_id;
         private String sc_pool_id;
         private String sc_date_id;
         @NonNull
         private String seat_number;
         private String status;
         private boolean state;

    public Seats(String _id, String for_date, String company_id, String bus_id, String sc_pool_id, String sc_date_id, String seat_number, String status, boolean state) {
        this._id = _id;
        this.for_date = for_date;
        this.company_id = company_id;
        this.bus_id = bus_id;
        this.sc_pool_id = sc_pool_id;
        this.sc_date_id = sc_date_id;
        this.seat_number = seat_number;
        this.status = status;
        this.state = state;
    }

    public String get_id() {
        return _id;
    }

    public String getFor_date() {
        return for_date;
    }

    public String getCompany_id() {
        return company_id;
    }

    public String getBus_id() {
        return bus_id;
    }

    public String getSc_pool_id() {
        return sc_pool_id;
    }

    public String getSc_date_id() {
        return sc_date_id;
    }

    public String getSeat_number() {
        return seat_number;
    }

    public String getStatus() {
        return status;
    }

    public boolean isState() {
        return state;
    }
}
