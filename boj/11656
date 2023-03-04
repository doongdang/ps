import java.util.*;
import java.io.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        String[] arr = new String[s.length()];

        for(int i = 0; i < arr.length; i++){
            arr[i] = s.substring(i, s.length());
        }

        Arrays.sort(arr);

        for(String ar : arr){
            bw.write(ar);
            bw.write("\n");
        }
        bw.close();
    }

}

