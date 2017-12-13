public class TempConversion{
    public static double CtoF(double C){
	return (9.0d/5)*C + 32;
    }
    public static double FtoC(double F){
	return (5.0d/9)*(F - 32);
    }
    public static void main(String arg[]){
	System.out.println(CtoF(-40));
	System.out.println(FtoC(-32));
	System.out.println(CtoF(0));
	System.out.println(FtoC(100));

    }
	
}
