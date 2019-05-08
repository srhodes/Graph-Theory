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
import java.lang.reflect.Array;
import java.util.*;


/**
 * List of component constituting a List Graph
 *
 * @param <V> - vertex of type V
 * @param <E> - Edge of type E
 */

public class ListGraph<V,E> extends DirectedGraph<V,E>
{
    protected Map < V , ArrayList<Edge<V,E> > > edges;

    /**
     * ListGraph constructor
     */

    public ListGraph()
    {
        clear();
    }

    /**
     * change the size of the list graph
     *
     */

    private void resize()
    {
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


        ArrayList<Edge<V,E>> vertexEdges = new ArrayList<Edge<V,E>>();
        for(int i = 0; i < size; i++)
        {
            vertexEdges.add(null);
        }
        edges.put(v, vertexEdges);

        size++;

        Set<V> keys = edges.keySet();
        for(V key : keys)
        {
            vertexEdges = edges.get(key);
            vertexEdges.add(null);
        }
    }


    /**
     * removing vertex
     *
     * @param v - vertex of type V
     * @return - vertex
     */
    public V remove(V v)
    {
        if(v == null)
        {
            throw new IllegalArgumentException();
        }

        int location = getVertexLocation(v);
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
        edges.remove(v);
        Set<V> keys = edges.keySet();

        for(V key : keys)
        {
            ArrayList<Edge<V,E>>vertexEdges = edges.get(key);
            vertexEdges.remove(location);
        }

        size --;
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

        ArrayList<Edge<V,E>> vertexEdges = edges.get(u);

        int vLoca = getVertexLocation(v);

        if(vLoca == -1 || vertexEdges == null)
        {
            throw new IllegalArgumentException();
        }

        if(vertexEdges.get(vLoca) != null)
        {
            throw new DuplicateVertexException();
        }

        Edge<V,E> edge = new Edge(u, v, label);


        // vtx1.label , vtx2.label
        vertexEdges.set(vLoca, edge);
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

        ArrayList<Edge<V,E>> vertexEdges = edges.get(u);

        int vLoca = getVertexLocation(v);

        if(vLoca == -1 || vertexEdges == null)
        {
            throw new IllegalArgumentException();
        }

        if(vertexEdges.get(vLoca) != null)
        {
            return true;
        }

        return false;
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


        ArrayList<Edge<V,E>> vertexEdges = edges.get(u);

        int vLoca = getVertexLocation(v);

        if(vLoca == -1 || vertexEdges == null)
        {

        }

        return vertexEdges.get(vLoca);
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

        ArrayList<Edge<V,E>> vertexEdges = edges.get(u);

        int vLoca = getVertexLocation(v);
        if(vLoca == -1 || vertexEdges == null)
        {
            throw new IllegalArgumentException();
        }
        Edge<V,E> edge = vertexEdges.get(vLoca);

        vertexEdges.set(vLoca, null);

        return edge.getLabel();
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

        ArrayList<Edge<V,E>> vertexEdges = edges.get(v);

        int count = 0;

        for(int i = 0; i < vertexEdges.size(); i++)
        {
            if(vertexEdges.get(i) != null )
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
        Set<V> keys = edges.keySet();

        for(V key : keys)
        {
            ArrayList<Edge<V,E>> vertexEdges = edges.get(key);
            for(Edge edge : vertexEdges)
            {
                if( edge != null)
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

        Set<V> keys = edges.keySet();

        for(V key : keys)
        {
            ArrayList<Edge<V,E>> vertexEdges = edges.get(key);
            for(Edge edge : vertexEdges)
            {
                if( edge != null)
                {
                    list.add(edge);
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
        edges = new HashMap<V,ArrayList<Edge<V,E>>>();
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

        Set<V> keys = edges.keySet();

        for(V key : keys)
        {
            ArrayList<Edge<V,E>> vertexEdges = edges.get(key);
            for(Edge<V,E> edge : vertexEdges)
            {
                if( edge != null)
                {
                    if(edge.getU().equals(v)){
                        if(!list.contains(edge.getV()))
                        {
                            list.add(edge.getV());
                        }
                    }
                    else if(edge.getV().equals(v))
                    {
                        if(!list.contains(edge.getU()))
                        {
                            list.add(edge.getU());
                        }
                    }
                }

            }
        }
        return list.iterator();
    }

}