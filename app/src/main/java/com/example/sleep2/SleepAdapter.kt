package com.example.sleep2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SleepAdapter (private val sleep: List<Sleep>) : RecyclerView.Adapter<SleepAdapter.ViewHolder>(){
    // Provide a direct reference to each of the views within a data item
    // Used to cache the views within the item layout for fast access
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val dateTextView: TextView
        val hourTextView: TextView
        val conditionTextView: TextView

        init {

            dateTextView = itemView.findViewById(R.id.dateTv)
            hourTextView = itemView.findViewById(R.id.hourTv)
            conditionTextView = itemView.findViewById(R.id.conditionTv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout
        val contactView = inflater.inflate(R.layout.sleep_item, parent, false)
        // Return a new holder instance
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // Get the data model based on position
        val sleeps = sleep[position]
        // Set item views based on views and data model
        holder.dateTextView.text = sleeps.date
        holder.hourTextView.text = sleeps.hour + " Hours"
        holder.conditionTextView.text = sleeps.condition
    }

    override fun getItemCount(): Int {
        return sleep.size
    }

}