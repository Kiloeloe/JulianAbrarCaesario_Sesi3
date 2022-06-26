package com.example.pertemuan3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    Button logout;
    TextView username;
    PageAdapter pageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        logout = findViewById(R.id.btn_logout);
        username = findViewById(R.id.tv_username);

        Intent intent =getIntent();
        String tempUsername = intent.getStringExtra("account_username");


        username.setText(tempUsername);
        setViewPager2(viewPager2);

        new TabLayoutMediator(tabLayout,viewPager2,((tab, position) -> {
            tab.setText(pageAdapter.getFragmentTitle(position));
        })).attach();

        logout.setOnClickListener( v ->{
            Intent logoutIntent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(logoutIntent);
        });
    }

    private void setViewPager2(viewPager2 viewPager2){
        if(pageAdapter == null){
            pageAdapter = new PageAdapter(this);
            pageAdapter.addFragment(new HomeFragment(),"home");
            pageAdapter.addFragment(new SecondFragment(),"sSecond");
            viewPager2.setAdapter(pageAdapter);
        }
    }
}