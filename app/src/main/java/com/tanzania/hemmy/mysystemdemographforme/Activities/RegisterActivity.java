package com.tanzania.hemmy.mysystemdemographforme.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.tanzania.hemmy.mysystemdemographforme.Dao.HistoryDao;
import com.tanzania.hemmy.mysystemdemographforme.Database.MsafiriDatabase;
import com.tanzania.hemmy.mysystemdemographforme.R;

public class RegisterActivity extends AppCompatActivity {

    MsafiriDatabase msafiriDatabase;
    HistoryDao historyDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        msafiriDatabase = MsafiriDatabase.getDatabase(getApplicationContext());
        historyDao = msafiriDatabase.HistoryDao();
        TextView textView = (TextView)findViewById(R.id.textView2);
        int id = historyDao.getHistoryCount();
        textView.setText("Total rows is " + id);
    }
}
