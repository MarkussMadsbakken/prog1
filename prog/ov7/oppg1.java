package prog.ov7;

public class oppg1 {
    public static void main(String[] args) {
        nyString a = new nyString("     Hei     øaokhfakøjshdfkjøashfd mn nn nnnnn   znxcb");
        System.out.println(a.forkort());
        System.out.println(a.fjern("H"));
        
    }

    public static class nyString{
        String string;

        public nyString(String _string){
            string = _string;
        }

        public String forkort(){
            String res = "";
            int start = 0;

            for(int i = 0; i < string.length(); i++){
                if(string.charAt(i) != " ".charAt(0)){
                    res += string.charAt(i);
                    start = i;
                    System.out.println(i);
                    break;
                }
            }
    
            for(int i = start; i < string.length(); i++){
                if(string.charAt(i) == " ".charAt(0) && string.charAt(i+1) != " ".charAt(0)){
                    res += string.charAt(i+1);
                }
            }

            return res;
        }

        public String fjern(String fjern){
            String res = "";

            for(int i = 0; i < string.length(); i++){
                if(string.charAt(i) != fjern.charAt(0)){
                    res += string.charAt(i);
                }
            }

            return res;
        }

    }
}
