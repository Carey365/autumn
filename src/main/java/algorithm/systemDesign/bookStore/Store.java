package algorithm.systemDesign.bookStore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Store {
    private Integer id;
    private String name;
    private Map<BookType, List<Integer>> bookTypeList;
    private Map<String,Book> bookNameMap;
    public Store(Integer id,String name){
        this.id = id;
        this.name = name;
        bookTypeList = new HashMap<>();
        bookNameMap = new HashMap<>();
    }
    public void addBook(Book book){
        if(!bookTypeList.containsKey(book.type)){
            bookTypeList.put(book.type,new ArrayList<>());
        }
        bookTypeList.get(book.type).add(book.id);
        book.status = BookStatus.ONSALE;
        bookNameMap.put(book.name,book);
    }
    public List<Integer> getBook(BookType type){
        return bookTypeList.get(type);
    }

    public Boolean buyBook(User user,Book book){
        //参数校验
        if(!bookNameMap.containsKey(book.name)){
            System.out.print("书本不存在");
            return Boolean.FALSE;
        }
        //操作数据库
        book.inventory--;
        return Boolean.TRUE;
    }

}
