package practica1;

import java.util.*;

public class practica1 {

    /**
     *  Método que toma dos conjuntos de enteros y separa los elementos entre aquellos que sólo aparecen una vez
     *  y aquellos que aparecen repetidos. El método modifica los conjuntos que toma como parámetros.
     * @param unicos    A la entrada un conjunto de enteros. A la sálida los elementos que solo aparecen en uno de
     *                  los conjuntos.
     * @param repetidos A la entrada un conjunto de enteros. A la salida los elementos que aparecen en ambos conjuntos.
     */
    static public void separa(Set<String> unicos, Set<String> repetidos) {
        // TODO
        if(unicos.isEmpty()){
            unicos.addAll(repetidos);
            repetidos.clear();
        }
        else{
            Set<String> copiaRepetidos = new HashSet<>(repetidos);
            for(String elemento : copiaRepetidos){
                if(unicos.contains(elemento)){
                    unicos.remove(elemento);
                }else{
                    unicos.add(elemento);
                    repetidos.remove(elemento);
                }
            }


        }
    }

    /**
     *  Toma un iterador a una colección de enteros positivos y devuelve como resultado un conjunto con aquellos elementos
     *  de la colección que no son múltiplos de algún otro de la colección. Los ceros son descartados
     * @param iter  Iterador a una colección de enteros
     * @return Conjunto de de enteros.
     */
    static public Set <Integer> filtra(Iterator<Integer> iter) {
        //TODO
        Set<Integer> numerosValidos = new HashSet<>();
        Set<Integer> numerosMultiplos = new HashSet<>();

        while (iter.hasNext()){
            Integer numero = iter.next();

            if (numero <= 0){
                continue;
            }


            boolean esMultiplo = false;
            for (Integer existente : numerosValidos){
                if(numero % existente == 0 && !numero.equals(existente)){
                    esMultiplo = true;
                    numerosMultiplos.add(numero);
                    break;
                }
            }
            if(!esMultiplo){
                numerosValidos.add(numero);
            }

        }
        if(numerosValidos.contains(1)){
            numerosValidos.clear();
            numerosValidos.add(1);
        }
        numerosValidos.removeAll(numerosMultiplos);

        return numerosValidos;
    }

    /**
     * Toma una colección de conjuntos de <i>String</i> y devuelve como resultado un conjunto con aquellos <i>String </i>
     * Que aparecen en al menos dos conjuntos de la colección.
     * @param col Coleccion de conjuntos de <i>String</i>
     * @return Conjunto de <i>String</i> repetidos. 
     */
    static public Set<String> repetidos(Collection<Set<String>> col) {
        // TODO
        Map<String, Integer> conteo = new HashMap<>();
        Set<String> resultado = new HashSet<>();

        for (Set<String> conjunto : col) {
            for (String elemento : conjunto) {
                conteo.put(elemento, conteo.getOrDefault(elemento, 0) + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : conteo.entrySet()) {
            if (entry.getValue() > 1) {
                resultado.add(entry.getKey());
            }
        }

        return resultado;
    }
}
