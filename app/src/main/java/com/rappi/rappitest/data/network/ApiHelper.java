
package com.rappi.rappitest.data.network;

import com.rappi.rappitest.data.network.model.MovieListResponse;

import io.reactivex.Observable;

public interface ApiHelper {
    Observable<MovieListResponse> doMovieListApiCall(int page);
}
