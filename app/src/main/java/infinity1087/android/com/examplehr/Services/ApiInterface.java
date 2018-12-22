package infinity1087.android.com.examplehr.Services;

import infinity1087.android.com.examplehr.Client.ExClient;
import infinity1087.android.com.examplehr.model.Banner;
import infinity1087.android.com.examplehr.model.Example;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiInterface {

    @GET("api/Product/Get")
    Call<Example> getcontacts();

    @POST("api/client/clientSignUp")
    @FormUrlEncoded
    Call<ExClient> savePost(@Field("FirstName") String fname,
                            @Field("LastName") String lname,
                            @Field("Password") String password);


    @GET("Banner/BindBanner")
    @Headers("Content-Type: application/json")
    Call<Banner> getBannerImages();

}
