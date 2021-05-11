package net.imwork.zhanlong.interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

/**
 * @author 展龙
 */
public class TheInterceptor1 extends AbstractInterceptor
{
    private static final String NAME = "hello";
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception
    {
        String p = (String) ServletActionContext.getRequest().getSession().getAttribute("p");

        if (NAME.equals(p))
        {
            return actionInvocation.invoke();
        }
        return "input";
    }
}
