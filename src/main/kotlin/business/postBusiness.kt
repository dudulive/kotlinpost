package business

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import entity.FullParameters
import entity.HttpResponse
import entity.PostEntity
import infra.EndpointConstansts
import infra.OperationMethod
import repository.PostRepository

class PostBusiness(){

    fun getAllPosts(): List<PostEntity> {
        val url = EndpointConstansts.BASE.URL + EndpointConstansts.POST.ALL_POSTS
        val fullParameters = FullParameters(url, OperationMethod.GET)
        val response: HttpResponse = PostRepository.getAllPosts(fullParameters);

        return Gson().fromJson<List<PostEntity>>(response.jsonResponse, object : TypeToken<List<PostEntity>>() {}.type)
    }

    fun getSinglePost(id: Int): PostEntity {
        val url = EndpointConstansts.BASE.URL + EndpointConstansts.POST.SINGLE_POSTS
        val fullParameters = FullParameters(url, OperationMethod.GET, mapOf(Pair("id", id.toString())))
        val response: HttpResponse = PostRepository.getSinglePost(fullParameters);

        return Gson().fromJson<List<PostEntity>>(response.jsonResponse, object : TypeToken<List<PostEntity>>() {}.type)[0]
    }
}