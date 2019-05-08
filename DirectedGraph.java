/*
*
* srhodes17@georgefox.edu
*
* Program 12
*
* 2018-12-14
*
* */

import javax.xml.bind.Element;
import java.util.*;

/**
 *  Abstract class of directed graph
 *
 * @param <V> - vertex of type V
 * @param <E> - edge of type E
 */

public abstract class DirectedGraph<V,E>
{
     protected static final int DEFAULT_SIZE = 5;

     protected Vertex<V> vertices[];

     protected int size;

     protected Edge<V,E> edges[][];

    /**
     * Vertex Protected Class
     *
     * @param <V> - vertex of type V
     */
     protected class Vertex<V>
     {
         private V label;

         /**
          * Vertex Constructor
          *
          * @param label - name of vertex
          */
         public Vertex(V label)
         {
             this.label = label;
         }

         /**
          * Vertex getter
          *
          * @return - name of vertex
          */
         V getLabel()
         {
             return label;
         }

         /**
          * comparing to another vertex
          *
          * @param o - another vertex
          * @return - validation of this vertex being equal to another vertex
          */

         public boolean equals(Vertex<E> o)
         {
             return getLabel().equals(o);
         }
     }

    /**
     * adding another vertex of type V
     *
     * @param v - vertex of type V
     */
    public abstract void add(V v);

    /**
     * removing another vertex of type V
     *
     * @param v - vertex of type V
     * @return
     */

    public abstract V remove(V v);

    /**
     * adding edge with a specific label
     * @param u - first vertex attached to edge
     * @param v - second vertex attached to edge
     * @param label - name of the edge
     */

    public abstract void addEdge(V u, V v, E label);

    /**
     * validation of edge existance
     * @param u - first vertex
     * @param v - second vertex
     * @return
     */
    public abstract boolean containsEdge(V u, V v);

    /**
     * getting edge
     *
     * @param u - first vertex belonging to an edge
     * @param v - second vertex belonging to an edge
     * @return
     */

    public abstract Edge<V,E> getEdge(V u, V v);

    /**
     * removing edge
     *
     * @param u - first vertex
     * @param v - second vertex
     * @return
     */
    public abstract E removeEdge(V u, V v);

    /**
     * how many edges connected to vertex
     *
     * @param v - the vertex v
     * @return -
     */

    public abstract int degree(V v);

    /**
     * number of edges
     *
     * @return
     *
     */

    public abstract int edgeCount();

    /**
     * traversing through edges
     *
     * @return
     *
     */

    public abstract Iterator<Edge<V,E>> edges();

    /**
     * resetting value back to zero
     *
     */

    public abstract void clear();

    /**
     *size of graph
     *
     * @return getting the size
     */
    public int size()
    {
         return size;
    }

    /**
     * validity of graph being empty
     *
     * @return checking if graph has no size
     */

    public boolean isEmpty()
    {
         return size == 0;
    }

    /**
     *validity of graph possessing a vertex
     *
     * @param v - vertex
     * @return - validation
     */

    public boolean contains(V v)
    {
        if (v == null)
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < size; i++)
        {
            if (vertices[i].getLabel().equals(v))
            {
                return true;
            }
        }
        return false;
    }

    /**
     *getting vertex v
     * @param v - vertex v
     * @return
     */

    public V get(V v)
    {
        if (v == null)
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < size; i++)
        {
            if (vertices[i].getLabel().equals(v))
            {
                return vertices[i].getLabel();
            }
        }

        return null;
    }

    /**
     *  the vertex memory location
     *
     * @param v - vertex v
     * @return
     */

    protected int getVertexLocation(V v)
    {
        if (v == null)
        {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < size; i++)
        {
            if(vertices[i].getLabel().equals(v))
            {
                return i;
            }
        }

        return -1;
    }

    /**
     * traversing the vertices
     *
     * @return
     */

    public Iterator<V> vertices()
    {
        List<V> list = new ArrayList<>();

        for (int i = 0; i < size ; i++)
        {
            list.add(vertices[i].getLabel());
        }

        return list.iterator();
    }

    /**
     * traversing the adjacent
     *
     * @param v vertex
     * @return
     */

    abstract public Iterator<V> adjacent(V v);
}








