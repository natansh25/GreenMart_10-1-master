package infinity1087.android.com.examplehr.Network;

import android.graphics.Movie;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import infinity1087.android.com.examplehr.model.Banner;
import infinity1087.android.com.examplehr.model.BannerTrial;
import infinity1087.android.com.examplehr.model.MainButtonImage;

public class NetworkClass {

    public static String BANNER_BASE_URL = "http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/api/Banner/BindBanner";
    public static String MAIN_BUTTON_URL = "http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/api/ProductGroup/BindProductGroup";

    //Fetching the json response

    public static List<BannerTrial> fetchBannerData(URL url) {
        Log.i("xyz", String.valueOf(url));

        String jsonResponse = null;
        try {
            jsonResponse = getResponseFromHttpUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<BannerTrial> bannerImages = extractFeaturesFromJson(jsonResponse);
        return bannerImages;

    }

    public static List<MainButtonImage> fetchMainButtonData(URL url) {
        Log.i("xyz", String.valueOf(url));

        String jsonResponse = null;
        try {
            jsonResponse = getResponseFromHttpUrl(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<MainButtonImage> bannerImages = extractMainData(jsonResponse);
        return bannerImages;

    }


    //Building URL used to query MOVIEDB

    public static URL buildURl(String url) {
        Uri builtUri = Uri.parse(url).buildUpon()
                .build();
        Log.i("NewUrl", String.valueOf(builtUri));
        URL url2 = null;
        try {
            url2 = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url2;
    }

    //Method for getting response from Network

    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

    //Method for json parsing

    private static List<BannerTrial> extractFeaturesFromJson(String Json) {

        if (TextUtils.isEmpty((Json))) {
            return null;
        }

        //creating empty array list to add the movies
        List<BannerTrial> movie = new ArrayList<>();

        try {

            JSONObject baseJsonResponse = new JSONObject(Json);


            JSONArray movieArray = baseJsonResponse.getJSONArray("ResponseData");


            for (int i = 0; i < movieArray.length(); i++) {

                JSONObject currentMovie = movieArray.getJSONObject(i);

                String img_path = currentMovie.getString("BannerImage");


                BannerTrial movie1 = new BannerTrial(img_path);

                movie.add(movie1);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movie;
    }

    private static List<MainButtonImage> extractMainData(String Json) {

        if (TextUtils.isEmpty((Json))) {
            return null;
        }

        //creating empty array list to add the movies
        List<MainButtonImage> movie = new ArrayList<>();

        try {

            JSONObject baseJsonResponse = new JSONObject(Json);

            JSONArray movieArray = baseJsonResponse.getJSONArray("ResponseData");

            for (int i = 0; i < movieArray.length(); i++) {

                JSONObject currentMovie = movieArray.getJSONObject(i);

                String id = currentMovie.getString("ProductGroupId");
                String txtname = currentMovie.getString("ProductGroupName");
                String img_icon = currentMovie.getString("ProductGroupIcon");
                String group_image = currentMovie.getString("ProductGroupImage");
                String groupBannerImage = currentMovie.getString("ProductGroupBannerImage");

                MainButtonImage movie1 = new MainButtonImage(img_icon, group_image, groupBannerImage,txtname,id);

                movie.add(movie1);

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return movie;
    }


}