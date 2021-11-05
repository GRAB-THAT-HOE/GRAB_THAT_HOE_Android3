package kr.co.moreversal.grapthathoe.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ItemFarmerHomeBinding
import kr.co.moreversal.grapthathoe.databinding.ItemFarmerPostBinding
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent
import kr.co.moreversal.grapthathoe.network.model.FarmerPost
import kr.co.moreversal.grapthathoe.network.model.MyPost
import kr.co.moreversal.grapthathoe.viewmodel.item.FarmerHomeItemViewModel

class FarmerPostRecyclerAdapter(val lifecycleOwner: LifecycleOwner):
    RecyclerView.Adapter<FarmerPostRecyclerAdapter.FarmerPostViewHolder>() {

    var farmerMyPostList : List<MyPost> = ArrayList<MyPost>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FarmerPostViewHolder {
        return FarmerPostViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_farmer_post,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: FarmerPostViewHolder, position: Int) {
        holder.bind(farmerMyPostList[position], lifecycleOwner)
    }

    override fun getItemCount(): Int = farmerMyPostList.size

    class FarmerPostViewHolder(private val binding: ItemFarmerPostBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myPost: MyPost, lifecycleOwner: LifecycleOwner) {

            with(myPost) {
                binding.tvMyTitle.text = title
                binding.tvMyDate.text = date

                Glide.with(binding.root)
                    .load(myPostImg)
                    .centerCrop()
                    .error(R.drawable.ic_no_image)
                    .into(binding.ivMyImg)
            }
        }
    }
}