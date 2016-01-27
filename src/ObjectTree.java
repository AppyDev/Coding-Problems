import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Node {

    String city;
    LinkedList<Node> list;
}

public class ObjectTree {

    static Node[] node = new Node[20];
    static LinkedList<Node> path = new LinkedList<Node>();
    static LinkedList<Node> visited = new LinkedList<Node>();
    static Queue<Node> queue = new LinkedList<Node>();
    static boolean goalReached = false;
    static Map map = new HashMap();

    public static void initialize() {
        for (int i = 0; i < 20; i++) {
            node[i] = new Node();
            node[i].list = new LinkedList();
        }
        node[0].city = "oradea";
        node[1].city = "zerind";
        node[2].city = "arad";
        node[3].city = "timisoara";
        node[4].city = "lugoj";
        node[5].city = "mehadia";
        node[6].city = "dobreta";
        node[7].city = "sibiu";
        node[8].city = "rimnicu_vilcea";
        node[9].city = "craiova";
        node[10].city = "fagaras";
        node[11].city = "pitesti";
        node[12].city = "bucharest";
        node[13].city = "giurgiu";
        node[14].city = "urziceni";
        node[15].city = "vaslui";
        node[16].city = "iasi";
        node[17].city = "neamt";
        node[18].city = "hirsova";
        node[19].city = "eforie";


        node[0].list.add(node[7]);
        node[0].list.add(node[1]);
        node[1].list.add(node[2]);
        node[1].list.add(node[0]);
        node[2].list.add(node[7]);
        node[2].list.add(node[3]);
        node[2].list.add(node[1]);
        node[3].list.add(node[2]);
        node[3].list.add(node[4]);
        node[4].list.add(node[5]);
        node[4].list.add(node[3]);
        node[5].list.add(node[6]);
        node[5].list.add(node[4]);
        node[6].list.add(node[9]);
        node[6].list.add(node[5]);
        node[7].list.add(node[2]);
        node[7].list.add(node[10]);
        node[7].list.add(node[0]);
        node[7].list.add(node[8]);
        node[8].list.add(node[9]);
        node[8].list.add(node[11]);
        node[8].list.add(node[7]);
        node[9].list.add(node[6]);
        node[9].list.add(node[11]);
        node[9].list.add(node[8]);
        node[10].list.add(node[12]);
        node[10].list.add(node[7]);
        node[11].list.add(node[12]);
        node[11].list.add(node[9]);
        node[11].list.add(node[8]);
        node[12].list.add(node[10]);
        node[12].list.add(node[13]);
        node[12].list.add(node[11]);
        node[12].list.add(node[14]);
        node[13].list.add(node[12]);
        node[14].list.add(node[12]);
        node[14].list.add(node[18]);
        node[14].list.add(node[15]);
        node[15].list.add(node[16]);
        node[15].list.add(node[14]);
        node[16].list.add(node[17]);
        node[16].list.add(node[15]);
        node[17].list.add(node[16]);
        node[18].list.add(node[19]);
        node[18].list.add(node[14]);
        node[19].list.add(node[18]);

    }

    static void dfs(Node current, Node goal) {

        if (goalReached == false) {
            path.add(current);
            visited.add(current);
            if (current.city.equals(goal.city)) {
                goalReached = true;
                for (Node p : path) {
                    System.out.println(p.city);
                }
            } else {
                for (Node next : current.list) {
                    if (!visited.contains(next)) {
                        dfs(next, goal);
                    }
                }
                path.removeLast();
            }
        }
    }

    static void bfs(Node current, Node goal) {
        if (!visited.contains(current)) {
            visited.add(current);
        }
        if (goalReached == false) {
            for (Node child : current.list) {
                if (!visited.contains(child)) {
                    visited.add(child);
                    queue.add(child);
                    map.put(child, current);
                    if (child.city.equals(goal.city)) {
                        goalReached = true;
                        path.add(child);
                        path.add(current);
                        while (path.getLast() != visited.get(0)) {
                            current = (Node) map.get(current);
                            path.add(current);
                        }
                        while (!path.isEmpty()) {
                            System.out.println(path.removeLast().city);
                        }
                        return;
                    }
                }
            }
            bfs(queue.remove(), goal);
        }
    }

    public static void main(String[] args) {
        initialize();
        Node start=node[0];
        Node goal=node[1];


        for (int i = 0; i < 20; i++) {
            if (node[i].city.equals(args[1])) {
                start = node[i];
            }
            if (node[i].city.equals(args[2])) {
                goal =node[i];
            }
        }
        if (args[0].equals("DFS")) {
            dfs(start, goal);
        } else if (args[0].equals("BFS")) {
            bfs(start, goal);
        }

        System.out.println("Total number of nodes expanded: " + visited.size());

    }
}