package com.example.ahsannaveed.foodpandaappclone;

import android.animation.ObjectAnimator;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.FirebaseUserMetadata;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView createAccountText_Login;
    private FirebaseAuth mAuth;
    private FirebaseUser mUser;
    private RecyclerView recyclerView;
    private NavigationView navigationView;
    private HorizontalRecycler adapter;
    private SeocndHorizontalAdapter adapter1;
    Retrofit retrofit;
    private DatabaseReference mDatabase;
    private TextView heading_Title_Text;
    //seocnd recycler
    private RecyclerView secondRecyclerView;
    private RecyclerView mainRecyclerView;
    private MainRecyclerViewAdapter mainRecyclerViewAdapter;
    //   LinearLayout horizontalLayout;
    ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createAccountText_Login = findViewById(R.id.create_account);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView = findViewById(R.id.recycler_view);
        secondRecyclerView = findViewById(R.id.seocnd_recycler_view);
        mainRecyclerView = findViewById(R.id.main_recycler_view);
//        progressBar = findViewById(R.id.progressBar);

        setSupportActionBar(toolbar);
        //step4.. create retrofit object
        retrofit = new Retrofit.Builder()
                .baseUrl(ApiInterface.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        //now create your api object means api class in your case it is ApiInterface
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("FoodPanda");
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        progressDialog.show();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);
        Call<List<Model>> call = apiInterface.getData();
        call.enqueue(new Callback<List<Model>>() {
            @Override
            public void onResponse(Call<List<Model>> call, Response<List<Model>> response) {
                loadDataList(response.body());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<Model>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t, Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }

        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


        navigationView = (NavigationView) findViewById(R.id.nav_view);
        hideMenuItems();
        navigationView.setNavigationItemSelectedListener(this);
//        navigationView.getMenu().findItem(R.id.nav_log_out).setVisible(false);
        navigationView.getMenu().findItem(R.id.nav_log_out).setVisible(true);
        navigationView.getMenu().findItem(R.id.nav_my_profile).setVisible(true);
        navigationView.getMenu().findItem(R.id.nav_my_addresses).setVisible(true);
        navigationView.getMenu().findItem(R.id.nav_my_vouchers).setVisible(true);
        navigationView.getMenu().findItem(R.id.nav_help_center).setVisible(true);


        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View view = navigationView.getHeaderView(0);
//        if (mUser != null) {
//
//            createAccountText_Login = view.findViewById(R.id.create_account);
//            FirebaseUserMetadata name = mUser.getMetadata();
//            createAccountText_Login.setText((CharSequence) name);
//        }

//    showData();
        //calling second datalist method
        secondApiInterface();
        //main datalist method call
        getMainApiInterface();
        //load spinner
//        loadProgressbarSpinner();


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }


        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();


        if (id == R.id.nav_my_orders) {
            // Handle the camera action

        } else if (id == R.id.nav_help_center) {

        } else if (id == R.id.nav_invite_friends) {

        } else if (id == R.id.nav_settings) {

        } else if (id == R.id.nav_tersm_conditions) {

        } else if (id == R.id.nav_log_out) {
//
            navigationView.getMenu().findItem(R.id.nav_log_out).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_my_profile).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_my_vouchers).setVisible(false);
            navigationView.getMenu().findItem(R.id.nav_my_addresses).setVisible(false);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);


        return true;
    }

    //hide menu items before log in
    private void hideMenuItems() {

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        Menu nav_menu = navigationView.getMenu();

        nav_menu.findItem(R.id.nav_my_profile).setVisible(false);
        nav_menu.findItem(R.id.nav_my_addresses).setVisible(false);
        nav_menu.findItem(R.id.nav_my_vouchers).setVisible(false);
        nav_menu.findItem(R.id.nav_log_out).setVisible(false);

    }

    public void login_Create_Account(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }


    private void loadDataList(List<Model> dataList) {
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        adapter = new HorizontalRecycler(dataList, MainActivity.this);
        //setting layout manager on adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(adapter);

    }

    //loadData for second recycler view
    private void loadDataList1(List<SecondModel> dataList1) {
        secondRecyclerView = findViewById(R.id.seocnd_recycler_view);
        secondRecyclerView.setHasFixedSize(true);
        adapter1 = new SeocndHorizontalAdapter(dataList1, MainActivity.this);
        //setting layout manager on adapter
        secondRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        secondRecyclerView.setAdapter(adapter1);

    }

    //second listApi Interface method created here and called in on create method
    public void secondApiInterface() {

        retrofit = new Retrofit.Builder()
                .baseUrl(SecondApiInterface.BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("FoodPanda");
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        progressDialog.show();
        //now create your api object means api class in your case it is ApiInterface
        SecondApiInterface apiInterface = retrofit.create(SecondApiInterface.class);
        Call<List<SecondModel>> call = apiInterface.getData1();
        call.enqueue(new Callback<List<SecondModel>>() {
            @Override
            public void onResponse(Call<List<SecondModel>> call, Response<List<SecondModel>> response) {
                loadDataList1(response.body());
                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<SecondModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "" + t, Toast.LENGTH_SHORT).show();
            }

        });

    }

    //main recycler
    private void loadDataListMain(List<MainModel> dataListMain) {
        mainRecyclerView = findViewById(R.id.main_recycler_view);
        mainRecyclerView.setHasFixedSize(true);
        mainRecyclerViewAdapter = new MainRecyclerViewAdapter(dataListMain, MainActivity.this);
        //setting layout manager on adapter
        mainRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mainRecyclerView.setAdapter(mainRecyclerViewAdapter);

    }

    //main listApi Interface method, called int the on create method
    public void getMainApiInterface() {

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("FoodPanda");
        progressDialog.setMessage("Please Wait");
        progressDialog.setCancelable(false);

        progressDialog.show();

        MainApiInterface mainApiInterface = retrofit.create(MainApiInterface.class);
        Call<List<MainModel>> call = mainApiInterface.getDataMain();
        call.enqueue(new Callback<List<MainModel>>() {
            @Override
            public void onResponse(Call<List<MainModel>> call, Response<List<MainModel>> response) {
                loadDataListMain(response.body());
                progressDialog.dismiss();
            }

            @Override
            public void onFailure(Call<List<MainModel>> call, Throwable t) {

            }
        });

    }

    public void firstHorizontalclciked(View view) {
        Intent intent = new Intent(MainActivity.this, ViewPagerActivity.class);
        startActivity(intent);
    }

//    public void loadProgressbarSpinner() {
////       progressBar.se
//    }


}
