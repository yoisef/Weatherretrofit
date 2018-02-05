package youssef.com.weatherretrobg;

import model.WeatherDetails;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by mohamed on 04/02/2018.
 */

public interface Apiint {
    @GET("data/2.5/weather?q=city&units=metric")
    Call<WeatherDetails> getinfo(@Query("q") String city);
}
