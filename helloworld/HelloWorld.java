/** 
 * The HelloWorld class implements an application that
 * simply displays "Hello World!" on the standard output.
 */
package helloworld;

class HelloWorld {
  public static void main(String[] args) {
     new HelloWorld().printMessage();
     new HelloWorld().add(5,5);
  }

 public  void printMessage() {
    System.out.println("Hello world!");
  }
  
  public int add(int a,int b)
  {
    return a+b;
  }

}
