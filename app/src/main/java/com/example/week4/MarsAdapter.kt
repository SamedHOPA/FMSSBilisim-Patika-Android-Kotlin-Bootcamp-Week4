package com.example.week4

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.example.week4.databinding.RecyclerItemBinding
import com.squareup.picasso.Picasso

class MarsAdapter (
    private val list: List<MarsModel>,
    private val onItemClickHandler: (MarsModel: MarsModel) -> Unit
): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    /**
     * onCreateViewHolder() — Adapter oluştuğunda viewHolder’ı başlatmak için bu metod çağrılır.
     *
     * @param parent
     * @param viewType
     * @return
     */

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val marsBinding = DataBindingUtil.inflate<ViewDataBinding>(
            LayoutInflater.from(parent.context),R.layout.recycler_item,parent,false
        )
        return MarsViewHolder(marsBinding)
    }

    /**
     * onBindViewHolder()- onCreateViewHolder() metodundan dönen veriyi bağlamak için kullanılır.
     *
     * @param holder
     * @param position
     */

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as MarsViewHolder).onBind(list[position], onItemClickHandler)
    }

    /**
     * getItemCount()- Listemizin eleman sayısını döndürür.
     *
     * @return
     */

    override fun getItemCount(): Int {
        return list.size
    }

    /**
     * ViewHolder() - Her itemin içinde bulunan bileşenlerin tanımlama işleminin yapıldığı yerdir.
     *
     * @property MarsBinding
     */

    class MarsViewHolder(
        private val MarsBinding: ViewDataBinding
    ): RecyclerView.ViewHolder(MarsBinding.root) {
        private val image by lazy { itemView.findViewById<ImageView>(R.id.imgUrl) }
        fun onBind(MarsModel: MarsModel, onItemClickHandler: (MarsModel: MarsModel) -> Unit){
            val binding = MarsBinding as RecyclerItemBinding
            binding.setVariable(BR.marsModel, MarsModel)
            Picasso.get().load(MarsModel.img_src).resize(160,200).into(image)
            binding.pictureCardView.setOnClickListener {onItemClickHandler(MarsModel)}
        }
    }
}