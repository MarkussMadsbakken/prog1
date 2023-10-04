package prog.ov5;

import java.util.Random;

public class oppg2 {

    public static void main(String[] args){
        MinRandom minrandom = new MinRandom();
        System.out.println(minrandom.nesteDesimaltall(0,10));
        System.out.println(minrandom.nesteHeltall(0,10));
    }
    
    public static class MinRandom{
        private Random random;

        public MinRandom(){
            random = new Random();
        }

        
        public int nesteHeltall(int nedre,int ovre) throws IllegalArgumentException{
            if(nedre > ovre){
                throw new IllegalArgumentException("nedre grense kan ikke være større enn øvre");
            }
            return nedre+random.nextInt(ovre-nedre+1);
        }
        
        public double nesteDesimaltall(double nedre, double ovre) throws IllegalArgumentException{
            if(nedre > ovre){
                throw new IllegalArgumentException("nedre grense kan ikke være større enn øvre");
            }

            return nedre+(random.nextDouble()*(ovre-nedre));
        }
    }
}
