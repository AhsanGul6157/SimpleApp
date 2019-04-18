package com.example.ahsannaveed.foodpandaappclone;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ViewPagerActivity extends AppCompatActivity {
        private static TextView setDeliveryTimeText;
    public static String time = "";
    public static String date = "";
    ImageView topImageView;

    //    private CardView horizontalCardView;
    String url = "https://firebasestorage.googleapis.com/v0/b/foodpandaappclone.appspot.com/o/food_images%2FFirst.png?alt=media&token=45fd5313-0371-4d37-a031-7273a8ed2957";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);
        topImageView = findViewById(R.id.top_image);
        setDeliveryTimeText = findViewById(R.id.delivery_time_text_view);

        //tab layout
        addTab();
        //cardview listener method
//        setHorizontalCardView();
        //laoad image
        Glide.with(this).load(url).into(topImageView);
        setDeliveryTimeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               AlertDialog(topImageView);

            }
        });

    }

    //adding tab layout
    public void addTab() {
        TabLayout tabLayout = findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("EXCLUSIVE DISCOUNTED DEALS"));
        tabLayout.addTab(tabLayout.newTab().setText("SOUP"));
        tabLayout.addTab(tabLayout.newTab().setText("SALADS"));
        tabLayout.addTab(tabLayout.newTab().setText("HANDI SPECIALATIES"));
//        tabLayout.addTab(tabLayout.newTab().setText("SPECIALATIES"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);
        //now setting the pager view
        final ViewPager viewPager = findViewById(R.id.pager);
        final ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    public void AlertDialog(View view) {
        ExampleDialog dialog = new ExampleDialog();
        dialog.show(getSupportFragmentManager(), "Example Dialog");

    }

    public static void updateTimeDate() {
        setDeliveryTimeText.setText(time + ", " + date);
    }


}
