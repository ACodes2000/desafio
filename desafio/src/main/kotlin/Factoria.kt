import kotlin.random.Random

object Factoria {
    var jugadores = ArrayList<Jugador>()
    fun crearJugadoresSector1(){
        for(i in 0..1) {
            var j: Jugador = Jugador(1, 10, 10)
            jugadores.add(j)
        }
    }

    fun crearJugadoresSector2(){
        for(i in 0..1) {
            var j: Jugador = Jugador(2, 10, 10)
            jugadores.add(j)
        }
    }

    fun crearJugadoresSector3(){
        for(i in 0..1) {
            var j: Jugador = Jugador(3, 10, 10)
            jugadores.add(j)
        }
    }

    fun crearJugadoresSector4(){
        for(i in 0..1) {
            var j: Jugador = Jugador(4, 10, 10)
            jugadores.add(j)
        }
    }

    fun crearJugadoresSector5(){
        for(i in 0..1) {
            var j: Jugador = Jugador(5, 10, 10)
            jugadores.add(j)
        }
    }
}