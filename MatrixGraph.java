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
 * List of component constituting a Matrix Graph
 *
 * @param <V>
 * @param <E>
 */
public class MatrixGraph<V,E> extends DirectedGraph<V,E>
{

    /**
     * MatrixGraph constructor
     */


    public MatrixGraph()
    {
        edges = new Edge[DEFAULT_SIZE][DEFAULT_SIZE];
        vertices = new Vertex[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * change the size of the list graph
     *
     */

    private void resize()
    {
        Edge newEdge[][] = new Edge[edges.length + DEFAULT_SIZE][edges[0].length + DEFAULT_SIZE];

        for(int i = 0; i < edges.length; i++)
        {
            for( int j = 0; j < edges[0].length; j++)
            {
                newEdge[i][j] = edges[i][j];
            }
        }
        edges = newEdge;

        Vertex newVertex[] = new Vertex[vertices.length + DEFAULT_SIZE];

        for(int i = 0; i < vertices.length; i++)
        {
                newVertex[i] = vertices[i];
        }
            vertices = newVertex;
    }

    /**
     * adding the vertex v
     *
     * @param v - vertex of type V
     */

    public void add(V v)
    {

        if(v == null)
        {
            throw new IllegalArgumentException();
        }

        for(int i = 0; i < size; i++)
        {
            if(vertices[i].getLabel().equals(v))
            {
                throw new DuplicateVertexException();
            }
        }

        Vertex<V> newVertex = new Vertex(v);

        if(size == vertices.length)
        {
            resize();
        }

        vertices[size] = newVertex;
        size++;
    }

    /**
     *  the vertex memory location
     *
     * @param v - vertex v
     * @return
     */

    protected int getVertexLocation(V v)
    {
        for(int i = 0; i < size; i++)
        {
            if(vertices[i].getLabel().equals(v))
            {
                return i;
            }
        }

        throw new NoSuchElementException();
    }


    /**
     * removing vertex
     *
     * @param v - vertex of type V
     * @return - vertex
     */

    public V remove(V v)
    {

        int location= getVertexLocation(v);

        if(location == -1)
        {
            throw new IllegalArgumentException();
        }

        //remove from vertices array
        for(int i = location; i < size-1; i++)
        {
            vertices[i] = vertices[i+1];
        }
        vertices[size-1] = null;

        //remove from edges array
        for(int i = location; i < size-1; i++)
        {
            edges[i] = edges[i+1];
        }
        edges[size-1] = null;

        size--;

        for(int i = 0; i < size; i++)
        {
            for(int j = location; j < size; j++)
            {
                edges[i][j] = edges[i][j+1];
            }
            edges[i][size] = null;
        }
        return  v;
    }

    /**
     * addition of edge
     *
     * @param u - first vertex attached to edge
     * @param v - second vertex attached to edge
     * @param label - name of the edge
     */

    public void addEdge(V u, V v, E label)
    {

        if(v == null || u == null)
        {
            throw new IllegalArgumentException();
        }

        int uLoca = getVertexLocation(u);
        int vLoca = getVertexLocation(v);

        if(vLoca == -1 || uLoca == -1)
        {
            throw new IllegalArgumentException();
        }

        if(edges[uLoca][vLoca] != null)
        {
            throw new DuplicateVertexException();
        }

        Edge<V,E> e = new Edge(u, v, label);
        // vtx1.label , vtx2.label
        edges[uLoca][vLoca] = e;
    }

    /**
     * validation of edge
     *
     * @param u - first vertex
     * @param v - second vertex
     * @return
     */

    public boolean containsEdge(V u, V v)
    {

        if(v == null || u == null)
        {
            throw new IllegalArgumentException();
        }

        int uLoca = getVertexLocation(u);
        int vLoca = getVertexLocation(v);

        if(vLoca == -1 || uLoca == -1)
        {
            throw new IllegalArgumentException();
        }

         return edges[uLoca][vLoca] != null;
    }

    /**
     *  getting edge
     *
     * @param u - first vertex belonging to an edge
     * @param v - second vertex belonging to an edge
     * @return
     */

    public Edge<V,E> getEdge(V u, V v)
    {
        if(v == null || u == null)
        {
            throw new IllegalArgumentException();
        }

        int uLoca = getVertexLocation(u);
        int vLoca = getVertexLocation(v);

        if(vLoca == -1 || uLoca == -1)
        {
            throw new IllegalArgumentException();
        }

        return edges[uLoca][vLoca];
    }

    /**
     * removing edge
     *
     * @param u - first vertex
     * @param v - second vertex
     * @return
     */

    public E removeEdge(V u, V v)
    {

        if(v == null || u == null)
        {
            throw new IllegalArgumentException();
        }

        int uLoca = getVertexLocation(u);
        int vLoca = getVertexLocation(v);


        E e = edges[uLoca][vLoca].getLabel();

        if(edges[uLoca][vLoca] == null)
        {
            throw new NoSuchElementException();
        }
        edges[uLoca][vLoca] = null;

        return e;
    }



    /**
     * number of edges surrounding the vertex
     *
     * @param v - the vertex v
     * @return
     */

    public int degree(V v)
    {

        if(v == null)
        {
            throw new IllegalArgumentException();
        }


        int loca = getVertexLocation(v);
        if(loca == -1)
        {
            throw new IllegalArgumentException();
        }
        Edge [] edges =  this.edges[loca];

        int count = 0;

        for(int i = 0; i < edges.length; i++)
        {
            if(edges[i] != null )
            {
                count++;
            }
        }
        return  count;
    }


    /**
     * number of edge
     *
     * @return
     */

    public int edgeCount()
    {
        int count = 0;

        for(int i = 0; i < size; i++ )
        {
            for(int j = 0; j < size; j++)
            {
                if(edges[i][j] != null)
                {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * traversing edges
     *
     * @return
     */

    public Iterator<Edge<V,E>> edges()
    {
        List<Edge<V,E>> list = new ArrayList<>();

        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(edges[i][j] != null)
                {
                    list.add(edges[i][j]);
                }
            }
        }

        return list.iterator();
    }

    /**
     * resetting all the values
     *
     */

    public void clear()
    {
        size = 0;
        edges = new Edge[DEFAULT_SIZE][DEFAULT_SIZE];
        vertices = new Vertex[DEFAULT_SIZE];
        size = 0;
    }

    /**
     * traversing through the adjacent vertex
     *
     * @param v vertex
     * @return
     */
    public Iterator<V> adjacent(V v)
    {
        List<V> list = new ArrayList<>();

        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(edges[i][j] != null)
                {
                    if(edges[i][j].getU().equals(v)){
                        if(!list.contains(edges[i][j].getV()))
                        {
                            list.add(edges[i][j].getV());
                        }
                    }
                    else if(edges[i][j].getV().equals(v))
                    {
                        if(!list.contains(edges[i][j].getU()))
                        {
                            list.add(edges[i][j].getU());
                        }
                    }
                }
            }
        }
        return list.iterator();
    }
}
