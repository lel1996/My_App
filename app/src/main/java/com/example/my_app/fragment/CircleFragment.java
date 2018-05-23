package com.example.my_app.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.my_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CircleFragment extends Fragment {
private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment>fragments;
private View view;
    public CircleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_circle, container, false);
        initView();
        init();
        return view;
    }

    private void init() {
    fragments=new ArrayList<>();
        fragments.add(new NewsFragment());
        fragments.add(new VideoFragment());
        fragments.add(new ImageFragment());

        viewPager.setAdapter(new pageAdapter(getChildFragmentManager()));

        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText("新闻");
        tabLayout.getTabAt(1).setText("视频");
        tabLayout.getTabAt(2).setText("图片");



    }

    public class pageAdapter extends FragmentPagerAdapter{
        public pageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }

    private void initView() {
        tabLayout= (TabLayout) view.findViewById(R.id.tableLayout);
        viewPager= (ViewPager) view.findViewById(R.id.viewpage);
    }

}
