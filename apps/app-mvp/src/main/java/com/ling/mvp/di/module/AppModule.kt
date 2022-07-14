package com.ling.mvp.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.ling.mvp.BuildConfig
import com.ling.mvp.app.AppConstants
import com.ling.mvp.data.database.AppDatabase
import com.ling.mvp.data.database.repository.options.OptionRepo
import com.ling.mvp.data.database.repository.options.OptionRepository
import com.ling.mvp.data.database.repository.questions.QuestionRepo
import com.ling.mvp.data.database.repository.questions.QuestionRepository
import com.ling.mvp.data.network.ApiHeader
import com.ling.mvp.data.network.ApiHelper
import com.ling.mvp.data.network.AppApiHelper
import com.ling.mvp.data.preferences.AppPreferenceHelper
import com.ling.mvp.data.preferences.PreferenceHelper
import com.ling.mvp.di.ApiKeyInfo
import com.ling.mvp.di.DatabaseInfo
import com.ling.mvp.di.PreferenceInfo
import com.ling.mvp.utils.SchedulerProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Singleton

/**
 * author : wangchengzhen
 * time   : 2022/7/8
 * desc   : AppModule
 */
@Module
class AppModule {

    @Singleton
    @Provides
    internal fun provideContext(application: Application): Context = application

    /* 轻量级键值对存储 - (key - value) */

    @PreferenceInfo
    @Provides
    internal fun providePrefFileName(): String = AppConstants.PREF_NAME

    @Singleton
    @Provides
    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper): PreferenceHelper =
        appPreferenceHelper

    /* 数据库存储 - (database) */

    @DatabaseInfo
    @Provides
    internal fun provideDatabaseName(): String = AppConstants.APP_DB_NAME

    @Singleton
    @Provides
    internal fun provideAppDatabase(context: Context, @DatabaseInfo databaseName: String): AppDatabase {
        return Room.databaseBuilder(context, AppDatabase::class.java, databaseName).build()
    }

    @Singleton
    @Provides
    internal fun provideQuestionRepoHelper(appDatabase: AppDatabase): QuestionRepo =
        QuestionRepository(appDatabase.questionDao())

    @Singleton
    @Provides
    internal fun provideOptionRepoHelper(appDatabase: AppDatabase): OptionRepo =
        OptionRepository(appDatabase.optionDao())

    /* 网络访问 - (network) */

    @ApiKeyInfo
    @Provides
    internal fun provideApiKey(): String = BuildConfig.API_KEY

    @Singleton
    @Provides
    internal fun provideProtectedApiHeader(@ApiKeyInfo apiKey: String, preferenceHelper: PreferenceHelper): ApiHeader.ProtectedApiHeader =
        ApiHeader.ProtectedApiHeader(apiKey = apiKey,
            userId = preferenceHelper.getCurrentUserId(),
            accessToken = preferenceHelper.getAccessToken())

    @Singleton
    @Provides
    internal fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper = appApiHelper

    /* 其他 - (others) */

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()

    @Provides
    internal fun provideSchedulerProvider(): SchedulerProvider = SchedulerProvider()
}
