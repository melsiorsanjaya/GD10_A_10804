package com.jaya.gd10_a_10804

import android.telecom.Call
import retrofit2.http.*

interface api {
    @GET("mahasiswa/{cari}")
    fun getData(@Path("cari") cari:String? = null):
            retrofit2.Call<ResponseDataMahasiswa>
    @FormUrlEncoded
    @POST("mahasiswa")
    fun createData(
        @Field("mhsnobp") mhsnobp:String?,
        @Field("mhsnama") mhsnama:String?,
        @Field("mhsalamat") mhsalamat:String?,
        @Field("prodinama") prodinama:String?,
        @Field("mhstgllhr") mhstgllhr:String?,
    ):retrofit2.Call<ResponseCreate>
    @DELETE("mahasiswa/{mhsnobp}")
    fun deleteData(@Path("mhsnobp")mhsnobp:
                   String?):retrofit2.Call<ResponseCreate>
    @FormUrlEncoded
    @PUT("mahasiswa/{mhsnobp}")
    fun updateData(
        @Path("mhsnobp") mhsnobp:String?,
        @Field("mhsnama") mhsnama:String?,
        @Field("mhsalamat") mhsalamat:String?,
        @Field("prodinama") prodinama:String?,
        @Field("mhstgllhr") mhstgllhr:String?,
    ):retrofit2.Call<ResponseCreate>
}
