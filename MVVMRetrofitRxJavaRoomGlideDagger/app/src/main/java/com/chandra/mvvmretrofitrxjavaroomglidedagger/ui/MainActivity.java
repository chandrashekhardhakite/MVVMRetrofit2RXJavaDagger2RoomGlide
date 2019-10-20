package com.chandra.mvvmretrofitrxjavaroomglidedagger.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.chandra.mvvmretrofitrxjavaroomglidedagger.R;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btnRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRecyclerView = findViewById(R.id.button);
        btnRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, "onClick: button clicked");
                startActivity(new Intent(MainActivity.this, RecyclerActivity.class));
            }
        });
    }


}
