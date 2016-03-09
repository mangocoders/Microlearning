package com.example.shandro.microlearning;

import android.app.Activity;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import android.os.Handler;
import java.util.logging.LogRecord;

public class Sudoko extends Activity {

    int seconds = 0;
    GridView gridview;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sudo_intro);

        new CountDownTimer(3000, 1000) {

            public void onTick(long millisUntilFinished) {
                //mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                setContentView(R.layout.activity_sudoko);

                runTimer();
                //mTextField.setText("done!");
            }
        }.start();




    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sudoko, menu);
        return true;
    }


    public void imageChange(View v)
    {
        if(v.getTag().equals("1"))
        {
            ImageView m = (ImageView)v;
            m.setImageResource(R.drawable.num2);
            m.setTag("2");
        }
        else if(v.getTag().equals("2"))
        {
            ImageView m = (ImageView)v;
            m.setImageResource(R.drawable.num3);
            m.setTag("3");
        }
        else
        {
            ImageView m = (ImageView)v;
            m.setImageResource(R.drawable.num1);
            m.setTag("1");
        }
    }

    public void runTimer()
    {

        final TextView timeView = (TextView)findViewById(R.id.timer);
        final Handler handler = new Handler();

        handler.post(new Runnable() {
            @Override
            public void run() {
                int hours = seconds/3600;
                int minutes = (seconds%3600)/60;
                int secs = seconds%60;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);
                timeView.setText(time);
                seconds++;
                handler.postDelayed(this, 1000);
            }
        });
    }

    public void check(View v)
    {
        //Log.v("here", "atcheck");
        boolean flag = true;
        ImageView image[][] = new ImageView[3][3];
        image[0][0] = (ImageView)findViewById(R.id.r1c1);

        image[0][1] = (ImageView)findViewById(R.id.r1c2);

        image[0][2] = (ImageView)findViewById(R.id.r1c3);

        image[1][0] = (ImageView)findViewById(R.id.r2c1);

        image[1][1] = (ImageView)findViewById(R.id.r2c2);

        image[1][2] = (ImageView)findViewById(R.id.r2c3);

        image[2][0] = (ImageView)findViewById(R.id.r3c1);

        image[2][1] = (ImageView)findViewById(R.id.r3c2);

        image[2][2] = (ImageView)findViewById(R.id.r3c3);

        for(int c = 0; c < 3; c++)
        {
            int array[] = new int[4];

            for(int i = c; i < 3; i++)
            {

                if(image[c][i].getTag().equals("1") || image[c][i].getTag().equals("1!"))
                {
                    if(array[1] == 1)
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        array[1] = 1;
                    }
                }
                else if(image[c][i].getTag().equals("2") || image[c][i].getTag().equals("2!"))
                {
                    if(array[2] == 1)
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        array[2] = 1;
                    }
                }
                else
                {
                    if(array[3] == 1)
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        array[3] = 1;
                    }
                }
            }



        }
        //Log.v("here", "atcheck");

        for(int i = 0; i < 3; i++)
        {
            int array[] = new int[4];

            for(int c = i; c < 3; c++)
            {

                if(image[c][i].getTag().equals("1") || image[c][i].getTag().equals("1!"))
                {
                    if(array[1] == 1)
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        array[1] = 1;
                    }
                }
                else if(image[c][i].getTag().equals("2") || image[c][i].getTag().equals("2!"))
                {
                    if(array[2] == 1)
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        array[2] = 1;
                    }
                }
                else
                {
                    if(array[3] == 1)
                    {
                        flag = false;
                        break;
                    }
                    else
                    {
                        array[3] = 1;
                    }
                }
            }
        }


        Log.v("here", "atcheck");
        Log.v("here", Boolean.toString(flag));

        if(!flag)
        {
            Toast toast = new Toast(this).makeText(this, "Wrong", Toast.LENGTH_LONG);
            toast.show();
        }
        else
        {
            Intent intent = new Intent(this, Result.class);
            intent.putExtra("VALUE", Integer.toString(seconds));
            startActivity(intent);
        }
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        seconds = 0;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
