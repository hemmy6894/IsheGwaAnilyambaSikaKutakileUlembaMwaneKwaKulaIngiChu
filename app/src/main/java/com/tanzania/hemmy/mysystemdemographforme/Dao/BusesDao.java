package com.tanzania.hemmy.mysystemdemographforme.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tanzania.hemmy.mysystemdemographforme.Class.Buses;

import java.util.List;

@Dao
public interface BusesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Buses buses);

    @Query("SELECT * FROM buses")
    LiveData<List<Buses>> getAllBuses();

    @Query("DELETE FROM buses")
    void drop();
}
