package com.rappi.rappitest.ui.list;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.rappi.rappitest.R;
import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.data.network.ApiEndPoint;
import com.rappi.rappitest.utils.AppConstants;
import com.rappi.rappitest.utils.ErrorHandlerUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MyViewHolder> {

    private ArrayList<Movie> movies;
    private Callback mCallback;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        int position;
        @BindView(R.id.photo)
        ImageView photo;
        @BindView(R.id.name)
        TextView name;
        @BindView(R.id.rating)
        TextView voteAvg;
        @BindView(R.id.year)
        TextView year;

        public MyViewHolder(View root) {
            super(root);
            ButterKnife.bind(this, itemView);
            setIsRecyclable(false);
        }

        public void onBind(int position) {
            this.position = position;

            final Movie movie = movies.get(position);

            name.setText(movie.getName());
            voteAvg.setText(String.valueOf(movie.getVoteAvg()));

            try {

                Calendar cal = Calendar.getInstance();
                cal.setTime(new SimpleDateFormat(AppConstants.TIMESTAMP_FORMAT, Locale.US).parse(movie.getDate()));
                year.setText(String.valueOf(cal.get(Calendar.YEAR)));
            } catch (ParseException e) {
                e.printStackTrace();
            }

            Glide.with(itemView.getContext())
                    .load(ApiEndPoint.ENDPOINT_IMAGES + movie.getImageUrl())
                    .apply(RequestOptions.circleCropTransform())
                    .into(photo);


//            itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    if (repo.getProjectUrl() != null) {
//                        Intent intent = new Intent();
//                        intent.setAction(Intent.ACTION_VIEW);
//                        intent.addCategory(Intent.CATEGORY_BROWSABLE);
//                        intent.setData(Uri.parse(repo.getProjectUrl()));
//                        itemView.getContext().startActivity(intent);
//                    }
//                }
//            });
        }
    }

    public void setCallback(Callback callback) {
        mCallback = callback;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Inject
    public ListAdapter() {
        this.movies = new ArrayList<>();
    }

    public void addItems(List<Movie> movies) {
        ErrorHandlerUtils.mCheckNotNull(movies);
        this.movies.addAll(movies);
        notifyDataSetChanged();
    }

    public void deleteItems() {
        movies.clear();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item, parent, false));
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }


    private class OnClickItemListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            mCallback.onItemClick(movies.get((Integer) view.getTag()));
        }
    }

    public interface Callback {
        void onItemClick(Movie movie);
    }

}
