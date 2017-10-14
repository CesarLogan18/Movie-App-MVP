

package com.rappi.rappitest.data;


import com.rappi.rappitest.data.db.DbHelper;
import com.rappi.rappitest.data.db.model.Movie;
import com.rappi.rappitest.data.network.ApiHelper;

public interface DataManager extends DbHelper, ApiHelper {

    void setCurrentMovie(Movie movie);

    Movie getCurrentMovie();
}
