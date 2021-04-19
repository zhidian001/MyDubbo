
public class Test {
    static void change(int m){
        m = 5;
        System.out.println("change"+m);
    }
    public static void main(String[] args) {
        int m =10;
        System.out.println("be"+m);
        change(m);
        System.out.println("af"+m);
    }
}
