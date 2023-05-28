package com.example.habtracker.di

import com.example.habtracker.common.Constants
import com.example.habtracker.data.remote.QuoteApi
import com.example.habtracker.data.repositories.RepositoryImplement
import com.example.habtracker.domain.repositories.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    val logging = HttpLoggingInterceptor()

    val httpClient = OkHttpClient.Builder().apply{
        addInterceptor (
            Interceptor{
                chain ->
                val builder = chain.request().newBuilder()
                builder.header("X-Theysaidso-Api-Secret", Constants.API_KEY)
                return@Interceptor chain.proceed(builder.build())
            }
        )
        logging.level = HttpLoggingInterceptor.Level.BODY
        addNetworkInterceptor(logging)
    }.build()

    @Provides
    @Singleton
    fun provideQuoteApi() : QuoteApi{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(httpClient)
            .build()
            .create(QuoteApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRepository(api: QuoteApi) : Repository{
        return RepositoryImplement(api)
    }
}