import java.util.Iterator;

public class ListMain {

    public static void main(String[] args)
    {
        DirectedGraph<String, String> ListGraph = new ListGraph<>();

        System.out.println("________________________________LIST GRAPH ________________________________");
        System.out.println("List is empty: " + ListGraph.isEmpty());

        ListGraph.add("a");
        ListGraph.add("b");
        ListGraph.add("c");
        ListGraph.add("d");
        ListGraph.add("e");
        ListGraph.add("f");
        ListGraph.add("g");

        System.out.println("List is empty: " + ListGraph.isEmpty());

        System.out.println("Clearing the list graph------------------------------------");
        ListGraph.clear();

        System.out.println("List is empty: " + ListGraph.isEmpty());

        System.out.println(ListGraph.size());

        try
        {
            ListGraph.removeEdge("b","c");
        } catch (Exception e)
        {
            System.out.println(" -- No such Edge --");
        };

        System.out.println(ListGraph.size());

        System.out.println("Contains E: " + ListGraph.contains("e"));
        System.out.println("Contains G: " + ListGraph.contains("g"));

        //  System.out.println("Contains E: " + matrixGraph.get("e"));
        //  System.out.println("Contains G: " + matrixGraph.get("g"));

        Iterator<String> it = ListGraph.vertices();

        System.out.println("vertices: ");

        while (it.hasNext())
        {
            System.out.println("\t" + it.next());
        }

        ListGraph.add("a");
        ListGraph.add("b");
        ListGraph.add("c");
        ListGraph.add("d");

        ListGraph.addEdge("a", "b", "AtoB");
        ListGraph.addEdge("a", "c", "AtoC");
        ListGraph.addEdge("a", "d", "AtoD");
        System.out.println("The number of degree: " + ListGraph.degree("a"));

        System.out.println("Contains Edge A-B " + ListGraph.containsEdge("a","b"));

        System.out.println("The number of edges before removing a and b: " + ListGraph.edgeCount());

        ListGraph.removeEdge("a", "b");

        System.out.println("The number of edges before removing a and b: " + ListGraph.edgeCount());

        System.out.println("Contains Edge A-B " + ListGraph.containsEdge("a","b"));

        System.out.println("The number of degree: " + ListGraph.degree("a"));

        ListGraph.add("f");
        ListGraph.add("e");

        ListGraph.addEdge("b", "d", "BtoD");
        ListGraph.addEdge("b", "c", "BtoC");
        ListGraph.addEdge("b", "a", "BtoA");
        ListGraph.addEdge("e", "b", "EtoB");
        ListGraph.addEdge("f", "b", "FtoB");

        System.out.println("CHECK IF EMPTY" +ListGraph.isEmpty());

        try
        {
            ListGraph.addEdge("b", "d", "BtoD");
        } catch (Exception e)
        {
            System.out.println("THERE IS ALREADY AN EDGE LIKE THIS");
        }

        try
        {
            ListGraph.add("a");
        }
        catch (Exception e)
        {
            System.out.println("THERE IS ALREADY A VERTEX LIKE THIS");
        }

        //   matrixGraph.remove("b");

        Iterator<Edge<String,String>> it2 = ListGraph.edges();

        System.out.println("edges: ");

        while (it2.hasNext())
        {
            Edge<String,String> edge = it2.next();

            System.out.println("\t" + edge.getU() + " - " + edge.getV() + ": " + edge.getLabel());
        }

        System.out.println("Adjacent Iterator---------------------------");

        Iterator<String> it4 = ListGraph.adjacent("b");

        System.out.println("adjacent: ");

        while (it4.hasNext())
        {
            // it4.next();
            System.out.println("\t" + it4.next());
        }

        System.out.println("Is H exist? " + ListGraph.get("h"));
        try
        {
            System.out.println("Is Vertex P-L exist? " + ListGraph.containsEdge("p","l"));
        }
        catch(Exception e)
        {
            System.out.println("Can't have p-l edge without vertices p and l");
        }

    }
}
