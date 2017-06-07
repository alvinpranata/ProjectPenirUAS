package com.example.alvinpranata.projectpeniruas;

import android.content.Context;
import android.os.StrictMode;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public ViewPager viewPager;
    public TabLayout tabLayout;
    public NavigationView navigationView;
    private MenuItem previousSelectedMenuItem;
    public DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_coordinator);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Toolbar toolbar = ((Toolbar) findViewById(R.id.toolbar));


        //Memberi tahu android untuk menggunakan toolbar sebagai pengganti Action Bar
        setSupportActionBar(toolbar);//kalo gk pake ini, nanti ada toolbar dan action bar terpisah

        ActionBar bar = getSupportActionBar();
        if(bar != null){
            bar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);
            bar.setDisplayHomeAsUpEnabled(true);
        }


        //Setup view pager
        viewPager = ((ViewPager) findViewById(R.id.viewpager));

        //Sinkronisasi tab dengan view pager
        tabLayout = ((TabLayout) findViewById(R.id.tabs));

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);


        //Kalo tabnya di klik
        //Mengaur fragment yang ditampilkan di view pager ketika tab dipilih
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //Tampilkan halaman yang sesuai dengan nomor tab
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        //Kalo swipe
        //Mengatur tab yang dipilih ketika halaman di viewPager berubah
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                //Ambil tab yang sesuai dengan nomor halaman (page)
                TabLayout.Tab tab = tabLayout.getTabAt(position);
                tab.select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        //Setup ReadData
        ReadDataFresh readData = new ReadDataFresh(this);
        readData.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=fresh");
        ReadDataHot readData2 = new ReadDataHot(this);
        readData2.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=hot");
        mainActivity=this;
        this.setTitle("Home");

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                //Matikan menu yang dipilih sebelumnya
                if(previousSelectedMenuItem != null)
                    previousSelectedMenuItem.setChecked(false);

                //membuat item yang dipilih menjaqdi aktif
                item.setChecked(true);

                //menyimpan item yang dipilih
                previousSelectedMenuItem=item;


                switch (item.getItemId()){
                    case R.id.itemHome:
                        /*navigationView.getMenu().getItem(0).setChecked(true);*/
                        break;
                    case R.id.itemMeme:
                        ReadDataFresh readDataMeme = new ReadDataFresh(mainActivity);
                        ReadDataHot readDataMeme2 = new ReadDataHot(mainActivity);
                        readDataMeme.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=freshKategori&id=2");
                        readDataMeme2.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=hotKategori&id=2");
                        mainActivity.setTitle("Meme");
                        break;
                    case R.id.itemAnimal:
                        ReadDataFresh readDataAnimal = new ReadDataFresh(mainActivity);
                        ReadDataHot readDataAnimal2 = new ReadDataHot(mainActivity);
                        readDataAnimal.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=freshKategori&id=1");
                        readDataAnimal2.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=hotKategori&id=1");
                        mainActivity.setTitle("Animal");
                        break;
                    case R.id.itemMovie:
                        ReadDataFresh readDataMovie = new ReadDataFresh(mainActivity);
                        ReadDataHot readDataMovie2 = new ReadDataHot(mainActivity);
                        readDataMovie.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=freshKategori&id=3");
                        readDataMovie2.execute("http://103.52.146.34/penir/penir06/manage.php?cmd=hotKategori&id=3");
                        mainActivity.setTitle("Movie");
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        //Listener untuk FAB
        FloatingActionButton floatingActionButton = ((FloatingActionButton) findViewById(R.id.floatingActionButton));
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Tampilkan SnackBar
                Snackbar.make(v,"FAB ditekan !",Snackbar.LENGTH_SHORT).setAction("Open Menu", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        drawerLayout.openDrawer(GravityCompat.START);
                    }
                }).show();
            }
        });




    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            drawerLayout.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //Guna inflate mengganti file xml menjadi tampilan layout
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
    public static Adapter adapter;
    private void setupViewPager(){
        //Buat adapter

        adapter = new Adapter(getSupportFragmentManager());
        CardHotFragment cardContent = new CardHotFragment();
        CardFreshFragment cardFresh = new CardFreshFragment();
        cardFresh.newInstance(freshs);
        cardContent.newInstance(hots);

        //Tambahkan semua fragment yang dibutuhkan
        adapter.addFragment(cardContent);
        adapter.addFragment(new CardFreshFragment());

        //Atur adapter ini ke ViewPager
        viewPager.setAdapter(adapter);
    }

    public static ArrayList<Post> freshs;
    public static ArrayList<Post> hots;
    public static  MainActivity mainActivity=null;
    public static void readDataFinishFresh(Context context, String result){
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            freshs = new ArrayList<>();
            //iterasi sebanytak jumlah JSONObject pada JSonArray
            for(int i=0; i<jsonArray.length();i++){
                JSONObject user = jsonArray.getJSONObject(i);
                String title = user.getString("title");
                int id = user.getInt("id");
                String tanggal = user.getString("tanggal");
                String gambar = user.getString("gambar");
                String kategori = user.getString("kategori");
                int like = user.getInt("like");
                freshs.add(new Post(id,title,tanggal,gambar,kategori,like));
            }
            for (Post fresh : freshs) {
                Log.d("fresh", fresh.toString());
            }
            mainActivity.setupViewPager();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
    public static void readDataFinishHot(Context context, String result){
        try {
            JSONObject jsonObject = new JSONObject(result);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            hots = new ArrayList<>();
            //iterasi sebanytak jumlah JSONObject pada JSonArray
            for(int i=0; i<jsonArray.length();i++){
                JSONObject user = jsonArray.getJSONObject(i);
                String title = user.getString("title");
                int id = user.getInt("id");
                String tanggal = user.getString("tanggal");
                String gambar = user.getString("gambar");
                String kategori = user.getString("kategori");
                int like = user.getInt("like");
                hots.add(new Post(id,title,tanggal,gambar,kategori,like));
            }
            for (Post hot : hots) {
                Log.d("hot", hot.toString());
            }
            mainActivity.setupViewPager();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }


}
