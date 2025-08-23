package uniandes.dpoo.estructuras.logica;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Esta clase tiene un conjunto de métodos para practicar operaciones sobre mapas.
 *
 * Todos los métodos deben operar sobre el atributo mapaCadenas que se declara como un Map.
 * 
 * En este mapa, las llaves serán cadenas y los valores serán también cadenas. La relación entre los dos será que cada llave será igual a la cadena del valor, pero invertida.
 * 
 * El objetivo de usar el tipo Map es que sólo puedan usarse métodos de esa interfaz y no métodos adicionales provistos por la implementación concreta (HashMap).
 * 
 * No pueden agregarse nuevos atributos.
 */
public class SandboxMapas
{
    /**
     * Un mapa de cadenas para realizar varias de las siguientes operaciones.
     * 
     * Las llaves del mapa son cadenas, así como los valores.
     * 
     * Las llaves corresponden a invertir la cadena que aparece asociada a cada llave.
     */
    private Map<String, String> mapaCadenas;

    /**
     * Crea una nueva instancia de la clase con las dos listas inicializadas pero vacías
     */
    public SandboxMapas( )
    {
        mapaCadenas = new HashMap<String, String>( );
    }

    /**
     * Retorna una lista con las cadenas del mapa (los valores) ordenadas lexicográficamente
     * @return Una lista ordenada con las cadenas que conforman los valores del mapa
     */
    public List<String> getValoresComoLista( )
    {
    	java.util.TreeSet<String> vals = new java.util.TreeSet<String>( );
        if( mapaCadenas != null )
        vals.addAll( mapaCadenas.values( ) );
        return new java.util.ArrayList<String>( vals );
    }

    /**
     * Retorna una lista con las llaves del mapa ordenadas lexicográficamente de mayor a menor
     * @return Una lista ordenada con las cadenas que conforman las llaves del mapa
     */
    public List<String> getLlavesComoListaInvertida( )
    {
    	java.util.ArrayList<String> llaves = new java.util.ArrayList<String>( );
        if( mapaCadenas != null )
        llaves.addAll( mapaCadenas.keySet( ) );
        java.util.Collections.sort( llaves, java.util.Collections.reverseOrder( ) );
        return llaves;
    }

    /**
     * Retorna la cadena que sea lexicográficamente menor dentro de las llaves del mapa .
     * 
     * Si el mapa está vacío, debe retornar null.
     * @return
     */
    public String getPrimera( )
    {
    	if( mapaCadenas == null || mapaCadenas.isEmpty( ) ) return null;
        java.util.TreeSet<String> vals = new java.util.TreeSet<String>( mapaCadenas.values( ) );
        return vals.isEmpty( ) ? null : vals.first( );
    }

    /**
     * Retorna la cadena que sea lexicográficamente mayor dentro de los valores del mapa
     * 
     * Si el conjunto está vacío, debe retornar null.
     * @return
     */
    public String getUltima( )
    {
    	if( mapaCadenas == null || mapaCadenas.isEmpty( ) ) return null;
        java.util.TreeSet<String> vals = new java.util.TreeSet<String>( mapaCadenas.values( ) );
        return vals.isEmpty( ) ? null : vals.last( );
    }

    /**
     * Retorna una colección con las llaves del mapa, convertidas a mayúsculas.
     * 
     * El orden de las llaves retornadas no importa.
     * @return Una lista de cadenas donde todas las cadenas están en mayúsculas
     */
    public Collection<String> getLlaves( )
    {
    	java.util.ArrayList<String> copia = new java.util.ArrayList<String>( );
        if( mapaCadenas != null )
        {
            for( String k : mapaCadenas.keySet( ) )
                copia.add( k == null ? null : k.toUpperCase( ) );
        }
        return copia;
    }

    /**
     * Retorna la cantidad de *valores* diferentes en el mapa
     * @return
     */
    public int getCantidadCadenasDiferentes( )
    {
    	if( mapaCadenas == null || mapaCadenas.isEmpty( ) ) return 0;
        java.util.HashSet<String> vals = new java.util.HashSet<String>( mapaCadenas.values( ) );
        return vals.size( );
    }

    /**
     * Agrega un nuevo valor al mapa de cadenas: el valor será el recibido por parámetro, y la llave será la cadena invertida
     * 
     * Este método podría o no aumentar el tamaño del mapa, dependiendo de si ya existía la cadena en el mapa
     * 
     * @param cadena La cadena que se va a agregar al mapa
     */
    public void agregarCadena( String cadena )
    {
    	if( cadena == null ) return;
        String llave = new StringBuilder( cadena ).reverse( ).toString( );
        mapaCadenas.put( llave, cadena );
    }

    /**
     * Elimina una cadena del mapa, dada la llave
     * @param cadena La llave para identificar el valor que se debe eliminar
     */
    public void eliminarCadenaConLLave( String llave )
    {
    	if( mapaCadenas == null ) return;
        mapaCadenas.remove( llave );
    }

    /**
     * Elimina una cadena del mapa, dado el valor
     * @param cadena El valor que se debe eliminar
     */
    public void eliminarCadenaConValor( String valor )
    {
    	if( mapaCadenas == null || mapaCadenas.isEmpty( ) ) return;
        java.util.ArrayList<String> porEliminar = new java.util.ArrayList<String>( );
        for( java.util.Map.Entry<String,String> e : mapaCadenas.entrySet( ) )
        {
            boolean eq = ( valor == null && e.getValue( ) == null ) || ( valor != null && valor.equals( e.getValue( ) ) );
            if( eq ) porEliminar.add( e.getKey( ) );
        }
        for( String k : porEliminar ) mapaCadenas.remove( k );
    }

    /**
     * Reinicia el mapa de cadenas con las representaciones como Strings de los objetos contenidos en la lista del parámetro 'objetos'.
     * 
     * Use el método toString para convertir los objetos a cadenas.
     * @param valores Una lista de objetos
     */
    public void reiniciarMapaCadenas( List<Object> objetos )
    {
    	mapaCadenas.clear( );
        if( objetos == null ) return;
        for( Object o : objetos )
        {
            String valor = String.valueOf( o );
            String llave = new StringBuilder( valor ).reverse( ).toString( );
            mapaCadenas.put( llave, valor );
        }
    }

    /**
     * Modifica el mapa de cadenas reemplazando las llaves para que ahora todas estén en mayúsculas pero sigan conservando las mismas cadenas asociadas.
     */
    public void volverMayusculas( )
    {
    	java.util.HashMap<String,String> nuevo = new java.util.HashMap<String,String>( );
        for( java.util.Map.Entry<String,String> e : mapaCadenas.entrySet( ) )
        {
            String k = e.getKey( );
            nuevo.put( k == null ? null : k.toUpperCase( ), e.getValue( ) );
        }
        mapaCadenas = nuevo;
    }

    /**
     * Verifica si todos los elementos en el arreglo de cadenas del parámetro hacen parte del mapa de cadenas (de los valores)
     * @param otroArreglo El arreglo de enteros con el que se debe comparar
     * @return True si todos los elementos del arreglo están dentro de los valores del mapa
     */
    public boolean compararValores( String[] otroArreglo )
    {
    	if( otroArreglo == null || otroArreglo.length == 0 ) return true;
        if( mapaCadenas == null || mapaCadenas.isEmpty( ) ) return false;
        java.util.HashSet<String> vals = new java.util.HashSet<String>( mapaCadenas.values( ) );
        for( String s : otroArreglo )
            if( !vals.contains( s ) ) return false;
        return true;   
    	}

}
