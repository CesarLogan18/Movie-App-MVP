

package com.rappi.rappitest.data.network;

import com.rappi.rappitest.BuildConfig;



public final class ApiEndPoint {

    public static final String ENDPOINT_MOVIES = BuildConfig.BASE_URL
            + "{pageNumber}/movie/popular";
    public static final String ENDPOINT_MOVIES_PARAM = "api_key";
    public static final String ENDPOINT_MOVIES_PARAM_PATH = "pageNumber";

    private ApiEndPoint() {
        // This class is not publicly instantiable
    }

}
