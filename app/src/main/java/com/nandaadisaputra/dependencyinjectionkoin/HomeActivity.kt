package com.nandaadisaputra.dependencyinjectionkoin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nandaadisaputra.dependencyinjectionkoin.databinding.ActivityHomeBinding
import org.koin.android.ext.android.inject

class HomeActivity : AppCompatActivity() {

    lateinit var binding: ActivityHomeBinding

    //    lateinit var userRepository: UserRepository
    private val userRepository: UserRepository by inject()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val session = SessionManager(this)
//        userRepository = UserRepository.getInstance(session)

        binding.tvWelcome.text = "Welcome ${userRepository.getUser()}"

        binding.btnLogout.setOnClickListener {
            userRepository.logoutUser()
            moveToMainActivity()
        }
    }

    private fun moveToMainActivity() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}