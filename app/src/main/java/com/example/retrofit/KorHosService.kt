package com.example.retrofit

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface KorHosService {
    // 아래 함수: BASE_URL/CHSEMGNCYCENTER?KEY="KEY"&Type="Type"
    // 이러한 겟요청을 보내고 Call<KorHosResponse> 객체를 반환받는 동작을 하는 함수
    @GET("CHSEMGNCYCENTER") // 겟요청할때 "ㅇㅇ"를 전달해줌
    fun getKorHosData(@Query("KEY")KEY: String, @Query("Type")Type:String): Call<KorHosResponse>
    // 키랑 타입인자는 쿼리 어노테이션을 써서 전달함. 응답은 call 객체로 받아오도록 함.
    // 콜은 서버에 리퀘스트를 보낸다음 응답을 반환하는 일회용객체임
}