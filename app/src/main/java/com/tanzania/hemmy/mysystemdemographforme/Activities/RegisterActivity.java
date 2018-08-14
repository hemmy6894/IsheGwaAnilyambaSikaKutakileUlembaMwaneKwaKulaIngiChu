package com.tanzania.hemmy.mysystemdemographforme.Activities;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tanzania.hemmy.mysystemdemographforme.Dao.HistoryDao;
import com.tanzania.hemmy.mysystemdemographforme.Database.MsafiriDatabase;
import com.tanzania.hemmy.mysystemdemographforme.R;

public class RegisterActivity extends AppCompatActivity {


    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText("Total rows is " + 0);
        AccessDb accessDb = new AccessDb(textView,getApplicationContext());
        accessDb.execute();
    }

    private static class AccessDb extends AsyncTask<Void, Void, Void>{
        MsafiriDatabase msafiriDatabase;
        HistoryDao historyDao;
        @SuppressLint("StaticFieldLeak")
        Context context;
        int number;
        @SuppressLint("StaticFieldLeak")
        TextView textView;
        AccessDb(TextView textView, Context context){
            this.context = context;
            this.textView = textView;
        }
        @Override
        protected Void doInBackground(Void... voids) {
            msafiriDatabase = MsafiriDatabase.getDatabase(context);
            historyDao = msafiriDatabase.HistoryDao();
            number = historyDao.getHistoryCount();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            textView.setText("Total rows is " + number);
        }
    }
}
