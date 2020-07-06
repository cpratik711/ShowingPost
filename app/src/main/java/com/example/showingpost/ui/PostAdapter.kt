//package com.abhay.shadicardmatcher.ui
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.recyclerview.widget.RecyclerView
//import com.example.showingpost.R
//import com.example.showingpost.databinding.RowItemBinding
//import com.example.showingpost.db_model.Post
//
//
//class PostAdapter(private val items: List<Post>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
//        val binding: RowItemBinding = DataBindingUtil.inflate(
//            LayoutInflater.from(parent.context),
//            R.layout.row_item, parent, false
//        )
//        return PostViewHolder(binding)
//    }
//
//
//    override fun getItemCount(): Int {
//        return items.size
//    }
//
//    inner class PostViewHolder(val binding: RowItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(item: Post) {
//            with(binding) {
//                t1.text = item.title
//                t2.text = item.body
//            }
//        }
//    }
//
//    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
//        var postViewHolder = holder as PostViewHolder
//        postViewHolder.bind(items[position])
//    }
//}
