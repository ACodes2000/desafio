import kotlin.random.Random

fun main(){
    var ganar:Boolean = false
    var tiempo:Int = 0
    Factoria.crearJugadoresSector1()
    Factoria.crearJugadoresSector2()
    Factoria.crearJugadoresSector3()
    Factoria.crearJugadoresSector4()
    Factoria.crearJugadoresSector5()

    var capitolio:Capitolio = Capitolio()
    println("LLenando la reserva de objetos......")
    capitolio.llenarReserva()
    Thread.sleep(1000)
    tiempo++
    var mapa:Mapa = Mapa()
    mapa.rellenarMapaItems(capitolio)
    mapa.rellenarMapaJugador()
    println("EMPIEZA EL JUEGO")
    mapa.mostrarMapa()
    println(" ")
    Thread.sleep(1000)
    tiempo++
    do{
        var n:Int = Random.nextInt(1,5)
        if(tiempo % 2 == 0){
            if(n == 1) {
                mapa.moverseIzq(capitolio)
            }

            if(n == 2) {
                mapa.moverseArriba(capitolio)
            }

            if(n == 3) {
                mapa.moverseDer(capitolio)
            }

            if(n == 4) {
                mapa.moverseAbajo(capitolio)
            }
            mapa.mostrarMapa()
            println()
        }
        Thread.sleep(1000)
        tiempo++

        if(tiempo % 5 == 0){
            mapa.tirarCuatroItems(capitolio)
        }
        Thread.sleep(1000)
        ganar = mapa.ganador()
    }while(ganar == false)
}