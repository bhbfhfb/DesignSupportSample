package com.pluusystem.designsupportsample;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public final class AppBarActivity extends AppCompatActivity {

  @Bind(R.id.recyclerView)
  protected RecyclerView mRecyclerView;
  @Bind(R.id.toolbar)
  protected Toolbar mToolBar;
  @Bind(R.id.collapsingToolbarLayout)
  protected CollapsingToolbarLayout mCollapsingToolbarLayout;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_app_bar);
    //FindViewById.
    ButterKnife.bind(this);
    //ActionBar Setting.
    setSupportActionBar(mToolBar);
    ActionBar ab = getSupportActionBar();
    if (ab != null) {
      ab.setDisplayHomeAsUpEnabled(true);
    }
    //Title Setting.
    mCollapsingToolbarLayout.setTitle(getString(R.string.title_activity_app_bar));
  }

  @Override
  protected void onPostCreate(Bundle savedInstanceState) {
    super.onPostCreate(savedInstanceState);
    //RecyclerView item list create.
    List<String> list = new ArrayList<>();
    for (int i = 0; i < 20; i++) {
      list.add("Item=" + i);
    }
    //RecyclerView Config.
    mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    mRecyclerView.setAdapter(new ItemAdapter(list));
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    switch (item.getItemId()) {
      case android.R.id.home:
        finish();
        return true;
    }
    return super.onOptionsItemSelected(item);
  }

  private final static class ItemAdapter extends RecyclerView.Adapter<ItemViewHolder> {

    private final List<String> mItemList;

    public ItemAdapter(List<String> list) {
      mItemList = list;
    }

    public String getItem(int position) {
      return mItemList.get(position);
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
      LayoutInflater li = LayoutInflater.from(viewGroup.getContext());
      View view = li.inflate(R.layout.layout_recycler_item, viewGroup, false);
      return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder viewHolder, int position) {
      String text = getItem(position);
      viewHolder.setTitleText(text);
    }

    @Override
    public int getItemCount() {
      return mItemList.size();
    }
  }

  private final static class ItemViewHolder extends RecyclerView.ViewHolder {

    public TextView mTitle;

    public ItemViewHolder(View itemView) {
      super(itemView);
      mTitle = (TextView) itemView.findViewById(R.id.textView);
    }

    private void setTitleText(String text) {
      mTitle.setText(text);
    }
  }
}
