package me.thecoolguy.rickandmorty.activities

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
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

class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_characters -> {
                Toast.makeText(this, "${item.itemId} selected!", Toast.LENGTH_SHORT).show()
            }
            R.id.menu_locations -> {

            }
            R.id.menu_episodes -> {

            }
        }
        return true
    }

    private lateinit var disposable: Disposable

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /* Set up Bottom navigation view */
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
        bottomNavigationView.selectedItemId = R.id.menu_characters

        // TODO: remove this
        // This is just a test function to check the API end points
        // TODO: Write Instrumented tests

        val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        val apiService = retrofit.create(ApiService::class.java)

        disposable = apiService.getEpisodeWithId(1)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribeBy(
                        onNext = {
                            Log.d(TAG, it.toString())
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
