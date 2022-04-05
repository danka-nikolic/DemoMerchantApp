package com.wolkabout.demomerchantapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wolkabout.demomerchantapp.databinding.FragmentIssueLocalTokensBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class IssueLocalTokensFragment : Fragment() {

    private var _binding: FragmentIssueLocalTokensBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentIssueLocalTokensBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}