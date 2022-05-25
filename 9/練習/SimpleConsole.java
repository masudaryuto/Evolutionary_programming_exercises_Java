import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SimpleConsole{
    private BufferedReader in;

    public SimpleConsole(){
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public String readLine() throws IOException{
        return in.readLine();
    }

    public void close() throws IOException{
        in.close();
    }
}
