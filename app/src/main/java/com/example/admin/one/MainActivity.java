package com.example.admin.one;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin.one.adapter.FragmentAdapter;
import com.example.admin.one.fragment.JRFragment;
import com.example.admin.one.fragment.RTFragment;
import com.example.admin.one.fragment.ZLFragment;
import com.example.admin.one.fragment.ZXFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TabLayout tab_layout;
    private ViewPager view_pager;
    private List<Fragment> list;
    private FragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tab_layout = (TabLayout) findViewById(R.id.tab_layout);
        view_pager = (ViewPager) findViewById(R.id.view_pager);
         initData();
    }

    private void initData() {
        list = new ArrayList<>();
        list.add(new ZXFragment());
        list.add(new ZLFragment());
        list.add(new RTFragment());
        list.add(new JRFragment());
        adapter = new FragmentAdapter(getSupportFragmentManager());
        adapter.setFragment(list);
        view_pager.setAdapter(adapter);
        for (int i = 0; i < list.size(); i++) {
            tab_layout.addTab(tab_layout.newTab());
        }
        tab_layout.setupWithViewPager(view_pager);
        tab_layout.getTabAt(0).setText("最新日报");
        tab_layout.getTabAt(1).setText("专栏");
        tab_layout.getTabAt(2).setText("热点");
        tab_layout.getTabAt(3).setText("主题日报");


    }


}
