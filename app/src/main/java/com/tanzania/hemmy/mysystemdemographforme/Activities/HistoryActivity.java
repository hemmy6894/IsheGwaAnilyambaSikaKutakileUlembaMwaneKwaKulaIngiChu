package com.tanzania.hemmy.mysystemdemographforme.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.tanzania.hemmy.mysystemdemographforme.Class.History;
import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {

    ListView listView;
    TextView textView;
    TextView drawer_title;
    ProgressBar progressBar;

    ArrayList<History> populatedMode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


}

