package uniandes.dpoo.estructuras.logica;

import java.util.HashMap;
// Esto es una prueba del commit
/** 
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre arreglos de enteros y de cadenas.
 *
 * Todos los métodos deben operar sobre los atributos arregloEnteros y arregloCadenas.
 * 
 * No pueden agregarse nuevos atributos.
 * 
 * Implemente los métodos usando operaciones sobre arreglos (ie., no haga cosas como construir listas para evitar la manipulación de arreglos).
 */
public class SandboxArreglos
{
    /**
     * Un arreglo de enteros para realizar varias de las siguientes operaciones.
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private int[] arregloEnteros;

    /**
     * Un arreglo de cadenas para realizar varias de las siguientes operaciones
     * 
     * Ninguna posición del arreglo puede estar vacía en ningún momento.
     */
    private String[] arregloCadenas;

    /**
     * Crea una nueva instancia de la clase con los dos arreglos inicializados pero vacíos (tamaño 0)
     */
    public SandboxArreglos( )
    {
        arregloEnteros = new int[]{};
        arregloCadenas = new String[]{};
    }

    /**
     * Retorna una copia del arreglo de enteros, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de enteros
     */
    public int[] getCopiaEnteros( )
    {
    	if (arregloEnteros == null) return new int[0];
        int[] copia = new int[arregloEnteros.length];
        for (int i = 0; i < arregloEnteros.length; i++) copia[i] = arregloEnteros[i];
        return copia;
    }

    /**
     * Retorna una copia del arreglo de cadenas, es decir un nuevo arreglo del mismo tamaño que contiene copias de los valores del arreglo original
     * @return Una copia del arreglo de cadenas
     */
    public String[] getCopiaCadenas( )
    {
    	if (arregloCadenas == null) return new String[0];
        String[] copia = new String[arregloCadenas.length];
        for (int i = 0; i < arregloCadenas.length; i++) copia[i] = arregloCadenas[i];
        return copia;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de enteros
     * @return
     */
    public int getCantidadEnteros( )
    {
        return arregloEnteros.length;
    }

    /**
     * Retorna la cantidad de valores en el arreglo de cadenas
     * @return
     */
    public int getCantidadCadenas( )
    {
        return arregloCadenas.length;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param entero El valor que se va a agregar.
     */
    public void agregarEntero( int entero )
    {
        int[] nuevo = new int[arregloEnteros.length + 1];
        for (int i = 0; i < arregloEnteros.length; i++) nuevo[i] = arregloEnteros[i];
        nuevo[nuevo.length - 1] = entero;
        arregloEnteros = nuevo;
    }

    /**
     * Agrega un nuevo valor al final del arreglo. Es decir que este método siempre debería aumentar en 1 la capacidad del arreglo.
     * 
     * @param cadena La cadena que se va a agregar.
     */
    public void agregarCadena( String cadena )
    {
    	String[] nuevo = new String[arregloCadenas.length + 1];
        for (int i = 0; i < arregloCadenas.length; i++) nuevo[i] = arregloCadenas[i];
        nuevo[nuevo.length - 1] = cadena;
        arregloCadenas = nuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de enteros
     * @param valor El valor que se va eliminar
     */
    public void eliminarEntero( int valor )
    {
    	if (arregloEnteros == null || arregloEnteros.length == 0) return;
        int count = 0;
        for (int v : arregloEnteros) if (v == valor) count++;
        if (count == 0) return;
        int[] nuevo = new int[arregloEnteros.length - count];
        int k = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (arregloEnteros[i] != valor) nuevo[k++] = arregloEnteros[i];
        }
        arregloEnteros = nuevo;
    }

    /**
     * Elimina todas las apariciones de un determinado valor dentro del arreglo de cadenas
     * @param cadena La cadena que se va eliminar
     */
    public void eliminarCadena( String cadena )
    {
    	if (arregloCadenas == null || arregloCadenas.length == 0) return;
        int count = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            String s = arregloCadenas[i];
            boolean eq = (cadena == null && s == null) || (cadena != null && cadena.equals(s));
            if (eq) count++;
        }
        if (count == 0) return;
        String[] nuevo = new String[arregloCadenas.length - count];
        int k = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            String s = arregloCadenas[i];
            boolean eq = (cadena == null && s == null) || (cadena != null && cadena.equals(s));
            if (!eq) nuevo[k++] = s;
        }
        arregloCadenas = nuevo;
    }

