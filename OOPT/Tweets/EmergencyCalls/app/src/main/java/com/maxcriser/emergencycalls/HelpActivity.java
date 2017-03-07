package com.maxcriser.emergencycalls;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.maxcriser.emergencycalls.dialog.AlertStandardDialog;

public class HelpActivity extends Activity {

    private final String githubLink = "https://github.com/maxcriser/Emergalls";
    TextView title;
    ImageButton send;

    public void onBackPressed(final View view) {
        onBackPressed();
    }

    public void onFeedbackClicked(final View view) {
        startActivity(new Intent(this, FeedbackActivity.class));
    }

    public void onBrowseClicked(final View view) {
        final String url = githubLink;
        final Intent intent = new Intent(Intent.ACTION_VIEW).setData(Uri.parse(url));
        startActivity(intent);
    }

    public void onHowMakeCallClicked(final View view) {
        showAlert(getString(R.string.how_to_make_a_call_to_the_rescue_service), getString(R.string.how_to_make_a_call_to_the_rescue_service_body));
    }

    public void onSendingClicked(final View view) {
        showAlert(getString(R.string.sending_a_message), getString(R.string.sending_a_message_body));
    }

    public void onAttachClicked(final View view) {
        showAlert(getString(R.string.attaching_coordinates_to_a_message), getString(R.string.attaching_coordinates_to_a_message_body));
    }

    public void onPossibleClicked(final View view) {
        showAlert(getString(R.string.possible_problems_with_determining_your_current_location), getString(R.string.possible_problems_with_determining_your_current_location_body));
    }

    private void showAlert(final CharSequence title, final CharSequence body) {
        new AlertStandardDialog(this)
                .setTopColorRes(R.color.text_toolbar)
                .setButtonsColorRes(R.color.green_material)
                .setTitle(title)
                .setMessage(body)
                .setIcon(R.drawable.ic_info)
                .setNegativeButton(android.R.string.ok, null)
                .show();
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
