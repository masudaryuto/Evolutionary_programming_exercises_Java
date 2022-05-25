public class Complex{
    Double real;
    Double imag;

    void print(){
        System.out.printf("%5.2f + %5.2f i",
            this.real, this.imag);
    }
    void println(){
        this.print();
        System.out.println();
    }
    public String toString(){
        return String.format("%5.2f + %5.2f i", this.real, this.imag);
    }
    Double absolute(){
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    Complex conjugate(){
        Complex complex = new Complex();
        complex.real = this.real;
        complex.imag = this.imag * -1;
        return complex;
    }


}