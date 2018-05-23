package com.example.my_app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.my_app.fragment.CircleFragment;
import com.example.my_app.fragment.FindFragment;
import com.example.my_app.fragment.MeFragment;
import com.example.my_app.fragment.MessageFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar
        .OnTabSelectedListener {
private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> mFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        init();
    }

    private void init() {
        mFragment=new ArrayList<>();

        mFragment.add(new CircleFragment());
        mFragment.add(new FindFragment());
        mFragment.add(new MessageFragment());
        mFragment.add(new MeFragment());

        bottomNavigationBar.addItem(new BottomNavigationItem(R.drawable.circle,"动态"))
                .addItem(new BottomNavigationItem(R.drawable.find,"发现"))
                .addItem(new BottomNavigationItem(R.drawable.message,"消息"))
                .addItem(new BottomNavigationItem(R.drawable.me,"我"))
                 .setMode(BottomNavigationBar.MODE_FIXED)
                  .initialise();

        bottomNavigationBar.setTabSelectedListener(this);

       setDefault(0);



    }

    private void setDefault(int postion) {
        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.fragment,mFragment.get(postion));
        ft.commit();
    }

    private void initView() {
        bottomNavigationBar= (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_container);
    }

    @Override
    public void onTabSelected(int position) {
        mFragment.get(position);

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
