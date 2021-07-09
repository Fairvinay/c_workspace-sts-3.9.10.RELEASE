package com.sample.next;

import java.io.BufferedReader;
import java.io.Externalizable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Objects;

class Node<T> implements Externalizable {
	Node left;
	Node right;

	T data;
	private String filePath = "nodelist.ser";
 
	public Node() {
		
	}
	public Node(int i, String string) {

	}

	public Node setData(T t) {
		data = t;
		return this;
	}

	public T getData() {
		return data;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		if ( data instanceof Externalizable) {
			((Externalizable)data).writeExternal(out);
		}
		
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		   in.readInt();
		Field[] fields = data.getClass().getDeclaredFields();
		Method[] methods = data.getClass().getDeclaredMethods();
		if (fields.length > 1 && methods.length > 1) {
			int i = 0;

			do {
				if (fields[i].isAccessible() && methods[i].isAccessible()) {
					Class<?> m = methods[i].getReturnType();
					String isSet = methods[i].getName();
					String mName = isSet.substring(isSet.indexOf("set") + 1);
					if (fields[i].getName().equalsIgnoreCase(mName) && isSet.indexOf("set") > -1) {
						Method ms = methods[i];
						if (Integer.class.isAssignableFrom(m)) {

							try {
								ms.invoke(in.readInt());
							} catch (IllegalAccessException e) {
								System.out.println(" readExternalize failed ");
							} catch (IllegalArgumentException e) {
								System.out.println(" readExternalize failed ");
							} catch (InvocationTargetException e) {
								System.out.println(" readExternalize failed ");
							}
						}
						if (String.class.isAssignableFrom(m)) {
							try {
								ms.invoke(in.readLine());
							} catch (IllegalAccessException e) {
								System.out.println(" readExternalize failed ");
							} catch (IllegalArgumentException e) {
								System.out.println(" readExternalize failed ");
							} catch (InvocationTargetException e) {
								System.out.println(" readExternalize failed ");
							}
						}

					}
				}

			} while (i < fields.length);
		}
		// data = in.readLine();
	}
    public String toString () {
    	return "Node { data " + data.toString() + " } ";
    }


}

public class Base implements Externalizable {
	public int id;
	private String name;
	private String filePath = "Baselist.ser";
	// private NavigableMap<String, String > lst =
	// Collections.checkedNavigableMap(m, keyType, valueType) ();

	public Base(int a, String string) {  
		id  = a ; name = string;
	}
    
	public Base() {

	}
	public Base(int i) {
		id = i;
	}

	public void shape(Object o) {
		System.out.println(" This is Base Object ");

	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return Objects.hashCode(id) + Objects.hashCode(name);
	}

	public void shape(int o) {
		System.out.println(" This is Base Object int ");

	}

	public void shape(short o) {
		System.out.println(" This is Base Object short ");

	}

	protected void two() {
		System.out.println("Base two");
	}

	protected static void three() {
		System.out.println("Base three ");
	}

	public void one(Base r) {

	}

	void one(int a) {
		System.out.println(" base class ");
	}

	private void oneTwo() {
	}

	public String toString() {
		return "Base [ id " + id + " name " + name + " ] ";
	}

	public static void main(String[] args) throws IOException {
		Base a = new Derived(3);
		Base b = new Base(3);
		a.two();
		((Derived) a).three();

		HashMap<Base, String> hm = new HashMap<Base, String>();

		Node listNode[] = new Node[] { new Node().setData(new Base(1, "Sdae")),
				new Node().setData(new Base(2, "Rajesh")), new Node().setData(new Base(3, "Adhikant")),
				new Node().setData(new Base(4, "Maria")) };

		System.out.println("Node List Before serialize "+listNode);
		b.serializeNodeList(listNode);
		Node[] nList = b.deserializeNodeList();
		
		System.out.println("Node List After deserialize "+nList);
		
		System.exit(1);
		int cnt = 0;
		/*
		 * Stream.of("010101").filter(a -> { Stream.of("101101").filter(b -> { if(a==b);
		 * } );
		 * 
		 * );
		 */

		String S = "010101", T = "101101";
		for (int i = 0; i < S.length(); i++) {

			if (S.charAt(i) == T.charAt(i)) {
				cnt += 1;
			}
		}
		System.out.println("cnt " + cnt);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String second = br.readLine();
		String[] pages = second.trim().split(" ");

		int score = 0;
		for (int i = 0; i < pages.length; i++) {

			String p = pages[i];
			int l = Integer.parseInt(p.charAt(p.length() - 1) + "");
			double N = new Integer("20.3").doubleValue();
			if (i == 0) {
				score += l;

			} else {
				score *= l;
			}
		}
		double k = Math.pow(10d, 9d) + 7;
		String sc = score % (k) + "";
		sc = sc.substring(0, sc.indexOf("."));

		System.out.println(" " + k);
		System.out.println(sc);

		/*
		 * Base b = (Base)a; b.one(5); ((Base) a).one(5); Base r = new Derived (3);
		 * r.one(b); a.two();
		 */

		b.shape(2);

	}

	public void serializeNodeList(Node[] list) throws IOException {

		serialize(list);

	}

	public Node[] deserializeNodeList() throws IOException {

		Node[] list = null;
		// for(Node a : list) {
		try {
			list = deserialize();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("deserialze failed ");
		}
		return list;
		// }
	}

	public void serialize(Node[] list) throws IOException {
		// serialize object's state
		FileOutputStream fos = new FileOutputStream(filePath);
		ObjectOutputStream outputStream = new ObjectOutputStream(fos);
		outputStream.writeObject(list);

		outputStream.close();
		// System.out.println("Base details before serialization:\n" + node);
		System.out.println("Serialization done");
	}

	public Node[] deserialize() throws ClassNotFoundException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		ObjectInputStream inputStream = new ObjectInputStream(fis);
		Node[] user = (Node[]) inputStream.readObject();
		inputStream.close();

		System.out.println("  de-serialization:\n" + user);
		return user;
	}

	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeInt(id);
		if (name != null)
			out.writeChars(name);
	}

	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		id = in.readInt();
		name = in.readLine();
	}
}
