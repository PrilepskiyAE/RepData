package prilepsky.repdata.lib

import androidx.lifecycle.ViewModel

abstract class RepDataViewModel<T>(val repData: RepData<T>): ViewModel(), RepDataObserver<T> {
    override fun onCleared() {
        repData.unobserve(this)
    }
}