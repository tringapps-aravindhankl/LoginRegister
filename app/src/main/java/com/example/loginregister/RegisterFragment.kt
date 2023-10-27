package com.example.loginregister

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.loginregister.databinding.FragmentRegisterBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterFragment : Fragment(R.layout.fragment_register) {
    private var _binding : FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegisterBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var registerButton=binding.registerButton;
        registerButton.setOnClickListener{
            var username = binding.registerName.text.toString()
            var password =binding.registerPassword.text.toString();
            var phonenumber=binding.registerPhonenumber.text.toString()
            var email = binding.registerEmail.text.toString();

            try {
                var database = MyDatabase?.getInstance(requireContext())
                var userdao = database?.userDao();
                var userLogin = UserLogin(username, password, phonenumber, email)

                GlobalScope.launch {
                    userdao?.insertData(userLogin)
                }
                clearData();
                userToast();
            }catch (e:Exception){
                Log.i("find",e.message.toString())
                Toast.makeText(context,"THROW SOME ERROR",Toast.LENGTH_SHORT).show();
            }
        }

    }

    private fun clearData() {
        binding.registerName.text.clear();
        binding.registerPassword.text.clear();
        binding.registerPhonenumber.text.clear();
        binding.registerEmail.text.clear();

    }

    private fun userToast(){
        Toast.makeText(context,"SUCCESFULLY SUBMITTED",Toast.LENGTH_SHORT).show();
    }


}