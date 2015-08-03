package com.pluusystem.designsupportsample.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pluusystem.designsupportsample.R;

/**
 * Created by PLUUSYSTEM-NEW on 2015-05-31.
 */
@SuppressWarnings("DefaultFileTemplate")
public final class FloatingLabelFragment extends Fragment {

  public static FloatingLabelFragment newInstance() {
    return new FloatingLabelFragment();
  }

  public FloatingLabelFragment() {
  }

  @Override
  public View onCreateView(LayoutInflater i, ViewGroup c, Bundle s) {
    return i.inflate(R.layout.fragment_floating_label, c, false);
  }
}
