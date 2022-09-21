package com.example.week4

import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.week4.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentHomeBinding = FragmentHomeBinding.inflate(layoutInflater)
        return fragmentHomeBinding.root
    }

    /**
     * Buton ile nav_graph'taki bir sonraki fragment'a geçişi sağladık.
     *
     * @param view
     * @param savedInstanceState
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        htmlText()
        fragmentHomeBinding.apply {
            homeButton.setOnClickListener {
                findNavController().apply {
                    navigate(R.id.action_homeFragment_to_recyclerViewFragment)
                }
            }
        }
    }

    /**
     * Ttextview içerisinde yazıları farklı renklerde yapamıyacağımız için
     * html şeklinde yazıp texview.tex'e atadık.
     */

    private fun htmlText() {
        val txtView = fragmentHomeBinding.homeContent
        val htmlText = getString(R.string.html_text)
        txtView.text = Html.fromHtml(htmlText)
    }
}