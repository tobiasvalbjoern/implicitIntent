package dk.tobias.intent.implicit.implicitintentemail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        main_btn_send.setOnClickListener {
            startMailIntent()
        }

    }

    private fun startMailIntent(){
    val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        val sender=main_edit_sender.text.toString()
        intent.putExtra(Intent.EXTRA_EMAIL,sender)

        val subject=main_edit_subject.text.toString()
        intent.putExtra(Intent.EXTRA_SUBJECT,subject)

        val body=main_edit_body.text.toString()
        intent.putExtra(Intent.EXTRA_TEXT,body)

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }


    }
}


