package dk.tobias.intent.implicit.implicitintentemail

import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        startMailIntent()


    }

    private fun startMailIntent(){
    val intent = Intent(Intent.ACTION_SENDTO)
        intent.data = Uri.parse("mailto:")
        intent.putExtra(Intent.EXTRA_EMAIL,"tvalbjoern@gmail.com")
        intent.putExtra(Intent.EXTRA_SUBJECT,"Email subject for the mail")
        intent.putExtra(Intent.EXTRA_TEXT,"Hi \n This is the mail")

        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }


    }
}


