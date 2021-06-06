package com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.info.InfoFragment;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.note.NoteFragment;
import com.josepvictorr.tugas_uts_akb_genap_2021_if9_10118369.menu.ProfileFragment;

public class ViewPageAdapter extends FragmentPagerAdapter {
    // 2 Juni 2021 - 10118369 - Josep Victor Rajadoli - IF 9

    public ViewPageAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case
                0:
                return new InfoFragment();
            case
                1:
                return new NoteFragment();
            case
                2:
                return new ProfileFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
