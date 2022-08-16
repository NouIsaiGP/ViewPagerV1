package com.example.viewpagerexample

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.viewpagerexample.databinding.ItemPageBinding

class ViewPagerAdapter(private var title: List<String>, private var details: List<String>, private var images: List<Int>) : RecyclerView.Adapter<ViewPagerAdapter.Pager2ViewHolder>() {

    inner class Pager2ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding = ItemPageBinding.bind(itemView)

        init {
            binding.imageView.setOnClickListener {
                val position = adapterPosition
                Toast.makeText(itemView.context,"Haz hecho click en el objeto#${position+1}",Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPagerAdapter.Pager2ViewHolder {
        return Pager2ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_page, parent, false))
    }

    override fun onBindViewHolder(holder: ViewPagerAdapter.Pager2ViewHolder, position: Int) {
        holder.binding.tvTitle.text = title[position]
        holder.binding.tvDetails.text = details[position]
        holder.binding.imageView.setImageResource(images[position])
    }

    override fun getItemCount(): Int = title.size
}