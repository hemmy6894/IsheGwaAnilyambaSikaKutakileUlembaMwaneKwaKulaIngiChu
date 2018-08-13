package com.tanzania.hemmy.mysystemdemographforme.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tanzania.hemmy.mysystemdemographforme.Class.Buses;
import com.tanzania.hemmy.mysystemdemographforme.Class.Seats;

import java.util.List;

@Dao
public interface SeatsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Seats seats);

    @Query("SELECT * FROM seats")
    LiveData<List<Seats>> getAllSeats();

    @Query("UPDATE seats SET status =:seatState WHERE seat_number =:seatId AND bus_id =:busId")
    void updateSeat(Boolean seatState, String seatId, String busId);

    @Query("DELETE  FROM seats")
    void drop();
}
