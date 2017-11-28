public class DriverBook{
    public static void main(String[] arg) {
	Book b = new Book();
	System.out.println(b.getAuthor());
	System.out.println(b);
	Book c = new Book("Bannana", "Minion", "123");
	System.out.println(c);
	System.out.println(c.getAuthor());
	b.setAuthor("Satan");
	b.setTitle("Devilish Demon");
	b.setISBN("666.666.666");
	System.out.println(b);
	
    }
}
