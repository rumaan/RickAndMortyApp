package me.thecoolguy.rickandmorty.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*
import me.thecoolguy.rickandmorty.R
import me.thecoolguy.rickandmorty.api.ApiService
import me.thecoolguy.rickandmorty.api.BASE_URL
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var disposable: Disposable

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // TODO: remove this
        // This is just a test function to check the API end points
        // TODO: Write Instrumented tests

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val apiService = retrofit.create(ApiService::class.java)

        disposable = apiService.getAllCharacters()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = {
                            response.text = it.results?.toString()
                        },
                        onError = {
                            Log.e(TAG, it.localizedMessage, it)
                        }
                )

    }

    override fun onStop() {
        super.onStop()
        disposable.dispose()
    }
}
