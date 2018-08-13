package com.tanzania.hemmy.mysystemdemographforme.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tanzania.hemmy.mysystemdemographforme.Class.Buses;
import com.tanzania.hemmy.mysystemdemographforme.Class.Users;

import java.util.List;

@Dao
public interface UsersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Users users);

    @Query("SELECT * FROM users")
    LiveData<List<Users>> getAllUsers();

    @Query("UPDATE users SET Password =:password WHERE _id =:userId")
    void updateUser(String password, Long userId);

    @Query("DELETE  FROM users")
    void drop();
}
