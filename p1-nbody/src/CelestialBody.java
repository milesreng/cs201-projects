

/**
 * Celestial Body class for NBody
 * Modified from original Planet class
 * used at Princeton and Berkeley
 * @author ola
 *
 * If you add code here, add yourself as @author below
 * @author Miles Eng
 *
 */
public class CelestialBody {

	private double myXPos;
	private double myYPos;
	private double myXVel;
	private double myYVel;
	private double myMass;
	private String myFileName;

	/**
	 * Create a Body from parameters	
	 * @param xp initial x position
	 * @param yp initial y position
	 * @param xv initial x velocity
	 * @param yv initial y velocity
	 * @param mass of object
	 * @param filename of image for object animation
	 */
	public CelestialBody(double xp, double yp, double xv,
			             double yv, double mass, String filename){
		myXPos = xp;
		myYPos = yp;
		myXVel = xv;
		myYVel = yv;
		myMass = mass;
		myFileName = filename;
	}

	/**
	 * Accessor for x position
	 * @return the value of this object's x-position
	 */
	public double getX() {
		return myXPos;
	}

	/**
	 *Accessor for y position
	 * @return the value of this object's y-position
	 */
	public double getY() {
		return myYPos;
	}

	/**
	 * Accessor for the x-velocity
	 * @return the value of this object's x-velocity
	 */
	public double getXVel() {
		return myXVel;
	}
	/**
	 * Accessor for the y-velocity 
	 * @return the value of this object's y-velocity
	 */
	public double getYVel() {
		return myYVel;
	}

	/**
	 * Accessor for the mass
	 * @return the value of this object's mass
	 */
	public double getMass() {
		return myMass;
	}

	/**
	 * Accessor for the name
	 * @return the name of this object
	 */
	public String getName() {
		return myFileName;
	}

	/**
	 * Return the distance between this body and another
	 * @param b the other body to which distance is calculated
	 * @return distance between this body and b
	 */
	public double calcDistance(CelestialBody b) {
		double dx = myXPos - b.myXPos;
		double dy = myYPos - b.myYPos;
		return Math.sqrt((dx * dx) + (dy * dy));
	}

	/**
	 * Return the force exerted on this body by another
	 * @param b the other body by which the force is exerted
	 * @return force exerted by b on this body
	 */
	public double calcForceExertedBy(CelestialBody b) {
		double g = 6.67 * Math.pow(10, -11);
		double r = calcDistance(b);
		return g * (myMass * b.myMass) / (r * r);
	}

	/**
	 * Return force exerted in the x direction
	 * @param b the other body by which the force is exerted
	 * @return force exerted in the x direction by b on this body
	 */
	public double calcForceExertedByX(CelestialBody b) {
		double f = calcForceExertedBy(b);
		double r = calcDistance(b);
		return f * (b.myXPos - myXPos) / r;
	}

	/**
	 * Return force exerted in the y direction
	 * @param b the other body by which the force is exerted
	 * @return force exerted in the y direction by b on this body
	 */
	public double calcForceExertedByY(CelestialBody b) {
		double f = calcForceExertedBy(b);
		double r = calcDistance(b);
		return f * (b.myYPos - myYPos) / r;
	}

	/**
	 * Return net force exerted in the x direction by all bodies on this body
	 * @param bodies all bodies by which force is exerted
	 * @return net force exerted in the x direction by bodies on this body
	 */
	public double calcNetForceExertedByX(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody b : bodies) {
			if (!b.equals(this)) {
				sum += calcForceExertedByX(b);
			}
		}
		return sum;
	}

	/**
	 * Return net force exerted in the y direction by all bodies on this body
	 * @param bodies all bodies by which force is exerted
	 * @return net force exerted in the y direction by bodies on this body
	 */
	public double calcNetForceExertedByY(CelestialBody[] bodies) {
		double sum = 0.0;
		for (CelestialBody b : bodies) {
			if (!b.equals(this)) {
				sum += calcForceExertedByY(b);
			}
		}
		return sum;
	}

	/**
	 * Updates the state/instance variables of this object
	 * @param deltaT small time steps
	 * @param xforce net force in x direction exerted by all other bodies
	 * @param yforce net force in y direction exerted by all other bodies
	 */
	public void update(double deltaT, 
			           double xforce, double yforce) {
		double ax = xforce / myMass;
		double ay = yforce / myMass;
		double nvx = myXVel + deltaT * ax;
		double nvy = myYVel + deltaT * ay;
		myXPos += deltaT * nvx;
		myYPos += deltaT * nvy;
		myXVel = nvx;
		myYVel = nvy;
	}

	/**
	 * Draws this planet's image at its current position
	 */
	public void draw() {
		StdDraw.picture(myXPos,myYPos,"images/"+myFileName);
	}
}
