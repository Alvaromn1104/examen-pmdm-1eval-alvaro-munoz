package com.examenAlvaroMN.myapplication.paginador;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.examenAlvaroMN.myapplication.fragments.primerFragment;
import com.examenAlvaroMN.myapplication.fragments.segundoFragment;
import com.examenAlvaroMN.myapplication.fragments.tercerFragment;

public class Paginador extends FragmentPagerAdapter {

    private final Context mContext;

    public Paginador(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){

            case 0:
                return new primerFragment();
            case 1:
                return new segundoFragment();
            case 2:
                return new tercerFragment();
            default:
                return null;

        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}