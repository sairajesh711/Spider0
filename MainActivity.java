package com.sairajesh.spider0;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity {
    int clicks=0;
    private static String Count="count";
    private int restore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //layout reference
        RelativeLayout Lay= (RelativeLayout)findViewById(R.id.Layout);
        Lay.setBackgroundColor(Color.YELLOW);
        TextView text= (TextView)findViewById(R.id.Text);
        text.setText("Welcome");
        //Click me reference
        Button Clickbutton = (Button)findViewById(R.id.Clickme);
        Clickbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public  void onClick(View v){
                        TextView Texts= (TextView)findViewById(R.id.Text);
                        clicks++;
                        Texts.setText("Button Clicks="+clicks);
                    }
                }
        );
        //Reset button reference
        Button Resetbutton = (Button)findViewById(R.id.Reset);
        Resetbutton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        TextView Tex= (TextView)findViewById(R.id.Text);
                        clicks=0;
                        Tex.setText("Button Clicks="+clicks);
                    }
                }


        );
    }
    //To preserve count on orientation change
    @Override
    protected void onSaveInstanceState(Bundle outState){
        outState.putInt(Count,clicks);
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        restore=savedInstanceState.getInt(Count);
        clicks=restore;
        TextView restoretext=(TextView)findViewById(R.id.Text);
        restoretext.setText("Button Clicks="+clicks);
    }

}
