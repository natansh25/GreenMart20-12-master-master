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

public class NetworkClass {

    final static String BASE_URL = "http://portfolio.barodaweb.com/Dynamic/EGreenMarketAPI/api/Banner/BindBanner";


    //Fetching the json response

    public static List<BannerTrial> fetchMovieData(URL url) {
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


    //Building URL used to query MOVIEDB

    public static URL buildURl() {
        Uri builtUri = Uri.parse(BASE_URL).buildUpon()
                .build();
        Log.i("NewUrl", String.valueOf(builtUri));
        URL url = null;
        try {
            url = new URL(builtUri.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }


        return url;
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


}