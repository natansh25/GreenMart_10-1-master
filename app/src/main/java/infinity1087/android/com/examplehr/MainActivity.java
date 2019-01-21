package infinity1087.android.com.examplehr;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import infinity1087.android.com.examplehr.Fragment.SimpleFragmentPageAdapter;
import infinity1087.android.com.examplehr.NavigationScreens.HelpActivity;
import infinity1087.android.com.examplehr.NavigationScreens.MyAccount;
import infinity1087.android.com.examplehr.NavigationScreens.MyWishListActivity;
import infinity1087.android.com.examplehr.NavigationScreens.SettingsActivity;
import infinity1087.android.com.examplehr.Network.NetworkClass;
import infinity1087.android.com.examplehr.Services.ApiClient;
import infinity1087.android.com.examplehr.Services.ApiInterface;
import infinity1087.android.com.examplehr.ViewPager.LoginViewPager;
import infinity1087.android.com.examplehr.adapter.RecyclerAdapter;
import infinity1087.android.com.examplehr.loginFragments.SignIn;
import infinity1087.android.com.examplehr.loginFragments.SignUp;
import infinity1087.android.com.examplehr.model.BannerResults;
import infinity1087.android.com.examplehr.model.BannerTrial;
import infinity1087.android.com.examplehr.ProductDetailModel.ResponseDetail;
import infinity1087.android.com.examplehr.ProductDetailModel.ResultList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static infinity1087.android.com.examplehr.loginFragments.SignUp.signup_email;
import static infinity1087.android.com.examplehr.loginFragments.SignUp.signup_name;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
// http://portfolio.barodaweb.com/Dynamic/egreenapi/api/ProductGroupId/Get

    //New
//    http://portfolio.barodaweb.com/Dynamic/egreenapi/api/Product/Get

//    image base url
//    http://image.barodaweb.net/api/EGreen/Magic/200/ProductGroup-Vegetables/a1.jpg/100
//    http://image.barodaweb.net/api/EGreen/Magic/<Width>/ProductGroup-<ProductGroupName>/<ProductImage>/<Quality>

//    Final product
    //http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/1/BindProductByProductGroupID

//    BaseImg Url  http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/
//    @get :api/banner/BindBanner

//   http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/swagger/ui/index
//    http://portfolio.barodaweb.com/Dynamic/EGreenMarket/
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ApiInterface apiInterface;
    private List<ResponseDetail> results;
    private List<BannerResults> mBannerResults;
    private ProgressBar mProgressBar;

    Button btnForget;
    List<BannerTrial> mPojos = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        android.support.v4.view.ViewPager viewPager = (android.support.v4.view.ViewPager) findViewById(R.id.viewpager);
        SimpleFragmentPageAdapter adapter = new SimpleFragmentPageAdapter(this, getSupportFragmentManager());
        mProgressBar=findViewById(R.id.progress_bar);

        //to remove title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // Set the adapter onto the view pager
        viewPager.setAdapter(adapter);

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_detail);

        View view = navigationView.getHeaderView(0);
        ImageView img = view.findViewById(R.id.img_header);
        TextView txt_name = view.findViewById(R.id.txt_username);
        TextView txt_lastname = view.findViewById(R.id.edt_lname);
        TextView txt_email = view.findViewById(R.id.txt_email);

        if (SignIn.user_image != null) {
            Picasso.get().load(SignIn.user_image).error(R.drawable.ic_launcher_background).placeholder(R.drawable.ic_launcher_background).into(img);
        }
        if (SignIn.user_name != null) {
            txt_name.setText(SignIn.user_name);
        }
        if (SignIn.user_mail != null) {
            txt_email.setText(SignIn.user_mail);
        }
        if (signup_name != null) {
            txt_name.setText(signup_name);
        }
        if (signup_email != null) {
            txt_email.setText(signup_email);
        }

        navigationView.setNavigationItemSelectedListener(this);
    //  ------------------------ our code begins-------------------
        setupRecyclerView();

        callAsyncForBanner();

    }

    private void callAsyncForBanner() {

        URL url = NetworkClass.buildURl(NetworkClass.BANNER_BASE_URL);

        new MyAsyncBanner().execute(url);

    }

    private void callRetrofit(int i) {

        apiInterface = ApiClient.getApiClient(ApiClient.BASE_URL).create(ApiInterface.class);
        Call<ResultList> call = apiInterface.getcontacts(i);

        call.enqueue(new Callback<ResultList>() {

            @Override
            public void onResponse(Call<ResultList> call, Response<ResultList> response) {

                Log.d("shifu", String.valueOf(response.raw().request().url()));
                results = response.body().getResponseData();
                Intent i = new Intent(MainActivity.this, DetailLayout.class);
                i.putExtra("yyy", (Serializable) results);
                mProgressBar.setVisibility(View.INVISIBLE);
                startActivity(i);

            }

            @Override
            public void onFailure(Call<ResultList> call, Throwable t) {

                Log.d("xyz", String.valueOf(t.getMessage()));

            }
        });
    }

    private void setupRecyclerView() {

        mRecyclerView = findViewById(R.id.recyclerView);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclerView.setLayoutManager(layoutManager);

    }

    @Override
    public void onBackPressed() {

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setCancelable(false)
                .setNegativeButton("no", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                })
                .setPositiveButton("yes", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface arg0, int arg1) {
                        MainActivity.this.finish();
                        Intent intent = new Intent(Intent.ACTION_MAIN);
                        intent.addCategory(Intent.CATEGORY_HOME);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(intent);

                    }

                }).create().show();

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }

        else {

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {

            SignIn.mGoogleSignInClient.signOut();
            Intent i = new Intent(this, LoginViewPager.class);
            SignUp.signup_name="";
            SignUp.signup_email="";
            startActivity(i);
            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_camera) {
            // Handle the camera action
            Intent home  = new Intent(MainActivity.this, MainActivity.class);
            startActivity(home);
        } else if (id == R.id.nav_gallery) {

            Intent i = new Intent(MainActivity.this,MyAccount.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

            Intent category  = new Intent(MainActivity.this, MainActivity.class);
            startActivity(category);

        } else if (id == R.id.nav_manage) {
            Intent wishList  = new Intent(MainActivity.this, MyWishListActivity.class);
            startActivity(wishList);
        }

        else if (id == R.id.nav_settings) {

            Intent i = new Intent(MainActivity.this, SettingsActivity.class);
            startActivity(i);
        }
        else if (id == R.id.nav_help) {

            Intent i = new Intent(MainActivity.this, HelpActivity.class);
            startActivity(i);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;
    }

    public void img_btn_vegg(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        callRetrofit(2);
    }

    public void img_btn_fruits(View view) {
        mProgressBar.setVisibility(View.VISIBLE);
        callRetrofit(1);
    }

    public void img_btn_waffer(View view) {

        Toast.makeText(this, "url not yet formed !!", Toast.LENGTH_SHORT).show();
        //callRetrofit(3);
    }

    public void img_btn_milk(View view) {

        Toast.makeText(this, "url not yet formed !!", Toast.LENGTH_SHORT).show();
        //callRetrofit(4);

    }

    public class MyAsyncBanner extends AsyncTask<URL, Void, List<BannerTrial>> {

        @Override
        protected List<BannerTrial> doInBackground(URL... urls) {

            mPojos = NetworkClass.fetchBannerData(urls[0]);
            return mPojos;

        }

        @Override
        protected void onPostExecute(List<BannerTrial> bannerTrials) {
            super.onPostExecute(bannerTrials);

            mAdapter = new RecyclerAdapter(mPojos);
            mRecyclerView.setAdapter(mAdapter);

        }

    }

}
