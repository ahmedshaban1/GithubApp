package com.task

import android.content.Context
import com.task.remote.BuildConfig
import com.task.remote.R
import okhttp3.*

class MockInterceptor(private val context: Context): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        if (BuildConfig.BUILD_TYPE != "release") {
            val uri = chain.request().url().uri().toString()
            val responseString = when {
                uri.contains("search") -> context.resources.openRawResource(R.raw.repo_mock_response)
                    .bufferedReader().use { it.readText() }
                else -> ""
            }

            return chain.proceed(chain.request())
                .newBuilder()
                .code(200)
                .protocol(Protocol.HTTP_2)
                .message(responseString)
                .body(
                    ResponseBody.create(
                        MediaType.parse("application/json"),
                        responseString.toByteArray()))
                .addHeader("content-type", "application/json")
                .build()
        } else {
            return chain.proceed(chain.request())
        }
    }
}

