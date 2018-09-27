package com.niu.jam.avr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "联系方式";
    public static final String Success_message = "成功开启" ;
    public static final String Fail_message = "此手机不支持，请联系xxxyyy";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view) {
        //CALLED WHEN CLICK THE BUTTON
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText2);
        String message = editText.getText().toString();


        //message = results.errorMsg;
        intent.putExtra(EXTRA_MESSAGE, Fail_message);

        ShellUtils.CommandResult results = ShellUtils.execCommand("sh  /data/forfat.mk", true);
        if (results.result == 0) {
            intent.putExtra(EXTRA_MESSAGE, Success_message);
                }
        else {
            intent.putExtra(EXTRA_MESSAGE, Fail_message);
        }

        startActivity(intent);
    }



}
