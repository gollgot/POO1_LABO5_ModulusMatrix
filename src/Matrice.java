public class Matrice {

    private int n;
    private int m;
    private int modulo;
    private int[][] content;

    public Matrice(int n, int m, int modulo){
        // The matrix size n and m must be between 0 and modulo - 1
        if(n >= modulo || m >= modulo ||
            n < 0 || m < 0)
        {
            throw new RuntimeException("The matrix size (n and m) must be between 0 and modulo - 1");
        }

        this.n = n;
        this.m = m;
        this.modulo = modulo;
        this.content = new int[n][m];

        randomPopulate();
    }

    private void randomPopulate(){
        int max = modulo - 1;
        int min = 0;
        int range = max - min + 1;

        for (int row = 0; row < this.n; ++row) {
            for(int col = 0; col < this.m; ++col){
                content[row][col] = (int)(Math.random() * range) + min;
            }
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (int row = 0; row < this.n; ++row) {
            for(int col = 0; col < this.m; ++col){
                str += content[row][col];
            }
            str += "\n";
        }

        return str;
    }
}
