package th.ac.su.ict.myfriend

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val FriendCollection = db.collection("friend")

        val data1:MutableMap<String,Any> = HashMap()
        data1["name"] = edtName.getText().toString()
        data1["number"] = edtNumber
        data1["numberphone"] = edtNumber

        btnAdd.setOnClickListener{

            data1["name"] = edtName.getText().toString()
            data1["number"] = edtNumber.getText().toString()
            data1["numberphone"] = edtNumberphone.getText().toString()
            FriendCollection.add(data1)






        }

        val FriendDocRef = db.collection("friend").document("friend")

            FriendDocRef.get()
                .addOnSuccessListener {
                    val name = it["name"]
                    val number = it["number"]
                    val numberphone = it["numberphone"]

                    tvName.text = name.toString()
                    tvNumber.text = number.toString()
                    tvNumberphone.text = numberphone.toString()
                }
    }
}
