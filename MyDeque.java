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
    start = start - 1;
    if (start < 0){
      start = data.length - 1;
    }
    data[start] = element;
  }
}
