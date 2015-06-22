package com.example.tarunnurat.materialdesigntestapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolBar = (Toolbar) findViewById(R.id.toolbar_top);
        setSupportActionBar(toolBar);

        Button parallxScrollingBt = (Button) findViewById(R.id.parallaxScrollingBt);
        parallxScrollingBt.setOnClickListener(this);
        Button vectorExampleBt = (Button) findViewById(R.id.vectorDrawableBt);
        vectorExampleBt.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_parallax_scrolling, menu);
        return true;
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

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.parallaxScrollingBt :
                intent = new Intent(this, ParallaxScrollingActivity.class);
                startActivity(intent);
                break;

            case R.id.vectorDrawableBt :
                intent = new Intent(this, VectorDrawableActivity.class);
                startActivity(intent);
                break;
        }
    }
}
