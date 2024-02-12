package com.example.retrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.example.retrofit.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var korHosAdapter: KorHosAdapter? = null // Nullable로 변경

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        korHosAdapter = KorHosAdapter() // 어댑터 생성

        binding.rv.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = korHosAdapter // 어댑터 - 리사이클러뷰 연결
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL)) // 사이에 줄 긋기
        }
        binding.btnGet.setOnClickListener {
            retrofitWork()
        }
    }
    private fun retrofitWork() {
        // 서비스를 실행하기 위해 인스턴스 만들어주고
        val service: KorHosService = RetrofitApi.korHosService
        // 서비스에 대해 겟데이터가 실행됨. 키랑 타입 넘겨주면 됨
        service.getKorHosData(getString(R.string.api_key),"json")
            .enqueue(object : Callback<KorHosResponse> {
                // 인큐로 하면 리퀘스트는 비동기적으로 보내고 리스폰스는 콜백으로 받게됨??
                override fun onResponse(
                    call: Call<KorHosResponse>,
                    response: Response<KorHosResponse>
                ) {
                    if (response.isSuccessful) {
//                        Log.d("TAG", response.body().toString())
                        val result: List<Row?>?= response.body()?.cHSEMGNCYCENTER?.get(1)?.row
                        // cHSEMGNCYCENTER가 null 이라고 에러뜸

//                        korHosAdapter?.submitList(result!!)
                        if (result != null) {
                            korHosAdapter?.submitList(result)
                        } else {
                            Log.d("TAG","뒤짐")
                            // result가 null인 경우에 대한 처리
                            // 예를 들어, 사용자에게 메시지를 표시하거나 다른 작업을 수행할 수 있음
                        }
                    }
                }

                override fun onFailure(call: Call<KorHosResponse>, t: Throwable) {
                    Log.d("TAG",t.message.toString())
                }

            })
    }
}