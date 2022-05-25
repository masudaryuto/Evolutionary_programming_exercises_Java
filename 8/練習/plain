//暗号化


import java.io.*;

public class CaesarCipher {

    void run(String[] args) throws IOException{

        Integer key = Integer.valueOf(args[0]);
        //BufferedReader in = new BufferedReader(new FileReader(new File(args[1])));
        FileInputStream in = new FileInputStream(args[1]);
        FileOutputStream out = new FileOutputStream(args[2]);
        //BufferedOutputStream secret = new BufferedOutputStream(new FileOutputStream(new File(args[2])));

        this.copy(key, in, out);
        in.close();
        out.close();
    }

    void copy(Integer key, FileInputStream in, FileOutputStream out) throws IOException{

        Integer data;
        Integer ans;

        while( (data = in.read()) != -1 ){
            ans = data+key;

            if( data+key >= 256 ){
                ans -= 256;
            }
            else if( data+key < 0 ){
                ans += 256;
            }
    
            out.write(ans);
        }
        //secret.close();
    }

    public static void main(String[] args) throws IOException{

        CaesarCipher cas = new CaesarCipher();

        cas.run(args);
    }

}