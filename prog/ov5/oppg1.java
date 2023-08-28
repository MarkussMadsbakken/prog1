package prog.ov5;

public class oppg1 {
    public static void main(String[] args){

        test_brok();

    }

    public static void test_brok(){ //test for brok
        brok a = new brok(1, 2);
        brok b = new brok(1, 3);

        a.multipliser(b); //1/6
        System.out.println(a.getTeller() + "/" + a.getNevner());

        a = new brok(1, 2);

        a.summer(b); //5/6
        System.out.println(a.getTeller() + "/" + a.getNevner());

        a = new brok(1, 2);

        a.subtraher(b); //1/6
        System.out.println(a.getTeller() + "/" + a.getNevner());

        a = new brok(124, 24);

        a.divider(b); //3/2
        System.out.println(a.getTeller() + "/" + a.getNevner());

        brok c = new brok(0,0);
        c.forkort();
        System.out.println(c.getTeller() + "/" + c.getNevner());
    }

    public static class brok{
        long teller;
        long nevner;

        public brok(long _teller, long _nevner) throws IllegalArgumentException{ 
            if(_nevner == 0){
                throw new IllegalArgumentException("nevner kan ikke være 0");
            }

            teller = _teller;
            nevner = _nevner;
        }

        public brok(long _teller){
            teller = _teller;
            nevner = 1;
        }

        public long getTeller(){
            return teller;
        }

        public long getNevner(){
            return nevner;
        }

        public void multipliser(brok b){
            teller = teller*b.getTeller();
            nevner = nevner*b.getNevner();
            forkort();
        }

        public void summer(brok b){
            teller = teller*b.getNevner() + b.getTeller()*nevner;
            nevner = nevner*b.getNevner();
            forkort();
        }

        public void subtraher(brok b){
            teller = teller*b.getNevner() - b.getTeller()*nevner;
            nevner = nevner*b.getNevner();
            forkort();
        }
        
        public void divider(brok b){
            teller = teller*b.getNevner();
            nevner = nevner*b.getTeller();
            forkort();
        }
        
        public void forkort(){ //forkorte brøken
            long divisor = sDivisor();

            if(teller == 0){ //teller kan hypotetisk sett være null, return
                return;
            }

            teller = teller/divisor;
            nevner = nevner/divisor;
        }

        public long sDivisor(){ //finne minste divisor
            if(teller == nevner){ //hvis nevner og teller er lik, del brøken på nevner
                return nevner;
            }

            long a = Math.abs(teller);
            long b = Math.abs(nevner);
            long d = 0;

            //dybde just in case
            int dybde = 200;
            int i = 0;

            System.out.println(a);
            System.out.println(b);


            while(dybde > i){ //https://en.wikipedia.org/wiki/Greatest_common_divisor#Binary_GCD_algorithm
                if(a%2 == 0 & b%2 == 0){ //hvis a og b er partall
                    a = a/2;
                    b = b/2;
                    d++;

                } else if (a%2 == 0){ //hvis b er oddetall
                    a = a/2;

                } else if (b%2 == 0){ //hvis a er oddetall
                    b = b/2;

                } else{ //hvis begge tallene er oddetall
                    if (a>b){ //hvis a er større enn b
                        a = (a-b)/2; //forsett gcd med c/2,b
                    } else { //hvis b er større enn det
                        long e = a; //bytt a og b
                        a = b;
                        b = e;
                    }
                }

                if(a == b){ //hvis a = b, gcd er a*2^d
                    return a*(long)Math.pow(2, d);
                }

                i++; //inkrementer dybde
            }
            System.out.println("dybde nådd");
            return 1;
        }
        
    }
}
