import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {

        //no input file.
        if(args.length == 0){
            System.out.println("파일이 없습니다.");
            System.exit(0);
        }
        File f = new File(args[0]);

    }
}