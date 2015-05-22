package objectoriented;
//******************************************************************
//  Demonstrates how to reference hidden fields 
//******************************************************************

public class Foo
{
   private int i = 5;
   private static double k = 3.0;

   void setI(int i) {
      this.i = i;
   }

   static void setK(double k) {
      Foo.k = k;
   }

   int getI() {
      return this.i;
   }

   double getK() {
      return Foo.k;
   }
}