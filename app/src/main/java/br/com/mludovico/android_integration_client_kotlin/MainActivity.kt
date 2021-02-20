package br.com.mludovico.android_integration_client_kotlin

import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.title = getString(R.string.app_title)
        refresh_button.setOnClickListener {
            getContentProvider()
        }
    }

    private fun getContentProvider() {
        try {
            val url = "content://br.com.mludovico.android_integration_kotlin.provider/notes"
            val data = Uri.parse(url)
            val cursor: Cursor? = contentResolver.query(data, null, null, null, "title")
            client_list.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = ClientAdapter(cursor as Cursor)
            }
        } catch (e: Exception) {
            Log.e("ContentProvider", "Erro ao localizar uri")
            e.printStackTrace()
        }
    }
}