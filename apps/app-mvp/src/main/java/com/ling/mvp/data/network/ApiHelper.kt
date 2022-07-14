package com.ling.mvp.data.network

import com.ling.mvp.data.network.model.*
import io.reactivex.Observable

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : ApiHelper
 */
interface ApiHelper {

    fun performServerLogin(request: LoginRequest.ServerLoginRequest): Observable<LoginResponse>

    fun performFBLogin(request: LoginRequest.FacebookLoginRequest): Observable<LoginResponse>

    fun performGoogleLogin(request: LoginRequest.GoogleLoginRequest): Observable<LoginResponse>

    fun performLogoutApiCall(): Observable<LogoutResponse>

    fun getBlogApiCall(): Observable<BlogResponse>

    fun getOpenSourceApiCall(): Observable<OpenSourceResponse>
}
