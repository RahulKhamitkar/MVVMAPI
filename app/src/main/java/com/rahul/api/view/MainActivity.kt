package com.rahul.api.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.rahul.api.R
import com.rahul.api.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        viewModel.refresh()

        observerViewModel()
    }

    private fun observerViewModel() {

        viewModel.response.observe(this, Observer {
            tv_responseFirstName.text= viewModel.response.value?.data?.firstName
            tv_responseLastName.text = viewModel.response.value?.data?.lastName
        })
    }

}
