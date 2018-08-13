package com.tanzania.hemmy.mysystemdemographforme.Dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.tanzania.hemmy.mysystemdemographforme.Class.Token;

@Dao
public interface TokenDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long insert(Token token);

    @Query("SELECT token FROM token WHERE isExpired =:isExpired")
    String getToken(Boolean isExpired);

    @Query("SELECT * FROM token WHERE isExpired =:isExpired LIMIT 1")
    Token[] getCustomer(Boolean isExpired);
}
