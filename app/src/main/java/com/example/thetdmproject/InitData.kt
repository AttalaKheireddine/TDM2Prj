package com.example.thetdmproject

import android.net.Uri
import java.net.URI
import java.util.*


//if we have time, this should go to a separateFile
val algeriadesc ="officially the People's Democratic Republic of Algeria, is a country in the Maghreb region of North Africa. The capital and most populous city is Algiers, located in the far north of the country on the Mediterranean coast. With an area of 2,381,741 square kilometres (919,595 sq mi), Algeria is the tenth-largest country in the world, and the largest by area in the African Union and the Arab world.[10] With an estimated population of over 44 million, it is the eighth-most populous country in Africa."
val russiadesc ="or the Russian Federation, is a transcontinental country located in Eastern Europe and Northern Asia. Covering an area of 17,125,200 square kilometres (6,612,100 sq mi) it is the largest country in the world by area, spanning more than one-eighth of the Earth's inhabited land area, stretching eleven time zones, and bordering 16 sovereign nations. The territory of Russia extends from the Baltic Sea in the west to the Pacific Ocean in the east, and from the Arctic Ocean in the north to the Black Sea and the Caucasus in the south. With 146.7 million inhabitants living in the country's 85 federal subjects,[9] Russia is the most populous nation in Europe and the ninth-most populous nation in the world. Russia's capital and largest city is Moscow; other major urban areas include Saint Petersburg, Novosibirsk, Yekaterinburg, Nizhny Novgorod, Kazan and Chelyabinsk."
val japandesc =" is an island country in East Asia located in the northwest Pacific Ocean. It borders the Sea of Japan to the west, and it extends from the Sea of Okhotsk in the north to the East China Sea and Taiwan in the south. Japan is part of the Pacific Ring of Fire and comprises an archipelago of 6,852 islands covering 377,975 square kilometers (145,937 sq mi); its five main islands, from north to south, are Hokkaido, Honshu, Shikoku, Kyushu, and Okinawa. Tokyo is the country's capital and largest city; other major cities include Osaka and Nagoya."

fun initalCountries():Array<Country>
{
    return arrayOf<Country>(
        Country("Algeria",algeriadesc,2381241,44,"/drawable/algeria_flag","/raw/algeria_anthem"),
        Country("Russia", russiadesc,17125200,147,"/drawable/russia_image2","/raw/russia_anthem"),
        Country("Japan",japandesc,126,2,"/drawable/japan_flag","/raw/japan_anthem")
    )
}

fun initalHistoryEvents(): Array<CountryHistoryEvent>
{
    return arrayOf<CountryHistoryEvent>(
        CountryHistoryEvent(1, Date(1954,7,5),"Algeria","Algeria became a " +
                "free nation after several years of revolution against the french"),
        CountryHistoryEvent(2, Date(1945,11,1),"Algeria","Algeria started " +
                "its revolution against the french nation"),

        CountryHistoryEvent(3, Date(1917,3,8),"Russia","The Russian Revolution was a period of " +
                "political and social revolution across the territory of the Russian Empire, commencing with the abolition of the monarchy in 1917, and concluding in 1923 after the Bolshevik establishment of the Soviet Union at the end of the Civil War."),
        CountryHistoryEvent(4, Date(1945,11,1),"Russia","President Franklin " +
                "Roosevelt ended almost 16 years of American non-recognition of the Soviet Union following a series of " +
                "negotiations in Washington, D.C. with the Soviet Commissar for Foreign Affairs, Maxim Litvinov."),

        CountryHistoryEvent(5, Date(1945,8,6),"Japan","an American B-29 bomber " +
                "dropped the world's first deployed atomic bomb over the Japanese city of Hiroshima. The explosion wiped out " +
                "90 percent of the city and immediately killed 80,000 people"),
        CountryHistoryEvent(6, Date(1941,12,7),"Japan","The Attack on Pearl Harbor was " +
                "a surprise military strike by the Imperial Japanese Navy Air Service upon the United States against the naval " +
                "base at Pearl Harbor in Honolulu, Territory of Hawaii, just before 08:00, on Sunday morning")
    )
}

