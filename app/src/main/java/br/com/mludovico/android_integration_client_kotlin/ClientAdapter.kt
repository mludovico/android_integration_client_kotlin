package br.com.mludovico.android_integration_client_kotlin

import android.database.Cursor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.client_item.view.*

class ClientAdapter(private val mCursor: Cursor): RecyclerView.Adapter<ClientViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClientViewHolder {
        return ClientViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.client_item, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ClientViewHolder, position: Int) {
        mCursor.moveToPosition(position)
        holder.itemView.item_title.text = mCursor.getString(mCursor.getColumnIndex("title"))
        holder.itemView.item_description.text = mCursor.getString(mCursor.getColumnIndex("description"))
    }

    override fun getItemCount(): Int = mCursor.count

}

class ClientViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)