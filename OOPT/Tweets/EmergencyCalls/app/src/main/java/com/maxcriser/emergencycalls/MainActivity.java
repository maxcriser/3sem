package com.maxcriser.emergencycalls;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.maxcriser.emergencycalls.adapter.EmAdapter;
import com.maxcriser.emergencycalls.constants.CountryTable;
import com.maxcriser.emergencycalls.dialog.LovelyCustomDialog;
import com.maxcriser.emergencycalls.dialog.LovelyCustomPickerDialog;
import com.maxcriser.emergencycalls.manager.GPSManager;
import com.maxcriser.emergencycalls.manager.PhoneManager;
import com.maxcriser.emergencycalls.model.CountryEm;
import com.maxcriser.emergencycalls.model.Em;
import com.maxcriser.emergencycalls.view.labels.EditTextRobotoRegular;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int zoom = 14;
    private static final String TEXT_PLAIN = "text/plain";
    private static final String HTTP_IP_API_COM_JSON = "http://ip-api.com/json";
    private static final String GET = "GET";
    private static final String COUNTRY = "country";
    RecyclerView recyclerView;
    EmAdapter adapter;
    SwipeToAction swipeToAction;
    ImageButton first;
    ImageButton second;
    ImageButton third;
    private DrawerLayout mDrawer;
    private Spinner mSpinner;
    private FrameLayout phoneContent;
    private FrameLayout mapContent;
    private MapView mapView;
    private GoogleMap googleMap;
    private LatLng currentLatLng;
    private Location mLocation;
    private List<Em> currentEm;
    private List<CountryEm> mCountryEmList;

    @Override
    public void onBackPressed() {
        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
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
    public boolean onNavigationItemSelected(@NonNull final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.send_feedback) {
            startActivity(new Intent(this, FeedbackActivity.class));
        } else if (id == R.id.help) {
            startActivity(new Intent(this, HelpActivity.class));
        } else if (id == R.id.nav_share) {
            final Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
            sharingIntent.setType(TEXT_PLAIN);
            sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, getString(R.string.e_android_application_share_title));
            sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, getString(R.string.body_share));
            final String SHARE_USING = "share_using";
            startActivity(Intent.createChooser(sharingIntent, SHARE_USING));
        }

        final DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void onPhoneClicked(final View view) {
        first.setImageResource(R.drawable.blue_phone);
        second.setImageResource(R.drawable.map_marker);
        third.setImageResource(R.drawable.google_maps);
        phoneContent.setVisibility(View.VISIBLE);
        mapContent.setVisibility(GONE);
    }

    public void onSecondClicked(final View view) {
        first.setImageResource(R.drawable.phone_black);
        second.setImageResource(R.drawable.blue_map_marker);
        third.setImageResource(R.drawable.google_maps);
    }

    public void onMapClicked(final View view) {
        first.setImageResource(R.drawable.phone_black);
        second.setImageResource(R.drawable.map_marker);
        third.setImageResource(R.drawable.blue_google_maps);
        phoneContent.setVisibility(GONE);
        mapContent.setVisibility(View.VISIBLE);

        if (googleMap == null) {
            mapView.onResume();
            mapView.getMapAsync(new OnMapReadyCallback() {

                @Override
                public void onMapReady(final GoogleMap pGoogleMap) {
                    googleMap = pGoogleMap;
                    googleMap.getUiSettings().setAllGesturesEnabled(true);

                    if (ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                            && ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        return;
                    }
                    googleMap.setMyLocationEnabled(true);
                    if (currentLatLng != null) {
                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, zoom));
                    }
                }
            });
        }
    }

    public void onMenuClicked(final View view) {
        mDrawer.openDrawer(GravityCompat.START);
    }

    public void onDownClicked(final View view) {
        mSpinner.performClick();
    }

    public void onSpaceClicked(final View view) {
    }

    @Override
    protected void onResume() {
        super.onResume();
        mLocation = GPSManager.getGPS(this);
        if (mLocation != null) {
            currentLatLng = new LatLng(mLocation.getLatitude(), mLocation.getLongitude());
        }
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        CountryTable countryTable = new CountryTable(this);
        mCountryEmList = countryTable.getEm();
        currentEm = mCountryEmList.get(mCountryEmList.size() - 1).getEmList();
        mapView.onCreate(savedInstanceState);
        initLocation();
    }

    private void initViews() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        mapView = (MapView) findViewById(R.id.map);
        phoneContent = (FrameLayout) findViewById(R.id.content_main);
        mapContent = (FrameLayout) findViewById(R.id.content_map);
        first = (ImageButton) findViewById(R.id.button_first);
        second = (ImageButton) findViewById(R.id.button_second);
        third = (ImageButton) findViewById(R.id.button_third);
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        final NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        final ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, mDrawer, null,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);

    }

    private void sendMessageTo(final Em itemData) {
        final List<String> chooseMessage = Arrays.asList(getResources().getStringArray(R.array.choose_message));
        final LovelyCustomDialog dialog = new LovelyCustomDialog(this);
        dialog.setView(R.layout.fragment_send_message)
                .setTopColorRes(R.color.text_toolbar)
                .setCancelable(true)
                .setIcon(R.drawable.ic_send_message_button)
                .show();

        final View view = dialog.getAddedView();
        final ImageButton sendButton = (ImageButton) view.findViewById(R.id.send_button);
        final EditTextRobotoRegular message = (EditTextRobotoRegular) view.findViewById(R.id.message);
        final CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
        if (mLocation == null) {
            checkbox.setVisibility(GONE);
        } else {
            checkbox.setVisibility(View.VISIBLE);
        }

        mSpinner = (Spinner) view.findViewById(R.id.spinner);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                message.setText(chooseMessage.get(position));
                message.setSelection(chooseMessage.get(position).length());
            }

            @Override
            public void onNothingSelected(final AdapterView<?> parent) {

            }
        });
        message.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

            }

            @Override
            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {

            }

            @Override
            public void afterTextChanged(final Editable s) {
                if (!message.getText().toString().isEmpty()) {
                    sendButton.setClickable(true);
                    sendButton.setImageResource(R.drawable.send_black);
                } else {
                    sendButton.setClickable(false);
                    sendButton.setImageResource(R.drawable.send_gray);
                }
            }
        });

        sendButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                String messageStr = message.getText().toString();
                if (mLocation != null) {
                    if (checkbox.isChecked()) {
                        messageStr += "\n_____\nLatitude: " + mLocation.getLatitude() + "\n"
                                + "Longitude: " + mLocation.getLongitude();
                    }
                }
                try {
                    PhoneManager.sendSMS(itemData.getSmsNumber(), messageStr);
                } catch (final Exception pE) {
                    Toast.makeText(MainActivity.this, "Error sending a message", Toast.LENGTH_LONG).show();
                }
                displaySnackbar("Sending messages in rescue service...", null, null);
                dialog.dismiss();
            }
        });
    }

    private void setUpRecyclerView() {
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        adapter = new EmAdapter(currentEm);
        recyclerView.setAdapter(adapter);

        swipeToAction = new SwipeToAction(this, recyclerView, new SwipeToAction.SwipeListener<Em>() {

            @Override
            public boolean swipeLeft(final Em itemData) {
                displaySnackbar("Calling the " + itemData.getTitle(), null, null);
                try {
                    PhoneManager.makeCall(MainActivity.this, itemData.getPhoneNumber());
                } catch (final Exception pE) {
                    Toast.makeText(MainActivity.this, "Call error", Toast.LENGTH_LONG).show();
                }
                return true;
            }

            @Override
            public boolean swipeRight(final Em itemData) {
                sendMessageTo(itemData);
                return true;
            }

            @Override
            public void onClick(final Em itemData) {
                showPickerDialog(itemData);
            }

            @Override
            public void onLongClick(final Em itemData) {
                showPickerDialog(itemData);
            }
        });
    }

    private void showPickerDialog(final Em itemData) {
        final LovelyCustomPickerDialog dialogOnClick = new LovelyCustomPickerDialog(this);
        dialogOnClick.setView(R.layout.fragment_choose_action)
                .setCancelable(true)
                .setListener(R.id.make_a_call, new View.OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        try {
                            PhoneManager.makeCall(MainActivity.this, itemData.getPhoneNumber());
                        } catch (final Exception pE) {
                            Toast.makeText(MainActivity.this, "Call error", Toast.LENGTH_LONG).show();
                        }
                        dialogOnClick.dismiss();
                    }
                })
                .setListener(R.id.send_a_mesge, new View.OnClickListener() {

                    @Override
                    public void onClick(final View v) {
                        final List<String> chooseMessage = Arrays.asList(getResources().getStringArray(R.array.choose_message));
                        final LovelyCustomDialog dialog = new LovelyCustomDialog(MainActivity.this);
                        dialog.setView(R.layout.fragment_send_message)
                                .setTopColorRes(R.color.text_toolbar)
                                .setCancelable(true)
                                .setIcon(R.drawable.ic_send_message_button)
                                .show();

                        final View view = dialog.getAddedView();
                        final ImageButton sendButton = (ImageButton) view.findViewById(R.id.send_button);
                        final EditTextRobotoRegular message = (EditTextRobotoRegular) view.findViewById(R.id.message);
                        final CheckBox checkbox = (CheckBox) view.findViewById(R.id.checkbox);
                        if (mLocation == null) {
                            checkbox.setVisibility(GONE);
                        } else {
                            checkbox.setVisibility(View.VISIBLE);
                        }

                        mSpinner = (Spinner) view.findViewById(R.id.spinner);
                        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

                            @Override
                            public void onItemSelected(final AdapterView<?> parent, final View view, final int position, final long id) {
                                message.setText(chooseMessage.get(position));
                                message.setSelection(chooseMessage.get(position).length());
                            }

                            @Override
                            public void onNothingSelected(final AdapterView<?> parent) {

                            }
                        });
                        message.addTextChangedListener(new TextWatcher() {

                            @Override
                            public void beforeTextChanged(final CharSequence s, final int start, final int count, final int after) {

                            }

                            @Override
                            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {

                            }

                            @Override
                            public void afterTextChanged(final Editable s) {
                                if (!message.getText().toString().isEmpty()) {
                                    sendButton.setClickable(true);
                                    sendButton.setImageResource(R.drawable.send_black);
                                } else {
                                    sendButton.setClickable(false);
                                    sendButton.setImageResource(R.drawable.send_gray);
                                }
                            }
                        });

                        sendButton.setOnClickListener(new View.OnClickListener() {

                            @Override
                            public void onClick(final View v) {
                                String messageStr = message.getText().toString();
                                if (mLocation != null) {
                                    if (checkbox.isChecked()) {
                                        messageStr += "\n_____\nLatitude: " + mLocation.getLatitude() + "\n"
                                                + "Longitude: " + mLocation.getLongitude();
                                    }
                                }
                                try {
                                    PhoneManager.sendSMS(itemData.getSmsNumber(), messageStr);
                                } catch (final Exception pE) {
                                    Toast.makeText(MainActivity.this, "Error sending a message", Toast.LENGTH_LONG).show();
                                }
                                displaySnackbar("Sending messages in rescue service...", null, null);
                                dialog.dismiss();
                            }
                        });
                        dialogOnClick.dismiss();
                    }
                })
                .show();

    }

    private void setUpCurrentEm(final String country) {
        for (int i = 0; i < mCountryEmList.size(); i++) {
            if (mCountryEmList.get(i).getCountryName().equals(country)) {
                currentEm = mCountryEmList.get(i).getEmList();
                break;
            }
        }
    }

    private void loadFromAPI() {
        new AsyncTask<String, Void, String>() {

            @Override
            protected void onPostExecute(final String pS) {
                super.onPostExecute(pS);
                if (pS != null) {
                    setUpCurrentEm(pS);
                } else {
                    Toast.makeText(MainActivity.this, "Error loading from API", Toast.LENGTH_SHORT).show();
                }
                setUpRecyclerView();
            }

            @Override
            protected String doInBackground(final String... params) {
                try {
                    final URL url = new URL(params[0]);

                    final HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                    urlConnection.setRequestMethod(GET);
                    urlConnection.connect();

                    final InputStream inputStream = urlConnection.getInputStream();
                    final StringBuilder buffer = new StringBuilder();

                    final BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        buffer.append(line);
                    }

                    final String resultJson = buffer.toString();
                    inputStream.close();

                    final JSONObject dataJsonObj;
                    dataJsonObj = new JSONObject(resultJson);

                    final String COUNTRY_ID = COUNTRY;
                    return dataJsonObj.getString(COUNTRY_ID);
                } catch (final Exception e) {
                    return null;
                }
            }
        }.execute(HTTP_IP_API_COM_JSON);
    }

    private void initLocation() {
        new AsyncTask<Void, Void, String>() {

            @Override
            protected void onPostExecute(final String pS) {
                super.onPostExecute(pS);
                if (pS != null) {
                    setUpCurrentEm(pS);
                    setUpRecyclerView();
                } else {
                    Toast.makeText(MainActivity.this, "Error loading from GPS", Toast.LENGTH_SHORT).show();
                    loadFromAPI();
                }
            }

            @Override
            protected String doInBackground(final Void... params) {
                try {
                    final Geocoder geocoder = new Geocoder(MainActivity.this, Locale.getDefault());
                    final Address address = geocoder.getFromLocation(mLocation.getLatitude(), mLocation.getLongitude(), 1).get(0);
                    return address.getCountryName();
                } catch (final Exception e) {
                    return null;
                }
            }
        }.execute();
    }

    private void displaySnackbar(final CharSequence text, final CharSequence actionName, final View.OnClickListener action) {
        final Snackbar snack = Snackbar.make(findViewById(android.R.id.content), text, Snackbar.LENGTH_LONG)
                .setAction(actionName, action);

        final View v = snack.getView();
        ((TextView) v.findViewById(android.support.design.R.id.snackbar_text)).setTextColor(Color.WHITE);
        ((TextView) v.findViewById(android.support.design.R.id.snackbar_action)).setTextColor(Color.BLACK);

        snack.show();
    }
}