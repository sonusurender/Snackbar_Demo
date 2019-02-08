package com.androidsnackbar_demo;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static CoordinatorLayout coordinatorLayout;
    private static Button singleLine, action, customColors, multiColored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        setListeners();

    }

    //Initiate Views
    private void initViews() {
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id
                .coordinatorLayout);
        singleLine = (Button) findViewById(R.id.singleLineSnackBar);

        action = (Button) findViewById(R.id.actionSnackBar);
        customColors = (Button) findViewById(R.id.customColorsSnackBar);
        multiColored = (Button) findViewById(R.id.multiColoredSnackBar);


    }

    //Set Listeners Over buttons
    private void setListeners() {
        singleLine.setOnClickListener(this);
        customColors.setOnClickListener(this);
        action.setOnClickListener(this);
        multiColored.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.singleLineSnackBar:
                Snackbar.make(coordinatorLayout, "Single Line SnackBar Demo.", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.actionSnackBar:

                Snackbar.make(coordinatorLayout, "Click on Action.", Snackbar.LENGTH_LONG).setAction("ACTION", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(coordinatorLayout, "You clicked on Action.", Snackbar.LENGTH_SHORT).show();
                    }
                }).show();

                break;

            case R.id.customColorsSnackBar:
                Snackbar snackbar = Snackbar.make(coordinatorLayout, "Custom Text Color and Custom Action Color.", Snackbar.LENGTH_LONG).setAction("ACTION", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        Snackbar.make(coordinatorLayout, "You clicked on Action.", Snackbar.LENGTH_SHORT).show();
                    }
                }).setActionTextColor(Color.BLUE);//Action Text Color

                // Changing SnackBar text color
                View snackView = snackbar.getView();
                TextView textView = (TextView) snackView.findViewById(android.support.design.R.id.snackbar_text);
                textView.setTextColor(Color.RED);
                snackbar.show();
                break;
            case R.id.multiColoredSnackBar:

                //Making multi colored text color of SnackBar text
                SpannableStringBuilder snackbarText = new SpannableStringBuilder();
                snackbarText.append("This is ");
                int boldStart = snackbarText.length();
                snackbarText.append("Multi Color");
                snackbarText.setSpan(new ForegroundColorSpan(0xFFFF0000), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.setSpan(new StyleSpan(Typeface.BOLD_ITALIC), boldStart, snackbarText.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
                snackbarText.append(" SnackBar Demo.");
                Snackbar.make(coordinatorLayout, snackbarText, Snackbar.LENGTH_LONG).show();

                break;
        }

    }
}
