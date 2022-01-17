# RepData

RepData это Библиотека которая позволяет передовать данные между репозиторием и viewmodel, используется реактивный подход с шаблоном наблюдателя

## Include in your project
**Gradle dependency**
Add this in your **app**-level **build.gradle** file:
```groovy
dependencies {
	...
	def latest_version_tag = 1.0.4
	implementation "com.github.PrilepskiyAE:RepData:$latest_version_tag"
	...
}
```
You can always find the **latest_version_tag** [here](https://github.com/PrilepskiyAE/RepData/releases).
Also make sure you have this repository in your **project**-level **build.gradle** file:
```groovy
allprojects {
	repositories {
		...
		maven { url 'https://jitpack.io' }
	}
}
```
# Examples of usage

**viewmodel**
```kotlin
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
```
**repository**
```kotlin
class MyRepo : prilepsky.repdata.lib.RepDataOwner<List<Item>> {
    override val repData: prilepsky.repdata.lib.RepData<List<Item>> =
        prilepsky.repdata.lib.emptyRepData()

    private val list = mutableListOf<Item>()

    fun getFromAPI() {
        list.add(Item(name = System.currentTimeMillis().toString()))

        repData.postData(list)
    }
}
```
