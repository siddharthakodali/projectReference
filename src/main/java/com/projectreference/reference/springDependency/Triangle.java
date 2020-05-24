package com.projectreference.reference.springDependency;

public class Triangle {

    public String details;
    public int size;
    private point pointerA;
    private point pointerB;
    private point pointerC;


    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public point getPointerA() {
        return pointerA;
    }

    public void setPointerA(point pointerA) {
        this.pointerA = pointerA;
    }

    public point getPointerB() {
        return pointerB;
    }

    public void setPointerB(point pointerB) {
        this.pointerB = pointerB;
    }

    public point getPointerC() {
        return pointerC;
    }

    public void setPointerC(point pointerC) {
        this.pointerC = pointerC;
    }

    public Triangle(String details) {
        this.details = details;
    }

    public Triangle(int shape) {
        this.size = shape;
    }

    public Triangle(String details, int shape) {
        this.details = details;
        this.size = shape;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public void draw() {
        System.out.println(details + "Drawing Triangle Details" + size);
        System.out.println("The point A values are " + pointerA.getX() + pointerA.getY());
        System.out.println("The point A values are " + pointerB.getX() + pointerA.getY());
        System.out.println("The point A values are " + pointerC.getX() + pointerA.getY());

    }


}
