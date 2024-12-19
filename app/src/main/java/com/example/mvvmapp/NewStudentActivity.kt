package com.example.mvvmapp

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NewStudentActivity : AppCompatActivity() {

    private lateinit var editFirstNameView: EditText
    private lateinit var editLastNameView: EditText
    private lateinit var editPhoneNumberView: EditText
    private lateinit var editEmailView: EditText

    companion object {
        const val EXTRA_FIRSTNAME = "FIRSTNAME"
        const val EXTRA_LASTNAME = "LASTNAME"
        const val EXTRA_PHONENUMBER = "PHONENUMBER"
        const val EXTRA_EMAIL = "EMAIL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_student)

        // Initialisation des vues
        editFirstNameView = findViewById(R.id.editFirstNameView)
        editLastNameView = findViewById(R.id.editLastNameView)
        editPhoneNumberView = findViewById(R.id.editPhoneNumberView)
        editEmailView = findViewById(R.id.editEmailView)

        val buttonSave = findViewById<Button>(R.id.buttonSave)
        buttonSave.setOnClickListener {
            val replyIntent = Intent()
            if (TextUtils.isEmpty(editFirstNameView.text)) {
                setResult(Activity.RESULT_CANCELED, replyIntent)
            } else {
                val firstName = editFirstNameView.text.toString()
                replyIntent.putExtra(EXTRA_FIRSTNAME, firstName)

                val lastName = editLastNameView.text.toString()
                replyIntent.putExtra(EXTRA_LASTNAME, lastName)

                val phoneNumber = editPhoneNumberView.text.toString()
                replyIntent.putExtra(EXTRA_PHONENUMBER, phoneNumber)

                val email = editEmailView.text.toString()
                replyIntent.putExtra(EXTRA_EMAIL, email)

                setResult(Activity.RESULT_OK, replyIntent)
            }
            finish() // Termine l'activité après avoir défini le résultat
        }
    }

}

