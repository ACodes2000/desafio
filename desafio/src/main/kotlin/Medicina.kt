class Medicina :Items{
    var vida = 10

    constructor(descripcion:String, vida:Int) :super(descripcion){
        this.descripcion = descripcion
        this.vida = vida
    }
}