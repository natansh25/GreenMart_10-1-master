package infinity1087.android.com.examplehr.Services;

import infinity1087.android.com.examplehr.Client.ExClient;
import infinity1087.android.com.examplehr.model.Banner;
import infinity1087.android.com.examplehr.ProductDetailModel.ResultList;
import infinity1087.android.com.examplehr.model.SwaggerPost;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("Product/{id}/BindByProductGroupID")
    Call<ResultList> getcontacts(@Path("id") int id);

    @POST("api/client/clientSignUp")
    @FormUrlEncoded
    Call<ExClient> savePost(@Field("FirstName") String fname,
                            @Field("LastName") String lname,
                            @Field("Password") String password);

    @GET("Banner/BindBanner")
    @Headers("Content-Type: application/json")
    Call<Banner> getBannerImages();

    @POST("ClientMaster/clientSignUp")
    @FormUrlEncoded
    Call<SwaggerPost> signUp(@Field("FirstName") String fname,
                             @Field("LastName") String lname,
                             @Field("Email") String email);

    @POST("clientSignUp")

    Call<SwaggerPost> google_sign_in(@Body SwaggerPost swaggerPost);


    @POST("clientSignUp")
    @FormUrlEncoded
    Call<SwaggerPost> fb_sign_in(@Field("FirstName") String fname,
                                 @Field("LastName") String lname,
                                 @Field("Email") String email);


}
