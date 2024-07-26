package com.example.advance_gtu;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.advance_gtu.fragments.Friday;
import com.example.advance_gtu.fragments.Monday;
import com.example.advance_gtu.fragments.Saturday;
import com.example.advance_gtu.fragments.Sunday;
import com.example.advance_gtu.fragments.Thursday;
import com.example.advance_gtu.fragments.Tuesday;
import com.example.advance_gtu.fragments.Wednesday;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch(position){
            case 0:
                return new Monday();
            case 1:
                return new Tuesday();
            case 2:
                return new Wednesday();
            case 3:
                return new Thursday();
            case 4:
                return new Friday();
            case 5:
                return new Saturday();
            case 6:
                return new Sunday();
            default:
                return new Monday();
        }
    }

    @Override
    public int getItemCount() {
        return 7;
    }
}
