package Engine.MathVectors;
/**
 * Stolen by Gref on 29.05.2016.
 */
public class Vector2d {
    private static final long serialVersionUID = 1L;

    /**
     * The x component of the vector.
     */
    public double x;
    /**
     * The y component of the vector.
     */
    public double y;

    /**
     * Create a new {@link Vector2d} and initialize its components to zero.
     */
    public Vector2d() {
    }

    /**
     * Create a new {@link Vector2d} and initialize both of its components with the given value.
     *
     * @param d
     *          the value of both components
     */
    public Vector2d(double d) {
        this(d, d);
    }

    /**
     * Create a new {@link Vector2d} and initialize its components to the given values.
     *
     * @param x
     *          the x value
     * @param y
     *          the y value
     */
    public Vector2d(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new {@link Vector2d} and initialize its components to the one of the given vector.
     *
     * @param v
     *          the {@link Vector2d} to copy the values from
     */
    public Vector2d(Vector2d v) {
        x = v.x;
        y = v.y;
    }



    /**
     * Set the x and y components to the supplied value.
     *
     * @param d
     *          the value of both components
     * @return this
     */
    public Vector2d set(double d) {
        return set(d, d);
    }

    /**
     * Set the x and y components to the supplied values.
     *
     * @param x
     *          the x value
     * @param y
     *          the y value
     * @return this
     */
    public Vector2d set(double x, double y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Set this {@link Vector2d} to the values of v.
     *
     * @param v
     *          the vector to copy from
     * @return this
     */
    public Vector2d set(Vector2d v) {
        x = v.x;
        y = v.y;
        return this;
    }

    /**
     * Set this {@link Vector2d} to be a clone of <code>v</code>.
     *
     * @param v
     *          the vector to copy from
     * @return this
     */


    /**
     * Store this vector into the supplied {@link DoubleBuffer} starting at the specified
     * absolute buffer position/index.
     * <p>
     * This method will not increment the position of the given DoubleBuffer.
     *
     * @param index
     *          the absolute position into the DoubleBuffer
     * @param buffer
     *          will receive the values of this vector in <tt>x, y</tt> order
     * @return the passed in buffer
     */

    /**
     * Set this vector to be one of its perpendicular vectors.
     *
     * @return this
     */
    public Vector2d perpendicular() {
        return set(y, x * -1);
    }

    /**
     * Subtract <code>v</code> from this vector.
     *
     * @param v
     *          the vector to subtract
     * @return this
     */
    public Vector2d sub(Vector2d v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    /**
     * Subtract <tt>(x, y)</tt> from this vector.
     *
     * @param x
     *          the x component to subtract
     * @param y
     *          the y component to subtract
     * @return this
     */
    public Vector2d sub(double x, double y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    /**
     * Subtract <tt>(x, y)</tt> from this vector and store the result in <code>dest</code>.
     *
     * @param x
     *          the x component to subtract
     * @param y
     *          the y component to subtract
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d sub(double x, double y, Vector2d dest) {
        dest.x = this.x - x;
        dest.y = this.y - y;
        return dest;
    }

    /**
     * Subtract <code>v</code> from this vector.
     *
     * @param v
     *          the vector to subtract
     * @return this
     */

    /**
     * Subtract <code>v</code> from <code>this</code> vector and store the result in <code>dest</code>.
     *
     * @param v
     *          the vector to subtract
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d sub(Vector2d v, Vector2d dest) {
        dest.x = x - v.x;
        dest.y = y - v.y;
        return dest;
    }

    /**
     * Subtract <code>v</code> from <code>this</code> vector and store the result in <code>dest</code>.
     *
     * @param v
     *          the vector to subtract
     * @param dest
     *          will hold the result
     * @return dest
     */

    /**
     * Multiply the components of this vector by the given scalar.
     *
     * @param scalar
     *        the value to multiply this vector's components by
     * @return this
     */
    public Vector2d mul(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    /**
     * Multiply the components of this vector by the given scalar and store the result in <code>dest</code>.
     *
     * @param scalar
     *        the value to multiply this vector's components by
     * @param dest
     *        will hold the result
     * @return dest
     */
    public Vector2d mul(double scalar, Vector2d dest) {
        dest.x = x * scalar;
        dest.y = y * scalar;
        return dest;
    }

    /**
     * Multiply the components of this Vector2d by the given scalar values and store the result in <code>this</code>.
     *
     * @param x
     *          the x component to multiply this vector by
     * @param y
     *          the y component to multiply this vector by
     * @return this
     */
    public Vector2d mul(double x, double y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    /**
     * Multiply the components of this Vector2d by the given scalar values and store the result in <code>dest</code>.
     *
     * @param x
     *          the x component to multiply this vector by
     * @param y
     *          the y component to multiply this vector by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d mul(double x, double y, Vector2d dest) {
        dest.x = this.x * x;
        dest.y = this.y * y;
        return dest;
    }

    /**
     * Multiply this Vector2d component-wise by another Vector2d.
     *
     * @param v
     *          the vector to multiply by
     * @return this
     */
    public Vector2d mul(Vector2d v) {
        x *= v.x;
        y *= v.y;
        return this;
    }

    /**
     * Multiply this Vector2d component-wise by another Vector2d and store the result in <code>dest</code>.
     *
     * @param v
     *          the vector to multiply by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d mul(Vector2d v, Vector2d dest) {
        dest.x = x * v.x;
        dest.y = y * v.y;
        return dest;
    }

    /**
     * Return the dot product of this vector and <code>v</code>.
     *
     * @param v
     *          the other vector
     * @return the dot product
     */
    public double dot(Vector2d v) {
        return x * v.x + y * v.y;
    }

    /**
     * Return the angle between this vector and the supplied vector.
     *
     * @param v
     *          the other vector
     * @return the angle, in radians
     */
    public double angle(Vector2d v) {
        double dot = x*v.x + y*v.y;
        double det = x*v.y - y*v.x;
        return Math.atan2(det, dot);
    }

    /**
     * Return the length of this vector.
     *
     * @return the length
     */
    public double length() {
        return Math.sqrt(x * x + y * y);
    }

    /**
     * Return the distance between <code>this</code> and <code>v</code>.
     *
     * @param v
     *          the other vector
     * @return the euclidean distance
     */
    public double distance(Vector2d v) {
        double dx = v.x - x;
        double dy = v.y - y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    /**
     * Return the distance between <code>this</code> and <code>v</code>.
     *
     * @param v
     *          the other vector
     * @return the euclidean distance
     */

    /**
     * Normalize this vector.
     *
     * @return this
     */
    public Vector2d normalize() {
        double invLength = 1.0 / Math.sqrt(x * x + y * y);
        x *= invLength;
        y *= invLength;
        return this;
    }

    /**
     * Normalize this vector and store the result in <code>dest</code>.
     *
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d normalize(Vector2d dest) {
        double invLength = 1.0 / Math.sqrt(x * x + y * y);
        dest.x = x * invLength;
        dest.y = y * invLength;
        return dest;
    }

    /**
     * Add <code>v</code> to this vector.
     *
     * @param v
     *          the vector to add
     * @return this
     */
    public Vector2d add(Vector2d v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * Add <code>(x, y)</code> to this vector.
     *
     * @param x
     *          the x component to add
     * @param y
     *          the y component to add
     * @return this
     */
    public Vector2d add(double x, double y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Add <code>(x, y)</code> to this vector and store the result in <code>dest</code>.
     *
     * @param x
     *          the x component to add
     * @param y
     *          the y component to add
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d add(double x, double y, Vector2d dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        return dest;
    }

    /**
     * Add <code>v</code> to this vector.
     *
     * @param v
     *          the vector to add
     * @return this
     */


    /**
     * Add <code>v</code> to this vector and store the result in <code>dest</code>.
     *
     * @param v
     *          the vector to add
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d add(Vector2d v, Vector2d dest) {
        dest.x = x + v.x;
        dest.y = y + v.y;
        return dest;
    }

    /**
     * Add <code>v</code> to this vector and store the result in <code>dest</code>.
     *
     * @param v
     *          the vector to add
     * @param dest
     *          will hold the result
     * @return dest
     */

    /**
     * Set all components to zero.
     *
     * @return this
     */
    public Vector2d zero() {
        x = 0.0;
        y = 0.0;
        return this;
    }
    /**
     * Negate this vector.
     *
     * @return this
     */
    public Vector2d negate() {
        x = -x;
        y = -y;
        return this;
    }

    /**
     * Negate this vector and store the result in <code>dest</code>.
     *
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d negate(Vector2d dest) {
        dest.x = -x;
        dest.y = -y;
        return dest;
    }

    /**
     * Linearly interpolate <code>this</code> and <code>other</code> using the given interpolation factor <code>t</code>
     * and store the result in <code>this</code>.
     * <p>
     * If <code>t</code> is <tt>0.0</tt> then the result is <code>this</code>. If the interpolation factor is <code>1.0</code>
     * then the result is <code>other</code>.
     *
     * @param other
     *          the other vector
     * @param t
     *          the interpolation factor between 0.0 and 1.0
     * @return this
     */
    public Vector2d lerp(Vector2d other, double t) {
        return lerp(other, t, this);
    }

    /**
     * Linearly interpolate <code>this</code> and <code>other</code> using the given interpolation factor <code>t</code>
     * and store the result in <code>dest</code>.
     * <p>
     * If <code>t</code> is <tt>0.0</tt> then the result is <code>this</code>. If the interpolation factor is <code>1.0</code>
     * then the result is <code>other</code>.
     *
     * @param other
     *          the other vector
     * @param t
     *          the interpolation factor between 0.0 and 1.0
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d lerp(Vector2d other, double t, Vector2d dest) {
        dest.x = x + (other.x - x) * t;
        dest.y = y + (other.y - y) * t;
        return dest;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vector2d other = (Vector2d) obj;
        if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
            return false;
        if (Double.doubleToLongBits(y) != Double.doubleToLongBits(other.y))
            return false;
        return true;
    }

    /**
     * Return a string representation of this vector.
     * <p>
     * This method creates a new {@link DecimalFormat} on every invocation with the format string "<tt> 0.000E0;-</tt>".
     *
     * @return the string representation
     */

    /**
     * Add the component-wise multiplication of <code>a * b</code> to this vector.
     *
     * @param a
     *          the first multiplicand
     * @param b
     *          the second multiplicand
     * @return this
     */
    public Vector2d fma(Vector2d a, Vector2d b) {
        x += a.x * b.x;
        y += a.y * b.y;
        return this;
    }

    /**
     * Add the component-wise multiplication of <code>a * b</code> to this vector.
     *
     * @param a
     *          the first multiplicand
     * @param b
     *          the second multiplicand
     * @return this
     */
    public Vector2d fma(double a, Vector2d b) {
        x += a * b.x;
        y += a * b.y;
        return this;
    }

    /**
     * Add the component-wise multiplication of <code>a * b</code> to this vector
     * and store the result in <code>dest</code>.
     *
     * @param a
     *          the first multiplicand
     * @param b
     *          the second multiplicand
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d fma(Vector2d a, Vector2d b, Vector2d dest) {
        dest.x = x + a.x * b.x;
        dest.y = y + a.y * b.y;
        return dest;
    }

    /**
     * Add the component-wise multiplication of <code>a * b</code> to this vector
     * and store the result in <code>dest</code>.
     *
     * @param a
     *          the first multiplicand
     * @param b
     *          the second multiplicand
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2d fma(double a, Vector2d b, Vector2d dest) {
        dest.x = x + a * b.x;
        dest.y = y + a * b.y;
        return dest;
    }

}

