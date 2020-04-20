package com.skteam.unitopper.retrofit;


import com.skteam.unitopper.loginregister.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitApi {


@FormUrlEncoded
    @POST("check_user.php")
Call<User> checkIfUserAlreadyExist(@Field("Mobile_Number") String number, @Field("Email") String email);

//
@FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("Full_Name") String full_name,
                               @Field("Email") String email,
                               @Field("Mobile_Number") String mobile_number,
                               @Field("User_Password") String user_password,
                               @Field("College_Name") String college_name,
                               @Field("University") String university,
                               @Field("Device_Id") String device_id,
                               @Field("Register_Date") String reg_date);

    @FormUrlEncoded
    @POST("login.php")
    Call<User> userLogin(@Field("Mobile_Number") String mobile_number,
                         @Field("User_Password") String user_password);
//
//    @FormUrlEncoded
//    @POST("check_promo_code.php")
//    Call<User> checkExistsPromoCode(@Field("Promo_Code") String promo_code);
//
//    @FormUrlEncoded
//    @POST("credit_referal_amount.php")
//    Call<User> creditReferalAmount(@Field("Email") String email,
//                                   @Field("Wallet") int wallet);
//
//        @GET("list_home_slider.php")
//   Call<HomeItemResponse>  getHomeSliderImages();
//
//    @GET("list_games.php")
//    Call<HomeItemResponse>  getGamesList();
//
//    @GET("list_badges.php")
//    Call<ProfileItemResponse>  getProfileBadgesList();
//
//    @FormUrlEncoded
//    @POST("update_user_profile.php")
//    Call<User> updateUserProfile(@Field("name") String name,
//                                 @Field("email") String email,
//                                 @Field("date_of_birth") String date_of_birth,
//                                 @Field("profile_picture") String profile_picture);
//
//    @FormUrlEncoded
//    @POST("redeem.php")
//    Call<User> updateWalletRedeem(@Field("Email") String email,
//                                  @Field("Wallet") int wallet,
//                                  @Field("Paytm") int paytm,
//                                  @Field("Paytm_Number") String paytm_number);
//

//
//    @FormUrlEncoded
//    @POST("get_referal_detail_by_email.php")
//    Call<User> getReferalDetailByEmail(@Field("Email") String email);
//
//    @FormUrlEncoded
//    @POST("fetch_user_detail.php")
//    Call<User> getUserDetail(@Field("Email") String email);
//
//    @FormUrlEncoded
//    @POST("credit_referal_amount.php")
//    Call<User> creditReferalAmount(@Field("Email") String email,
//                                   @Field("Scratch_Card") int scratch_card);
//
//    @FormUrlEncoded
//    @POST("credit_user_reward.php")
//    Call<User> creditUserReward(@Field("Email") String email,
//                                @Field("Scratch_Card") int scratch_card,
//                                @Field("Wallet") int wallet,
//                                @Field("Total_Reward") int total_reward);
//    @FormUrlEncoded
//    @POST("credit_scratch_card.php")
//    Call<User> creditScratchCard(@Field("Email") String email,
//                                 @Field("Scratch_Card") int scratch_card);
//
//    @FormUrlEncoded
//    @POST("get_website_time.php")
//    Call<User> getWebsiteTime(@Field("Email") String email,
//                              @Field("Website") String website);
//
//    @FormUrlEncoded
//    @POST("update_website_time.php")
//    Call<User> updateWebsiteTime(@Field("Email") String email,
//                                 @Field("Website") String website,
//                                 @Field("Time") String time);
//
////
////
////    @GET("livedata.php")
////    Call<LiveDataResponse>  getLiveData();
////
////    @GET("historydata.php")
////    Call<LiveDataResponse>  getHistoryData();
////
//    @GET("get_demo_list.php")
//    Call<SliderItemResponse>  getDemoList();


}
