public class Matrice {

    private int n;
    private int m;
    private int modulo;
    private int[][] content;

    public Matrice(int n, int m, int modulo) {
        // The matrix size n and m must be between 0 and modulo - 1
        if (modulo == 0) {
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

    public Matrice add(Matrice other) {

        if (this.modulo != other.modulo) {
            throw new RuntimeException();
        }

        int maxN = Math.max(this.n, other.n);
        int maxM = Math.max(this.m, other.m);

        Matrice sum = new Matrice(maxN, maxM, this.modulo);

        for (int row = 0; row < maxN; ++row) {
            for(int col = 0; col < maxM; ++col){
                int op1 = row > this.n || col > this.m ? 0 : this.content[row][col];
                int op2 = row > other.n || col > other.m ? 0 : other.content[row][col];

                sum.content[row][col] = (op1 + op2) % sum.modulo;
            }
        }

        return sum;
    }

    public Matrice sub(Matrice other) {
        if (this.modulo != other.modulo) {
            throw new RuntimeException();
        }

        int maxN = Math.max(this.n, other.n);
        int maxM = Math.max(this.m, other.m);

        Matrice sum = new Matrice(maxN, maxM, this.modulo);

        for (int row = 0; row < maxN; ++row) {
            for(int col = 0; col < maxM; ++col){
                int op1 = row > this.n || col > this.m ? 0 : this.content[row][col];
                int op2 = row > other.n || col > other.m ? 0 : other.content[row][col];

                sum.content[row][col] = (op1 - op2) % sum.modulo;
            }
        }

        return sum;
    }
    
    public Matrice multiply(Matrice other) {
        if (this.modulo != other.modulo) {
            throw new RuntimeException();
        }

        int maxN = Math.max(this.n, other.n);
        int maxM = Math.max(this.m, other.m);

        Matrice sum = new Matrice(maxN, maxM, this.modulo);

        for (int row = 0; row < maxN; ++row) {
            for(int col = 0; col < maxM; ++col){
                int op1 = row > this.n || col > this.m ? 0 : this.content[row][col];
                int op2 = row > other.n || col > other.m ? 0 : other.content[row][col];

                sum.content[row][col] = (op1 * op2) % sum.modulo;
            }
        }

        return sum;
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
