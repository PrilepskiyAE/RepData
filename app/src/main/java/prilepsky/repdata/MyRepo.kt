package prilepsky.repdata

import prilepsky.repdata.lib.RepData
import prilepsky.repdata.lib.RepDataOwner
import prilepsky.repdata.lib.emptyRepData

class MyRepo : RepDataOwner<List<Item>>  {
    override val repData: RepData<List<Item>> = emptyRepData()

    private val list = mutableListOf<Item>()

    fun getFromAPI() {
        list.add(Item(name = System.currentTimeMillis().toString()))

        repData.postData(list)
    }
}