    /**
     * Inserta un nuevo entero en el arreglo de enteros.
     * 
     * @param entero El nuevo valor que debe agregarse
     * @param posicion La posición donde debe quedar el nuevo valor en el arreglo aumentado. Si la posición es menor a 0, se inserta el valor en la primera posición. Si la
     *        posición es mayor que el tamaño del arreglo, se inserta el valor en la última posición.
     */
    public void insertarEntero( int entero, int posicion )
    {
    	if (arregloEnteros == null) {
            arregloEnteros = new int[]{ entero };
            return;
        }
        if (posicion < 0) posicion = 0;
        if (posicion > arregloEnteros.length) posicion = arregloEnteros.length;
        int[] nuevo = new int[arregloEnteros.length + 1];
        int k = 0;
        for (int i = 0; i < nuevo.length; i++) {
            if (i == posicion) {
                nuevo[i] = entero;
            } else {
                nuevo[i] = arregloEnteros[k++];
            }
        }
        arregloEnteros = nuevo;
    }

    /**
     * Elimina un valor del arreglo de enteros dada su posición.
     * @param posicion La posición donde está el elemento que debe ser eliminado. Si el parámetro posicion no corresponde a ninguna posición del arreglo de enteros, el método
     *        no debe hacer nada.
     */
    public void eliminarEnteroPorPosicion( int posicion )
    {
    	if (arregloEnteros == null || arregloEnteros.length == 0) return;
        if (posicion < 0 || posicion >= arregloEnteros.length) return;
        int[] nuevo = new int[arregloEnteros.length - 1];
        int k = 0;
        for (int i = 0; i < arregloEnteros.length; i++) {
            if (i != posicion) nuevo[k++] = arregloEnteros[i];
        }
        arregloEnteros = nuevo;
    }

    /**
     * Reinicia el arreglo de enteros con los valores contenidos en el arreglo del parámetro 'valores' truncados.
     * 
     * Es decir que si el valor fuera 3.67, en el nuevo arreglo de enteros debería quedar el entero 3.
     * @param valores Un arreglo de valores decimales.
     */
    public void reiniciarArregloEnteros( double[] valores )
    {
    	if (valores == null) { arregloEnteros = new int[0]; return; }
        arregloEnteros = new int[valores.length];
        for (int i = 0; i < valores.length; i++) arregloEnteros[i] = (int) (valores[i]);
    }

