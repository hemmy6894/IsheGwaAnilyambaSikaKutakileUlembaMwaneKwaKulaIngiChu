package com.tanzania.hemmy.mysystemdemographforme.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tanzania.hemmy.mysystemdemographforme.Class.History;

import java.util.List;

@Dao
public interface HistoryDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(History history);

    @Query("SELECT * FROM history WHERE state =:seatState")
    LiveData<List<History>> getHistory(String seatState);

    @Query("SELECT * FROM history WHERE state =:seatState AND seat_id =:seatId AND bus_id =:busId")
    LiveData<List<History>> getHistory(String seatState,String seatId, String busId);

    @Query("DELETE  FROM history WHERE seat_id =:seatId AND bus_id =:busId")
    int deleteSeat(String seatId, String busId);

    @Query("UPDATE history SET state =:seatState WHERE seat_id =:seatId AND bus_id =:busId")
    void updateSeat(String seatState,String seatId, String busId);
}
