package com.maxcriser.emergencycalls;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class HelpActivity extends Activity {

    TextView title;
    ImageButton send;

    public void onBackPressed(View view) {
        onBackPressed();
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        initViews();
    }

    private void initViews() {
        title = (TextView) findViewById(R.id.title_toolbar);
        send = (ImageButton) findViewById(R.id.send);
        title.setText(R.string.help);
        send.setVisibility(View.GONE);
    }
}
