package edu.csun.comp182;

import java.util.LinkedList;

public class Book  implements Comparable<Book>{

    private final String title;


    public Book(String Title_arg){
        title = Title_arg;
    }

    @Override
    public boolean equals(Object other){
        if (this == other)
            return true;

        if (other instanceof Book) {
            Book otherbook = (Book) other;

            return title.equals(otherbook .title);

        }else {

            return false;
        }
    }
    @Override
    public int compareTo(Book o){
        return title.compareTo(o.title);
    }


}
