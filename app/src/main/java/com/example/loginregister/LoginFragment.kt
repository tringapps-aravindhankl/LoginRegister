package com.example.loginregister

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.loginregister.databinding.FragmentLoginBinding
import com.example.loginregister.databinding.FragmentRegisterBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class LoginFragment : Fragment(R.layout.fragment_login) {

    private var _binding:FragmentLoginBinding?=null
    private val binding get() =_binding!!


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      _binding=FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var loginbutton=binding.submit;

        loginbutton.setOnClickListener{
            var username=binding.username.text.toString();
            var password=binding.password.text.toString();
            Log.i("ANSWER",username)
            Log.i("ANSWER",password)

            var database=MyDatabase.getInstance(requireContext())
            var userdao=database?.userDao();
            GlobalScope.launch {
               var solution= userdao?.checkEmail(username);
                Log.i("email",solution.toString())
                if(solution==username){
                    Log.i("email","ENTER")
                    Toast.makeText(requireContext(),"Login Success",Toast.LENGTH_LONG).show();
                }else{
                    Log.i("email","else")
                    Toast.makeText(requireContext(),"INVALID VALID",Toast.LENGTH_SHORT).show();
                }
            }



        }
    }

}