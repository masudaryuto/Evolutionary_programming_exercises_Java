import java.io.*;

public class SimpleCopier2{
    void run(String[] args) throws IOException {
        FileInputStream in = new FileInputStream(args[0]);
        FileOutputStream out = new FileOutputStream("output");
        this.copy(in, out);
        in.close();
        out.close();
    }

    void copy(FileInputStream in, FileOutputStream out) throws IOException {
        Integer data;
        while((data = in.read()) != -1){ // １文字ずつ読み込み，
                                         // データが読み込めなくなるまで繰り返す．
            out.write(data); // データを１文字書き出す．
        }
    }

    public static void main(String[] args) throws IOException {
        SimpleCopier2 copier = new SimpleCopier2();
        copier.run(args);
    }
}