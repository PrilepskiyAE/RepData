package prilepsky.repdata.lib

import android.util.Log

class RepData<T> @JvmOverloads constructor(private var data: T? = null) {
    private val observers: MutableList<RepDataObserver<T>> = mutableListOf()

    fun observe(observer: RepDataObserver<T>) {
        if (!observers.contains(observer))
            observers.add(observer)
        else
            Log.d(this::class.java.name, "Observer $observer is already observing this RepData.")
    }

    fun unobserve(observer: RepDataObserver<T>) {
        observers.remove(observer)
    }

    @JvmOverloads
    fun postData(data: T?, notifyObservers: Boolean = true) {
        this.data = data

        if (notifyObservers)
            notifyObservers()
    }

    private fun notifyObservers() {
        observers.forEach {
            it.onRepDataChanged(data)
        }
    }
}

fun <T> repDataOf(data: T?) = RepData(data)

fun <T> emptyRepData() = RepData<T>()