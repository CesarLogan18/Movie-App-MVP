

package com.rappi.rappitest.data.network;

import com.rappi.rappitest.BuildConfig;
import com.rappi.rappitest.data.network.model.MovieListResponse;
import com.rx2androidnetworking.Rx2AndroidNetworking;

import javax.inject.Inject;
import javax.inject.Singleton;

import io.reactivex.Observable;


@Singleton
public class AppApiHelper implements ApiHelper {

    @Inject
    public AppApiHelper() {

    }
    @Override
    public Observable<MovieListResponse> doMovieListApiCall(int page) {
        return Rx2AndroidNetworking.get(ApiEndPoint.ENDPOINT_MOVIES)
                .addQueryParameter(ApiEndPoint.ENDPOINT_MOVIES_PARAM_PAGE, String.valueOf(page))
                .addQueryParameter(ApiEndPoint.ENDPOINT_MOVIES_PARAM_API, BuildConfig.API_KEY)
                .build()
                .getObjectObservable(MovieListResponse.class);
    }
}

