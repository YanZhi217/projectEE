package day7;

public class student13 {
    /*
        JavaBean类: 封装数据
    */
        private String name;
        private int age;

        public student13() { }

        public student13(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void show(){
            System.out.println(name + "..." + age);
        }
}
