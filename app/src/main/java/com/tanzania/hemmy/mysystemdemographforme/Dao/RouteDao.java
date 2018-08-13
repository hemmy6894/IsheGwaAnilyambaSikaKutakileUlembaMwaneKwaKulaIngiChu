package com.tanzania.hemmy.mysystemdemographforme.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tanzania.hemmy.mysystemdemographforme.Class.Buses;
import com.tanzania.hemmy.mysystemdemographforme.Class.Route;

import java.util.List;

@Dao
public interface RouteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Route route);

    @Query("SELECT * FROM route")
    LiveData<List<Route>> getRoute();

    @Query("SELECT * FROM route WHERE company =:companyId")
    LiveData<List<Route>> getRoute(String companyId);

    @Query("SELECT * FROM route WHERE company =:companyId AND bus_id=:busId")
    LiveData<List<Route>> getRoute(String companyId, String busId);

    @Query("DELETE  FROM route")
    void drop();
}
