package com.tanzania.hemmy.mysystemdemographforme.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.tanzania.hemmy.mysystemdemographforme.Class.Token;
import com.tanzania.hemmy.mysystemdemographforme.Dao.TokenDao;
import com.tanzania.hemmy.mysystemdemographforme.Database.MsafiriDatabase;
import com.tanzania.hemmy.mysystemdemographforme.R;
import com.tanzania.hemmy.mysystemdemographforme.Repository.HistoryRepository;

public class StartingActivity extends AppCompatActivity {

    MsafiriDatabase msafiriDatabase;
    TokenDao tokenDao;
    private boolean isLogedOn = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting);

        msafiriDatabase = MsafiriDatabase.getDatabase(getApplicationContext());
        tokenDao = msafiriDatabase.TokenDao();

        new Thread() {
            public void run() {
                try {
                    ProgressBar progressBar = (ProgressBar)findViewById(R.id.progress_bar);
                    progressBar.setVisibility(View.VISIBLE);
                    Token token[] = tokenDao.getCustomer(false);
                    if(token.length < 1){
                        Log.e("TokenDb","Users is loged out");
                    }else{
                        String[] statuses = new String[]{"on_hold","history","ticket"};
                        for(String status : statuses ){
                            HistoryRepository repoHis = new HistoryRepository();
                            repoHis.loadHistoryData(status);
                        }
                        Log.e("TokenDb","Users is logged in");
                        isLogedOn = true;
                    }

                    sleep(6000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    Log.e("TokenDb","Finished");
                    Intent intent;
                    if(isLogedOn){
                        intent = new Intent(StartingActivity.this,UsersActivity.class);
                    }else{
                        intent = new Intent(StartingActivity.this,RegisterActivity.class);
                    }
                    startActivity(intent);
                    finish();
                }
            }
        }.start();
    }
}
