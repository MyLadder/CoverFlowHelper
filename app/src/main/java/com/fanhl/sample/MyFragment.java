package com.fanhl.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * Created by fanhl on 2017/2/15.
 */
public class MyFragment extends Fragment {
    private int position;

    public static MyFragment newInstance(int position) {
        Bundle args = new Bundle();

        MyFragment fragment = new MyFragment();
        fragment.setArguments(args);
        fragment.position=position;
        return fragment;
    }

    @Nullable @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.view_item, container, false);
        assignViews(view);
        return view;
    }

    private void assignViews(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View view) {
                Toast.makeText(getActivity(), "Position:" + position, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
