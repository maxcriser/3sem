package com.maxcriser.algoritmsarray;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView answerLinearSearch;
    private TextView answerBetterLinearSearch;
    private TextView answerSentinelLinearSearch;
    private TextView answerRecursiveLinearSearch;

    TextView textArray;
    EditText editNumberOfElements;
    EditText x;
    List<Integer> list = new ArrayList<>();
    int min = 1;
    int max = 100;

    public void onGenerateClicked(final View view) {
        String text = "";
        list.clear();
        final Integer numberOfElements = Integer.parseInt(editNumberOfElements.getText().toString());
        for (int i = 0; i < numberOfElements; i++) {
            final Random r = new Random();
            final int randomInt = r.nextInt(max - min + 1) + min;
            list.add(randomInt);
            text += randomInt + ", ";
        }
        textArray.setText(text);
    }

    public void onSearchClicked(final View view) {
        final int xInt = Integer.parseInt(x.getText().toString());
        final int nInt = Integer.parseInt(editNumberOfElements.getText().toString());
        answerLinearSearch.setText(Solutions.LinearSearch(list, xInt, nInt));
        answerBetterLinearSearch.setText(Solutions.BetterLinearSearch(list, xInt, nInt));
        answerRecursiveLinearSearch.setText(Solutions.RecursiveLinearSearch(list, xInt, nInt, 0));
        answerSentinelLinearSearch.setText(Solutions.SentineLinearSearch(list, xInt, nInt));
    }

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    void initViews() {
        editNumberOfElements = (EditText) findViewById(R.id.number_of_elements);
        textArray = (TextView) findViewById(R.id.array_list);
        x = (EditText) findViewById(R.id.x);
        answerLinearSearch = (TextView) findViewById(R.id.first);
        answerBetterLinearSearch = (TextView) findViewById(R.id.second);
        answerSentinelLinearSearch = (TextView) findViewById(R.id.third);
        answerRecursiveLinearSearch = (TextView) findViewById(R.id.fourth);
    }
}
