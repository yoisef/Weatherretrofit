package youssef.com.weatherretrobg;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import model.WeatherDetails;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView cityy;
    private TextView tempp;
    private TextView cloudd;
    private TextView presuree;
    private TextView humdityy;
    private TextView sunrise;
    private TextView sunsett;
    private TextView updatee;
    private TextView thumbnaill;
    private TextView condition;
    private Button asd;
    private String answer;
    String cityde;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cityy = (TextView) findViewById(R.id.citytext);
        tempp = (TextView) findViewById(R.id.temptext);
        cloudd = (TextView) findViewById(R.id.cloudtext);
        presuree = (TextView) findViewById(R.id.pressuretext);
        humdityy = (TextView) findViewById(R.id.humidtytext);
        sunrise = (TextView) findViewById(R.id.sunrise);
        sunsett = (TextView) findViewById(R.id.sunset);
        thumbnaill = (TextView) findViewById(R.id.thumbnailicon);
        condition = (TextView) findViewById(R.id.condition);

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Apiint apiinterface=retrofit.create(Apiint.class);
        Call<WeatherDetails> connection=apiinterface.getinfo("Cairo,Eg");
        connection.enqueue(new Callback<WeatherDetails>() {
            @Override
            public void onResponse(Call<WeatherDetails> call, Response<WeatherDetails> response) {

                cityy.setText(response.body().getCountry());
              //  tempp.setText(response.body().getTemp());
                presuree.setText(response.body().getPressure());

            }

            @Override
            public void onFailure(Call<WeatherDetails> call, Throwable t) {

            }
        });


    }
}