fun initalCountryImgs():Array<CountryImg>
{
    return arrayOf(
        CountryImg(1,"Algeria","/drawable/algeria_image1"),
        CountryImg(2,"Algeria","/drawable/algeria_image2"),

        CountryImg(3,"Russia","/drawable/russia_image1"),
        CountryImg(4,"Russia","/drawable/russia_image2"),

        CountryImg(5,"Japan","/drawable/japan_image1"),
        CountryImg(6,"Japan","/drawable/japan_image2")

    )
}

fun initalCountryVideos():Array<CountryVideo>
{
    return arrayOf(
        CountryVideo(1,"Algeria","/drawable/algeria_vid1"),
        CountryVideo(2,"Algeria","/drawable/algeria_vid2"),

        CountryVideo(3,"Russia","/drawable/russia_vid1"),
        CountryVideo(4,"Russia","/drawable/russia_vid2"),

        CountryVideo(5,"Japan","/drawable/japan_vid1"),
        CountryVideo(6,"Japan","/drawable/japan_vid2")

    )
}

fun initialPersonnalities():Array<Personnality>
{
    return arrayOf(
        Personnality(1,"Algeria","1923-6-10","1954-3-4","El Arbi Ben Mhidi"
        ,"Larbi Ben M'hidi, commonly known as Si Larbi or simply as Ben M'hidi, was a prominent revolutionary" +
                    " leader during the Algerian war of independence.","/drawable/benmhidi"),

        Personnality(2,"Algeria","1889-12-4","1940-4-16","Abd El Hamid Ibn Badis"
            ,"Abd al-Hamīd ibn Mustafa ibn Makki ibn Badis, better known as Abdelhamid Ben Badis, was an Algerian educator" +
                    ", exegete, Islamic reformer, scholar and figurehead of cultural nationalism","/drawable/benbadis"),

        Personnality(3,"Russia","1952-10-7","present","Vladimir Putin"
            ,"Vladimir Vladimirovich Putin is a Russian politician and former intelligence officer who has served as" +
                    " President of Russia since 2012, previously holding the position from 1999 until 2008. He was also the" +
                    " Prime Minister of Russia from" +
                    " 1999 to 2000 and again from 2008 to 2012","/drawable/putin"),

        Personnality(4,"Russia","1878-12-18","1953-3-5","Joseph Stalin"
            ,"Joseph Vissarionovich Stalin was a Georgian revolutionary and Soviet politician who led the Soviet Union" +
                    " from the mid-1920s until 1953 as the general secretary of the Communist Party of the Soviet Union and premier" +
                    " of the Soviet Union","/drawable/stalin"),

        Personnality(5,"Japan","1944-11-20","present","Koko Kondo"
            ,"Koko Tanimoto is a prominent atomic bomb survivor, and is the daughter of Kiyoshi Tanimoto, a Methodist minister" +
                    " famous for his work for the Hiroshima Maidens. Both appear in John Hersey's book, Hiroshima.","/drawable/koko"),

        Personnality(6,"Japan","1896-11-13","1987-8-7","Nobusuke Kishi"
            ,"Nobusuke Kishi was a Japanese politician who was Prime Minister of Japan from 1957 to 1960. He is the maternal" +
                    " grandfather of Shinzō Abe, twice prime minister in 2006–2007 and 2012–present. Known for his brutal rule of the Japanese" +
                    " puppet state Manchukuo in Northeast China","/drawable/kishi")
    )
}


fun intialRessourceCategories(): Array<RessourceCategory>? {

    return arrayOf<RessourceCategory>(
        RessourceCategory("Oil","Million Barrels"),
        RessourceCategory("Natural Gas","Trillion Cubic Feet"),
        RessourceCategory("Coasts","Km")
    )
}

fun initalRessources(): Array<Resource>?
{
    return arrayOf(
        Resource(1,"Russia","Coasts",37653.0),
        Resource(2,"Russia","Natural Gas",10.0),
        Resource(3,"Russia","Oil",80.0),

        Resource(4,"Algeria","Coasts",1622.0),
        Resource(5,"Algeria","Oil",12200.0),
        Resource(6,"Algeria","Natural Gas",159.0),

        Resource(7,"Japan","Coasts",29751.0)
    )
}

fun DBFileURI(element :String,packageName:String) :Uri
{
    return Uri.parse("android.resource://" + packageName +element)
}

fun DBFilePath(element :String,packageName:String) :String
{
    return "android.resource://" + packageName +element
}

