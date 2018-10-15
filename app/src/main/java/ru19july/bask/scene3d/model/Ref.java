package ru19july.bask.scene3d.model;

public class Ref<T> {

    private T value;

    public Ref(T value) {
        this.value = value;
    }

    public T get() {
        return value;
    }

    public void set(T anotherValue) {
        value = anotherValue;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object obj) {
        return value.equals(obj);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}

/*

public void changeRef(Ref<String> ref) {
    ref.set("bbb");
}

// ...
Ref<String> ref = new Ref<String>("aaa");
changeRef(ref);
System.out.println(ref); // prints "bbb"
*/