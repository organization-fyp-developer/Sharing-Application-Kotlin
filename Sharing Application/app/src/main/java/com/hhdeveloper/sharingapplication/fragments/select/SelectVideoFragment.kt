package com.hhdeveloper.sharingapplication.fragments.select


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hhdeveloper.sharingapplication.R
import com.hhdeveloper.sharingapplication.adapter.SelectVideoAdapter
import com.hhdeveloper.sharingapplication.databinding.FragmentSelectVideoBinding
import com.hhdeveloper.sharingapplication.datasource.data.VideoData
import com.hhdeveloper.sharingapplication.utils.Constant.TAG
import com.hhdeveloper.sharingapplication.viewmodel.DataViewModel
import java.util.EnumSet.of


class SelectVideoFragment : Fragment(R.layout.fragment_select_video) {
    private lateinit var binding:FragmentSelectVideoBinding
    private lateinit var dataViewModel:DataViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding=FragmentSelectVideoBinding.bind(view)
        Log.d(TAG,"In video fragment")
        //INITIALIZE DATA VIEW MODEL
        dataViewModel=ViewModelProvider(this).get(DataViewModel::class.java)
        //SET ADAPTER
        setRecyclerAdapter()

    }

    private fun setRecyclerAdapter() {
        val adapter = SelectVideoAdapter(requireContext())
        binding.recycler.apply {
            this.adapter = adapter
            layoutManager = GridLayoutManager(requireContext(), 2)
        }
        dataViewModel.getVideoList.observe(viewLifecycleOwner){
            it?.let {
                adapter.submitList(it)
            }
        }
    }
}