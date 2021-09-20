package com.example.grupo8sidney

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException

class MainActivity : AppCompatActivity() {

    private lateinit var mPoi: ArrayList<Poi>
    private lateinit var mAdapter: PoiAdapter
    private lateinit var recycler: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_poi)

        recycler = findViewById(R.id.poiList)
        setupRecyclerView()
        generatePOI()

    }

    private fun setupRecyclerView() {
        mPoi = arrayListOf()
        recycler.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        mAdapter = PoiAdapter(mPoi)
        recycler.adapter = mAdapter
    }

    private fun generatePOI(){
        val POIString = readPOIJsonFile()
        try {
            val POIJson = JSONArray(POIString)
            for (i in 0 until POIJson.length()) {
                val contactJson = POIJson.getJSONObject(i)
                val poi = Poi(
                    contactJson.getString("name"),
                    contactJson.getString("description"),
                    contactJson.getString("imageURL")
                )
                mPoi.add(poi)
            }

            mAdapter.notifyDataSetChanged()
        } catch (e: JSONException) {
            e.printStackTrace()
        }
    }

    private fun readPOIJsonFile(): String? {
        var POIString: String? = null
        try {
            val inputStream = assets.open("SidneyData.json")
            val size = inputStream.available()
            val buffer = ByteArray(size)
            inputStream.read(buffer)
            inputStream.close()

            POIString = String(buffer)
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return POIString
    }
}