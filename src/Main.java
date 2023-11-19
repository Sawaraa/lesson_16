//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.io.PrintStream;
import java.lang.reflect.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {

        Class<Animal> ac = Animal.class;
        Animal animal = new Animal();

        String getName = ac.getName();
        System.out.println("Ім'я " + getName);

        String acString = ac.toString();
        System.out.println(acString);

        int acMidi = ac.getModifiers();
        String mod = Modifier.toString(acMidi);

        System.out.println(mod);
        String packageName = ac.getPackageName();
        System.out.println("Ім'я пакету " + packageName);

        Boolean isLocal = ac.isLocalClass();
        System.out.println("Чи локальний " + isLocal);

        Boolean isArray = ac.isArray();
        System.out.println("Масив "+isArray);

        System.out.println("Приватний "+Modifier.isPrivate(acMidi));
        System.out.println("Абстрактний "+Modifier.isAbstract(acMidi));
        System.out.println("Публічний "+Modifier.isPublic(acMidi));
        System.out.println("Статичний "+Modifier.isStatic(acMidi));

        // отримати коструктор
        Constructor<Animal>[] animalConstructor = (Constructor<Animal>[]) ac.getConstructors();
        System.out.println(Arrays.toString(animalConstructor));

        Constructor<Animal> constructor = animalConstructor[0];
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        for (int i=0; i < parameterTypes.length; i++) {
            Class<?> class1 =  parameterTypes[i];
            System.out.println(class1);
        }

        //отрмати параметри констурктора (але параметри вже отримувались коли викликти сам коструктор)
        Class<?>[] parameterTypes1 = constructor.getParameterTypes();
        for(int i=0; i < parameterTypes1.length; i++){
            Class<?> aClass = parameterTypes1[i];
            System.out.println("Параметри "+aClass);
        }

        //замінемо дані класу Animal

        Constructor<Animal> animalconstructor = ac.getConstructor(String.class, int.class, String.class);
        // створюємо нову тварину
        Animal newAnimal = animalconstructor.newInstance("Name", 20, "breed");
        System.out.println("Не змінений: " + newAnimal);
        // змінюємо вік
        Field ageField = ac.getDeclaredField("age");
        ageField.set(newAnimal, 80);
        System.out.println("Змінений:" + newAnimal);

        //Викличемо методи
        Method[] methods = ac.getMethods();
        for (int i =0; i< methods.length;  i++){
            Method method = methods[i];
            System.out.println(method);
        }

        // methods[1].invoke(newAnimal,"lal" );

    }
}
