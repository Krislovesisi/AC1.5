package com.example.materialtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class DaoshuActivity extends AppCompatActivity {

    private List<Daoshu> daoshuList = new ArrayList<Daoshu>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.daoshu);
        initDaoshu();
        DaoshuAdapter adapter = new DaoshuAdapter(DaoshuActivity.this, R.layout.daoshu_item, daoshuList);
        ListView listView = (ListView) findViewById(R.id.daoshu_list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Daoshu daoshu = daoshuList.get(position);
                Toast.makeText(DaoshuActivity.this, daoshu.getDaoshuname(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initDaoshu() {
        Daoshu ch01 = new Daoshu("为什么要学数学",R.drawable.ch01);
        daoshuList.add(ch01);
        Daoshu ch02 = new Daoshu("数学过敏症对策",R.drawable.ch02);
        daoshuList.add(ch02);
        Daoshu ch03 = new Daoshu("导数有什么用",R.drawable.ch03);
        daoshuList.add(ch03);
        Daoshu ch04 = new Daoshu("某一点的斜率和瞬间斜率",R.drawable.ch04);
        daoshuList.add(ch04);
        Daoshu ch05 = new Daoshu("曲线的高峰",R.drawable.ch05);
        daoshuList.add(ch05);
        Daoshu ch06 = new Daoshu("如何画曲线图",R.drawable.ch06);
        daoshuList.add(ch06);
        Daoshu ch07 = new Daoshu("如何使用导数",R.drawable.ch07);
        daoshuList.add(ch07);
        Daoshu ch08 = new Daoshu("用导数处理图像",R.drawable.ch08);
        daoshuList.add(ch08);
        Daoshu ch09 = new Daoshu("如何求斜率",R.drawable.ch09);
        daoshuList.add(ch09);
        Daoshu ch10 = new Daoshu("怎样在曲线上取两点",R.drawable.ch10);
        daoshuList.add(ch10);
        Daoshu ch11 = new Daoshu("使曲线上的两点不断接近",R.drawable.ch11);
        daoshuList.add(ch11);
        Daoshu ch12 = new Daoshu("什么是极限",R.drawable.ch12);
        daoshuList.add(ch12);
        Daoshu ch13 = new Daoshu("什么是无限接近",R.drawable.ch13);
        daoshuList.add(ch13);
        Daoshu ch14 = new Daoshu("怎样利用数学算式表示极限",R.drawable.ch14);
        daoshuList.add(ch14);
        Daoshu ch15 = new Daoshu("极值的求法和表示方法",R.drawable.ch15);
        daoshuList.add(ch15);
    }

}
