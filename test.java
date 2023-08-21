public class test {
    public static void main(String[] args){
        a();
        System.out.println("a");
    }

    public static void a(){
        System.out.println("2");
    }

    a b = new a();

    b.test();



}

class a{
    public void test(){
        System.out.println("a");
    }
}





