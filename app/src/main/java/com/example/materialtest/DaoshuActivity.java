package com.example.materialtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class DaoshuActivity extends AppCompatActivity {

    private List<Daoshu> daoshuList = new ArrayList<Daoshu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daoshu);
        initDaoshu();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.daoshu_view);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        DaoshuAdapter adapter = new DaoshuAdapter(daoshuList);
        recyclerView.setAdapter(adapter);
    }

    private void initDaoshu() {
            Daoshu apple = new Daoshu("Apple", R.drawable.apple);
            daoshuList.add(apple);
    }



}
