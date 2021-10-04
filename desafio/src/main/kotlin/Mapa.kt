import kotlin.random.Random

class Mapa {
    var mapa = Array(5) { Array<Any>(5){" "} }

    fun rellenarMapaItems(c:Capitolio){
        var contador:Int = 0
        for(i in 0..mapa.size-1){
            for(x in 0..mapa.size-1){
                while(contador!=11) {
                    var r1 = Random.nextInt(0, 5)
                    var r2 = Random.nextInt(0, 5)
                    var r3 = Random.nextInt(c.reservaItems.size)
                    mapa[r1][r2] = c.reservaItems[r3].descripcion
                    contador++
                    c.reservaItems.removeAt(r3)
                }
            }
        }
    }

    fun rellenarMapaJugador(){
        for(i in 0..mapa.size-1){
            for(x in 0..mapa.size-1){
                var contador = 0
                var r1 = Random.nextInt(mapa.size)
                var r2 = Random.nextInt(mapa.size)
                if(mapa[r1][r2] == " "){
                    mapa[r1][r2] = Factoria.jugadores[contador].sector
                    Factoria.jugadores.removeAt(contador)
                }
            }
        }
    }

    fun mostrarMapa(){
        for(i in 0..mapa.size-1) {
            for (x in 0..mapa.size - 1) {
                print("|"+mapa[i][x]+"|")
                print(" ")
            }
            println("")
        }
    }
}