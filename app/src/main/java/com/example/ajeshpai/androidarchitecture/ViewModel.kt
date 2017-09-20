package com.example.ajeshpai.androidarchitecture

import io.reactivex.Observable
import io.reactivex.ObservableSource
import io.reactivex.ObservableTransformer



class ViewModel{

    val service=Service()

    /*private val submit=object :ObservableTransformer<SubmitAction,SubmitResult>{
        override fun apply(action: Observable<SubmitAction>?): ObservableSource<SubmitResult> {
            action?.flatMap(fun(obj:SubmitAction):Observable<SubmitResult>{
                return service.setName(obj.name)
            })
        }

    }*/
}
