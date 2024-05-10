package com.example.modul7

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.net.URL
import java.util.concurrent.Executors

class jsdfs : AppCompatActivity() {
//    private var imgSlot1: ImageView? = null
//    private var imgSlot2: ImageView? = null
//    private var imgSlot3: ImageView? = null
//    private var btnGet: Button? = null
//    private var tvHasil: TextView? = null
//    var arrayUrl = ArrayList<String>()
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        btnGet = findViewById(R.id.btn_get)
//        imgSlot1 = findViewById(R.id.img_slot1)
//        imgSlot2 = findViewById(R.id.img_slot2)
//        imgSlot3 = findViewById(R.id.img_slot3)
//        tvHasil = findViewById(R.id.tv_hasil)
//        val execGetImage = Executors.newSingleThreadExecutor()
//        val handler = Handler(Looper.getMainLooper())
//        btnGet.setOnClickListener(View.OnClickListener {
//            execGetImage.execute {
//                try {
//                    val txt =
//                        loadStringFromNetwork("https://mocki.io/v1/821f1b13-fa9a-43aa-ba9a-9e328df8270e")
//                    try {
//                        val jsonArray = JSONArray(txt)
//                        for (i in 0 until
//                                jsonArray.length()) {
//                            val jsonObject = jsonArray.getJSONObject(i)
//                            arrayUrl.add(jsonObject.getString("url"))
//                        }
//                    } catch (e: JSONException) {
//                        e.printStackTrace()
//                    }
//                    handler.post {
//                        Glide.with(this@jsdfs)
//                            .load(arrayUrl[0])
//                            .into(imgSlot1)
//                        Glide.with(this@jsdfs)
//                            .load(arrayUrl[1])
//                            .into(imgSlot2)
//                        Glide.with(this@jsdfs)
//                            .load(arrayUrl[2])
//                            .into(imgSlot3)
//                        tvHasil.setText(txt)
//                    }
//                } catch (e: IOException) {
//                    e.printStackTrace()
//                }
//            }
//        })
//    }
//
//    @Throws(IOException::class)
//    private fun loadStringFromNetwork(s: String): String {
//        val myUrl = URL(s)
//        val `in` = myUrl.openStream()
//        val out = StringBuilder()
//        val buffer = ByteArray(1024)
//        try {
//            var ctr: Int
//            while (`in`.read(buffer).also { ctr = it } != -1) {
//                out.append(String(buffer, 0, ctr))
//            }
//        } catch (e: IOException) {
//            throw RuntimeException(
//                "Gagal mendapatkan text",
//                e
//            )
//        }
//        return out.toString()
//    }
}