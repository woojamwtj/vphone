package com.niu.jam.avr;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static java.lang.Runtime.*;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        // Get the Intent that started this activity and set
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.editText);
        textView.setText(message);
        readFile("");
    }

    public  StringBuilder readFile(String filePath){
        StringBuilder fileContent = new StringBuilder("");
        BufferedReader reader = null ;
        Context context = getApplicationContext();
        CharSequence textForShow = "jam test here";
        String filename = "678.txt";

        FileInputStream inputStream;
        try {
            inputStream = openFileInput(filename);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            Log.d("niuxiaojie:::",line);
            inputStream.close();
            if (line.isEmpty() )
            {
               Toast.makeText(context,"it is an empty line ...niuxiaojie...",Toast.LENGTH_LONG).show();
            }else {
                Toast.makeText(context,line,Toast.LENGTH_LONG).show();
            }
        }catch ( Exception e ){
            e.printStackTrace();;
        }
        //int duration = Toast.LENGTH_SHORT;;
        /*File fl = new File(filePath);
        StringBuilder fileContent = new StringBuilder("");
        if (fl == null || !fl.isFile() ){
            Toast.makeText(context,"problem here...",Toast.LENGTH_LONG).show();
            return  null;
        }else {
            Toast.makeText(context,textForShow,Toast.LENGTH_LONG).show();
        }*/
/*        BufferedReader reader = null;
        try{
            InputStreamReader isr = new InputStreamReader(new FileInputStream(fl));
            Toast.makeText(context,"jam test everything oK",Toast.LENGTH_LONG).show();
            *//*reader = new BufferedReader(isr);
            String line = null;
            while ((line = reader.readLine() ) !=null){
                if(!fileContent.toString().equals("")){
                    fileContent.append("\n");
                }
                fileContent.append(line);

            return fileContent;}*//*
        }catch(IOException e){
            throw new RuntimeException("I/O exception happened..",e);

        }finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            }catch (IOException e){
                throw new RuntimeException("IOException occurred. ", e);
            }

        }*/
        return fileContent ;
    }



}
