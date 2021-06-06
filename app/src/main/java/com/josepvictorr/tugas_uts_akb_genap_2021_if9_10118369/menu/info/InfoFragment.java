package com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.info;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.MainActivity;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.R;

import java.util.ArrayList;
import java.util.List;

public class InfoFragment extends Fragment {
    // 2 Juni 2021 - 10118369 - Josep Victor Rajadoli - IF 9
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;
    private MainActivity mainActivity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_info, container, false);

        viewPager = root.findViewById(R.id.view_pager_info);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        mainActivity = (MainActivity) getActivity();
        mainActivity.getSupportActionBar().hide();

        List<Fragment> list = new ArrayList<>();
        list.add(new InfoFragmentSlide1());
        list.add(new InfoFragmentSlide2());
        list.add(new InfoFragmentSlide3());

        pagerAdapter = new InfoFragmentSlideAdapter(requireActivity().getSupportFragmentManager(), list);

        viewPager.setAdapter(pagerAdapter);
    }
}