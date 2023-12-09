package com.example.roomdemo
import android.location.GnssAntennaInfo.Listener
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdemo.db.UserEntity


class RecyclerViewAdapter(val Listener : RowClickListener): RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {
    var items = ArrayList<UserEntity>()
     fun setListData(data: ArrayList<UserEntity>){
         this.items=data
     }


    override fun onCreateViewHolder(parent:ViewGroup, ViewType : Int) : RecyclerViewAdapter.MyViewHolder {
        val inflater = LayoutInflater.from(parent.context).inflate(R.layout.recyclerview_row, parent, false)
        return MyViewHolder(inflater,  Listener)
    }
    override fun getItemCount() : Int {
        return items.size
    }


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        holder.itemView.setOnClickListener{
            Listener.onItemClickListener([position])
        }
       holder.bind(items[position])
    }


    class MyViewHolder(view : View val listener: RowClickListener) : RecyclerView.ViewHolder(view) {
        val tvNama = view.tvNama
        val tvEmail = view.tvemail
        val deleteUserId = view.deleteUserId

        fun bind(data: UserEntity) {
            tvNama.text = data.name
            tvEmail.text = data.email

            deleteUserId. setOnClickListener{
                Listener.onDeleteUserClickListener(data)

            }
        }
    }

    interface RowClickListener{
        fun onDeleteUserClickListener(user: UserEntity)
        fun onItemClickListener(user: UserEntity)

    }
}