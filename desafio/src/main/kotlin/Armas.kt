class Armas :Items{
    var fuerza:Int = 10

    constructor(descripcion:String, fuerza:Int) :super(descripcion){
        this.descripcion = descripcion
        this.fuerza = fuerza
    }
}