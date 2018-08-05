package com.goldenpiedevs.schedule.app.core.api.group

import com.goldenpiedevs.schedule.app.core.api.utils.ToJson
import com.goldenpiedevs.schedule.app.core.dao.BaseResponseModel
import com.goldenpiedevs.schedule.app.core.dao.group.GroupModel
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GroupService {
    @GET("groups")
    fun searchGroupList(@ToJson @Query("search") groupName: Map<String, String>): Observable<Response<BaseResponseModel<List<GroupModel>>>>

    @GET("groups/{id}")
    fun getGroup(@Path("id") groupName: Int): Observable<Response<BaseResponseModel<GroupModel>>>

    companion object {
        const val LIMIT = "limit"
        const val OFFSET = "offset"
        const val QUERY = "query"
    }
}