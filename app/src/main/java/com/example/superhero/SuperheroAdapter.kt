package com.example.superhero

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.superhero.databinding.ItemHeroBinding


class SuperheroAdapter(private val onItemClicked: (hero: Hero) -> Unit) :
    RecyclerView.Adapter<SuperheroAdapter.Holder>() {

    private var superheroList: List<Hero> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemHeroBinding.inflate(inflater, parent, false)
        return Holder(binding, onItemClicked)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val hero = superheroList[position]
        holder.bind(hero)
    }

    override fun getItemCount(): Int = superheroList.size

    class Holder(private val binding: ItemHeroBinding, val onItemClicked: (hero: Hero) -> Unit) :
        RecyclerView.ViewHolder(binding.root) {


        fun bind(hero: Hero) {
            binding.nickname.text = hero.nickname
            if (hero.biography?.fullName.isNullOrBlank()) {
                binding.name.text = ""
            } else {
                binding.name.text = hero.biography?.fullName
            }
            Glide.with(itemView)
                .load(hero.avatar?.url)
                .into(binding.avatar)

            when (hero.biography?.publisher) {
                Universal.MARVEL_COMICS.text -> downloadImage("https://images7.alphacoders.com/606/thumb-1920-606422.jpg")
                Universal.DARK_HORSE_COMICS.text ->
                    downloadImage("https://www.collconn.com/wp-content/uploads/2018/03/Dark_Horse_Comics_logo_300x200-1200x800.jpg")
                Universal.DC_COMICS.text
                -> downloadImage("https://cutewallpaper.org/21/dc-comics-logo-wallpaper/DC-Comics-Logo-Wallpaper-by-M4W006-on-DeviantArt.jpg")
                Universal.NBC_HEROES.text
                -> downloadImage("https://upload.wikimedia.org/wikipedia/fi/thumb/a/a1/HeroesTitleCard.png/1200px-HeroesTitleCard.png")
                Universal.SHARON_CARTER.text -> downloadImage("https://wallpapercave.com/wp/wp2288818.jpg")
                Universal.ARCHANGEL.text -> downloadImage("https://i.pinimg.com/736x/e8/18/60/e81860e303e857db946d864a55680ac5.jpg")
                Universal.TEMPEST.text
                -> downloadImage("https://steamuserimages-a.akamaihd.net/ugc/924801928755449963/2B60581214D9172C60BF38C087F4DC79B7B02999/?imw=512&amp;imh=288&amp;ima=fit&amp;impolicy=Letterbox&amp;imcolor=%23000000&amp;letterbox=true")
                Universal.IMAGE_COMICS.text -> downloadImage("https://lrmonline.com/wp-content/uploads/2021/01/image-comics-logo-1.jpg")
            }
            itemView.setOnClickListener {
                onItemClicked(hero)
            }
        }

        private fun downloadImage(url: String?) {
            Glide.with(itemView)
                .load(url)
                .into(binding.universeImage)
        }
    }

    fun updateList(newList: List<Hero>) {
        superheroList = newList
        notifyDataSetChanged()
    }
}


