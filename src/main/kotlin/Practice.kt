import io.github.serpro69.kfaker.Faker
import io.github.serpro69.kfaker.faker
import io.github.serpro69.kfaker.fakerConfig

object PracticeJava {
    @JvmStatic
    fun main(args: Array<String>) {
        //println("Hello World")
        //test()
        val config = fakerConfig { locale = "en-IND" }
        val faker = Faker(config)
        println(faker.name.firstName())
        println(faker.name.lastName())
        println(faker.yoda.quotes())
    }

    fun test(): Int {
        var map: Map<String,String> = HashMap()
        map = HashMap()
        var arr = Array(8) {i-> i+-1 }
        for (item in arr)
            print(item)

        var st = """Navneet
            |sfklfs
            |sf
            |sf
            |sf
            |sf;sf;s
            |lfslkf
            |ksfk
            |skfs
            |fs
            |skf
        """.trimMargin() + """sfljsjflbjslfbljsbflsbflsljbfsljbfsbjlsfb"""

       var st1 =  st + """
           |
           |additionalstring""".trimMargin()
        print(st1)
        var aa: Int = 1000
        var b : Long = aa.toLong()
        aa = b.toInt()
        //Fakeit.init()
        return 1

    }
}