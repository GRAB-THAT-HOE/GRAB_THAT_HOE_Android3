package kr.co.moreversal.grapthathoe.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ItemDetailFarmBinding
import kr.co.moreversal.grapthathoe.network.model.FarmImg

class DetailFarmAdapter(lifecycleOwner: LifecycleOwner) :
RecyclerView.Adapter<DetailFarmAdapter.PagerViewHolder>(){

    private val farmImgList : List<FarmImg> = ArrayList<FarmImg>()

    class PagerViewHolder(private val binding: ItemDetailFarmBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(farmImg: FarmImg) {
            with(farmImg) {
                Glide.with(binding.root)
                    .load(farmImg.farmImg)
                    .error(R.drawable.ic_no_image)
                    .centerCrop()
                    .into(binding.imgDetailImg)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PagerViewHolder {
        return PagerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_detail_farm,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PagerViewHolder, position: Int) {
        holder.bind(farmImgList[position])
    }

    override fun getItemCount(): Int = farmImgList.size
}