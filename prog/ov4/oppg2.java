package prog.ov4;

public class oppg2 {
    public static void main(String[] args){
        spill spill = new spill();
        spill.startSpill();
    }

    public static class spill{

        public void startSpill(){
            spiller A = new spiller();
            spiller B = new spiller();
            int runde = 0;

            while (!A.erFerdig() && !B.erFerdig()){
                runde++;
                System.out.println("runde " + runde);

                A.kastTerningen();
                B.kastTerningen();

                System.out.println("spiller A har "+A.getSumPoeng()+" poeng");
                System.out.println("spiller B har "+B.getSumPoeng()+" poeng");

                System.out.println("");
            }
            if(A.erFerdig()){
                System.out.println("spiller A vant");
            } else {
                System.out.println("spiller B vant");
            }
        }
    }

    public static class spiller{
        int poeng;

        public spiller(){
            poeng = 0;
        }

        public boolean erFerdig(){
            if(poeng == 100){
                return true;
            }
            return false;
        }

        public int getSumPoeng(){
            return poeng;
        }
        
        public void kastTerningen(){
            int terning = (int)(Math.random()*6) + 1;
            if(terning == 1){
                poeng = 0;
            } else {
                if(poeng > 100){
                    poeng-=terning;
                } else{
                    poeng += terning;
                }
            }
        }
    }
}
