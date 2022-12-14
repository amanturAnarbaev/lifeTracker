package com.example.a1hw4monthlifetracker

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.MenuView
import androidx.navigation.fragment.findNavController
import androidx.viewpager.widget.ViewPager
import com.example.a1hw4monthlifetracker.databinding.FragmentBoradBinding
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import layout.AdapterBoard
import layout.BoardModel


class BoradFragment : Fragment(), ItemClicker {


    private lateinit var binding: FragmentBoradBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBoradBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity() as MainActivity).hideToolbar()
        val preference = requireContext().getSharedPreferences("setting file", Context.MODE_PRIVATE)
        val isShow: Boolean = preference.getBoolean("isShow", false)
        if (isShow){
            findNavController().navigate(R.id.action_boradFragment_to_taskFragment2)

        }
        val list = arrayListOf<BoardModel>()
        list.add(BoardModel(R.drawable.ic_board_first, "экономь время", "Next"))
        list.add(BoardModel(R.drawable.ic_second, "экономь время", "next"))
        list.add(BoardModel(R.drawable.ic_thurd, "развивайся", "Start"))
        val boardAdapter = AdapterBoard(list, this)
        binding.viewpager.adapter = boardAdapter
        binding.dotsIndicator.attachTo(binding.viewpager)


    }

    override fun itemClick() {
        val preference = requireContext().getSharedPreferences("setting file", Context.MODE_PRIVATE)
        preference.edit().putBoolean("isShow", true).apply()
        findNavController().navigate(R.id.action_boradFragment_to_taskFragment2)
    }

    override fun click1Page() {
        binding.viewpager.setCurrentItem(1)
    }

    override fun click2Page() {
        binding.viewpager.setCurrentItem(2)
    }
}