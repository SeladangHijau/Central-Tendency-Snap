package com.seladanghijau.centraltendencysnap.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.seladanghijau.centraltendencysnap.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    // views
    Button btnGroupData, btnUngroupData;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    // initialization ------------------------------------------------------------------------------
    private void initViews() {
        btnGroupData = (Button) findViewById(R.id.btnGroupData);
        btnUngroupData = (Button) findViewById(R.id.btnUngroupData);

        btnGroupData.setOnClickListener(this);
        btnUngroupData.setOnClickListener(this);
    }
    // ---------------------------------------------------------------------------------------------

    // listener ------------------------------------------------------------------------------------
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnGroupData:
                startActivity(new Intent(this, GroupedData.class));
                break;
            case R.id.btnUngroupData:
                startActivity(new Intent(this, UngroupedData.class));
                break;
        }
    }
    // ---------------------------------------------------------------------------------------------
}
