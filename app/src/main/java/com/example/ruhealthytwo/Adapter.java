package com.example.ruhealthytwo;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class Adapter extends FragmentStateAdapter {
    public Adapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        /*Fragment fragment = new DemoFragment();
        Bundle args = new Bundle();
        args.putString(DemoFragment.TITLE, "Tab "+(position + 1));
        fragment.setArguments(args);
        return fragment;*/

        switch (position) {
            case 0:
                return new ProfileFragment();
            case 1:
                return new MapFragment();
            case 2:
                return new ListFragment();
            default:
                return new ProfileFragment();
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
