import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.test.module.home.AllRec
import com.test.module.home.network.ApiService

class RecPagingSource(private val apiService: ApiService):PagingSource<Int,AllRec.Item>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, AllRec.Item> {
        return try {
            val page=params.key?:1
            val pageSize=params.loadSize
            val rec=apiService.searchRec(page,pageSize)
            val recItems=rec.itemList
            val prevKey=if (page>1)page-1 else null
            val nextKey=if (recItems.isNotEmpty()) page+1 else null
            LoadResult.Page(recItems,prevKey,nextKey)
        } catch (e:Exception){
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, AllRec.Item>): Int? =null
}