package team3966.math.complex;

/**
 * Complex number.
 * re+i*im, where i^2 = -1
 * 
 * Specifically useful for calculating rotations, and converting polar coordinates to rectangular
 * 
 * @author cade
 */
public class Complex {
	
	public static Complex i = new Complex(0, 1);
	
	public double re, im;
	
	public Complex(double _re, double _im) {
		re = _re;
		im = _im;
	}
	
	public Complex(double _re) {
		re = _re;
		im = 0;
	}
	
	// basic coordinates
	public static Complex fromRect(double x, double y) {
		return new Complex(x, y);
	}
	
	// basic coordinates
	public static Complex fromPolar(double radius, double theta) {
		return ComplexMath.exp(new Complex(0, theta)).scale(radius);
	}
	
	public double getRadius() {
		return this.norm();
	}
	
	// returns the angle in polar coordinates (in radians)
	public double getAngle() {
		return Math.atan2(im, re);
	}
	
	public Complex unit() {
		return this.div(norm());
	}
	
	public double norm() {
		return Math.sqrt(normSqr());
	}
	
	public double normSqr() {
		return re*re + im*im;
	}
	
	public Complex rotate(double theta) {
		return this.mul(fromPolar(1, theta));
	}
	
	public Complex conj() {
		return new Complex(re, -im);
	}
			
	public Complex scale(double a) {
		return new Complex(re * a, im * a);
	}
	
	// returns 1 / this
	public Complex inv() {
		return conj().scale(1.0 / normSqr());
	}
	
	public Complex add(Complex a) {
		return new Complex(re + a.re, im + a.im);
	}

	public Complex add(double a) {
		return new Complex(re + a, im);
	}
	
	
	public Complex sub(Complex a) {
		return new Complex(re + a.re, im - a.im);
	}
	
	public Complex sub(double a) {
		return new Complex(re - a, im);
	}
	
	// defined via expansion:
	// (a+ib)(x+iy)=(ax-by)+i(xb+ay)
	public Complex mul(Complex a) {
		return new Complex(re*a.re - im*a.im, re*a.im + im*a.re);
	}
	public Complex mul(double a) {
		return this.scale(a);
	}
	
	
	public Complex div(Complex a) {
		return this.mul(a.inv());
	}
	
	public Complex div(double a) {
		return this.scale(1.0 / a);
	}
	
	
	public Complex pow(Complex a) {
		return ComplexMath.exp(ComplexMath.log(this).mul(a));
	}
	
	public Complex pow(double a) {
		return ComplexMath.exp(ComplexMath.log(this).mul(a));
	}
	
}
