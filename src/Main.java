public class Main {

    public static void main(String[] args) {

        int modulus = 5;

        Matrice m1 = new Matrice(new int[][] {{1,3,1,1},{3,2,4,2},{1,0,1,0}}, modulus);
        Matrice m2 = new Matrice(new int[][] {{1,4,2,3,2},{0,1,0,4,2},{0,0,2,0,2}}, modulus);

        System.out.println("The modulus is " + modulus + "\n");

        System.out.println("one");
        System.out.println(m1);

        System.out.println("two");
        System.out.println(m2);

        System.out.println("one + two");
        System.out.println(m1.add(m2));

        System.out.println("one - two");
        System.out.println(m1.sub(m2));

        System.out.println("one x two");
        System.out.println(m1.multiply(m2));
    }

}
