package com.rappi.rappitest.ui.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rappi.rappitest.R;
import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.data.network.ApiEndPoint;
import com.rappi.rappitest.ui.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class DetailActivity extends BaseActivity {
    public static final String PARAM_MOVIE = "MOVIE";
    @BindView(R.id.photo)
    ImageView photo;
    @BindView(R.id.name)
    TextView name;
    @BindView(R.id.rating)
    TextView rating;
    @BindView(R.id.overview)
    TextView overview;
    @BindView(R.id.language)
    TextView language;
    @BindView(R.id.adult_content)
    TextView adultContent;
    @BindView(R.id.release_date)
    TextView releaseDate;
    @BindView(R.id.popularity)
    TextView popularity;
    private Movie movie;

    public static Intent getStartIntent(Context context, Movie movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(PARAM_MOVIE, movie);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        if (getIntent() != null && getIntent().hasExtra(PARAM_MOVIE)) {
            movie = (Movie) getIntent().getSerializableExtra(PARAM_MOVIE);
            setUp();
        }

    }

    @Override
    protected void setUp() {
        Glide.with(this)
                .load(ApiEndPoint.ENDPOINT_IMAGES + movie.getImageUrl())
                .apply(RequestOptions.centerCropTransform())
                .into(photo);


        name.setText(movie.getName());
        rating.setText(String.valueOf(movie.getVoteAvg()));
        overview.setText(movie.getOverview());
        language.setText(movie.getLanguage().toUpperCase());
        adultContent.setText(movie.isAdultContent() ? "YES" : "NO");
        releaseDate.setText(movie.getDate());
        popularity.setText(String.valueOf(movie.getPopularity()));
    }

    @OnClick(R.id.back)
    public void onViewClicked() {
        onBackPressed();
    }
}
