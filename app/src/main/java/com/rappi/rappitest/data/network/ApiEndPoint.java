

package com.rappi.rappitest.data.network;

import com.rappi.rappitest.BuildConfig;


public final class ApiEndPoint {

    public static final String ENDPOINT_MOVIES_POPULAR = BuildConfig.BASE_URL
            + "3/movie/popular";
    public static final String ENDPOINT_MOVIES_TOP_RATED = BuildConfig.BASE_URL
            + "3/movie/top_rated";
    public static final String ENDPOINT_MOVIES_UPCOMING = BuildConfig.BASE_URL
            + "3/movie/upcoming";
    public static final String ENDPOINT_MOVIES_PARAM_API = "api_key";
    public static final String ENDPOINT_MOVIES_PARAM_PAGE = "page";

    public static final String ENDPOINT_IMAGES = "https://image.tmdb.org/t/p/w500";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
