import java.io.*;
import java.util.*;

class ReverseHuffmanCode {

    public static void main(String[] args) {
        new ReverseHuffmanCode().run();
    }

    public void run() {
        String fileName = "Input2.txt";
        File inputFile = new File(fileName);
        int num = 0;
        int length = 0;
        Map<String,Character> code = new TreeMap<String,Character>();
        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader in = new BufferedReader(new FileReader(inputFile.getAbsoluteFile()));
            sb.append(in.readLine());
            int spaceIndex = sb.indexOf(" ");
            num = Integer.parseInt(sb.substring(0,spaceIndex));
            length = Integer.parseInt(sb.substring(spaceIndex+1,sb.length()));
            sb.delete(0, sb.length());

            Character ch;
            for (int i=0; i<num; i++) {
                sb.append(in.readLine());
                ch = sb.charAt(0);
                sb.delete(0,3);
                code.put(sb.toString(),ch);
                sb.delete(0,sb.length());
            }
            sb.append(in.readLine());
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        /* Ввод через консоль
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int length = sc.nextInt();
        sc.nextLine();

        Map<String,Character> code = new TreeMap<String,Character>();
        StringBuilder sb = new StringBuilder();
        char ch;
        for (int i=0; i<num; i++) {
            sb.append(sc.nextLine());
            ch = sb.charAt(0);
            sb.delete(0,3);
            code.put(sb.toString(),ch);
            sb.delete(0,sb.length());
        }
        sb.append(sc.nextLine()); */

        StringBuilder sbCode = new StringBuilder();
        StringBuilder response = new StringBuilder();
        for (int i=0; i<length; i++) {
            sbCode.append(sb.charAt(i));
            if (code.containsKey(sbCode.toString())) {
                response.append(code.get(sbCode.toString()));
                sbCode.delete(0,sbCode.length());
            }
        }


        File outputFile = new File("Output2.txt");
        if(!outputFile.exists()){
            try {
                outputFile.createNewFile();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        try {
            FileWriter out = new FileWriter(outputFile, true);
            out.write(response.toString() + "\n");
            out.write("\n");
            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        //System.out.println(response.toString());
    }
}
