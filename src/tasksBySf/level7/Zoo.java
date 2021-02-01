package tasksBySf.level7;

public  class Zoo {
    static Object[] animals;

    public Zoo() {
        animals = new Object[3];
        animals[0] = new Dog();
        animals[1] = new Cat();
        animals[2] = new Reptile();
    }

    public void print() {
        for (Object a : animals) {
            System.out.println(a);;
        }
    }
    public void sound() {
        for (Object a : animals) {
            if(a instanceof Soundable){
                ((Soundable) a).sound();
            }
        }
    }

    public void change(Object a, int i) {
        if (i >= 0 && i < animals.length) {
            animals[i] = a;
        }
    }

    @Override
    public String toString() {
        return "Zoo: [I am a Dog, I am a Cat, I am a Dog]";
    }


}
