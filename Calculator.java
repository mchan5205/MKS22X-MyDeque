import java.io.*;
import java.util.*;
public class Calculator{
  public static double eval(String s){
    Scanner t = new Scanner(s);
    MyDeque<Double> nums = new MyDeque<Double>();
    while(t.hasNext()){
      String temp = t.next();
      if (temp.equals("+")){
        double second = nums.removeLast();
        double first = nums.removeLast();
        nums.addLast(first + second);
      }
      else if (temp.equals("-")){
        double second = nums.removeLast();
        double first = nums.removeLast();
        nums.addLast(first - second);
      }
      else if (temp.equals("*")){
        double second = nums.removeLast();
        double first = nums.removeLast();
        nums.addLast(first * second);
      }
      else if (temp.equals("/")){
        double second = nums.removeLast();
        double first = nums.removeLast();
        nums.addLast(first / second);
      }
      else if (temp.equals("%")){
        double second = nums.removeLast();
        double first = nums.removeLast();
        nums.addLast(first % second);
      }
      else{
        nums.addLast(Double.parseDouble(temp));
      }
    }
    return nums.getLast();
  }
  public static void main(String[] args){
    eval("1 2 +");
  }
}
