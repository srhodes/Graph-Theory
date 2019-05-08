import java.util.Iterator;

public class MatrixMain {
    public static void main(String[] args)
    {
        DirectedGraph<String, String> matrixGraph = new MatrixGraph<>();

        System.out.println("________________________________MATRIX GRAPH ________________________________");

        System.out.println("List is empty: " + matrixGraph.isEmpty());

        matrixGraph.add("a");
        matrixGraph.add("b");
        matrixGraph.add("c");
        matrixGraph.add("d");
        matrixGraph.add("e");
        matrixGraph.add("f");
        matrixGraph.add("g");

        System.out.println("List is empty: " + matrixGraph.isEmpty());

        System.out.println("Clearing the matrix graph------------------------------------");

        matrixGraph.clear();

        System.out.println("List is empty: " + matrixGraph.isEmpty());

        System.out.println(matrixGraph.size());

        try
        {
            matrixGraph.removeEdge("b","c");
        }
        catch (Exception e)
        {
            System.out.println(" -- No such Edge --");
        };

        System.out.println(matrixGraph.size());

        System.out.println("Contains E: " + matrixGraph.contains("e"));
        System.out.println("Contains G: " + matrixGraph.contains("g"));

        //  System.out.println("Contains E: " + matrixGraph.get("e"));
        //  System.out.println("Contains G: " + matrixGraph.get("g"));


        Iterator<String> it = matrixGraph.vertices();

        System.out.println("vertices: ");

        while (it.hasNext())
        {
            System.out.println("\t" + it.next());
        }

        matrixGraph.add("a");
        matrixGraph.add("b");
        matrixGraph.add("c");
        matrixGraph.add("d");


        matrixGraph.addEdge("a", "b", "AtoB");
        matrixGraph.addEdge("a", "c", "AtoC");
        matrixGraph.addEdge("a", "d", "AtoD");
        System.out.println("The number of degree: " + matrixGraph.degree("a"));

        System.out.println("Contains Edge A-B " + matrixGraph.containsEdge("a","b"));

        System.out.println("The number of edges before removing a and b: " + matrixGraph.edgeCount());

        matrixGraph.removeEdge("a", "b");

        System.out.println("The number of edges before removing a and b: " + matrixGraph.edgeCount());

        System.out.println("Contains Edge A-B " + matrixGraph.containsEdge("a","b"));

        System.out.println("The number of degree: " + matrixGraph.degree("a"));


        matrixGraph.add("e");
        matrixGraph.add("f");


        matrixGraph.addEdge("b", "d", "BtoD");
        matrixGraph.addEdge("b", "c", "BtoC");
        matrixGraph.addEdge("b", "a", "BtoA");

        matrixGraph.addEdge("e", "b", "EtoB");
        matrixGraph.addEdge("f", "b", "FtoB");


        try
        {
            matrixGraph.addEdge("b", "d", "BtoD");
        }
        catch (Exception e)
        {
            System.out.println("THERE IS ALREADY AN EDGE LIKE THIS");
        }

        try
        {
            matrixGraph.add("a");
        }
        catch (Exception e)
        {
            System.out.println("THERE IS ALREADY A VERTEX LIKE THIS");
        }

        matrixGraph.add("y");
        matrixGraph.add("w");
        matrixGraph.add("q");

        matrixGraph.remove("w");
        matrixGraph.addEdge("e", "y", "EtoY");

        matrixGraph.addEdge("e","q", "EtoQ");

        System.out.println("Edge Iterator--------------------------------");

        Iterator<Edge<String,String>> it2 = matrixGraph.edges();

        System.out.println("edges: ");

        while (it2.hasNext())
        {
            Edge<String,String> edge = it2.next();

            System.out.println("\t" + edge.getU() + " - " + edge.getV() + ": " + edge.getLabel());
        }

        System.out.println("Vertex Iterator--------------------------------");

        Iterator<String> it3 = matrixGraph.vertices();

        System.out.println("vertices: ");

        while (it3.hasNext())
        {
            //it3.next();
            System.out.println("\t" + it3.next());
        }

        System.out.println("What for undeleted vertex");



        System.out.println("Adjacent Iterator---------------------------");

        Iterator<String> it4 = matrixGraph.adjacent("b");

        System.out.println("adjacent: ");

        while (it4.hasNext())
        {
            // it4.next();
            System.out.println("\t" + it4.next());
        }

    }
}
