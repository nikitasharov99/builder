package ru.netology;

public class Main {
    public static void main(String[] args) {
        Person father = new PersonBuilder()
                .setName("Иван")
                .setSurname("Иванов")
                .setAge(25)
                .setAddress("Москва")
                .build();
        Person son = father.newChildBuilder()
                .setName("Петя")
                .build();
        Person daughter = father.newChildBuilder()
                .setName("Аня")
                .setAddress("Пермь")
                .setAge(10)
                .build();

        System.out.println("У " + father + " есть сын, " + son);
        System.out.println("У " + father + " есть дочь, " + daughter);

        //спустя год =)
        father.happyBirthday();
        son.happyBirthday();
        daughter.happyBirthday();

        System.out.println();
        System.out.println("У " + father + " есть сын, " + son);
        System.out.println("У " + father + " есть дочь, " + daughter);


        try {
            //Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            //Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}
