package kr.co.moreversal.grapthathoe.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import kr.co.moreversal.grapthathoe.R
import kr.co.moreversal.grapthathoe.databinding.ItemConnectBinding
import kr.co.moreversal.grapthathoe.extension.SingleLiveEvent
import kr.co.moreversal.grapthathoe.network.model.Connect
import kr.co.moreversal.grapthathoe.viewmodel.item.ConnectItemViewModel

class ConnectRecyclerAdapter(val lifecycleOwner: LifecycleOwner):
    RecyclerView.Adapter<ConnectRecyclerAdapter.ConnectViewHolder>() {

    var connectList: List<Connect> = ArrayList<Connect>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ConnectViewHolder {
        return ConnectViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_connect,
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ConnectViewHolder, position: Int) {
        holder.bind(connectList[position], lifecycleOwner)
    }

    override fun getItemCount(): Int = connectList.size


    class ConnectViewHolder(private val binding: ItemConnectBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(connect: Connect, lifecycleOwner: LifecycleOwner) {
            val viewModel = ConnectItemViewModel()
            binding.vm = viewModel
            binding.lifecycleOwner = lifecycleOwner

            with(connect) {
                binding.tvRecordName.text = name
                binding.tvRecordDate.text = date

                Glide.with(binding.root)
                    .load(profileImg)
                    .centerCrop()
                    .error(R.drawable.ic_no_image)
                    .into(binding.ivProfileRecord)

                viewModel.onDetailProfileEvent.observe(lifecycleOwner, {
                    onClickDetailProfile.call()
                })
            }
        }
    }

    companion object {
        val onClickDetailProfile = SingleLiveEvent<Unit>()
    }
}