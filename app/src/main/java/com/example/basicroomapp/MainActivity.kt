package com.example.basicroomapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.example.basicroomapp.database.User

class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
/*
        mainViewModel.saveUser(User(
            "Userid0003",
            "name0003",
            1.73,
            73.23,
            "user003@email.com",
            "passworduser0003"
        ))

 */
        mainViewModel.getUsers()
        //Nota:
        //si es en un fragment
        //es con viewLifecycleOwner en lugar de this
        mainViewModel.savedUsers.observe(this, {usersList ->
            if(!usersList.isNullOrEmpty()){
                for(user in usersList){
                    Log.d("thesearetheusers", user.user_name)
                }
            }else{
                Log.d("thesearetheusers", "null or empty")
            }
        } )
    }
}