    /**
     * Reinicia el arreglo de cadenas con las representaciones como Strings de los objetos contenidos en el arreglo del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Un arreglo de objetos
     */
    public void reiniciarArregloCadenas( Object[] objetos )
    {
    	if (objetos == null) { arregloCadenas = new String[0]; return; }
        arregloCadenas = new String[objetos.length];
        for (int i = 0; i < objetos.length; i++) arregloCadenas[i] = String.valueOf(objetos[i]);
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores sean positivos.
     * 
     * Es decir que si en una posición había un valor negativo, después de ejecutar el método debe quedar el mismo valor muliplicado por -1.
     */
    public void volverPositivos( )
    {
    	if (arregloEnteros == null) return;
        for (int i = 0; i < arregloEnteros.length; i++) if (arregloEnteros[i] < 0) arregloEnteros[i] = -arregloEnteros[i];
    }

    /**
     * Modifica el arreglo de enteros para que todos los valores queden organizados de menor a mayor.
     */
    public void organizarEnteros( )
    {
    	if (arregloEnteros == null || arregloEnteros.length < 2) return;
        // insertion sort ascending
        for (int i = 1; i < arregloEnteros.length; i++) {
            int key = arregloEnteros[i];
            int j = i - 1;
            while (j >= 0 && arregloEnteros[j] > key) {
                arregloEnteros[j + 1] = arregloEnteros[j];
                j--;
            }
            arregloEnteros[j + 1] = key;
        }
    }

    /**
     * Modifica el arreglo de cadenas para que todos los valores queden organizados lexicográficamente.
     */
    public void organizarCadenas( )
    {
    	if (arregloCadenas == null || arregloCadenas.length < 2) return;
        // insertion sort for strings ascending
        for (int i = 1; i < arregloCadenas.length; i++) {
            String key = arregloCadenas[i];
            int j = i - 1;
            while (j >= 0 && arregloCadenas[j].compareTo(key) > 0) {
                arregloCadenas[j + 1] = arregloCadenas[j];
                j--;
            }
            arregloCadenas[j + 1] = key;
        }
    }

    /**
     * Cuenta cuántas veces aparece el valor recibido por parámetro en el arreglo de enteros
     * @param valor El valor buscado
     * @return La cantidad de veces que aparece el valor
     */
    public int contarApariciones( int valor )
    {
    	if (arregloEnteros == null) return 0;
        int c = 0;
        for (int v : arregloEnteros) if (v == valor) c++;
        return c;
    }

    /**
     * Cuenta cuántas veces aparece la cadena recibida por parámetro en el arreglo de cadenas.
     * 
     * La búsqueda no debe diferenciar entre mayúsculas y minúsculas.
     * @param cadena La cadena buscada
     * @return La cantidad de veces que aparece la cadena
     */
    public int contarApariciones( String cadena )
    {
    	if (arregloCadenas == null) return 0;
        int c = 0;
        for (int i = 0; i < arregloCadenas.length; i++) {
            String s = arregloCadenas[i];
            boolean eq;
            if (cadena == null) eq = (s == null);
            else eq = (s != null && cadena.equalsIgnoreCase(s));
            if (eq) c++;
        }
        return c;
    }

    /**
     * Busca en qué posiciones del arreglo de enteros se encuentra el valor que se recibe en el parámetro
     * @param valor El valor que se debe buscar
     * @return Un arreglo con los números de las posiciones del arreglo de enteros en las que se encuentra el valor buscado. Si el valor no se encuentra, el arreglo retornado
     *         es de tamaño 0.
     */
    public int[] buscarEntero( int valor )
    {
    	if (arregloEnteros == null || arregloEnteros.length == 0) return new int[0];
        int count = 0;
        for (int v : arregloEnteros) if (v == valor) count++;
        if (count == 0) return new int[0];
        int[] idxs = new int[count];
        int k = 0;
        for (int i = 0; i < arregloEnteros.length; i++) if (arregloEnteros[i] == valor) idxs[k++] = i;
        return idxs;
    }

    /**
     * Calcula cuál es el rango de los enteros (el valor mínimo y el máximo).
     * @return Un arreglo con dos posiciones: en la primera posición, debe estar el valor mínimo en el arreglo de enteros; en la segunda posición, debe estar el valor máximo
     *         en el arreglo de enteros. Si el arreglo está vacío, debe retornar un arreglo vacío.
     */
    public int[] calcularRangoEnteros( )
    {
    	if (arregloEnteros == null || arregloEnteros.length == 0) return new int[0];
        int min = arregloEnteros[0], max = arregloEnteros[0];
        for (int i = 1; i < arregloEnteros.length; i++) {
            int v = arregloEnteros[i];
            if (v < min) min = v;
            if (v > max) max = v;
        }
        return new int[]{ min, max };
    }

    /**
     * Calcula un histograma de los valores del arreglo de enteros y lo devuelve como un mapa donde las llaves son los valores del arreglo y los valores son la cantidad de
     * veces que aparece cada uno en el arreglo de enteros.
     * @return Un mapa con el histograma de valores.
     */
    public HashMap<Integer, Integer> calcularHistograma( )
    {
    	HashMap<Integer, Integer> hist = new HashMap<Integer, Integer>();
        if (arregloEnteros == null) return hist;
        for (int v : arregloEnteros) {
            Integer c = hist.get(v);
            if (c == null) hist.put(v, 1);
            else hist.put(v, c + 1);
        }
        return hist;
    }

    /**
     * Cuenta cuántos valores dentro del arreglo de enteros están repetidos.
     * @return La cantidad de enteos diferentes que aparecen más de una vez
     */
    public int contarEnterosRepetidos( )
    {
    	if (arregloEnteros == null || arregloEnteros.length == 0) return 0;
        java.util.HashMap<Integer, Integer> freq = new java.util.HashMap<Integer, Integer>();
        for (int v : arregloEnteros) {
            Integer c = freq.get(v);
            if (c == null) freq.put(v, 1);
            else freq.put(v, c + 1);
        }
        int count = 0;
        for (java.util.Map.Entry<Integer, Integer> e : freq.entrySet()) if (e.getValue() > 1) count++;
        return count;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica si son iguales, es decir que contienen los mismos elementos exactamente en el mismo orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los arreglos son idénticos y false de lo contrario
     */
    public boolean compararArregloEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros == null || otroArreglo == null) return false;
        if (arregloEnteros.length != otroArreglo.length) return false;
        for (int i = 0; i < arregloEnteros.length; i++) if (arregloEnteros[i] != otroArreglo[i]) return false;
        return true;
    }

