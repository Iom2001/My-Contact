package uz.iommeom.mycontact

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_add.*
import uz.iommeom.mycontact.models.Contact
import uz.iommeom.mycontact.utils.MySharedPreferences

class AddActivity : AppCompatActivity() {

    lateinit var mySharedPreferences: MySharedPreferences
    lateinit var gson: Gson

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        supportActionBar?.title = "Kontakt qo'shish"

        MySharedPreferences.init(this)

        add_number.setOnClickListener {
            var name = contact_name.text.toString()
            var number = contact_number.text.toString()
            if (name != "" && number != "") {
                var contact = Contact(name, number)
                val contactData = MySharedPreferences.getContact(this)
                val type = object : TypeToken<ArrayList<Contact>>() {}.type
                gson = Gson()
                var contactList = gson.fromJson<ArrayList<Contact>>(contactData, type)
                if (contactList == null) contactList = ArrayList()
                contactList.add(contact)
                val jsonString = gson.toJson(contactList)
                MySharedPreferences.setContact(jsonString)
                Toast.makeText(this, "Contact added", Toast.LENGTH_SHORT).show()
                contact_name.setText("")
                contact_number.setText("")
            } else {
                Toast.makeText(this, "Fill the blank!!!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}