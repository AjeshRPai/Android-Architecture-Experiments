package com.example.ajeshpai.androidarchitecture

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.widget.ContentLoadingProgressBar
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    private lateinit var viewmodelFactory:ViewModelFactory
    private lateinit var viewModel:MyViewModel

    private val disposable=CompositeDisposable()

    private lateinit var recycler_view:RecyclerView

    private val adapter=MyRecyclerViewAdapter(null)

    private lateinit var fab:FloatingActionButton

    private lateinit var progress_bar:ContentLoadingProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewmodelFactory=Injection.provideViewModelFactory(this)
        viewModel=ViewModelProviders.of(this,viewmodelFactory).get(MyViewModel::class.java)
        recycler_view=findViewById(R.id.my_recycler_view)
        recycler_view.layoutManager=LinearLayoutManager(this)
        recycler_view.adapter=adapter
        fab=findViewById(R.id.add)

        fab.setOnClickListener {
            viewModel.addName(MyPojo("this is one"))
        }

        progress_bar=findViewById(R.id.contentLoading)
    }

    override fun onStart() {
        super.onStart()
        disposable.addAll(viewModel.getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe{ progress_bar.hide()
            adapter.additems(it)
            recycler_view.visibility=View.VISIBLE})

    }

    override fun onStop() {
        super.onStop()
        disposable.clear()
    }





}
