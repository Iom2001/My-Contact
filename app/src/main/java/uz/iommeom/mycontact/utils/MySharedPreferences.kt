package uz.iommeom.mycontact.utils

import android.content.Context
import android.content.SharedPreferences

object MySharedPreferences {
    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor:SharedPreferences.Editor
    private const val UNICAL_KEY = "KEY"

    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(UNICAL_KEY, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    fun setContact(contact: String) {
        editor.putString("contact", contact)
        editor.commit()
    }

    fun getContact(context: Context): String? {
        sharedPreferences = context.getSharedPreferences(UNICAL_KEY, Context.MODE_PRIVATE)
        return sharedPreferences.getString("contact", "")
    }
}