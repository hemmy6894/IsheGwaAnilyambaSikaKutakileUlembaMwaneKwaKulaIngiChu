package com.tanzania.hemmy.mysystemdemographforme.Database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.tanzania.hemmy.mysystemdemographforme.Class.Buses;
import com.tanzania.hemmy.mysystemdemographforme.Class.Company;
import com.tanzania.hemmy.mysystemdemographforme.Class.History;
import com.tanzania.hemmy.mysystemdemographforme.Class.Route;
import com.tanzania.hemmy.mysystemdemographforme.Class.Seats;
import com.tanzania.hemmy.mysystemdemographforme.Class.Token;
import com.tanzania.hemmy.mysystemdemographforme.Class.Users;
import com.tanzania.hemmy.mysystemdemographforme.Dao.BusesDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.CompanyDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.HistoryDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.RouteDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.SeatsDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.TokenDao;
import com.tanzania.hemmy.mysystemdemographforme.Dao.UsersDao;


@Database(entities = {Buses.class, Company.class, Route.class, Seats.class, Users.class, History.class, Token.class}, version = 3, exportSchema = false)
public abstract class MsafiriDatabase extends RoomDatabase{
    public abstract BusesDao BusesDao();
    public abstract CompanyDao CompanyDao();
    public abstract RouteDao RouteDao();
    public abstract SeatsDao SeatsDao();
    public abstract UsersDao UsersDao();
    public abstract HistoryDao HistoryDao();
    public abstract TokenDao TokenDao();

    private static MsafiriDatabase INSTANCE;

    public static MsafiriDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MsafiriDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            MsafiriDatabase.class, "M-Safari_Database")
                            // Wipes and rebuilds instead of migrating
                            // if no Migration object.
                            // Migration is not part of this practical.
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}
