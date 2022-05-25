
// VectorCalculator.java
public class VectorCalculator{
    void run(){
        Vector vector1 = this.createVector(-8, 1, -4);
        Vector vector2 = this.createVector(12, -4, 6);
        this.printVector("v1", vector1); // (1)
        this.printVector("v2", vector2); // (2)
        this.printVector("v1+v2", vector1.add(vector2)); // (3)
        System.out.printf("v1 v2 = %d%n", vector1.innerProduct(vector2)); //
        
    }
void printVector(String label, Vector vector){
    System.out.printf("%s: (%d, %d, %d)", label, vector.v1, vector.v2,
    vector.v3);
    System.out.printf(", |%s| = %f%n", label, vector.norm());
}
Vector createVector(Integer v1, Integer v2, Integer v3){
    Vector vector = new Vector();
    vector.v1 = v1;
    vector.v2 = v2;
    vector.v3 = v3;
    return vector;
}

    public static void main(String[] args){
        VectorCalculator calculator = new VectorCalculator();
        calculator.run();
    }
}
