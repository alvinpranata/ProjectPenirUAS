package com.example.alvinpranata.project;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    public ViewPager vp;
    public TabLayout tabs;
    public NavigationView nv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vp = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(vp);


        tabs = (TabLayout) findViewById(R.id.tabs);
        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                vp.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

        vp.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                TabLayout.Tab tab = tabs.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        nv = (NavigationView) findViewById(R.id.nav_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                DrawerLayout dl = (DrawerLayout) findViewById(R.id.drawer);
                dl.closeDrawers();

                switch (item.getItemId()) {
                    case R.id.menuHome:
                        nv.getMenu().getItem(0).setChecked(true);
                        break;
                    case R.id.menuLogin:
                        nv.getMenu().getItem(1).setChecked(true);
                        break;
                    case R.id.menuRegister:
                        nv.getMenu().getItem(2).setChecked(true);
                        break;
                    case R.id.menuLogout:
                        nv.getMenu().getItem(3).setChecked(true);
                        break;
                }
                return false;

            }
        });



    }
    private void setupViewPager(ViewPager vp) {
        Adapter adapter = new Adapter(getSupportFragmentManager());
        adapter.addFragment(new CardFunnyFragment());
        adapter.addFragment(new CardPrankFragment());
        adapter.addFragment(new CardCompilationFragment());
        adapter.addFragment(new CardDailyFragment());
        vp.setAdapter(adapter);
    }

}
