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



    // TODO : Faire un constructeur qui prend un tableau en parametre pour ainsi pouvoir créer une matrice avec exactement les valeurs qu'on veut



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

    private Matrice doOperation(Matrice other, Operation operation){
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
                int operationResult = operation.calculate(op1, op2);
                sum.content[row][col] = operationResult % sum.modulo;
            }
        }

        return sum;
    }

    public Matrice add(Matrice other) {
        return doOperation(other, new Addition());
    }

    public Matrice sub(Matrice other) {
        return doOperation(other, new Subtraction());
    }
    
    public Matrice multiply(Matrice other) {
        return doOperation(other, new Multiplication());
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
