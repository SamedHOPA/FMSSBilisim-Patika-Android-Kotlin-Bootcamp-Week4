package com.example.week4

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week4.databinding.FragmentProductBinding
import com.squareup.picasso.Picasso

class ProductFragment : Fragment() {

    private lateinit var binding : FragmentProductBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentProductBinding.inflate(layoutInflater)
        return binding.root
    }

    /**
     * sharedPreferences ile verileri çektik ve fragmentımıza atamalrı yaptık.
     * picasso ile gelen url imageView'e basıldı.
     * geri butonu ile nav_graph taki bir önceki fragmenta geçiş yaptık.
     *
     * @param view
     * @param savedInstanceState
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPreferences = activity?.getSharedPreferences("mars_content", Context.MODE_PRIVATE)
        val imgUrl = sharedPreferences?.getString("img_src","")

        binding.apply {
            productType.text = sharedPreferences?.getString("type","")
            productPrice.text = sharedPreferences?.getString("price","")
            productLocation.text = sharedPreferences?.getString("id","")
            Picasso.get().load(imgUrl).resize(411,450).into(imgProduct)
            productBackButton.setOnClickListener {
                findNavController().apply {
                    navigateUp()
                }
            }
        }
    }
}