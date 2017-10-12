package com.rappi.rappitest.ui.list;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.rappi.rappitest.R;
import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.ui.base.BaseActivity;
import com.rappi.rappitest.ui.detail.DetailActivity;
import com.rappi.rappitest.utils.NetworkUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends BaseActivity implements ListMvpView {

    @Inject
    LinearLayoutManager manager;
    @Inject
    ListPresenter<ListMvpView> presenter;
    @Inject
    ListAdapter adapter;

    @BindView(R.id.search)
    EditText search;
    @BindView(R.id.delete)
    ImageView delete;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.label_no_items)
    TextView labelNoItems;

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
        setupRecyclerView();
        search.addTextChangedListener(new TextWatcherListener());
        search.setOnFocusChangeListener(new TextWatcherListener());

        if (NetworkUtils.isNetworkConnected(this))
            presenter.onLoadMoreItems(1);
        else
            presenter.onLoadMoreItems(-1);
    }


    @Override
    public void openDetailActivity(Movie movie) {
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

    private void setupRecyclerView() {
        recyclerView.setLayoutManager(manager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new ScrollListener(manager));
    }

    @OnClick(R.id.delete)
    public void onViewClicked() {

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
                    presenter.filterList(s.toString().toLowerCase().trim());
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
            presenter.onLoadMoreItems(page);
        }
    }
}
