import kotlin.random.Random

class Capitolio {
    var reservaItems = ArrayList<Items>()
    var jugadoresMuertos = ArrayList<Jugador>()

    fun llenarReserva(){
        for(i in 1..100){
            var random = Random.nextInt(1, 4)
            if(random == 1){
                var arma:Armas = Armas("Pistola")
                reservaItems.add(arma)
            }

            if(random == 2){
                var medicina:Medicina = Medicina("Botiquin")
                reservaItems.add(medicina)
            }

            if(random == 3){
                var trampa:Trampa = Trampa("Pinchos")
                reservaItems.add(trampa)
            }
        }
    }

}