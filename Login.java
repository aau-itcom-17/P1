import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Collectors;

import static com.sun.activation.registries.LogSupport.log;
import static java.lang.System.out;


public class Login {
    
    //checks if string contains special chars including space " ". Returns true if there are, returns false if it's only a-z, 0-9
    public static boolean containsSpecChar (String enteredString){
          Pattern p = Pattern.compile("[^a-z0-9]");
          Matcher m = p.matcher(enteredString);
          boolean b = m.find();

          if(b) return true;
          return false;
      }

    public static boolean login(String enteredUsername, String enteredPass) throws IOException {
        FileReader fileReader = new FileReader("text.txt");


        byte[] bytes = Files.readAllBytes(Paths.get("text.txt"));
        String s = new String(bytes);


        try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                if (enteredUsername.equals("") || enteredPass.equals("")) {
                    return false;
                } else if (s.contains(enteredUsername + " " + enteredPass)) {
                    return true;
                }
                // process the line.
            }
        }
        return false;
    }


}

/**
    public static void main (String[] args ) throws IOException{
        Scanner scanner = new Scanner(System.in);

        System.out.println("User: ");
        String user = scanner.next();
        System.out.println("Pass: ");
        String pass = scanner.next();


        FileReader fileReader = new FileReader("/Users/akroghp/IdeaProjects/P1 LoginUser/src/text.txt");
        BufferedReader bufferedReader = new BufferedReader(fileReader);


        byte[] bytes = Files.readAllBytes(Paths.get("/Users/akroghp/IdeaProjects/P1 LoginUser/src/text.txt"));
        String s = new String(bytes);




        if (s.indexOf(user + " " + pass) == 0){
            System.out.println("You are logged in");
        } else{
            System.err.println("Username and password doesn't match");
        }



        bufferedReader.close();



    }

}

**/
