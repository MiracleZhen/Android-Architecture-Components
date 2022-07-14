package com.ling.mvp.data.network

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.ling.mvp.di.ApiKeyInfo
import javax.inject.Inject

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : ApiHeader
 */
class ApiHeader @Inject constructor(internal val publicApiHeader: PublicApiHeader,
                                    internal val protectedApiHeader: ProtectedApiHeader) {

    class PublicApiHeader @Inject constructor(
        @Expose
        @SerializedName("api_key")
        @ApiKeyInfo
        val apiKey: String
    )

    class ProtectedApiHeader @Inject constructor(
        @Expose
        @SerializedName("api_key")
        val apiKey: String,

        @Expose
        @SerializedName("user_id")
        val userId: Long?,

        @Expose
        @SerializedName("access_token")
        val accessToken: String?
    )
}
