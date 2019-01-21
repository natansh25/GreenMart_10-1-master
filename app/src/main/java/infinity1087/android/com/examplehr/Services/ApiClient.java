package infinity1087.android.com.examplehr.Services;

import android.util.JsonReader;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    public static final String BASE_URL = "http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/api/";
    public static final String Swagger_url="http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/api/";
    public static Retrofit retrofit = null;

    private static Gson gson = new GsonBuilder()
            .setLenient().excludeFieldsWithoutExposeAnnotation().create();

    public static Retrofit getApiClient(String url) {

        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
