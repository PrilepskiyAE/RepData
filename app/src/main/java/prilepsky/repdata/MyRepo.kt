package prilepsky.repdata

class MyRepo : prilepsky.repdata.lib.RepDataOwner<List<Item>> {
    override val repData: prilepsky.repdata.lib.RepData<List<Item>> =
        prilepsky.repdata.lib.emptyRepData()

    private val list = mutableListOf<Item>()

    fun getFromAPI() {
        list.add(Item(name = System.currentTimeMillis().toString()))

        repData.postData(list)
    }
}