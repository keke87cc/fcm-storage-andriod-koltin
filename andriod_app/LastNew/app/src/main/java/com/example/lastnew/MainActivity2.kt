package com.example.lastnew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.bumptech.glide.Glide
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage

class MainActivity2 : AppCompatActivity() {
//
//

    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val message : String? = intent.getStringExtra("name")

        var imageView: ImageView = findViewById(R.id.imageView2)
        var gsReference = Firebase.storage.reference.child("/$message")
        gsReference.downloadUrl.addOnSuccessListener {Uri->
            val imageURL = Uri.toString()
            Glide.with(this)
                .load(imageURL)
                .into(imageView)
        }
//
//        val title = findViewById<TextView>(R.id.title).apply{
//            text = message[0]
//        }
//        val body = findViewById<TextView>(R.id.body).apply{
//            text = message[1]
//        }
//        val image = findViewById<ImageView>(R.id.image).apply{
//
//        }
    }

}
