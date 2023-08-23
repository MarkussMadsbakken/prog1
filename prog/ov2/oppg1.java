package prog.ov2;

public class oppg1 {
    public static void main(String[] args){
        System.out.println(testSkuddar(0));
        System.out.println(testSkuddar(2));
        System.out.println(testSkuddar(4));
        System.out.println(testSkuddar(100));
        System.out.println(testSkuddar(400));
        System.out.println(testSkuddar(2023));
        System.out.println(testSkuddar(2024));
    }

    public static boolean testSkuddar(int ar){
        if(ar%100 !=0){
            if(ar%4 == 0){
                return true;
            }
            return false;
        }

        if(ar%400 == 0){
            return true;
        }
        return false;
    }
}
