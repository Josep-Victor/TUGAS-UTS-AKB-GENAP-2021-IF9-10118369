package com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.MainActivity;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.R;

public class ProfileFragment extends Fragment {
    // 2 Juni 2021 - 10118369 - Josep Victor Rajadoli - IF 9

    private MainActivity mainActivity;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().hide();
    }
}