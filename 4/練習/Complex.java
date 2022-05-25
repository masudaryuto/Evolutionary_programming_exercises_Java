public class Complex {
    Double real;
    Double imag;




    //コンストラクタに似ている。出力でインスタンスがよばれると、出力される。
    public String toString(){
        return String.format("%3.2f + %3.2f i", this.real, this.imag);
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


    Complex add(Complex value){
        // this + value の結果を返す．
        Complex c1 = new Complex();

        c1.real = this.real + value.real;
        c1.imag = this.imag + value.imag;


        return c1;
    }
    
    Complex subtract(Complex value){
        // this - value の結果を返す．

        Complex c1 = new Complex();

        c1.real = this.real - value.real;
        c1.imag = this.imag - value.imag;


        return c1;
    }
    Complex multiply(Complex value){
        // this * value の結果を返す．

        Complex c1 = new Complex();

        c1.real = (this.real*value.real)-(this.imag*value.imag);
        c1.imag = (this.real*value.imag) + (this.imag*value.real);


        return c1;
    }
    Complex divide(Complex value){
        // this / value の結果を返す．

        Complex c1 = new Complex();

        c1.real = ((this.real*value.real)+(this.imag*value.imag)) / (Math.pow(value.real,2) + Math.pow(value.imag, 2));
        c1.imag = ((this.imag*value.real)-(this.real*value.imag)) / (Math.pow(value.real,2) + Math.pow(value.imag, 2));


        return c1;
    }

}