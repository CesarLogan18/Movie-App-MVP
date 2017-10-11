package com.rappi.rappitest;

import android.os.Bundle;

import com.rappi.rappitest.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void setUp() {

    }
}
