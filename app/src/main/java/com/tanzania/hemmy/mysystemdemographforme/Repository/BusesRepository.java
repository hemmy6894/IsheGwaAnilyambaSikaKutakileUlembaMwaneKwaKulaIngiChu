package com.tanzania.hemmy.mysystemdemographforme.Repository;

import android.os.AsyncTask;

import com.tanzania.hemmy.mysystemdemographforme.Dao.BusesDao;

public class BusesRepository {

    private static class deleteBusess extends AsyncTask<Long, Void, Void> {
        private BusesDao busesDao;
        deleteBusess(BusesDao dao){
            busesDao = dao;
        }
        @Override
        protected Void doInBackground(Long... longs) {
            return null;
        }
    }

    private static class updateBuses extends AsyncTask<Long, Void, Void> {
        private BusesDao busesDao;
        updateBuses(BusesDao dao){
            busesDao = dao;
        }
        @Override
        protected Void doInBackground(Long... longs) {
            return null;
        }
    }
}
