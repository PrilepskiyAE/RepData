package prilepsky.repdata

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel(val repository: MyRepo) : ViewModel(),
    prilepsky.repdata.lib.RepDataObserver<List<Item>> {
    val data: MutableLiveData<List<Item>> = MutableLiveData()

    init {
        repository.observeData(this)
    }

    override fun onRepDataChanged(newData: List<Item>?) {
        data.postValue(newData)
    }

    override fun onCleared() {
        repository.unobserveData(this)
    }

    fun updateData() {
        repository.getFromAPI()
    }
}