package day17;

class GenericDemo<T>{

    T obj;

    void add(T obj){
        this.obj=obj;
    }

    T get(){
        return obj;
    }
}


public class Demo4 {
    public static void main(String[] args) {
        GenericDemo<Integer> genericDemo = new GenericDemo<>();
        genericDemo.add(10);
        System.out.println(genericDemo.get());
    }
}
