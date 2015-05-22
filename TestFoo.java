package objectoriented;
//******************************************************************
//  A driver/tester class for the Foo class
//******************************************************************

public class TestFoo 
{
  public static void main(String[] args)
  {
    Foo obj1 = new Foo();    // one instance of the Foo class
    Foo obj2 = new Foo();    // a different instance of Foo

    System.out.println("Before obj1: (" + obj1.getI() + "," +
                                           obj1.getK() + ")");
    System.out.println("Before obj2: (" + obj2.getI() + "," +
                                            obj2.getK() + ")");

    obj1.setI(10);    // Setting the "instance" variable
    Foo.setK(6.5);    // Setting the "static" variable

    System.out.println();
    System.out.println("After obj1: (" + obj1.getI() + "," +
                                           obj1.getK() + ")");
    System.out.println("After obj2: (" + obj2.getI() + "," +
                                            obj2.getK() + ")");
  }
}