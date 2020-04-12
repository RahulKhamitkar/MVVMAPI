package com.rahul.api.viewmodel

import android.app.Application
import android.util.Log
import com.rahul.api.Service.ApiClient
import com.rahul.api.Service.ApiInterface
import com.rahul.api.model.Model
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.launch
import androidx.lifecycle.MutableLiveData
import io.reactivex.Observer
import io.reactivex.disposables.Disposable


class MainViewModel(application: Application): BaseViewModel(application){

    private val disposable = CompositeDisposable()
    private val apiClient = ApiClient()
    val response = MutableLiveData<Model>()



    fun refresh(){
        fetchFromRemote()
    }

    private fun fetchFromRemote() {
        disposable.add(
            apiClient.getData()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : Observer<Model>, Disposable {
                    override fun onComplete() {
                    }

                    override fun onSubscribe(d: Disposable) {
                    }

                    override fun onNext(t: Model) {
                        response.value = t
                        Log.i("First Name ","First Name ${t.data.firstName}")

                    }

                    override fun onError(e: Throwable) {
                    }

                    override fun isDisposed(): Boolean {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                    override fun dispose() {
                        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                    }

                })
        )


    }

    override fun onCleared() {
        super.onCleared()
        disposable.clear()

    }
}