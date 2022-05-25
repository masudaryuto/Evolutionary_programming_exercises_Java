public class Gcd {

    void run(String[] args) {
        if(args.length <= 1) {
            System.out.println("java Gcd <number> <numbers...>");
            return;
        }
        ArrayList<Integer> values = convert(args);
        Integer gcdValue = values.get(0);
        for(Integer i = 1; i < values.size(); i++){
            gcdValue = gcd(gcdValue, values.get(i));
        }
        System.out.printf("gcd(%s) = %d%n", String.join(", ", args), gcdValue);
    }

    Integer gcd(Integer x, Integer y) {
        if(y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    ArrayList<Integer> convert(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        for(Integer i = 0; i < args.length; i++){
            list.add(Integer.valueOf(args[i]));
        }
        return list;
    }


    public static void main(String[] args){

        Gcd g = new Gcd();

        g.run(args);
    }
}