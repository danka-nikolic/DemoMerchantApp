package com.wolkabout.demomerchantapp.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.wolkabout.demomerchantapp.activity.HomeActivity
import com.wolkabout.demomerchantapp.databinding.FragmentLoginBinding
import com.wolkabout.demomerchantapp.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: LoginViewModel by activityViewModels()

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
            val email = binding.emailInput.text.toString().trim()
            val password = binding.passwordInput.text.toString().trim()

            if (email.isEmpty()) {
                binding.emailInput.error = "Email required"
                binding.emailInput.requestFocus()
                return@setOnClickListener
            }

            if (password.isEmpty()) {
                binding.passwordInput.error = "Password required"
                binding.passwordInput.requestFocus()
                return@setOnClickListener
            }

            login(email, password)

            if (email == "demo@wolkabout.com" && password == "Test12345") {
                requireActivity().run {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            } else {
//                binding.loginButton.error = "Incorrect credentials! Please try again."
                requireActivity().run {
                    startActivity(Intent(this, HomeActivity::class.java))
                    finish()
                }
            }

//            val actionMainFragmentToListFragment = LoginFragmentDirections.actionLoginFragmentToHomeFragment("rs")
//            findNavController().navigate(actionMainFragmentToListFragment)
        }
    }

    private fun login(username: String, password: String) {
        viewModel.getLoginData(username, password)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}