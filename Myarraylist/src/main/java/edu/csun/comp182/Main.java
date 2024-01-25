package edu.csun.comp182;



public class Main {
    public static void main(String[] args) {
        MyArrayList<Book> mylist = new MyArrayList<>();
        Book mybook = new Book("War and Peace");

        System.out.println("List size = " + mylist.size());
        mylist.add(mybook);
        System.out.println("List size = " + mylist.size());

        Book another = new Book("War and Peace");


        mylist.contains(another);



    }
}