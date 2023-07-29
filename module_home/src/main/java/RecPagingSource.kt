import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.test.module.home.AllRec
import com.test.module.home.network.ApiService

//定义数据源
class RecPagingSource(private val apiService: ApiService):PagingSource<Int,AllRec.Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AllRec.Item> {
        return try {
            val page=params.key?:1
            val pageSize=params.loadSize
            val rec=apiService.searchRec(page,pageSize)
            val itemList= mutableListOf<AllRec.Item>()
            for (i in rec.itemList.indices){
                if (rec.itemList[i].data.title!=null)
                    itemList.add(rec.itemList[i])
            }
            val prevKey=if (page>1)page-1 else null
            val nextKey= if (itemList.isNotEmpty()) page + 1 else null
            LoadResult.Page(itemList, prevKey, nextKey)
        } catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AllRec.Item>): Int? =null
}