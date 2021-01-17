package uz.iommeom.mycontact

import android.annotation.SuppressLint
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_number.*
import uz.iommeom.mycontact.models.Contact
import uz.iommeom.mycontact.utils.MySharedPreferences

class NumberActivity : AppCompatActivity() {

    lateinit var gson: Gson

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number)
        supportActionBar?.title = "Barcha kontaktlar"

        val contactData = MySharedPreferences.getContact(this)
        val type = object : TypeToken<ArrayList<Contact>>(){}.type
        gson = Gson()
        var contactList = gson.fromJson<ArrayList<Contact>>(contactData,type)
        if (contactList == null) contactList = ArrayList()
        for (i in contactList.indices) {
            tv.text = tv.text.toString() + "${contactList[i].name}\n${contactList[i].number}\n\n"
        }
    }
}