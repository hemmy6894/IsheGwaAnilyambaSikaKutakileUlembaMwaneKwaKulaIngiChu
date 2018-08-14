package com.tanzania.hemmy.mysystemdemographforme.Class;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "token")
public class Token {
    @PrimaryKey
    @NonNull
    private String id;
    private String token;
    private boolean isExpired;
    private Long expiredTime;

    public Token(String id, String token, boolean isExpired, Long expiredTime) {
        this.id = id;
        this.token = token;
        this.isExpired = isExpired;
        this.expiredTime = expiredTime;
    }

    public String getId() {
        return id;
    }

    public String getToken() {
        return token;
    }

    public boolean isExpired() {
        return isExpired;
    }

    public Long getExpiredTime() {
        return expiredTime;
    }
}
