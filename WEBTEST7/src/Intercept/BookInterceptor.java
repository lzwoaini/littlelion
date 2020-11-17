package Intercept;

import Action.BookAction;
import JavaBean.Book;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import com.sun.org.apache.xpath.internal.Arg;

import java.util.Map;

public class BookInterceptor extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        BookAction bookAction = (BookAction) actionInvocation.getAction();
        Book book = bookAction.getBook();
        if (book.getPrice() <= 10) {
            bookAction.setMessage("图书价格必须大于十元");
            return Action.INPUT;
        }
        return actionInvocation.invoke();
    }
}