    /**
     * Compara el arreglo de enteros con otro arreglo de enteros y verifica que tengan los mismos elementos, aunque podría ser en otro orden.
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si los elementos en los dos arreglos son los mismos
     */
    public boolean mismosEnteros( int[] otroArreglo )
    {
    	if (arregloEnteros == null || otroArreglo == null) return arregloEnteros == null && otroArreglo == null;
        if (arregloEnteros.length != otroArreglo.length) return false;
        java.util.HashMap<Integer, Integer> a = new java.util.HashMap<Integer, Integer>();
        for (int v : arregloEnteros) a.put(v, a.getOrDefault(v, 0) + 1);
        java.util.HashMap<Integer, Integer> b = new java.util.HashMap<Integer, Integer>();
        for (int v : otroArreglo) b.put(v, b.getOrDefault(v, 0) + 1);
        if (a.size() != b.size()) return false;
        for (java.util.Map.Entry<Integer, Integer> e : a.entrySet()) {
            Integer c = b.get(e.getKey());
            if (c == null || !c.equals(e.getValue())) return false;
        }
        return true;
    }

    /**
     * Cambia los elementos del arreglo de enteros por una nueva serie de valores generada de forma aleatoria.
     * 
     * Para generar los valores se debe partir de una distribución uniforme usando Math.random().
     * 
     * Los números en el arreglo deben quedar entre el valor mínimo y el máximo.
     * @param cantidad La cantidad de elementos que debe haber en el arreglo
     * @param minimo El valor mínimo para los números generados
     * @param maximo El valor máximo para los números generados
     */
    public void generarEnteros( int cantidad, int minimo, int maximo )
    {
    	if (cantidad < 0) cantidad = 0;
        if (minimo > maximo) { int t = minimo; minimo = maximo; maximo = t; }
        arregloEnteros = new int[cantidad];
        int rango = maximo - minimo + 1;
        if (rango <= 0) rango = 1;
        for (int i = 0; i < cantidad; i++) {
            int valor = (int)(Math.random() * rango) + minimo;
            arregloEnteros[i] = valor;
        }
    }

}
