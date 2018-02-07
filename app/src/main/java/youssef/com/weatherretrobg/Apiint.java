package youssef.com.weatherretrobg;

import model.Example;
import model.Sys;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by mohamed on 04/02/2018.
 */

public interface Apiint {
    @GET("weather?appid=5f50c9540b0cb55aa216ec61a2d91857")
    Call<Example> getinfo(@Query("q") String city);
}
