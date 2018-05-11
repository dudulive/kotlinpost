package business

import entity.FullParameters
import entity.HttpResponse
import infra.EndpointConstansts
import infra.OperationMethod
import repository.PostRepository

class PostBusiness(){

    fun getAllPosts(): HttpResponse {
        val url = EndpointConstansts.BASE.URL + EndpointConstansts.POST.ALL_POSTS
        val fullParameters = FullParameters(url, OperationMethod.GET)
        val response: HttpResponse = PostRepository.getAllPosts(fullParameters);

        return response
    }

    fun getSinglePost(id: Int): HttpResponse {
        val url = EndpointConstansts.BASE.URL + EndpointConstansts.POST.SINGLE_POSTS
        val fullParameters = FullParameters(url, OperationMethod.GET, mapOf(Pair("id", id.toString())))
        val response: HttpResponse = PostRepository.getSinglePost(fullParameters);

        return response
    }
}