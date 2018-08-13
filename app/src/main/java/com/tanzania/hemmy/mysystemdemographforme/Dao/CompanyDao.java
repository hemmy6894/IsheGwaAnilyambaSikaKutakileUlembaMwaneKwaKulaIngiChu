package com.tanzania.hemmy.mysystemdemographforme.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tanzania.hemmy.mysystemdemographforme.Class.Buses;
import com.tanzania.hemmy.mysystemdemographforme.Class.Company;

import java.util.List;

@Dao
public interface CompanyDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    long insert(Company company);

    @Query("SELECT * FROM company")
    LiveData<List<Company>> getAllCompany();

    @Query("DELETE  FROM company")
    void drop();
}
