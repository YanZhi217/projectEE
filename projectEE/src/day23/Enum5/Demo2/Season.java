package day23.Enum5.Demo2;


public enum Season {

    SPRING ("春"){
        @Override
        public void show() {
            System.out.println(this.name);
        }
    },

    SUMMER ("夏"){
        @Override
        public void show() {
            System.out.println(this.name);
        }
    },

    AUTUMN ("秋"){
        @Override
        public void show() {
            System.out.println(this.name);
        }
    },

    WINTER("冬"){
        @Override
        public void show() {
            System.out.println(this.name);
        }
    };


    public String name;


    //空参构造
    private Season(){}

    //有参构造
    private Season(String name){
        this.name = name;
    }

    //抽象方法
    public abstract void show();
}
