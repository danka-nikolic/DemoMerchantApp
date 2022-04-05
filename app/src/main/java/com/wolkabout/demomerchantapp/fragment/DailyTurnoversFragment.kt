package com.wolkabout.demomerchantapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.wolkabout.demomerchantapp.databinding.FragmentDailyTurnoversBinding
import com.wolkabout.demomerchantapp.viewmodel.DailyTurnoverViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DailyTurnoversFragment : Fragment() {

    private var _binding: FragmentDailyTurnoversBinding? = null
    private val binding get() = _binding!!

    private val viewModel: DailyTurnoverViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDailyTurnoversBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.getDailyTurnoverData()

//        viewModel.dailyTurnoverLiveData.observe(viewLifecycleOwner) { result ->
//            when (result) {
//                is Result.Success -> {
//                    val data = result.data
//                    data?.facilities?.forEach {
//                        Log.d("######", it.facilityName)
//                    }
//                }
//                is Result.Loading -> {
//                }
//                is Result.Error -> {
//                    Log.e("TAG", "Error fetching products: ${result.errorMessage}")
//                }
//            }
//        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}