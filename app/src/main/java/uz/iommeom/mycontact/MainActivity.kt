package uz.iommeom.mycontact

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.text.Html
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.title = "Asosiy oyna"
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        contact_list.setOnClickListener {
            startActivity(Intent(this, NumberActivity::class.java))
        }

        add_contact.setOnClickListener {
            startActivity(Intent(this, AddActivity::class.java))
        }
    }
}