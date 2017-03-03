package com.maxcriser.emergencycalls;

import android.Manifest;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
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
import android.util.Log;
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
import com.google.android.gms.maps.model.MarkerOptions;
import com.maxcriser.emergencycalls.adapter.EmAdapter;
import com.maxcriser.emergencycalls.constants.LocationTable;
import com.maxcriser.emergencycalls.dialog.LovelyCustomDialog;
import com.maxcriser.emergencycalls.dialog.LovelyCustomPickerDialog;
import com.maxcriser.emergencycalls.manager.GPSManager;
import com.maxcriser.emergencycalls.model.Em;
import com.maxcriser.emergencycalls.view.labels.EditTextRobotoRegular;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import static android.view.View.GONE;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final int zoom = 14;
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
    private View.OnClickListener onCall;
    private View.OnClickListener onSendMesge;

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
    public boolean onNavigationItemSelected(final MenuItem item) {
        final int id = item.getItemId();

        if (id == R.id.nav_pin) {

        } else if (id == R.id.send_feedback) {

        } else if (id == R.id.help) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_about) {

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
    }

    public void onMenuClicked(final View view) {
        mDrawer.openDrawer(GravityCompat.START);
    }

    public void onDownClicked(final View view) {
        mSpinner.performClick();
    }

    public void onSpaceClicked(final View view) {
    }

    public void onShowMeClicked(final View view) {
        try {
            googleMap.addMarker(new MarkerOptions().position(currentLatLng).title("Show me").snippet("It's me"));
            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, zoom));
        } catch (final Exception e) {
            Toast.makeText(this, "Cannot load", Toast.LENGTH_LONG).show();
        }
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
        mapView = (MapView) findViewById(R.id.map);
        mapView.onCreate(savedInstanceState);
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
        initViews();
    }

    public String getUsername() {
        final AccountManager manager = AccountManager.get(this);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.GET_ACCOUNTS) == PackageManager.PERMISSION_GRANTED) {
            final Account[] accounts = manager.getAccountsByType("com.google");
            final List<String> possibleEmails = new LinkedList<>();

            for (final Account account : accounts) {
                // TODO: Check possibleEmail against an email regex or treat
                // account.name as an email address only for certain account.type values.
                possibleEmails.add(account.name);
            }

            if (!possibleEmails.isEmpty() && possibleEmails.get(0) != null) {
                return possibleEmails.get(0);
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    private void makeCallTo() {
        final Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+375298893673"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        startActivity(intent);
        recyclerView.setAdapter(adapter);
    }

    private void sendMessageTo() {
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
                // TODO: 02.03.2017 send message to getSMSnumber
                displaySnackbar("Sending messages in rescue service...", null, null);
                String messageStr = message.getText().toString();
                if (mLocation != null) {
                    if (checkbox.isChecked()) {
                        messageStr += "\n_____\nLatitude: " + mLocation.getLatitude() + "\n"
                                + "Longitude: " + mLocation.getLongitude();
                    }
                }
                Toast.makeText(MainActivity.this, messageStr, Toast.LENGTH_LONG).show();
                dialog.dismiss();
            }
        });
    }

    private void initViews() {
        final Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        try {
            final Address address = geocoder.getFromLocation(GPSManager.getGPS(this).getLatitude(), GPSManager.getGPS(this).getLongitude(), 1).get(0);
            Log.d("LOC", address.getAddressLine(0));
        } catch (final Exception e) {
            Log.d("LOC", "NULL");
        }

        onCall = new View.OnClickListener() {

            @Override
            public void onClick(final View v) {
                makeCallTo();
            }
        };

        onSendMesge = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                sendMessageTo();
            }
        };

        phoneContent = (FrameLayout) findViewById(R.id.content_main);
//        locationContent = (FrameLayout) findViewById(R.id.content_location);
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

        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        adapter = new EmAdapter(LocationTable.em);
        recyclerView.setAdapter(adapter);

        swipeToAction = new SwipeToAction(this, recyclerView, new SwipeToAction.SwipeListener<Em>() {

            @Override
            public boolean swipeLeft(final Em itemData) {
                // TODO: 02.03.2017 calling to getPhoneNumber
                displaySnackbar("Calling the " + itemData.getTitle(), null, null);
                makeCallTo();
                return true;
            }

            @Override
            public boolean swipeRight(final Em itemData) {
                sendMessageTo();
                return true;
            }

            @Override
            public void onClick(final Em itemData) {
                showPickerDialog();
            }

            @Override
            public void onLongClick(final Em itemData) {
                showPickerDialog();
            }
        });
    }

    private void showPickerDialog() {
        final LovelyCustomPickerDialog dialogOnClick = new LovelyCustomPickerDialog(MainActivity.this);
        dialogOnClick.setView(R.layout.fragment_choose_action)
                .setCancelable(true)
                .setListener(R.id.make_a_call, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        final Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:+375298893673"));
                        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                            return;
                        }
                        startActivity(intent);
                        recyclerView.setAdapter(adapter);
                        dialogOnClick.dismiss();
                    }
                })
                .setListener(R.id.send_a_mesge, new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
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
                                // TODO: 02.03.2017 send message to getSMSnumber
                                displaySnackbar("Sending messages in rescue service...", null, null);
                                String messageStr = message.getText().toString();
                                if (mLocation != null) {
                                    if (checkbox.isChecked()) {
                                        messageStr += "\n_____\nLatitude: " + mLocation.getLatitude() + "\n"
                                                + "Longitude: " + mLocation.getLongitude();
                                    }
                                }
                                Toast.makeText(MainActivity.this, messageStr, Toast.LENGTH_LONG).show();
                                dialog.dismiss();
                            }
                        });
                        dialogOnClick.dismiss();
                    }
                })
                .show();
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