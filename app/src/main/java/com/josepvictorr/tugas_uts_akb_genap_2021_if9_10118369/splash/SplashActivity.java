package com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.splash;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;

import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.MainActivity;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.R;

public class SplashActivity extends AppCompatActivity {
    // 2 Juni 2021 - 10118369 - Josep Victor Rajadoli - IF 9

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);

        getSupportActionBar().hide();

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), MainActivity.class));
                finish();
            }
        }, 3000L);
    }
}