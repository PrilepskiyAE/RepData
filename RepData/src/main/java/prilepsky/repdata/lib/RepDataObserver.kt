package prilepsky.repdata.lib

interface RepDataObserver<T> {
    fun onRepDataChanged(newData: T?)
}