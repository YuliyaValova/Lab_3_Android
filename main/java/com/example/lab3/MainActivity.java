package com.example.lab3;


import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements OnClickListener {
    //MyDialogFragment fragment = new MyDialogFragment();
    private Button redButton;
    private Button blueButton;
    private Button greenButton;
    private Button yellowButton;
    private Toast informationToast;
    private LinearLayout layout;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonsInit();
        setListeners();
    }

    private void setListeners() {
        redButton.setOnClickListener(this);
        blueButton.setOnClickListener(this);
        greenButton.setOnClickListener(this);
        yellowButton.setOnClickListener(this);
    }

    private void buttonsInit() {
        redButton = (Button) findViewById(R.id.b_red);
        blueButton = (Button) findViewById(R.id.b_blue);
        greenButton = (Button) findViewById(R.id.b_green);
        yellowButton = (Button) findViewById(R.id.b_yellow);
        layout = (LinearLayout) findViewById(R.id.screenLayout);
    }

    private void showToast(String text) {
        informationToast = Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT);
        informationToast.show();
    }

    public void showDeveloper(View view) {
        prepareDialogView();
        dialog.show();
        //fragment.onClick(view);

    }

    private void prepareDialogView() {
        dialog = new Dialog(MainActivity.this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setContentView(R.layout.dialog);
        TextView text = (TextView) dialog.findViewById(R.id.textView2);
        text.setText("Hello. My name is Yuliya. I am a student of BSUIR :3");
    }

    public void setBackgroundImage(View view) {
        layout.setBackgroundResource(R.drawable.im2);
    }

    @Override
    public void onClick(View view) {
        if (redButton.equals(view)) {
            layout.setBackgroundColor(Color.RED);
            showToast("Hello red");
        } else if (greenButton.equals(view)) {
            layout.setBackgroundColor(Color.GREEN);
            showToast("Hello green");
        } else if (blueButton.equals(view)) {
            layout.setBackgroundColor(Color.BLUE);
            showToast("Hello blue");
        } else if (yellowButton.equals(view)) {
            layout.setBackgroundColor(Color.YELLOW);
            showToast("Hello yellow");
        }

    }

    public void closeDialog(View view) {
        dialog.cancel();
    }
}