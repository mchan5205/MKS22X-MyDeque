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
    if (size == data.length){
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
    if (size == data.length){
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
    return data[start];
  }
  public E getLast(){
    return data[end];
  }
  public E removeFirst(){
    E temp = data[start];
    start += 1;
    size -= 1;
    return temp;
  }
  public E removeLast(){
    E temp = data[end];
    end -= 1;
    size -= 1;
    return temp;
  }
  public String toString(){
    String y = "{";
    if (start > end){
      for (int i = start; i < data.length; i++){
        y += data[i] + " ";
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
          y += data[i] + " ";
        }
      }
    }
    y += "}";
    return y;
  }
  private void resize(){
    E[] newary = (E[])new Object[data.length * 2 + 1];
    int k = 0;
    if (start > end){
      for (int i = start; i < data.length; i++){
        newary[k] = data[i];
        k++;
      }
      for (int o = 0; o <= end; o++){
        newary[k] = data[o];
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
}
