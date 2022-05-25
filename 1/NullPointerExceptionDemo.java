public class NullPointerExceptionDemo {
    void run() {
        String emptyString  = "";
        String stringString = "string";
        String nullString   = null;

        System.out.println(emptyString.toString());  // => 空文字が出力される．
        System.out.println(stringString.toString()); // => stringという文字列が出力される．
        System.out.println(nullString.toString());   // => NullPointerException
    }

    public static void main(String[] args) {
        NullPointerExceptionDemo demo = new NullPointerExceptionDemo();
        demo.run();
    }
}
