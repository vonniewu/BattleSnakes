package com.hakrx.battlesnakes;

public class Point<T> implements Cloneable {

    T x, y;

    public Point(T x, T y){
        this.x = x;
        this.y = y;
    }

    public T getX() {
        return x;
    }

    public T getY() {
        return y;
    }

    public void setX(T x) {
       this.x = x;
    }

    public void setY(T y) {
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;

        if (obj instanceof Point<?>) {
            Point<?> point = (Point<?>)obj;
            return point.x.equals(getX()) && point.y.equals(getY());
        }

        return false;
    }

    // Adapted from Microsoft Complex class hash code: http://referencesource.microsoft.com/#System.Numerics/System/Numerics/Complex.cs
    @Override
    public int hashCode() {
        int n1 = 99999997;
        int hash_x = x.hashCode() % n1;
        int hash_y = y.hashCode();
        return hash_x ^ hash_y;
    }

    public Point<T> clone() {
        return new Point<T>(getX(), getY());
    }
}
