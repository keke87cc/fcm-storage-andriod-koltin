package com.example.lastnew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import com.bumptech.glide.Glide
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.storage.StorageReference
import com.google.firebase.storage.ktx.storage
import android.widget.Toast

import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import com.google.firebase.storage.ListResult
import com.google.android.gms.tasks.OnFailureListener

import com.google.android.gms.tasks.OnSuccessListener

import com.google.firebase.storage.FirebaseStorage





class MainActivity : AppCompatActivity() {
    private val TAG : String = "Towa"
    lateinit var listView : ListView
    var dataarray  = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val storageRef = FirebaseStorage.getInstance().reference
//        val storage = storageRef.child("/ddd")

        listView = findViewById<ListView>(R.id.list_view)

        val storagedata = Firebase.storage
        val storage = storagedata.reference.child("/")

// Now we get the references of these images
        storage.listAll()
            .addOnSuccessListener { prefixes ->
                for(item in prefixes.prefixes){
                    dataarray.add(item.toString())

                }
                val listItems = arrayOfNulls<String>(dataarray.size)
// 3
                for (i in listItems.indices) {

                    var pathname = (dataarray[i].toString()).split("/")
                    listItems[i] =((pathname.last()).toString())

                }
// 4
                val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems)
                listView.adapter = adapter
                listView.setOnItemClickListener { parent, view, i, l ->
                    val element = parent.getItemAtPosition(i)// The item that was clicked
                    val intent = Intent(this, MainActivity3::class.java).apply{
                        putExtra("name","${listItems[i]}")
                    }
                    startActivity(intent)
                }
            }

// Now we get the references of these images
//        storage.listAll().addOnSuccessListener(OnSuccessListener<ListResult> { result ->
//            for (fileRef in result.items) {
//                // TODO: Download the file using its reference (fileRef)
//                dataarray.add(fileRef.toString())
//                Toast.makeText(baseContext, dataarray.toString(), Toast.LENGTH_LONG).show()
//            }
//        }).addOnFailureListener(OnFailureListener {
//            // Handle any errors
//        })


//        gsReference.downloadUrl.addOnSuccessListener {Uri->
//            val imageURL = Uri.toString()
//            Toast.makeText(baseContext,"$imageURL",Toast.LENGTH_LONG).show()
//            Glide.with(this)
//                .load(imageURL)
//                .into(imageView)
//        }

//        Glide.with(this /* context */)
//            .load("gs://haha7414la.appspot.com/1")
//            .into(imageView)
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                Log.w(TAG, "Fetching FCM registration token failed", task.exception)
//                return@OnCompleteListener
//            }
//
//            // Get new FCM registration token
//            val token = task.result
//
//            if (token != null) {
//                Log.d(TAG, token)
//            }
//            Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
//        } )

//
//        val list = findViewById<ListView>(R.id.List)
//
//        var x = {message::class.simpleName}
//        val textView = findViewById<TextView>(R.id.list).apply{
//            text = message[0] + message[1]
//        }
    }
//    private fun processResults(items: List<StorageReference>, prefixes: List<StorageReference>) {
//
//    }
//
//    fun listAllPaginated(pageToken: String?) {
//        val storage = Firebase.storage
//        val listRef = storage.reference.child("files/")
//
//        // Fetch the next page of results, using the pageToken if we have one.
//        val listPageTask = if (pageToken != null) {
//            listRef.list(100, pageToken)
//        } else {
//            listRef.list(100)
//        }
//
//        // You'll need to import com.google.firebase.storage.ktx.component1 and
//        // com.google.firebase.storage.ktx.component2
//        listPageTask
//            .addOnSuccessListener { (items, prefixes, pageToken) ->
//                // Process page of results
//                processResults(items, prefixes)
//
//                // Recurse onto next page
//                pageToken?.let {
//                    listAllPaginated(it)
//                }
//            }.addOnFailureListener {
//                // Uh-oh, an error occurred.
//            }
//    }

//    private val onItemClickListener =
//        OnItemClickListener { parent, view, position, id ->
//            val element = parent.getItemAtPosition(position)// The item that was clicked
//
//            val intent = Intent(this, MainActivity2::class.java)
//            startActivity(intent)
//        }


}


