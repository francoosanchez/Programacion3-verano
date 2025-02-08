package clase4.actividad1;

/*
    Actividad 1

    Aplicar la técnica de Divide y Vencerás en una lista de clientes con id, nombre y scoring, buscando el cliente con el scoring máximo.
    Resolver mediante pseudocódigo
    Implementar en java
 */

@SuppressWarnings("unused")
class Cliente{
    int id;
    String nombre;
    int scoring;

    public Cliente(int id, String nombre, int scoring){
        this.id = id;
        this.nombre = nombre;
        this.scoring = scoring;
    }
    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", scoring=" + scoring +
                '}';
    }
}


public class c4_act1{
    public static Cliente encontrarClienteMaximo(Cliente[] listaC, int i, int f){
        if(i == f){ // caso base : un solo cliente
            return listaC[i]; // O(1)
        }

        int mitad = (i + f) / 2; // O(1)

        Cliente clienteIzq = encontrarClienteMaximo(listaC, i, mitad);  // Llamada recursiva O(T(n/2))
        Cliente clienteDer = encontrarClienteMaximo(listaC, mitad+1, f); // Llamada recursiva O(T(n/2))

        if(clienteIzq.scoring > clienteDer.scoring){ // O(1)
            return clienteIzq;
        }else{
            return clienteDer;
        }
    }

    public static void main(String[] args) {
        Cliente[] clientes = {
            new Cliente(1, "Pablo", 111),
            new Cliente(2, "Antonio", 56),
            new Cliente(3, "Delfina", 123),
            new Cliente(4, "Manuel", 198),
            new Cliente(5, "Franco", 108)
        };

        Cliente clienteMaxScore = encontrarClienteMaximo(clientes, 0, clientes.length -1);
        System.out.println("Cliente con el scoring máximo: " + clienteMaxScore);
        System.out.println("Scoring : " + clienteMaxScore.scoring);
    }
}