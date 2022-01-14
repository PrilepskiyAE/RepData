package prilepsky.repdata.lib

import androidx.lifecycle.ViewModel

abstract class RepDataViewModel<T>(private val repository: RepDataOwner<T>): ViewModel(), RepDataObserver<T> {
    override fun onCleared() {
        repository.unobserveData(this)
    }
}