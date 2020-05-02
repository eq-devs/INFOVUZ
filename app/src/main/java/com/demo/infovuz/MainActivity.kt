package com.demo.infovuz

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.demo.infovuz.models.User
import com.demo.infovuz.registration.RegisterActivity
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header_main.*
import kotlinx.android.synthetic.main.nav_header_main.view.*
import org.jetbrains.anko.doAsync

const val PATH="info"
const val ID="id"
const val NAME ="name"
const val IMAGE="image "
const val TimeZone="timeZone"
const val DISCRPTION="discriptin"
const val PHONE ="phone"
const val EMAIL="email"
const val FACEBOOK="facebook"
const val INSTAGRAM="instagram"
const val ADDRESS="address"
class MainActivity : AppCompatActivity() {


    companion object {
        val INFO_KEY="INFO_KEY"
        var currentUser: User? = null
                        }

    private var auth: FirebaseAuth? = null
    private lateinit var appBarConfiguration: AppBarConfiguration
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        FirebaseAuth.getInstance()



doAsync {FetchCurrentuser()}

        imageView_setting?.setOnClickListener {

            /*val intent = Intent(this, SettingsFragment::class.java)
            startActivity(intent)*/
        }
        logout.setOnClickListener{
            FirebaseAuth.getInstance().signOut()
            val intent = Intent(this, RegisterActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK.or(Intent.FLAG_ACTIVITY_NEW_TASK)
            startActivity(intent)

        }


        val toolbar: Toolbar = findViewById(R.id.navbar)
        setSupportActionBar(toolbar)
        nav_view.setBackgroundColor(Color.rgb(57,87,108))
        //navbar.setBackgroundColor(Color.rgb(57,87,108))
        //toolbar.setBackgroundColor(Color.rgb(57,87,108))
       // val demo=findViewById<View>(R.layout.fragment_about)



       // demo.setOnClickListener {
         //   FirebaseAuth.getInstance().signOut()

        //}
        /**
         *
         *
         *

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(

            setOf(
                R.id.nav_feedback,
                R.id.nav_univer,
                R.id.nav_bookmarks,
                R.id.nav_search,
                R.id.nav_help,
                R.id.nav_logout
            ), drawerLayout
        )

        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true



    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()

    }
    private fun FetchCurrentuser() {
        val uid =FirebaseAuth.getInstance().uid
        val ref =FirebaseDatabase.getInstance().getReference("/users/$uid")
        ref.addListenerForSingleValueEvent(object :ValueEventListener
        {
            override fun onDataChange(p0: DataSnapshot) {
                currentUser=p0.getValue(User::class.java)


                Log.d("m","workssss    +++++++++ " +
                        "${currentUser?.profileImageUrl}")
                    val header:View =nav_view.getHeaderView(0)
                    val uri= currentUser?.profileImageUrl
                    Picasso.get().load(uri).into(header.imageView_nav_heaader)
                    header.textView_userName.text= currentUser?.username.toString()




            }

            override fun onCancelled(p0: DatabaseError) {

            }


        })


    }


}

