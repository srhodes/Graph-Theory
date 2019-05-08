/*
 *
 * srhodes17@georgefox.edu
 *
 * Program 12
 *
 * 2018-12-14
 *
 * */

/**
 * class of edge
 *
 * @param <V> - vertex of type V
 * @param <E> - edge of type E
 */

public class Edge<V,E>
{

    private V u;

    private V v;

    private E label;

    /**
     * Edge constructor
     *
     * @param u - first vertex u
     * @param v - second vertex v
     * @param label - name of
     */
    public Edge(V u, V v, E label)
    {
        this.u = u;
        this.v = v;
        this.label = label;
    }

    /**
     * getting the vertex u value
     *
     * @return vertex u
     */
    public V getU(){
        return u;
    }

    /**
     * getting the vertex v value
     *
     * @return vertex v
     */

    public V getV(){
        return v;
    }

    /**
     * getting the label name
     *
     * @return name of vertex
     */
    public E getLabel(){
        return label;
    }

    /**
     * setting the label name
     *
     * @param label name of vertex
     */
    public void setLabel(E label){
        this.label = label;
    }

    /**
     * compare to another
     * @param o Edge
     * @return
     */

    public boolean equals(Edge<V,E> o){
        return u.equals(o.getU()) && v.equals(o.getV());
    }
}
