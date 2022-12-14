package com.example.vinylteam8.ui.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.net.toUri
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.vinylteam8.R
import com.example.vinylteam8.databinding.FragmentPerfomerListBinding
import com.example.vinylteam8.models.Performer
import com.example.vinylteam8.ui.performer.PerformerFragmentDirections

class PerformerAdapter : RecyclerView.Adapter<PerformerAdapter.PerformerViewHolder>(){

    var performers :List<Performer> = emptyList()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerformerViewHolder {
        val withDataBinding: FragmentPerfomerListBinding= DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            PerformerViewHolder.LAYOUT,
            parent,
            false)
        return PerformerViewHolder(withDataBinding)
    }

    override fun onBindViewHolder(holder: PerformerViewHolder, position: Int) {
        holder.viewDataBinding.also {
            it.performer = performers[position]
        }

        holder.viewDataBinding.root.setOnClickListener {
            val action = PerformerFragmentDirections.actionNavigationPerformerToPerformerDetailsFragment(performers[position].performerID)
            // Navigate using that action
            holder.viewDataBinding.root.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return performers.size
    }


    class PerformerViewHolder(val viewDataBinding: FragmentPerfomerListBinding) :
        RecyclerView.ViewHolder(viewDataBinding.root) {
        companion object {
            @LayoutRes
            val LAYOUT = R.layout.fragment_perfomer_list
        }

    }
}