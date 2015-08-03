package com.pluusystem.designsupportsample.fragment;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.pluusystem.designsupportsample.R;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Created by PLUUSYSTEM-NEW on 2015-05-31.
 */
@SuppressWarnings("DefaultFileTemplate")
public class FloatingButtonFragment extends Fragment implements View.OnClickListener {

  @InjectView(R.id.coordinatorLayout)
  CoordinatorLayout coordinatorLayout;

  /**
   * Create New Fragment.
   *
   * @return Fragment.
   */
  public static FloatingButtonFragment newInstance() {
    return new FloatingButtonFragment();
  }

  @Override
  public View onCreateView(LayoutInflater i, ViewGroup c, Bundle s) {
    return i.inflate(R.layout.fragment_floating_button, c, false);
  }

  @Override
  public void onViewCreated(View view, Bundle savedInstanceState) {
    ButterKnife.inject(this, view);
  }

  @Override
  public void onDestroyView() {
    super.onDestroyView();
    ButterKnife.reset(this);
  }

  @OnClick(R.id.actionButton)
  public void viwSnackBar() {
    Snackbar.make(coordinatorLayout, R.string.snackbar_text, Snackbar.LENGTH_LONG)
        .setAction(R.string.snackbar_action, this)
        .setActionTextColor(getResources().getColor(R.color.color_snackbar_action))
        .show();
  }

  @Override
  public void onClick(View v) {
    Toast.makeText(getActivity(), "UNDO", Toast.LENGTH_SHORT).show();
  }
}
