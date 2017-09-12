import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

class HuffmanCode {
    Map<Character,StringBuilder> code = new TreeMap<Character,StringBuilder>();
    class Node {
        char name;
        int freq;
        ArrayList<Node> children = new ArrayList<Node>();
        Node parent;
        StringBuilder code = new StringBuilder("");

        Node (Map.Entry<Character,Integer> a) {
            name = a.getKey();
            freq = a.getValue();
        }

        Node (char n, int f) {
            name = n;
            freq = f;
        }

        private void addParent(Node p){
            parent = p;
        }

        void addChild(Node c) {
            children.add(c);
            c.addParent(this);
        }

        void setFreq (int f) {
            freq = f;
        }
    }

    class Tree {
        ArrayList<Node> tree = new ArrayList<Node>();

        Tree (Map<Character,Integer> frequency) {
            for (Map.Entry<Character,Integer> pair: frequency.entrySet()) {
                    tree.add(new Node(pair));
            }
        }

        Node getNode(int i) {
            return tree.get(i);
        }

        void addNode(Node n) {
            tree.add(n);
        }

        Node getRoot() {
            Node root = null;
            for (Node n: tree) {
                if (n.parent == null) {
                    root = n;
                }
            }
            return root;
        }

        Node min() {
            Node min = null;
            for (Node n: tree) {
                if (n.parent == null) {
                    min = n;
                    break;
                }
            }
            for (Node n: tree) {
                if ((n.parent == null) && (n.freq <= min.freq)) {
                    min = n;
                }
            }
            return min;
        }

        void traversal(Node parent){
            if (!parent.children.isEmpty()) {
                for (int i=0; i<parent.children.size(); i++) {
                    if (i==0) {
                        parent.children.get(i).code.append(parent.code + "0");
                    } else {
                        parent.children.get(i).code.append(parent.code + "1");
                    }
                    traversal(parent.children.get(i));
                }
            }
        }
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            for (Node n: tree) {
                sb.append(n.name + ": " + n.freq  + ": " + n.parent + ": " + n.code + ": ");
                for (Node ch: n.children) {
                    sb.append(ch.name + " ");
                }
                sb.append("\n");
            }
            sb.append("\n");
            return sb.toString();
        }
    }

    public static void main(String[] args) {
        new HuffmanCode().run();
    }

    public void run() {
        //считываем данные и считаем частоту символов

        String fileName = "Input1.txt";
        File inputFile = new File(fileName);
        String st = "";

        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
            st = in.readLine();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //Scanner sc = new Scanner(System.in);
        //String st = sc.nextLine();

        Map<Character,Integer> frequency = new HashMap<Character,Integer>();

        char cur;
        for (int i=0; i<st.length(); i++){
            cur = st.charAt(i);
            if (frequency.get(cur) == null) {
                frequency.put(cur,1);
            } else {
                frequency.replace(cur,frequency.get(cur)+1);
            }
        }
        int k = frequency.size();

        //создаем дерево
        Tree treeFreq = new Tree(frequency);
        if (k==1) {
            treeFreq.tree.get(0).code = new StringBuilder("0");
            code.put(treeFreq.getNode(0).name,new StringBuilder("0"));
        } else {
            int numWithoutParent = k;
            Node root = null;
            while (numWithoutParent>1) {
                Node newNode = new Node('!', 0);
                Node min1 = treeFreq.min();
                newNode.addChild(min1);
                Node min2 = treeFreq.min();
                newNode.addChild(min2);
                newNode.setFreq(min1.freq + min2.freq);
                treeFreq.addNode(newNode);
                numWithoutParent--;
                root = newNode;
            }

            //обходим дерево, начиная с корня
            treeFreq.traversal(root);

            for (Node n: treeFreq.tree) {
                if (n.children.isEmpty()) {
                    code.put(n.name, n.code);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i=0; i<st.length(); i++) {
            sb.append(code.get(st.charAt(i)));
        }

        File outputFile = new File("Output1.txt");
        if(!outputFile.exists()){
            try {
                outputFile.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        try {
            FileWriter out = new FileWriter(outputFile, true);
            out.write("Количество различных символов: " + k + "\n");
            out.write("Длина выходной строки: " + sb.length() + "\n");
            for (Node n: treeFreq.tree) {
                if (n.children.isEmpty()) {
                    out.write(n.name + ": " + n.code + "\n");
                }
            }
            out.write(sb.toString() + "\n");
            out.write("\n");
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /*

        System.out.println(k + " " + sb.length());
        for (Node n: treeFreq.tree) {
            if (n.children.isEmpty()) {
                System.out.println(n.name + ": " + n.code);
            }
        }
        System.out.println(sb.toString()); */
    }
}





