import java.util.*;
public class MyDeque<E>{
  private E[] data;
  private int size, start, end;
  @SuppressWarnings("unchecked")
  public MyDeque(){
    data = (E[])new Object[10];
    size = 0;
    start = 0;
    end = 0;
  }
  public MyDeque(int capacity){
    data = (E[])new Object[capacity];
    size = 0;
    start = 0;
    end = 0;
  }
  public int size(){
    return size;
  }
  public void addFirst(E element){
    if (element == null){
        throw new NullPointerException();
    }
    if (size == data.length - 1){
      resize();
    }
    start = start - 1;
    if (start < 0){
      start = data.length - 1;
    }
    data[start] = element;
    size += 1;
  }
  public void addLast(E element){
    if (element == null){
        throw new NullPointerException();
    }
    if (size == data.length - 1){
      resize();
    }
    end = end + 1;
    if (end == data.length){
      end = 0;
    }
    data[end] = element;
    size += 1;
  }
  public E getFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    return data[start];
  }
  public E getLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    return data[end];
  }
  public E removeFirst(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    if (size == 1 && start == 0){
      return removeLast();
    }
    E temp = data[start];
    data[start] = null;
    start += 1;
    size -= 1;
    return temp;
  }
  public E removeLast(){
    if (size == 0){
      throw new NoSuchElementException();
    }
    if (size == 1 && end == 0){
      return removeFirst();
    }
    E temp = data[end];
    data[end] = null;
    end -= 1;
    size -= 1;
    return temp;
  }
  public String toString(){
    String y = "{";
    if (start > end){
      for (int i = start; i < data.length; i++){
        if (data[i] != null){
          y += data[i] + " ";
        }
      }
      for (int o = 0; o <= end; o++){
        if (data[o] != null){
          y += data[o] + " ";
        }
      }
    }
    else{
      if (start - end != 0){
        for (int i = start; i <= end; i++){
          if (data[i] != null){
            y += data[i] + " ";
          }
        }
      }
    }
    y += "}";
    return y;
  }
  public void resize(){
    E[] newary = (E[])new Object[data.length * 2 + 1];
    int k = 0;
    if (start > end){
      for (int i = start; i < data.length; i++){
        newary[k] = data[i];
        k++;
      }
      for (int o = 0; o <= end; o++){
        if (data[o] != null){
          newary[k] = data[o];
        }
        k++;
      }
    }
    else{
      for (int i = start; i <= end; i++){
        newary[k] = data[i];
        k++;
      }
    }
    start = 0;
    end = k - 1;
    data = newary;
  }
  public static void main(String[] args){
		MyDeque<Integer> a = new MyDeque<Integer>(3);
		System.out.println(a);
    a.addLast(5);
		a.removeFirst();
		System.out.println(a);
    a.resize();
    System.out.println(a);
	}
}
