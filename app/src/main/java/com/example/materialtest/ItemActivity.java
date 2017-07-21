package com.example.materialtest;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ItemActivity extends AppCompatActivity {

    public static final String ITEM_NAME = "item_name";

    public static final String ITEM_IMAGE_ID = "item_image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);
        Intent intent = getIntent();
        String itemName = intent.getStringExtra(ITEM_NAME);
        int itemImageId = intent.getIntExtra(ITEM_IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        ImageView itemImageView = (ImageView) findViewById(R.id.fruit_image_view);
        TextView itemContentText = (TextView) findViewById(R.id.fruit_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbar.setTitle(itemName);
        Glide.with(this).load(itemImageId).into(itemImageView);
        String fruitContent = generateItemContent(itemName);
        itemContentText.setText(fruitContent);
    }

    private String generateItemContent(String itemName) {
        StringBuilder fruitContent = new StringBuilder();
        for (int i = 0; i < 200; i++) {
            fruitContent.append(itemName);
        }
        return fruitContent.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
