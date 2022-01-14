package prilepsky.repdata.lib

interface RepDataOwner<T> {
    val repData: RepData<T>

    fun observeData(observer: RepDataObserver<T>) {
        repData.observe(observer)
    }

    fun unobserveData(observer: RepDataObserver<T>) {
        repData.unobserve(observer)
    }
}