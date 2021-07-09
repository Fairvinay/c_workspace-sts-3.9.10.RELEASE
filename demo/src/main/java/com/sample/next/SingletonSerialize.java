package com.sample.next;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SingletonSerialize implements Serializable {

private static SingletonSerialize instance = new SingletonSerialize();
private int i;

public static SingletonSerialize getInstance() {
    return instance;
}

private SingletonSerialize() {
}

private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
    ois.defaultReadObject();
    instance = this;
}

private Object readResolve()  {
    return instance;
}

public static void main(String[] args) throws Throwable {

    SingletonSerialize s = SingletonSerialize.getInstance();
    s.i = 5;
    System.out.println("before serialization::"+s.i+" "+ s); //printing value and object
    ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
    ObjectOutputStream oos = new java.io.ObjectOutputStream(baos);
    oos.writeObject(getInstance());
    oos.close();

    s.i = 7; //modified after serialization
    System.out.println("modified after serialization::"+s.i+" "+s);
    InputStream is = new ByteArrayInputStream(baos.toByteArray());
    ObjectInputStream ois = new ObjectInputStream(is);
    SingletonSerialize deserialized = (SingletonSerialize) ois.readObject();
    System.out.println("after deserialization::"+deserialized.i+" "+deserialized); //prints 5, but hashCode is different, which means object is not the same

}
}