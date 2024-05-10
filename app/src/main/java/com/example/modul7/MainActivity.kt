package com.example.modul7

import android.annotation.SuppressLint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException
import java.net.URL
import java.util.Random
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class MainActivity : AppCompatActivity() {
    private lateinit var imgSlot1: ImageView
    private lateinit var imgSlot2: ImageView
    private lateinit var imgSlot3: ImageView
    private lateinit var btnGet: Button
    private lateinit var tvHasil: TextView
//    private var arrayUrl = ArrayList<String>()

    private var isPlay = false

    private var execService1: ExecutorService? = null
    private var execService2: ExecutorService? = null
    private var execService3: ExecutorService? = null
    private var execServicePool: ExecutorService? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnGet = findViewById(R.id.btn_get)
        imgSlot1 = findViewById(R.id.img_slot1)
        imgSlot2 = findViewById(R.id.img_slot2)
        imgSlot3 = findViewById(R.id.img_slot3)
        tvHasil = findViewById(R.id.tv_hasil)

        imgSlot1.setImageResource(R.drawable.slotbar)
        imgSlot2.setImageResource(R.drawable.slotbar)
        imgSlot3.setImageResource(R.drawable.slotbar)

        execService1 = Executors.newSingleThreadExecutor()
        execService2 = Executors.newSingleThreadExecutor()
        execService3 = Executors.newSingleThreadExecutor()
        execServicePool = Executors.newFixedThreadPool(3)

        val slotTask1 = SlotTask(imgSlot1)
        val slotTask2 = SlotTask(imgSlot2)
        val slotTask3 = SlotTask(imgSlot3)

        btnGet.setOnClickListener {
            if (!isPlay) {
                slotTask1.play = true
                slotTask2.play = true
                slotTask3.play = true

                execServicePool?.execute(slotTask1)
                execServicePool?.execute(slotTask2)
                execServicePool?.execute(slotTask3)

                btnGet.text = "Stop"
                isPlay = true
            } else {
                slotTask1.play = false
                slotTask2.play = false
                slotTask3.play = false

                btnGet.text = "Play"
                isPlay = false
            }
        }
    }

    internal class SlotTask(private val slotImg: ImageView) : Runnable {
        private val random = Random()
        var play = true

        override fun run() {
            while (play) {
                try {
//                    loadStringFromNetwork("https://662e87fba7dda1fa378d337e.mockapi.io/api/v1/fruits")
                    val imageUrl = getRandomImageUrl()

                    Handler(Looper.getMainLooper()).post {
                        Glide.with(slotImg.context)
                            .load(imageUrl)
                            .into(slotImg)
                    }
                    Thread.sleep(random.nextInt(1000).toLong())
                } catch (e: InterruptedException) {
                    e.printStackTrace()
                }
            }
        }

        private fun getRandomImageUrl(): String {
            val apiUrl = "https://662e87fba7dda1fa378d337e.mockapi.io/api/v1/fruits"
            try {
                val jsonString = URL(apiUrl).readText()
                val jsonArray = JSONArray(jsonString)
                val randomIndex = random.nextInt(jsonArray.length())
                val jsonObject = jsonArray.getJSONObject(randomIndex)
                return jsonObject.getString("url")
            } catch (e: IOException) {
                e.printStackTrace()
            } catch (e: JSONException) {
                e.printStackTrace()
            }
            return ""
        }
    }
}


    @Throws(IOException::class)
    private fun loadStringFromNetwork(s: String): String? {
        val myUrl = URL(s)
        val `in` = myUrl.openStream()
        val out = StringBuilder()
        val buffer = ByteArray(1024)
        try {
            var ctr: Int
            while (`in`.read(buffer).also { ctr = it } != -1) {
                out.append(String(buffer, 0, ctr))
            }
        } catch (e: IOException) {
            throw RuntimeException(
                "Gagal mendapatkan text",
                e
            )
        }
        return out.toString()
    }

