package com.bitcodetech.myapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class MainActivity extends Activity {

    private LinearLayout mainContainer;
    private ImageView imgBitCode;
    private TextView txtWelcomeMessage;
    private EditText edtMessage;
    private Button btnSetMessage;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mainContainer = new LinearLayout(this);
        mainContainer.setOrientation(LinearLayout.VERTICAL);
        mainContainer.setPadding(30, 30, 30, 30);

        ViewGroup.LayoutParams layoutParams1 =
                new ViewGroup.LayoutParams(
                        400,
                        300
                );

        imgBitCode = new ImageView(this);
        imgBitCode.setImageResource(R.drawable.bitcode);
        imgBitCode.setLayoutParams(layoutParams1);
        mainContainer.addView(imgBitCode);
        //setContentView(imgBitCode);


        ViewGroup.LayoutParams layoutParams2 = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );
        txtWelcomeMessage = new TextView(this);
        txtWelcomeMessage.setText("Welcome to BitCode!");
        txtWelcomeMessage.setTextSize(30);
        txtWelcomeMessage.setLayoutParams(layoutParams2);
        mainContainer.addView(txtWelcomeMessage);
        //setContentView(txtWelcomeMessage);


        edtMessage = new EditText(this);
        edtMessage.setHint("Enter new message");
        edtMessage.setLayoutParams(layoutParams2);
        mainContainer.addView(edtMessage);

        btnSetMessage = new Button(this);
        btnSetMessage.setText("Set Message");
        mainContainer.addView(btnSetMessage);

        btnSetMessage.setOnClickListener(new BtnSetMessageClickListener());
        txtWelcomeMessage.setOnClickListener(new TxtWelcomeMessageClickListener());

        setContentView(mainContainer);

    }

    private class TxtWelcomeMessageClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txtWelcomeMessage.setText("");
        }
    }

    private class BtnSetMessageClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            txtWelcomeMessage.setText(
                    edtMessage.getText().toString()
            );
        }
    }

}
