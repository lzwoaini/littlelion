package Action;
import JavaBean.Book;
import JavaBean.Conn;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.ServletActionContext;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.annotation.processing.SupportedSourceVersion;
import javax.servlet.http.HttpServletRequest;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookAction extends ActionSupport {
    private Book book;
    private String condition = null;
    private ArrayList<Book> books = new ArrayList<>();
    private boolean submitted = false;
    private String message;

    public String add(){
        try{
            Conn conn = new Conn();
            ResultSet res = conn.executeQuery("select * from book where isbn = '"+book.getIsbn()+"'");
            if(res.next()){
                setMessage("添加图书失败!");
                return ERROR;
            }
            String str = "insert into book values('"+book.getIsbn()+"','"+book.getTitle()+"','"+book.getAuthor()+"',"+book.getPrice()+")";
            conn.executeUpdate(str);
            ActionContext.getContext().getSession().put("book",book);
            setMessage("成功添加书籍:"+book.getTitle()+","+book.getAuthor()+","+book.getPrice()+"元");
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

    public String list(){
            try {
                Conn conn = new Conn();
                if(condition==null||condition.trim().equals("")) {
                    ResultSet res = conn.executeQuery("select * from book");
                    while (res.next()) {
                        Book book = new Book();
                        book.setTitle(res.getString("title"));
                        book.setPrice(Integer.parseInt(res.getString("price")));
                        book.setAuthor(res.getString("author"));
                        book.setIsbn(res.getString("isbn"));
                        books.add(book);
                    }
                }else{
                    String string ="select * from book where (isbn like '%"+condition+"%') or (title like '%"+condition+"%') or (author like '%"+condition+"%') or (price like '%"+condition+"%')";
                    ResultSet res2 = conn.executeQuery(string);
                    while(res2.next()){
                        Book book = new Book();
                        book.setIsbn(res2.getString("isbn"));
                        book.setPrice(Integer.parseInt(res2.getString("price")));
                        book.setAuthor(res2.getString("author"));
                        book.setTitle(res2.getString("title"));
                        books.add(book);
                    }
                    return SUCCESS;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return SUCCESS;
    }

    public String delete(){
        try {
            Conn conn = new Conn();
            conn.executeUpdate("delete from book where isbn = '"+book.getIsbn()+"'");
            ActionContext.getContext().getSession().put("book",book.getTitle());
            list();
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return SUCCESS;
    }

   public String update(){
        try{
            Conn conn = new Conn();
            String string = "update book set title = '"+book.getTitle()+"' , author = '"+book.getAuthor()+"' , price = "+book.getPrice()+" where isbn = '"+book.getIsbn()+"'";
            conn.executeUpdate(string);
            setMessage("修改成功!");
            return SUCCESS;
        }catch (Exception e){
            e.printStackTrace();
        }
        return  SUCCESS;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
