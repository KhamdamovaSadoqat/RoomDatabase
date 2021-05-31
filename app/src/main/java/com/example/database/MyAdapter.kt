package com.example.database

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.database.databinding.RvItemBinding
import com.example.database.model.Word

class MyAdapter (private  val itemClickListener: ((Word) -> Unit)): RecyclerView.Adapter<MyAdapter.VH>() {

    var list = arrayListOf<Word>()

    fun setData(wordList: ArrayList<Word>){
        this.list = wordList
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.VH {
        val inflater = LayoutInflater.from(parent.context)
        val binding = RvItemBinding.inflate(inflater, parent, false)
        return VH(binding)
    }

    override fun onBindViewHolder(holder: MyAdapter.VH, position: Int) {
        holder.onBind(list[position])
        holder.itemView.setOnClickListener {
            itemClickListener.invoke(list[position])
        }

    }


    override fun getItemCount() : Int{
        return list.size
    }

    class VH(private val binding: RvItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun onBind(word: Word){
            binding.english.text = word.english
            Log.d("-------------", "onBind: ")
        }
    }

}