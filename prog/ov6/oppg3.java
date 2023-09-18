package prog.ov6;

public class oppg3 {
    public static void main(String[] args){
        Matrise m1 = new Matrise(new int[][]{{1,2,3}});
        Matrise m2 = new Matrise(new int[][]{{10,11},{20,21},{30,31}});

        m1.multiplikasjon(m2).print();
        
        Matrise m3 = new Matrise(new int[][]{{6,7},{7,8},{4,1}});
        m3.transponer().print();
    }

    public static class Matrise{
        int[][] matrise;

        public Matrise(int[][] _matrise){
            matrise = _matrise;

            
        }

        public int[][] getList(){
            return matrise;
        }

        public void print(){
            for (int i = 0; i < matrise.length; i++){
                for (int j = 0; j <matrise[0].length; j++){
                    System.out.print(matrise[i][j] + " ");
                }
                System.out.println("");
            }
        }

        public Matrise addisjon(Matrise _m2) throws IllegalArgumentException{
            int[][] m2 = _m2.getList();
            int[][] m1 = matrise;

            if(m1.length != m2.length || m1[0].length != m2[0].length){
                throw new IllegalArgumentException("Matrisene er ikke like store");
            }

            int[][] res = new int[m1.length][m1[0].length];

            for (int i = 0; i < m1.length; i++){
                for (int j = 0; j < m1[0].length; j++){
                    res[i][j] = m1[i][j] + m2[i][j];
                }
            }

            return new Matrise(res);
        }

        public Matrise multiplikasjon(Matrise _m2) throws IllegalArgumentException{
            int[][] m1 = matrise;
            int[][] m2 = _m2.getList();
            System.out.println(m1.length);
            System.out.println(m2.length);

            if(m1[0].length == m2.length){ //bytt matrisene om de kan ganges sammen med reversert rekkefølge
                int[][] temp = m1;
                m1 = m2;
                m2 = temp;
            }

            if(m1.length != m2[0].length){
                throw new IllegalArgumentException("Kolonnene i den ene matrisen må tilsvare radene i den andre");
            }
            
            int[][] res = new int[m2.length][m1[0].length];

            for (int i = 0; i < m2.length; i++){ //kollonne
                for (int j = 0; j < m1[0].length; j++){ //rad
                    for (int k = 0; k < m1.length; k++){ //element
                        res[i][j] += m1[k][j]*m2[i][k];
                    }
                }
            }
            return new Matrise(res);
        }

        public Matrise transponer(){
            int[][] res = new int[matrise[0].length][matrise.length]; //reverser størrelse

            for (int i = 0; i < matrise.length; i++){ //rad
                for (int j = 0; j < matrise[0].length; j++){ //kollonne
                    res[j][i] = matrise[i][j]; //reverser plassering  
                }
            }
            return new Matrise(res);
        } 
    }
}
