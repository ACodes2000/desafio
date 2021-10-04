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
    Thread.sleep(3000)
    var mapa:Mapa = Mapa()
    mapa.rellenarMapaItems(capitolio)
    mapa.rellenarMapaJugador()
    println("EMPIEZA EL JUEGO")
    mapa.mostrarMapa()
    do{
        if(tiempo % 2 == 0){

        }
    }while(ganar == true)
}