public class Vector {
    Integer v1;
    Integer v2;
    Integer v3;
    Double norm(){
        return Math.sqrt(v1 * v1 + v2 * v2 + v3 * v3);
    }
    Vector add(Vector v1){
        Vector v = new Vector();
        v.v1 = this.v1 + v1.v1;
        v.v2 = this.v2 + v1.v2;
        v.v3 = this.v3 + v1.v3;
        return v;
    }
    Integer innerProduct(Vector v){
        Integer sum = 0;
        sum += this.v1 * v.v1;
        sum += this.v2 * v.v2;
        sum += this.v3 * v.v3;
        return sum;
    }
}