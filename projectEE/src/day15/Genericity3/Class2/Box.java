package day15.Genericity3.Class2;

//这是一个泛型类
public class Box<E> {
    private E element;

    public E getElement() {
        return element;
    }

    public void setElement(E element) {
        this.element = element;
    }
}
