import java.io.File;

public class DirectoryExample {

    public static void main(String[] args) {

       File directory = new File("C:\\Program Files");

       for(File f : directory.listFiles()){

            System.out.println(f);

       }


    }
}
