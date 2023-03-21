// you must update MainActivity.kt with this code
// study this compared to what is in the lab book
// https://coda.io/@peter-sigurdson/mads-4001-introduction-to-android-development

package com.example.march21a

import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class Flower(val name: String, val description: String, val price: Double)

    inner class FlowerAdapter(private val context: AppCompatActivity, private val flowers: List<Flower>) : BaseAdapter() {

        override fun getCount(): Int {
            return flowers.size
        }

        override fun getItem(position: Int): Any {
            return flowers[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var view = convertView
            if (view == null) {
                view = layoutInflater.inflate(R.layout.flower_list_item, parent, false)
            }

            val flower = flowers[position]
            view?.findViewById<TextView>(R.id.flower_name)?.text = flower.name
           // view?.findViewById<TextView>(R.id.flower_description)?.text = flower.description
            view?.findViewById<TextView>(R.id.flower_price)?.text = "$${String.format("%.2f", flower.price)}"

            return view!!
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flowerList = listOf(
            Flower("Red Rose", "A beautiful red rose", 12.99),
            Flower("Lily", "A fragrant white lily", 9.99),
            Flower("Tulip", "A colorful tulip", 7.99),
            Flower("Daisy", "A cute daisy", 6.99),
            Flower("Sunflower", "A bright sunflower", 8.99)
        )

        val listView = findViewById<ListView>(R.id.list_view)
        val adapter = FlowerAdapter(this, flowerList)
        listView.adapter = adapter

        val add_button = findViewById<Button>(R.id.add_button)
        add_button.setOnClickListener {
            // Add code to handle button click event
        }
    }
}



flower_list_item.xml is the layout file for the custom list item view used in the ListView in the flower shop app. It should contain the layout for a single item in the list, including the TextView elements for displaying the flower name and price.
Here's an example of what the flower_list_item.xml file could look like:

<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:orientation="horizontal"
    android:padding="16dp">

    <TextView
        android:id="@+id/flower_name"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_weight="1"
        android:textColor="@android:color/black"
        android:textSize="18sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/flower_price"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:textColor="@android:color/black"
        android:textSize="18sp" />

</LinearLayout>

This layout file defines a LinearLayout with a horizontal orientation containing two TextView elements: one for the flower name and one for the flower price. The TextView for the flower name has a weight of 1, which makes it expand to fill the available space in the layout. The TextView for the flower price has a fixed width and displays the price of the flower.


Make sure that the flower_description TextView is properly defined in the flower_details.xml layout file. 

Here's an example of how it can be defined:

<TextView
    android:id="@+id/flower_description"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_margin="16dp"
    android:textColor="#000"
    android:textSize="18sp"
    android:text="@string/flower_description_placeholder"/>

Make sure that the android:id attribute matches the ID used in your code (R.id.flower_description). Also, make sure that the android:text attribute is set to a valid string resource or a hardcoded string value.


