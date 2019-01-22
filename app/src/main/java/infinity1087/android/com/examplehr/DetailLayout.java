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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import infinity1087.android.com.examplehr.NavigationScreens.HelpActivity;
import infinity1087.android.com.examplehr.NavigationScreens.MyAccount;
import infinity1087.android.com.examplehr.NavigationScreens.SettingsActivity;
import infinity1087.android.com.examplehr.ProductDetailModel.PriceDetails;
import infinity1087.android.com.examplehr.ProductDetailModel.RoomModel;
import infinity1087.android.com.examplehr.Roomdatabase.AppDatabase;
import infinity1087.android.com.examplehr.RoundedTransformation.RoundedTransformation;
import infinity1087.android.com.examplehr.adapter.RecyclerItems;
import infinity1087.android.com.examplehr.ProductDetailModel.ResponseDetail;
import infinity1087.android.com.examplehr.appExecuter.AppExecutors;

public class DetailLayout extends AppCompatActivity implements AdapterView.OnItemSelectedListener, NavigationView.OnNavigationItemSelectedListener, RecyclerItems.AddToCartItemClickListner {

    private RecyclerView mRecyclerView;
    private RecyclerItems mAdapter;
    private List<ResponseDetail> mData;
    private RecyclerView.LayoutManager layoutManager;
    private boolean sort = true;
    private TextView txt_total, txt_pname, txt_price;
    private double itemamount = 0;
    private double itemquantity = 0;
    private AppDatabase mDb;

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
        mAdapter.setOnItemCliackListner(this);
        setUpRecyclerView(mData);
        navigationView.setNavigationItemSelectedListener(this);
        mDb = AppDatabase.getDatabase(getApplicationContext());

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

    @Override
    public void onListItemClick(ResponseDetail responseDetail, String price) {


        //TODO read below
        //on clicking the add button i have saved the data into room database you can see it using setho
        //in the cart activity just setup a recycler view
        //make a new adpter and in the cart activity using AppExecuter get all the list
        //of products saved as list call the query look some room examples if you dont get this.
        //and just pass this to the recycler view
        // i have done little code for getting the list in cart activity just submit this list to recyclerview
        //and lastly put myCart activity intent on the cart icon 


        final RoomModel model=new RoomModel();
        model.setName(responseDetail.getP().getProductName());
        model.setPrice(price);
        String image="http://image.barodaweb.net/api/EGreen/Magic/270/Product-" + responseDetail.getP().getProductId() + "/" + responseDetail.getP().getProductImage() + "/100";
        model.setImage(image);
        AppExecutors.getInstance().diskIO().execute(new Runnable() {
            @Override
            public void run() {
                mDb.movieDao().insert(model);
            }
        });


        Toast.makeText(this, "hulaaa", Toast.LENGTH_SHORT).show();
       /* Intent i = new Intent(this, MyCart.class);
        startActivity(i);*/


        //PriceDetails details = responseDetail.getPriceDetail().get(0);
/*
        final List<String> mList = new ArrayList<>();

        //mList.clear();
        for (i = 0; i < size; i++) {

            PriceDetails details2 = datum.getPriceDetail().get(i);
            mList.add(String.valueOf(details2.getPP().getWeight() + " " + details2.getPU().getUnitName() + " - " + details2.getPP().getSellCost() + "₹"));

        }

        Log.d("oal", String.valueOf(Arrays.asList(mList)));




        myViewHolder.txt_name.setText(responseDetail.getP().getProductName());
        myViewHolder.txt_price.setText(String.valueOf(details.getPP().getBasicCost()) + "₹");
        myViewHolder.txt_offer.setText(String.valueOf(details.getPP().getCheckeredCost()) + "₹");

        Picasso.get()
                .load(t)
                .transform(new RoundedTransformation(20, 0))
                .into(myViewHolder.imageView);

        myViewHolder.niceSpinner.addOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                PriceDetails details3 = datum.getPriceDetail().get(i);
                price=String.valueOf(details3.getPP().getBasicCost());
                myViewHolder.txt_price.setText(String.valueOf(details3.getPP().getBasicCost()) + "₹");
                myViewHolder.txt_offer.setText(String.valueOf(details3.getPP().getCheckeredCost()) + "₹");

            }
        });*/


    }
}
