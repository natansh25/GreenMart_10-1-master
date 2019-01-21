package infinity1087.android.com.examplehr;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

import infinity1087.android.com.examplehr.NavigationScreens.HelpActivity;
import infinity1087.android.com.examplehr.NavigationScreens.MyAccount;
import infinity1087.android.com.examplehr.NavigationScreens.SettingsActivity;
import infinity1087.android.com.examplehr.adapter.RecyclerItems;
import infinity1087.android.com.examplehr.ProductDetailModel.ResponseDetail;

public class DetailLayout extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener {

    private RecyclerView mRecyclerView;
    private RecyclerItems mAdapter;
    private List<ResponseDetail> mData;
    private RecyclerView.LayoutManager layoutManager;
    private boolean sort = true;
    private TextView txt_total, txt_pname, txt_price;
    private double itemamount = 0;
    private double itemquantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_navigation_trial);
        mRecyclerView = findViewById(R.id.recycler_view_detail);
        Intent i = getIntent();
        mData = (List<ResponseDetail>) i.getSerializableExtra("yyy");

        Log.d("ttt", String.valueOf(mData));
        txt_pname = (TextView) findViewById(R.id.txt_item_name);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        android.support.v7.widget.Toolbar toolbar = (android.support.v7.widget.Toolbar) findViewById(R.id.toolbar_detail);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view_detail);

        //to remove title from toolbar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        @SuppressLint("ResourceType") ArrayAdapter<String> dataA = new ArrayAdapter<String>(this, R.id.spinner);
        mAdapter = new RecyclerItems(mData, mData, this);
        setUpRecyclerView(mData);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // Handle navigation view item clicks here.
        int id = item.getItemId();

        Fragment fragment = null;
        if (id == R.id.nav_camera) {

            // Handle the camera action
            Intent home = new Intent(DetailLayout.this, MainActivity.class);
            startActivity(home);

        } else if (id == R.id.nav_gallery) {

            Intent i = new Intent(DetailLayout.this, MyAccount.class);
            startActivity(i);

        } else if (id == R.id.nav_slideshow) {

            Intent category = new Intent(DetailLayout.this, MainActivity.class);
            startActivity(category);

        } else if (id == R.id.nav_manage) {

            Intent wishList = new Intent(DetailLayout.this, MainActivity.class);
            startActivity(wishList);

        } else if (id == R.id.nav_settings) {

            Intent i = new Intent(DetailLayout.this, SettingsActivity.class);
            startActivity(i);

        } else if (id == R.id.nav_help) {

            Intent i = new Intent(DetailLayout.this, HelpActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        return true;

    }

    private void setUpRecyclerView(List<ResponseDetail> datumList) {

        //RecyclerView mRecyclerView = findViewById(R.id.recycler_view_detail);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // mAdapter = new RecyclerItems(datumList,datumList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }

    private void setUpRecyclerViewList(List<ResponseDetail> datumList) {

        //RecyclerView mRecyclerView = findViewById(R.id.recycler_view_detail);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        //  mAdapter = new RecyclerItems(datumList,datumList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item = String.valueOf(parent.getItemIdAtPosition(position));
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void btnAddtoCart(View view) {

        // TODO Add product to cart
        Intent i = new Intent(DetailLayout.this, MyCart.class);
        startActivity(i);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.filter, menu);

        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.searchbar, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchManager searchManager = (SearchManager) DetailLayout.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setSearchableInfo(searchManager
                .getSearchableInfo(this.getComponentName()));
        searchView.setMaxWidth(Integer.MAX_VALUE);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String query) {
                // filter recycler view when query submitted
                mAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String query) {
                // filter recycler view when text is changed
                mAdapter.getFilter().filter(query);
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch (id) {

            case R.id.action_price:

                Collections.sort(mData, ResponseDetail.BY_PRICE);
                mAdapter = new RecyclerItems(mData, mData, this);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

                break;

            case R.id.action_name:

                Collections.sort(mData, ResponseDetail.BY_NAME_Desending);
                mAdapter = new RecyclerItems(mData, mData, this);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

                break;

            case R.id.action_default:

                Collections.sort(mData, ResponseDetail.BY_NAME_Alphabetacally);
                mAdapter = new RecyclerItems(mData, mData, this);
                mRecyclerView.setAdapter(mAdapter);
                mAdapter.notifyDataSetChanged();

                break;

            case R.id.action_filter:

                if (sort) {
                    setUpRecyclerViewList(mData);
                    sort = true;
                }

                break;
//            case R.id.action_single:
//
//                if (sort) {
//                    setUpRecyclerView(mData);
//                    sort = true;
//                }
//
//                break;
        }

        return false;
    }

}
