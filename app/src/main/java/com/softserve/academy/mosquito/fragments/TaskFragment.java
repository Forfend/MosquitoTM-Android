package com.softserve.academy.mosquito.fragments;

import android.support.v4.app.Fragment;
import android.widget.TextView;

import com.softserve.academy.mosquito.R;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EFragment;
import org.androidannotations.annotations.ViewById;

@EFragment(R.layout.fragment_task)
public class TaskFragment extends Fragment {

    @ViewById(R.id.task_fragment_name)
    TextView textView;

    @AfterViews
    public void set(){
    }

}
