public class Main {

    public static void main(String[] args) {

        Matrice m1 = new Matrice(2,4,5);
        Matrice m2 = new Matrice(2,4,5);

        Matrice m3 = m1.add(m2);

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }

}
