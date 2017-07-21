package com.example.materialtest;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    private Home_Item[] homeItems = {new Home_Item("为什么要学数学", R.drawable.apple), new Home_Item("数学过敏症", R.drawable.banana),
            new Home_Item("积分先生", R.drawable.orange), new Home_Item("导数先生", R.drawable.watermelon),
            new Home_Item("微积分的历史", R.drawable.pear), new Home_Item("微积分的应用", R.drawable.grape)};

    private List<Home_Item> homeItemList = new ArrayList<>();

    private ItemAdapter adapter;

    //private SwipeRefreshLayout swipeRefresh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        NavigationView navView = (NavigationView) findViewById(R.id.nav_view);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_menu);
        }
        navView.setCheckedItem(R.id.nav_host);
        navView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                int id = item.getItemId();
               switch (id){
                   case R.id.nav_host:
                       mDrawerLayout.closeDrawers();
                       break;
               }

               mDrawerLayout.closeDrawer(Gravity.LEFT);
               return true;
            }
        });


        iniHomeItem();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new ItemAdapter(homeItemList);
        recyclerView.setAdapter(adapter);
        //swipeRefresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        //swipeRefresh.setColorSchemeResources(R.color.colorPrimary);
        /*swipeRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshFruits();
            }
        });*/
    }

    /*private void refreshFruits() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        iniHomeItem();
                        adapter.notifyDataSetChanged();
                        swipeRefresh.setRefreshing(false);
                    }
                });
            }
        }).start();
    }*/

    private void iniHomeItem() {
        homeItemList.clear();
        Home_Item a = new Home_Item("为什么要学数学",R.drawable.apple);
        homeItemList.add(a);
        Home_Item b = new Home_Item("数学过敏症",R.drawable.banana);
        homeItemList.add(b);
        Home_Item c = new Home_Item("积分先生",R.drawable.orange);
        homeItemList.add(c);
        Home_Item d = new Home_Item("导数先生",R.drawable.watermelon);
        homeItemList.add(d);
        Home_Item e = new Home_Item("微积分的历史",R.drawable.pear);
        homeItemList.add(e);
        Home_Item f = new Home_Item("微积分的应用",R.drawable.grape);
        homeItemList.add(f);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(this, "You clicked Backup", Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(this, "You clicked Delete", Toast.LENGTH_SHORT).show();
                break;
            case R.id.settings:
                Toast.makeText(this, "You clicked Settings", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

}
