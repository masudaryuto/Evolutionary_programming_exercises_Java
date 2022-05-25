public class Complex{
    Double real;
    Double imag;

    void print(){
        System.out.printf("%5.2f + %5.2f i", this.real, this.imag);
    }
    void println(){
        this.print();
        System.out.println();
    }
    Complex conjugate(){
        Complex complex = new Complex();
        complex.real = this.real;
        complex.imag = -1 * this.imag;
        return complex;
    }
    Double absolute(){
        return Math.sqrt(this.real * this.real + this.imag * this.imag);
    }

    Complex add(Complex c1){
        Complex c = new Complex();
        c.real = this.real + c1.real;
        c.imag = this.imag + c1.imag;
        return c;
    }

    Complex subtract(Complex c1){
        Complex c = new Complex();
        c.real = this.real - c1.real;
        c.imag = this.imag - c1.imag;
        return c;
    }

    Complex multiply(Complex c1){
        Complex c = new Complex();
        c.real = this.real * c1.real - this.imag * c1.imag;
        c.imag = this.real * c1.imag + this.imag * c1.real;
        return c;
    }

    Complex divide(Complex c1){
        Complex c = new Complex();
        Double denominator = c1.real * c1.real + c1.imag + c1.imag;
        c.real = (this.real * c1.real + this.imag * c1.imag) / denominator;
        c.imag = (this.imag * c1.real - this.real * c1.imag) / denominator;
        return c;
    }

    public String toString(){
        return String.format("%5.2f + %5.2f i", this.real, this.imag);
    }
}
