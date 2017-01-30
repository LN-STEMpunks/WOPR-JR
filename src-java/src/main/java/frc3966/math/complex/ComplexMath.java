package frc3966.math.complex;

/**
 * Math, like trig, exp, etc with Complex numbers
 * @author cade
 */
public class ComplexMath {
    
    public static Complex exp(Complex a) {
        return cis(a.im).scale(Math.exp(a.re));
    }
    
    public static Complex log(Complex a) {
        return new Complex(Math.log(a.norm()), a.getAngle());
    }
    
    public static Complex log(Complex a, Complex b) {
        return log(a).div(log(b));
    }
    
    
    public static Complex cis(double a) {
        return new Complex(Math.cos(a), Math.sin(a));
    }
    
    public static Complex sin(Complex a) {
        Complex expia = exp(a.mul(Complex.i));
        return expia.sub(expia.inv()).div(new Complex(0, 2));
    }
    
    public static Complex cos(Complex a) {
        Complex expia = exp(a.mul(Complex.i));
        return expia.add(expia.inv()).div(2);
    }
    
    public static Complex tan(Complex a) {
        return sin(a).div(cos(a));
    }
    
}
