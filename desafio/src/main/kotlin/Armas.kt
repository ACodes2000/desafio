import kotlin.random.Random

class Armas :Items{
    var fuerza:Int = Random.nextInt(50, 101)

    constructor(descripcion:String) :super(descripcion){
        this.descripcion = descripcion
        this.fuerza = fuerza
    }
}