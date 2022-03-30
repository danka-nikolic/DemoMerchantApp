package com.wolkabout.demomerchantapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wolkabout.demomerchantapp.databinding.FragmentLoginBinding
import com.wolkabout.demomerchantapp.model.HomeActivity

class LoginFragment: Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButton.setOnClickListener {
//            val actionMainFragmentToListFragment = LoginFragmentDirections.actionLoginFragmentToHomeFragment("rs")
//            findNavController().navigate(actionMainFragmentToListFragment)
           requireActivity().run {
               startActivity(Intent(this, HomeActivity::class.java))
               finish()
           }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}