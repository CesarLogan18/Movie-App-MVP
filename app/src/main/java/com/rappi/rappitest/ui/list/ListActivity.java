package com.rappi.rappitest.ui.list;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SwitchCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rappi.rappitest.R;
import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.ui.base.BaseActivity;
import com.rappi.rappitest.ui.detail.DetailActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends BaseActivity implements ListMvpView, ListAdapter.Callback {

    @Inject
    LinearLayoutManager manager;
    @Inject
    ListPresenter<ListMvpView> presenter;
    @Inject
    ListAdapter adapter;

    ScrollListener scrollListener;

    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.delete)
    ImageView delete;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.label_no_items)
    TextView labelNoItems;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    @BindView(R.id.simple_switch)
    SwitchCompat switchCompat;
    @BindView(R.id.search_bar)
    LinearLayout searchBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        presenter.onAttach(ListActivity.this);

        setUp();

    }

    @Override
    protected void onDestroy() {
        presenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        adapter.setCallback(this);
        setupRecyclerView();
        setupTabLayout();
        switchCompat.setOnCheckedChangeListener(new SwitchListener());
        tabLayout.setOnTabSelectedListener(new TabListener());
        search.addTextChangedListener(new TextWatcherListener());
        search.setOnFocusChangeListener(new TextWatcherListener());

        presenter.onLoadMoreItems(1, 0);

    }


    @Override
    public void openDetailActivity() {
        startActivity(DetailActivity.getStartIntent(this));
    }

    @Override
    public void refreshList(List<Movie> items) {
        adapter.addItems(items);
    }

    @Override
    public void showLabelNoItem() {
        labelNoItems.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLabelNoItem() {
        labelNoItems.setVisibility(View.GONE);
    }

    @Override
    public void showSearchBar() {
        searchBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideSearchBar() {
        searchBar.setVisibility(View.GONE);
    }

    @Override
    public void resetAdapter() {
        adapter.deleteItems();
        scrollListener.resetState();

    }

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        scrollListener = new ScrollListener(manager);
        recyclerView.addOnScrollListener(scrollListener);
    }

    private void setupTabLayout() {

        tabLayout.addTab(tabLayout.newTab().setText(R.string.list_tab_1));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.list_tab_2));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.list_tab_3));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
    }

    @OnClick(R.id.delete)
    public void onViewClicked() {
        search.getText().clear();
    }

    @Override
    public void onItemClick(Movie movie) {
        presenter.onMovieSelected(movie);
    }

    private class TextWatcherListener implements TextWatcher, View.OnFocusChangeListener {

        Handler handler = new Handler(Looper.getMainLooper());
        Runnable workRunnable;

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(final CharSequence s, int start, int before, int count) {

            handler.removeCallbacks(workRunnable);
            workRunnable = new Runnable() {
                @Override
                public void run() {

                    presenter.filterList(tabLayout.getSelectedTabPosition(), s.toString().toLowerCase().trim());

                }
            };
            handler.postDelayed(workRunnable, 500);


        }

        @Override
        public void afterTextChanged(Editable s) {

        }

        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus)
                hideKeyboard();
        }
    }

    private class ScrollListener extends EndlessScrollListener {


        public ScrollListener(LinearLayoutManager layoutManager) {
            super(layoutManager);
            resetState();
        }

        @Override
        public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
            if (!switchCompat.isChecked())
                presenter.onLoadMoreItems(page, tabLayout.getSelectedTabPosition());
        }
    }

    private class SwitchListener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            presenter.onModeChange(tabLayout.getSelectedTabPosition(), b);
        }
    }

    private class TabListener implements TabLayout.OnTabSelectedListener {

        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            search.getText().clear();
            presenter.onTabChange(tabLayout.getSelectedTabPosition(), switchCompat.isChecked());
        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }
}
