package algorithm.systemDesign.bookStore;

import java.math.BigDecimal;

public class Book {
    public Integer id;
    public String name;
    public String authorName;
    public int sourceId;
    public String sourceName;
    public BigDecimal price;
    public BookStatus status;
    public BookType type;
    public int inventory;

    public Book(Integer id,String name,BookType type){
        this.id = id;
        this.name = name;
        this.type = type;
        this.inventory = 100;
    }

}
