import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVTOHTML {

    public static void main(String[] args) throws Exception {
        List<String[]> output = readAll(new File("/home/schodron/COMPSCI400/CGI/cgi_activity/data.csv"));
        try {
            System.out.println("<html><body><p>");
            System.out.println("<table>");
            int num = output.size();
            String[] cooper = output.get(0);
            System.out.print("<tr>");
            for(int x = 0; x<cooper.length; x++) {
                System.out.print("<th>" + cooper[x]  +  "</th>");
            }
            System.out.println();
            for(int x = 1; x<num; x++) {
                String[] alex = output.get(x);
                int num2 = alex.length;
                System.out.print("<tr>");
                for(int y = 0; y<num2; y++) {
                        System.out.print("<td>" + alex[y] + "</td>");
                }
                System.out.println();
            }
            System.out.println("</table>");
            System.out.println("</p></body></html>");
        } catch(Exception e) {
            System.out.println("<html><body><pre>");
            System.out.println("Ooops, something went wrong. There was an exception in the Java program:");
            e.printStackTrace(System.out);
            System.out.println("</pre></body></html>");
        }
    }

    public static List<String[]> readAll(File csvFile) throws Exception {
        List<String[]> output = new ArrayList<>();
        try (Scanner fin = new Scanner(csvFile)) {
            while(fin.hasNextLine()) {
                output.add(fin.nextLine().split(","));
            }
        }
        return output;
    }

}
