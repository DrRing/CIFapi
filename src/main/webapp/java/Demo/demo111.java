package Demo;

public class demo111 {


        public boolean equals( demo111 other) {
            System.out.println("use Demo equals." );
            return true;
        }

        public static void main(String[] args) {
            Object o1 =new demo111 ();
            Object o2 =new demo111 ();
            demo111 o3 =new demo111 ();
            demo111 o4 =new demo111 ();

//            if (o1.equals(o2)) {
//                System.out.println("o1 is equal with o2.");
//            }

            if(o3.equals(o4)) {
                System.out.println("o3 is equal with o4.");
            }
        }
    }
