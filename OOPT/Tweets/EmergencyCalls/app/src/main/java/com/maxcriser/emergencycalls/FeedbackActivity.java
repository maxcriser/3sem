package com.maxcriser.emergencycalls;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.maxcriser.emergencycalls.manager.ProfileManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FeedbackActivity extends Activity {

    private static final String FEEDBACK_FROM_EMERGALLS = "Feedback from Emergalls";
    private static final String MV_MAXCRISER_GMAIL_COM = "mv.maxcriser@gmail.com";
    private static final String MESSAGE_RFC822 = "message/rfc822";
    private static final String MAILTO = "mailto:";
    private EditText feedback;
    private EditText email;
    private CheckBox includeScreenshot;
    private ImageView screenshot;

    public void onBackPressed(final View view) {
        onBackPressed();
    }

    public void onSendClicked(final View view) {
        final Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setType(MESSAGE_RFC822);
        i.putExtra(Intent.EXTRA_EMAIL, email.getText());
        i.putExtra(Intent.EXTRA_SUBJECT, FEEDBACK_FROM_EMERGALLS);
        i.putExtra(Intent.EXTRA_TEXT, feedback.getText());
        i.setData(Uri.parse(MAILTO + MV_MAXCRISER_GMAIL_COM));
        try {
            startActivity(i);
        } catch (final android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, R.string.no_email_clients_installed, Toast.LENGTH_SHORT).show();
        }
        onBackPressed();
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        initViews();
    }

    private void initViews() {
        screenshot = (ImageView) findViewById(R.id.screenshot);
        screenshot.setDrawingCacheEnabled(false);
        email = (EditText) findViewById(R.id.email_profile);
        email.setText(ProfileManager.getUserMail(this));
        feedback = (EditText) findViewById(R.id.text_feedback);
        feedback.requestFocus();
        includeScreenshot = (CheckBox) findViewById(R.id.include_screenshot);
    }
}