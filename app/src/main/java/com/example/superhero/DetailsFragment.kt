package com.example.superhero

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.superhero.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment(R.layout.fragment_details) {
    private lateinit var binding: FragmentDetailsBinding
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Glide.with(view)
            .load(args.hero.avatar?.url)
            .into(binding.avatar)
        if (args.hero.nickname != "null") {
            binding.title.text = args.hero.nickname
        } else {
            binding.title.text = "нет информации"
        }
        if (args.hero.biography?.fullName != "null") {
            binding.fullNameTextView.text = args.hero.biography?.fullName
        } else binding.fullNameTextView.text = "нет информации"

        if (args.hero.powerstats?.intelligence != "null") {
            binding.intelligenceHero.text = args.hero.powerstats?.intelligence
        } else binding.intelligenceHero.text = "нет информации"

        if (args.hero.powerstats?.strength != "null") {
            binding.strengthHero.text = args.hero.powerstats?.strength
        } else binding.strengthHero.text = "нет информации"

        if (args.hero.powerstats?.speed != "null") {
            binding.speedHero.text = args.hero.powerstats?.speed
        } else binding.speedHero.text = "нет информации"

        if (args.hero.powerstats?.combat != "null") {
            binding.combatHero.text = args.hero.powerstats?.combat
        } else binding.combatHero.text = "нет информации"

        if (args.hero.biography?.birthsPlace != "null") {
            binding.birthsPlaceHero.text = args.hero.biography?.birthsPlace
        } else binding.birthsPlaceHero.text = "нет информации"

        if (args.hero.biography?.firstAppearance != "null") {
            binding.firstAppearanceHero.text = args.hero.biography?.firstAppearance
        } else binding.firstAppearanceHero.text = "нет информации"

        if (args.hero.work?.occupation != "null") {
            binding.occupationHero.text = args.hero.work?.occupation
        } else binding.occupationHero.text = "нет информации"

        if (args.hero.connections?.relatives != "null") {
            binding.relativesHero.text = args.hero.connections?.relatives
        } else binding.relativesHero.text = "нет информации"
        loadUniversalImage()
    }

    private fun loadUniversalImage() {
        when (args.hero.biography?.publisher) {
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
    }

    private fun downloadImage(url: String?) {
        view?.let {
            Glide.with(it)
                .load(url)
                .into(binding.imageUniversal)
        }
    }
}