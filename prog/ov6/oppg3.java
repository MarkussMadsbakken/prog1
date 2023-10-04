package prog.ov6;

public class oppg3 {
    public static void main(String[] args){
        Matrise m1 = new Matrise(new int[][]{{1,-2,1},{2,1,3}});
        Matrise m2 = new Matrise(new int[][]{{2,1},{3,2},{1,8}});

        m2.multiplikasjon(m1).print();
        
        Matrise m3 = new Matrise(new int[][]{{6,7},{7,8},{1,2}});
        //m3.transponer().print();s
    }

    public static class Matrise{
        private final int[][] matrise;

        public Matrise(int[][] _matrise){
            for (int i = 0; i < _matrise.length; i++){
                if (_matrise[i].length != _matrise[0].length){
                    throw new IllegalArgumentException("Alle radene i matrisen være like lange");
                }
            }

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

        public String toString(){
            String res = "";
            for (int i = 0; i < matrise.length; i++){
                for (int j = 0; j <matrise[0].length; j++){
                    res+= matrise[i][j] + " ";
                }
                res+= "\n";
            }

            return res;
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

            if(m1[0].length != m2.length){
                if(m1[0].length == m2.length){ //om matrisene kanskje er i feil rekkefølge
                    throw new IllegalArgumentException("Kolonnene i den ene matrisen må tilsvare radene i den andre. Mente du: \n" + _m2.toString() + " * \n" + toString() + "?" );
                }
                throw new IllegalArgumentException("Kolonnene i den ene matrisen må tilsvare radene i den andre");
            }
            
            int[][] res = new int[m1.length][m2[0].length];

            for (int i = 0; i < m1.length; i++){ //kollonne
                for (int j = 0; j < m2[0].length; j++){ //rad
                    for (int k = 0; k < m2.length; k++){ //element
                        res[i][j] += m2[k][j]*m1[i][k];
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
