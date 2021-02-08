package interview;

public class mytest {


    public static class Parent implements Cloneable {
        String name = "";
        int age = 0;
        Son theson;

        Parent(String n, int age) {
            this.name = n;
            this.age = age;
        }

        public void setName(String na) {
            name = na;
        }

        public void setSon(Son s) {
            theson = s;
        }

        @Override
        protected Parent clone() {
            Parent clone = null;
            try {
                clone = (Parent) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e); // won't happen  
            }
            clone.theson = theson.clone();
            return clone;
        }

        public String toString() {
            return "Parent[" + name + "===" + age + "];" + "---Son:" + (theson != null ? theson.name : "null");
        }
    }

    public static class Son implements Cloneable {
        String name = "";
        int age = 0;

        Son(String n, int age) {
            this.name = n;
            this.age = age;
        }

        public void setName(String na) {
            name = na;
        }

        @Override
        protected Son clone() {
            Son clone = null;
            try {
                clone = (Son) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new RuntimeException(e); // won't happen  
            }

            return clone;
        }

        public String toString() {
            return "Son[" + name + "===" + age + "];";
        }
    }

    public static void main(String[] args) {
        Parent item1 = new Parent("john", 10);
        Son son = new Son("john's son", 10);
        item1.setSon(son);

        Parent item2 = item1.clone();
        son.setName("tom's son");
        item1.setName("tom");
        System.out.println("parent1 = " + item1.toString());
        System.out.println("parent2 = " + item2.toString());
    }

}  