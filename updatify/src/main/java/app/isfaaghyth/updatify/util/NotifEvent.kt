package app.isfaaghyth.updatify.util

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

/**
 * Created by isfaaghyth on 6/16/18.
 * github: @isfaaghyth
 */
class NotifEvent {

    private val instance: NotifEvent = NotifEvent()
    private val subject: PublishSubject<Any> = PublishSubject.create()

    fun getInstance(): NotifEvent = instance

    fun <T> register(tClass: Class<T>, onNext: Consumer<Any>, onError: Consumer<Throwable>): Disposable =
            subject
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .filter({ o -> o == tClass })
                    .map({ o -> o })
                    .subscribe(onNext, onError)

    fun unregister(disposable: Disposable) = disposable.dispose()

    fun post(any: Any) = subject.onNext(any)

}