package com.example.miwokkotlin.datasource

import com.example.miwokkotlin.MiwokEnum
import com.example.miwokkotlin.R
import com.example.miwokkotlin.models.MiwokModel

class DataSource {

    var colorsModels: ArrayList<MiwokModel> = arrayListOf()
    var familyModels: ArrayList<MiwokModel> = arrayListOf()
    var numbersModels: ArrayList<MiwokModel> = arrayListOf()
    var phrasesModels: ArrayList<MiwokModel> = arrayListOf()

    init {
        bindColorsData()
        bindPhrasesData()
        bindFamilyData()
        bindNumbersData()
    }

    // This isn't good, it shouldn't return null. In case of no data, return empty.
    fun getData(value: MiwokEnum?): ArrayList<MiwokModel>? {
        return when (value) {
            MiwokEnum.NUMBERS -> numbersModels
            MiwokEnum.FAMILY -> familyModels
            MiwokEnum.COLORS -> colorsModels
            MiwokEnum.PHRASES -> phrasesModels
            else -> {
                throw Exception("Unknown fragment.")
            }
        }
    }

    private fun bindColorsData() {
        val miwokColors = R.array.miwok_colors
        val englishColors = R.array.english_colors
        val colorImages = intArrayOf(
            R.drawable.color_red,
            R.drawable.color_mustard_yellow,
            R.drawable.color_dusty_yellow,
            R.drawable.color_green,
            R.drawable.color_brown,
            R.drawable.color_gray,
            R.drawable.color_black,
            R.drawable.color_white
        )
        val colorSounds = intArrayOf(
            R.raw.color_red, R.raw.color_mustard_yellow, R.raw.color_dusty_yellow, R.raw.color_green,
            R.raw.color_brown, R.raw.color_gray, R.raw.color_black, R.raw.color_white
        )
        // Binds all the data necessary for Colors to the respective model.
        for(i in colorImages.indices){
            colorsModels?.add(MiwokModel(miwokColors, englishColors, colorSounds[i], colorImages[i]))
        }
    }

    private fun bindFamilyData() {
        val miwokFamily = R.array.family_miwok
        val englishFamily = R.array.family_english
        val familyImages = intArrayOf(
            R.drawable.family_father,
            R.drawable.family_mother,
            R.drawable.family_son,
            R.drawable.family_daughter,
            R.drawable.family_older_brother,
            R.drawable.family_younger_brother,
            R.drawable.family_older_sister,
            R.drawable.family_younger_sister,
            R.drawable.family_grandmother,
            R.drawable.family_grandfather
        )
        val familySounds = intArrayOf(
            R.raw.family_father,
            R.raw.family_mother,
            R.raw.family_son,
            R.raw.family_daughter,
            R.raw.family_older_brother,
            R.raw.family_younger_brother,
            R.raw.family_older_sister,
            R.raw.family_younger_sister,
            R.raw.family_grandmother,
            R.raw.family_grandfather
        )
        // Binds all the data necessary for Families to the respective model.
        for(i in familyImages.indices){
            familyModels?.add(MiwokModel(miwokFamily,englishFamily,familySounds[i],familyImages[i]))
        }
    }

    private fun bindNumbersData() {
        val miwokNumbers = R.array.numbers_miwok
        val englishNumbers = R.array.numbers_english
        val numberImages = intArrayOf(
            R.drawable.number_one,
            R.drawable.number_two,
            R.drawable.number_three,
            R.drawable.number_four,
            R.drawable.number_five,
            R.drawable.number_six,
            R.drawable.number_seven,
            R.drawable.number_eight,
            R.drawable.number_nine,
            R.drawable.number_ten
        )
        val numberSounds = intArrayOf(
            R.raw.number_one,
            R.raw.number_two,
            R.raw.number_three,
            R.raw.number_four,
            R.raw.number_five,
            R.raw.number_six,
            R.raw.number_seven,
            R.raw.number_eight,
            R.raw.number_nine,
            R.raw.number_ten
        )
        // Binds all the data necessary for Numbers to the respective model.
        for(i in numberImages.indices){
            numbersModels?.add(MiwokModel(miwokNumbers,englishNumbers,numberSounds[i],numberImages[i]))
        }
    }

    private fun bindPhrasesData() {
        val miwokPhrases = R.array.miwok_phrases
        val englishPhrases = R.array.english_phrases
        val phrasesSounds = intArrayOf(
            R.raw.phrase_where_are_you_going,
            R.raw.phrase_what_is_your_name,
            R.raw.phrase_my_name_is,
            R.raw.phrase_how_are_you_feeling,
            R.raw.phrase_im_feeling_good,
            R.raw.phrase_are_you_coming,
            R.raw.phrase_yes_im_coming,
            R.raw.phrase_im_coming,
            R.raw.phrase_lets_go,
            R.raw.phrase_come_here
        )
        // Binds all the data necessary for Phrases to the respective model.
        for(i in phrasesSounds.indices){
            phrasesModels?.add(MiwokModel(miwokPhrases, englishPhrases, phrasesSounds[i]))
        }
    }

}