package com.irmablanco.listandroid

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.text.InputType
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    /*
    *This variable is gonna to be populated some point
    * in the future, otherwise I would need to initialize it
    * right now
    * **/
    lateinit var listsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            showCreateListDialog()
        }
        /**
         * We initialize our recyclerwiew on Oncreate
         * */
        listsRecyclerView = findViewById<RecyclerView>(R.id.lists_recyclerview)
        /*** We use layoutManager, a RecyclerView property, to create a
         * LinearLayout* */
        listsRecyclerView.layoutManager = LinearLayoutManager(this)
        /**
         * Add our adapter to the RecyclerView* */
        listsRecyclerView.adapter = ListSelectionRecyclerViewAdapter()

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    /*Manage open dialog widget
    * With this method we inform the dialog builder that we want a positive button
    * added to the dialog, this tells the dialog that a positive action has occurred
    * and something should happen.
    *
    * We call this method in onCreate
    * */
    private fun showCreateListDialog() {
        //We refer to the string in our string resource
        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)

        /**We create an instance of the dialog by calling a builder constructor
        *and I pass in the activity, wich is represent by the keyword this
         *  as the context
         *  */
        val builder = AlertDialog.Builder(this)
        /*
        * Now lets create an editText user interface element, EditText is an
        * android widget tha extendes TextView
        * Android can show different kinds of text keyboards depending on the context
        * We select a textKeyboard by calling .inputType a selectin TYPE_CLASS_TEXT
        * Next we set the dialog text title equal to one of our strings
        * Finally we add our editText
        *
        *
        * **/
        val listTitleEditText = EditText(this)
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT
        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)
        //When the uses pulses the positive button, the dialog is dismissed
        builder.setPositiveButton(positiveButtonTitle, { dialog, _ -> dialog.dismiss() })
        //Show the dialog
        builder.create().show()
    }
}
