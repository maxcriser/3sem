package com.maxcriser.tweets_android;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.maxcriser.tweets_android.adapter.StatePointsAdapter;
import com.maxcriser.tweets_android.adapter.TweetAdapter;
import com.maxcriser.tweets_android.handler.CountValueStatesHandler;
import com.maxcriser.tweets_android.model.StateModel;
import com.maxcriser.tweets_android.model.Tweet;
import com.maxcriser.tweets_android.utils.TweetsReader;

import java.util.List;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    RecyclerView rv;
    RecyclerView rvLocation;
    List<Tweet> tweets;
    LinearLayout loading;
    TweetAdapter mTweetAdapter;
    StatePointsAdapter mStatePointsAdapter;
    String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/tweets_folder";
    FrameLayout homeContent;
    FrameLayout locationContent;
    FrameLayout mapContent;
    List<StateModel> stats;
    CountValueStatesHandler countValueStatesHandler;
//    DrawerLayout drawer;

    @Override
    public void onBackPressed() {
//        if (drawer.isDrawerOpen(GravityCompat.START)) {
//            drawer.closeDrawer(GravityCompat.START);
//        } else {
//            super.onBackPressed();
//        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

//        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onMenuClicked(final View view) {
//        drawer.openDrawer(GravityCompat.START);
    }

    public void onLocationClicked(final View view) {
        if (countValueStatesHandler != null) {
            homeContent.setVisibility(GONE);
            mapContent.setVisibility(GONE);
            locationContent.setVisibility(View.VISIBLE);

            if (stats == null) {
                stats = countValueStatesHandler.getStateModelList();
            }
            setRecyclerViewLocation();
        } else {
            Toast.makeText(this, "Feature will be available after loading tweets", Toast.LENGTH_LONG).show();
        }
    }

    public void onHomeClicked(final View view) {
        homeContent.setVisibility(View.VISIBLE);
        mapContent.setVisibility(GONE);
        locationContent.setVisibility(GONE);
    }

    public void onMapClicked(final View view) {
        homeContent.setVisibility(GONE);
        mapContent.setVisibility(View.VISIBLE);
        locationContent.setVisibility(GONE);
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);
        initViews();
        final LoadTask loadTask = new LoadTask();
        loadTask.execute();
    }

    void loadData() {
        tweets = TweetsReader.getListTweet(this, path + "/texas.txt");
        countValueStatesHandler = new CountValueStatesHandler(tweets);
    }

    void setRecyclerViewLocation() {
        mStatePointsAdapter = new StatePointsAdapter(stats, this);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rvLocation.setLayoutManager(mLayoutManager);
        rvLocation.setItemAnimator(new DefaultItemAnimator());
        rvLocation.setAdapter(mStatePointsAdapter);
    }

    void setRecyclerViewTweets() {
        mTweetAdapter = new TweetAdapter(tweets, this);
        final RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setLayoutManager(mLayoutManager);
        rv.setItemAnimator(new DefaultItemAnimator());
        rv.setAdapter(mTweetAdapter);
    }

    void initViews() {
//        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        homeContent = (FrameLayout) findViewById(R.id.content_main);
        locationContent = (FrameLayout) findViewById(R.id.content_location);
        mapContent = (FrameLayout) findViewById(R.id.content_map);
        loading = (LinearLayout) findViewById(R.id.loading);
        rv = (RecyclerView) findViewById(R.id.rv);
        rvLocation = (RecyclerView) findViewById(R.id.rv_location);
    }

    class LoadTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(final Void... params) {
            loadData();
            return null;
        }

        @Override
        protected void onPostExecute(final Void result) {
            super.onPostExecute(result);
            setRecyclerViewTweets();
            loading.setVisibility(GONE);
            rv.setVisibility(View.VISIBLE);
        }
    }
}
