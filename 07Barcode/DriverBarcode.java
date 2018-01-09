public class DriverBarcode{
  public static void main(String[]args){
    if(Barcode.toZip(Barcode.toCode("14322")).equals("14322")  ){
      System.out.println("Test "+ 1 +",PASS");
      //   System.exit(0);
    }
    if(Barcode.toZip(Barcode.toCode("94322")).equals("94322") ) {
      System.out.println("Test "+ 1 +",PASS");
      //    System.exit(0);
    }

    Barcode A = new Barcode("11245");
    Barcode B = new Barcode("38760");
    Barcode C = new Barcode("11245");
    Barcode D = new Barcode("00294");

    System.out.println(A.getZip());//11245
    System.out.println(D.getZip());//00234
    System.out.println(A.getCode());// |:::||:::||::|:|:|::|:|:|:::||:|
    System.out.println(A.toString());// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    System.out.println(B);// |::||:|::|:|:::|:||::||::::|::|| (38760)
    System.out.println(C);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
    System.out.println(D);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
    System.out.println(A.compareTo(B));// negative
    System.out.println(A.compareTo(C));// 0
    System.out.println(A.compareTo(D));// positive
    System.out.println(A.equals(B));// false
    System.out.println(A.equals(C));// true
    System.out.println(A.equals(D));// false

  Barcode a = new Barcode("11245");
  Barcode b = new Barcode("38760");
  Barcode c = new Barcode("11245");
  Barcode d = new Barcode("00294");
  System.out.println(a.getZip());//11245
  System.out.println(d.getZip());//00234
  System.out.println(a.getCode());// |:::||:::||::|:|:|::|:|:|:::||:|
  System.out.println(a.toString());
  // |:::||:::||::|:|:|::|:|:|:::||:| (11245)
  // |:::||:::||::|:|:|::|:|:|:::||:|(11245)

  System.out.println(b);// |::||:|::|:|:::|:||::||::::|::|| (38760)
  System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
  System.out.println(d);// |||:::||:::::|:||:|:::|::|:|:|:| (00294)
  System.out.println(a.compareTo(b));// negative
  System.out.println(a.compareTo(c));// 0
  System.out.println(a.compareTo(d));// positive
  System.out.println(a.equals(b));// false
  System.out.println(a);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
  System.out.println(c);// |:::||:::||::|:|:|::|:|:|:::||:| (11245)
  System.out.println(a.equals(c));// true
  System.out.println(a.equals(d));// false
  //Barcode e = new Barcode("12sa1"); //Should throw an error, sa not valid nums
  //Barcode f = new Barcode("12312312"); //Should throw an error, too many nums
  //Barcode.toCode("131"); //Should throw an error, too little nums
  //Barcode.toCode("123dasda"); //Should throw an error, dasda are not valid #s
  //Barcode.toZip("|||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, Way too long
  //Barcode.toZip(":||:::||:::::|:||:|:::|::|:|:|::|"); //Should throw an error, should not end with :
  //Barcode.toZip(":||:::||:::::|:||:|:::|::|:||:::|"); //Should throw an error, checkSum incorrect
  //Barcode.toZip("|::::::|:::::|:||:|:::|::|:|:|::|"); //Should throw an error, ::::: found
  }
}
