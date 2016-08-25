package Engine.MathVectors;

/**
 * Stolen by Gref on 29.05.2016.
 */

public class Vector2i {

    private static final long serialVersionUID = 1L;

    /**
     * The x component of the vector.
     */
    public int x;
    /**
     * The y component of the vector.
     */
    public int y;

    /**
     * Create a new {@link Vector2i} and initialize its components to zero.
     */
    public Vector2i() {
    }

    /**
     * Create a new {@link Vector2i} and initialize both of its components with
     * the given value.
     *
     * @param s
     *          the value of both components
     */
    public Vector2i(int s) {
        this.x = s;
        this.y = s;
    }

    /**
     * Create a new {@link Vector2i} and initialize its components to the given values.
     *
     * @param x
     *          the x component
     * @param y
     *          the y component
     */
    public Vector2i(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Create a new {@link Vector2i} and initialize its components to the one of
     * the given vector.
     *
     * @param v
     *          the {@link Vector2i} to copy the values from
     */
    public Vector2i(Vector2i v) {
        x = v.x;
        y = v.y;
    }


    /**
     * Set the x and y components to the supplied value.
     *
     * @param s
     *          scalar value of both components
     * @return this
     */
    public Vector2i set(int s) {
        this.x = s;
        this.y = s;
        return this;
    }

    /**
     * Set the x and y components to the supplied values.
     *
     * @param x
     *          the x component
     * @param y
     *          the y component
     * @return this
     */
    public Vector2i set(int x, int y) {
        this.x = x;
        this.y = y;
        return this;
    }

    /**
     * Set this {@link Vector2i} to the values of v.
     *
     * @param v
     *          the vector to copy from
     * @return this
     */
    public void set(Vector2i v) {
        this.x = v.x;
        this.y = v.y;
    }

    /**
     * Set this {@link Vector2i} to the values of v.
     * <p>
     * Note that due to the given vector <code>v</code> storing the components
     * in double-precision, there is the possibility to lose precision.
     *
     * @param v
     *          the vector to copy from
     * @return this
     */
//    public Vector2i set(Vector2d v) {
//        x = (int) v.x;
//        y = (int) v.y;
//        return this;
//    }

    /**
     * Subtract the supplied vector from this one and store the result in
     * <code>this</code>.
     *
     * @param v
     *          the vector to subtract
     * @return this
     */
    public Vector2i sub(Vector2i v) {
        x -= v.x;
        y -= v.y;
        return this;
    }

    /**
     * Subtract the supplied vector from this one and store the result in
     * <code>dest</code>.
     *
     * @param v
     *          the vector to subtract
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2i sub(Vector2i v, Vector2i dest) {
        dest.x = x - v.x;
        dest.y = y - v.y;
        return dest;
    }

    /**
     * Decrement the components of this vector by the given values.
     *
     * @param x
     *          the x component to subtract
     * @param y
     *          the y component to subtract
     * @return this
     */
    public Vector2i sub(int x, int y) {
        this.x -= x;
        this.y -= y;
        return this;
    }

    /**
     * Decrement the components of this vector by the given values and store the
     * result in <code>dest</code>.
     *
     * @param x
     *          the x component to subtract
     * @param y
     *          the y component to subtract
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2i sub(int x, int y, Vector2i dest) {
        dest.x = this.x - x;
        dest.y = this.y - y;
        return dest;
    }

    /**
     * Return the length squared of this vector.
     *
     * @return the length squared
     */
    public long lengthSquared() {
        return x * x + y * y;
    }

    /**
     * Return the length of this vector.
     *
     * @return the length
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * Return the distance between this Vector and <code>v</code>.
     *
     * @param v
     *          the other vector
     * @return the distance
     */
    public double distance(Vector2i v) {
        return Math.sqrt(distanceSquared(v));
    }

    /**
     * Return the distance between <code>this</code> vector and <tt>(x, y)</tt>.
     *
     * @param x
     *          the x component of the other vector
     * @param y
     *          the y component of the other vector
     * @return the euclidean distance
     */
    public double distance(int x, int y) {
        return Math.sqrt(distanceSquared(x, y));
    }

    /**
     * Return the square of the distance between this vector and <code>v</code>.
     *
     * @param v
     *          the other vector
     * @return the squared of the distance
     */
    public long distanceSquared(Vector2i v) {
        int dx = this.x - v.x;
        int dy = this.y - v.y;
        return dx * dx + dy * dy;
    }

    /**
     * Return the square of the distance between <code>this</code> vector and
     * <tt>(x, y)</tt>.
     *
     * @param x
     *          the x component of the other vector
     * @param y
     *          the y component of the other vector
     * @return the square of the distance
     */
    public long distanceSquared(int x, int y) {
        int dx = this.x - x;
        int dy = this.y - y;
        return dx * dx + dy * dy;
    }

    /**
     * Add <code>v</code> to this vector.
     *
     * @param v
     *          the vector to add
     * @return this
     */
    public Vector2i add(Vector2i v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * Add the supplied vector to this one and store the result in
     * <code>dest</code>.
     *
     * @param v
     *          the vector to add
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2i add(Vector2i v, Vector2i dest) {
        dest.x = x + v.x;
        dest.y = y + v.y;
        return dest;
    }

    /**
     * Increment the components of this vector by the given values.
     *
     * @param x
     *          the x component to add
     * @param y
     *          the y component to add
     * @return this
     */
    public Vector2i add(int x, int y) {
        this.x += x;
        this.y += y;
        return this;
    }

    /**
     * Increment the components of this vector by the given values and store the
     * result in <code>dest</code>.
     *
     * @param x
     *          the x component to add
     * @param y
     *          the y component to add
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2i add(int x, int y, Vector2i dest) {
        dest.x = this.x + x;
        dest.y = this.y + y;
        return dest;
    }

    /**
     * Multiply all components of this {@link Vector2i} by the given scalar
     * value.
     *
     * @param scalar
     *          the scalar to multiply this vector by
     * @return this
     */
    public Vector2i mul(int scalar) {
        x *= scalar;
        y *= scalar;
        return this;
    }

    /**
     * Multiply all components of this {@link Vector2i} by the given scalar
     * value and store the result in <code>dest</code>.
     *
     * @param scalar
     *          the scalar to multiply this vector by
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2i mul(int scalar, Vector2i dest) {
        dest.x = x * scalar;
        dest.y = y * scalar;
        return dest;
    }

    /**
     * Add the supplied vector by this one.
     *
     * @param v
     *          the vector to multiply
     * @return this
     */
    public Vector2i mul(Vector2i v) {
        x += v.x;
        y += v.y;
        return this;
    }

    /**
     * Multiply the supplied vector by this one and store the result in
     * <code>dest</code>.
     *
     * @param v
     *          the vector to multiply
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2i mul(Vector2i v, Vector2i dest) {
        dest.x = x * v.x;
        dest.y = y * v.y;
        return dest;
    }

    /**
     * Multiply the components of this vector by the given values.
     *
     * @param x
     *          the x component to multiply
     * @param y
     *          the y component to multiply
     * @return this
     */
    public Vector2i mul(int x, int y) {
        this.x *= x;
        this.y *= y;
        return this;
    }

    /**
     * Multiply the components of this vector by the given values and store the
     * result in <code>dest</code>.
     *
     * @param x
     *          the x component to multiply
     * @param y
     *          the y component to multiply
     * @param dest
     *          will hold the result
     * @return dest
     */
    public Vector2i mul(int x, int y, Vector2i dest) {
        dest.x = this.x * x;
        dest.y = this.y * y;
        return dest;
    }

    /**
     * Set all components to zero.
     *
     * @return this
     */
    public Vector2i zero() {
        this.x = 0;
        this.y = 0;
        return this;
    }


    /**
     * Negate this vector.
     *
     * @return this
     */
    public Vector2i negate() {
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
    public Vector2i negate(Vector2i dest) {
        dest.x = -x;
        dest.y = -y;
        return dest;
    }

    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Vector2i other = (Vector2i) obj;
        if (x != other.x) {
            return false;
        }
        if (y != other.y) {
            return false;
        }
        return true;
    }

    /**
     * Return a string representation of this vector.
     *
     * @return the string representation
     */
    public String toString() {
        return "(" + x + " " + y + ")"; //$NON-NLS-1$ //$NON-NLS-2$ //$NON-NLS-3$
    }

}

