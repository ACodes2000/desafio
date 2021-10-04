import kotlin.random.Random

class Mapa {
    var columna:Int = 5
    var fila:Int = 5

    var mapa = Array(5) { Array<Any>(5) { " " } }
    var jugador1:Jugador = Jugador(0, 10, 10)
    var jugador2:Jugador = Jugador(0, 10, 10)
    var arma:Armas = Armas("Pistola")
    var medicina:Medicina = Medicina("Botiquin")
    var trampa:Trampa = Trampa("Pinchos")

    fun rellenarMapaItems(c: Capitolio) {
        var contador: Int = 0
        for (i in 0..mapa.size - 1) {
            for (x in 0..mapa.size - 1) {
                while (contador != 11) {
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

    fun rellenarMapaJugador() {
        for (i in 0..mapa.size - 1) {
            for (x in 0..mapa.size - 1) {
                var contador = 0
                var r1 = Random.nextInt(mapa.size)
                var r2 = Random.nextInt(mapa.size)
                if (mapa[r1][r2] == " ") {
                    mapa[r1][r2] = Factoria.jugadores[contador].sector
                    Factoria.jugadores.removeAt(contador)
                }
            }
        }
    }

    fun moverseIzq(c :Capitolio){
        /*Recorro el bucle*/
        for(i in 0..mapa.size-1){
            for(x in 0..mapa.size-1){
                if(mapa[i][x] is Jugador){
                    jugador1 = mapa[i][x] as Jugador
                }

                if(mapa[i][x-1] is Jugador){
                    jugador2 = mapa[i][x] as Jugador

                    if(jugador1.fuerza > jugador2.fuerza){
                        mapa[i][x-1] = jugador1.sector
                        c.jugadoresMuertos.add(jugador2)
                        mapa[i][x-1] = {}
                    }

                    if(jugador1.fuerza < jugador2.fuerza){
                        mapa[i][x-1] = jugador2.sector
                        c.jugadoresMuertos.add(jugador1)
                        mapa[i][x-1] = {}
                    }
                }else{
                    if(mapa[i][x-1] is Items){
                        if(mapa[i][x-1] is Armas){
                           arma = mapa[i][x-1] as Armas
                            jugador1.fuerza = jugador1.fuerza + arma.fuerza
                            mapa[i][x-1] = jugador1
                            mapa[i][x-1] = {}
                        }

                        if(mapa[i][x-1] is Medicina){
                            medicina = mapa[i][x-1] as Medicina
                            jugador1.vida = jugador1.vida + medicina.vida
                            mapa[i][x-1] = jugador1
                            mapa[i][x-1] = {}
                        }

                        if(mapa[i][x-1] is Trampa){
                            trampa = mapa[i][x-1] as Trampa
                            mapa[i][x-1] = jugador1
                            c.jugadoresMuertos.add(jugador1)
                            mapa[i][x-1] = {}
                        }
                    }
                }
            }
        }
    }

    fun moverseArriba(c :Capitolio){
        /*Recorro el bucle*/
        for(i in 0..mapa.size-1){
            for(x in 0..mapa.size-1){
                if(mapa[i][x] is Jugador){
                    jugador1 = mapa[i][x] as Jugador
                }

                if(mapa[i-1][x] is Jugador){
                    jugador2 = mapa[i][x] as Jugador

                    if(jugador1.fuerza > jugador2.fuerza){
                        mapa[i-1][x] = jugador1.sector
                        c.jugadoresMuertos.add(jugador2)
                        mapa[i-1][x] = {}
                    }

                    if(jugador1.fuerza < jugador2.fuerza){
                        mapa[i-1][x] = jugador2.sector
                        c.jugadoresMuertos.add(jugador1)
                        mapa[i-1][x] = {}
                    }
                }else{
                    if(mapa[i-1][x] is Items){
                        if(mapa[i-1][x] is Armas){
                            arma = mapa[i-1][x] as Armas
                            jugador1.fuerza = jugador1.fuerza + arma.fuerza
                            mapa[i-1][x] = jugador1
                            mapa[i-1][x] = {}
                        }

                        if(mapa[i-1][x] is Medicina){
                            medicina = mapa[i-1][x] as Medicina
                            jugador1.vida = jugador1.vida + medicina.vida
                            mapa[i-1][x] = jugador1
                            mapa[i-1][x] = {}
                        }

                        if(mapa[i-1][x] is Trampa){
                            trampa = mapa[i-1][x] as Trampa
                            mapa[i-1][x] = jugador1
                            c.jugadoresMuertos.add(jugador1)
                            mapa[i-1][x] = {}
                        }
                    }
                }
            }
        }
    }

    fun moverseAbajo(c :Capitolio){
        /*Recorro el bucle*/
        for(i in 0..mapa.size-1){
            for(x in 0..mapa.size-1){
                if(mapa[i][x] is Jugador){
                    jugador1 = mapa[i][x] as Jugador
                }

                if(mapa[i+1][x] is Jugador){
                    jugador2 = mapa[i][x] as Jugador

                    if(jugador1.fuerza > jugador2.fuerza){
                        mapa[i+1][x] = jugador1.sector
                        c.jugadoresMuertos.add(jugador2)
                        mapa[i+1][x] = {}
                    }

                    if(jugador1.fuerza < jugador2.fuerza){
                        mapa[i+1][x] = jugador2.sector
                        c.jugadoresMuertos.add(jugador1)
                        mapa[i+1][x] = {}
                    }
                }else{
                    if(mapa[i+1][x] is Items){
                        if(mapa[i+1][x] is Armas){
                            arma = mapa[i+1][x] as Armas
                            jugador1.fuerza = jugador1.fuerza + arma.fuerza
                            mapa[i+1][x] = jugador1
                            mapa[i+1][x] = {}
                        }

                        if(mapa[i+1][x] is Medicina){
                            medicina = mapa[i+1][x] as Medicina
                            jugador1.vida = jugador1.vida + medicina.vida
                            mapa[i+1][x] = jugador1
                            mapa[i+1][x] = {}
                        }

                        if(mapa[i+1][x] is Trampa){
                            trampa = mapa[i+1][x] as Trampa
                            mapa[i+1][x] = jugador1
                            c.jugadoresMuertos.add(jugador1)
                            mapa[i+1][x] = {}
                        }
                    }
                }
            }
        }
    }

    fun moverseDer(c :Capitolio){
        /*Recorro el bucle*/
        for(i in 0..mapa.size-1){
            for(x in 0..mapa.size-1){
                if(mapa[i][x] is Jugador){
                    jugador1 = mapa[i][x] as Jugador
                }

                if(mapa[i][x+1] is Jugador){
                    jugador2 = mapa[i][x] as Jugador

                    if(jugador1.fuerza > jugador2.fuerza){
                        mapa[i][x+1] = jugador1.sector
                        c.jugadoresMuertos.add(jugador2)
                        mapa[i][x+1] = {}
                    }

                    if(jugador1.fuerza < jugador2.fuerza){
                        mapa[i][x+1] = jugador2.sector
                        c.jugadoresMuertos.add(jugador1)
                        mapa[i][x+1] = {}
                    }
                }else{
                    if(mapa[i][x+1] is Items){
                        if(mapa[i][x+1] is Armas){
                            arma = mapa[i][x+1] as Armas
                            jugador1.fuerza = jugador1.fuerza + arma.fuerza
                            mapa[i][x+1] = jugador1
                            mapa[i][x+1] = {}
                        }

                        if(mapa[i][x+1] is Medicina){
                            medicina = mapa[i][x+1] as Medicina
                            jugador1.vida = jugador1.vida + medicina.vida
                            mapa[i][x+1] = jugador1
                            mapa[i][x+1] = {}
                        }

                        if(mapa[i][x+1] is Trampa){
                            trampa = mapa[i][x+1] as Trampa
                            mapa[i][x+1] = jugador1
                            c.jugadoresMuertos.add(jugador1)
                            mapa[i][x+1] = {}
                        }
                    }
                }
            }
        }
    }

    fun tirarCuatroItems(c: Capitolio) {
        var contador: Int = 0
        for (i in 0..mapa.size - 1) {
            for (x in 0..mapa.size - 1) {
                while (contador != 5) {
                    var r1 = Random.nextInt(0, 5)
                    var r2 = Random.nextInt(0, 5)
                    var r3 = Random.nextInt(c.reservaItems.size)
                    if(mapa[r1][r2] == "") {
                        mapa[r1][r2] = c.reservaItems[r3].descripcion
                        contador++
                        c.reservaItems.removeAt(r3)
                    }
                }
            }
        }
    }

    fun ganador():Boolean{
        var contador = 0;
        var ganador = false
        for(i in 0..mapa.size-1){
            for(x in 0..mapa.size-1){
                if(mapa[i][x] is Jugador){
                    contador++
                }
                if(contador == 1){
                    ganador = true
                }
            }
        }
        return ganador
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
