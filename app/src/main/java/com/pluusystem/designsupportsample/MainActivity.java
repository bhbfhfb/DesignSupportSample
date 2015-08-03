package com.pluusystem.designsupportsample;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.pluusystem.designsupportsample.fragment.FloatingButtonFragment;
import com.pluusystem.designsupportsample.fragment.FloatingLabelFragment;
import com.pluusystem.designsupportsample.fragment.MainFragment;
import com.pluusystem.designsupportsample.fragment.TabsFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Bind(R.id.main_tool_bar)
  protected Toolbar mToolBar;
  @Bind(R.id.main_drawer_view)
  protected NavigationView mNavigationView;
  @Bind(R.id.drawer_layout)
  protected DrawerLayout mDrawerLayout;

  private ActionBarDrawerToggle mDrawerToggle;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    //FindViewById.
    ButterKnife.bind(this);
    //ActionBar Setting.
    setSupportActionBar(mToolBar);

    //Left Navigation Menu Initialize.
    mDrawerToggle = new ActionBarDrawerToggle(this, //Attach Activity.
                                              mDrawerLayout,//Attach Layout.
                                              mToolBar,//Optional Toolbar.
                                              R.string.app_name,//Opened Description.
                                              R.string.app_name);//Closed Description.
    mDrawerToggle.setDrawerIndicatorEnabled(true);
    mDrawerLayout.setDrawerListener(mDrawerToggle);
    mNavigationView.setNavigationItemSelectedListener(this);
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    mDrawerToggle.syncState();

    FragmentManager fm = getSupportFragmentManager();
    fm.beginTransaction()
        .replace(R.id.main_frame, MainFragment.newInstance())
        .commit();
  }

  @Override
  public void onConfigurationChanged(Configuration newConfig) {
    super.onConfigurationChanged(newConfig);
    mDrawerToggle.onConfigurationChanged(newConfig);
  }

  @Override
  public boolean onNavigationItemSelected(MenuItem menuItem) {
    int id = menuItem.getItemId();
    Fragment fragment = null;
    switch (id) {
      case R.id.navi_group1_item0:
        fragment = MainFragment.newInstance();
        break;
      case R.id.navi_group1_item1:
        fragment = FloatingLabelFragment.newInstance();
        break;
      case R.id.navi_group1_item2:
        fragment = FloatingButtonFragment.newInstance();
        break;
      case R.id.navi_group1_item3:
        fragment = TabsFragment.newInstance();
        break;
      case R.id.navi_group1_item4:
        startActivity(new Intent(this, AppBarActivity.class));
        break;
    }

    if (fragment != null) {
      //Change Attached Fragment.
      FragmentManager manager = getSupportFragmentManager();
      manager.beginTransaction().replace(R.id.main_frame, fragment).commit();

      mDrawerLayout.closeDrawers();
      menuItem.setChecked(true);
    }
    return true;
  }

}
