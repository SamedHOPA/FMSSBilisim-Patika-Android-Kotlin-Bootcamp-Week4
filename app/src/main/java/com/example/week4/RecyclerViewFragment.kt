package com.example.week4

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import com.example.week4.databinding.FragmentRecyclerViewBinding


class RecyclerViewFragment : Fragment() {

    private lateinit var binding: FragmentRecyclerViewBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRecyclerViewBinding.inflate(layoutInflater)
        return binding.root

    }

    /**
     * recyclerView ile Api'dan gelen verileri recycler_item'a atıyarak gösterimni sağladık.
     * sharedPreferences ile recycler_item'daki verileri bir sonraki fragmentta kullanabilmek için yazdırdık.
     *
     * @param view
     * @param savedInstanceState
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        MarsApi.retrofitService.getMars().enqueue(object : Callback<List<MarsModel>>{
            @SuppressLint("CommitPrefEdits")
            override fun onResponse(call: Call<List<MarsModel>>, response: Response<List<MarsModel>>) {

                val list = ArrayList(response.body()!!)
                val gridLayoutManager = GridLayoutManager(activity,2)
                val sharedPreferences = activity?.getSharedPreferences("mars_content",Context.MODE_PRIVATE)
                val editor = sharedPreferences?.edit()
                binding.recyclerView.layoutManager = gridLayoutManager
                val adapter = MarsAdapter(list
                ) {
                    findNavController().apply {
                        navigate(R.id.action_recyclerViewFragment_to_productFragment)
                    }

                    editor?.putString("type", it.type)
                    editor?.putString("price", it.price)
                    editor?.putString("id", it.id)
                    editor?.putString("img_src", it.img_src)
                    editor?.apply()
                }
                binding.setVariable(BR.adapter,adapter)

            }

            override fun onFailure(call: Call<List<MarsModel>>, t: Throwable) {
                Log.v("hopa",t.message.toString())
            }

        })
    }

}