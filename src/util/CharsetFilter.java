package util;

import javax.servlet.*;
import java.io.IOException;

/**
 * 过滤器用于设置http请求和响应的编码方式
 */
public class CharsetFilter implements Filter {

    private String encoding;

    public void init(FilterConfig config) throws ServletException {
        encoding = config.getInitParameter("requestEncoding");
        if (encoding == null) encoding = "UTF-8";
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain next)
            throws IOException, ServletException {
        // 请求编码
        if (null == request.getCharacterEncoding()) {
            request.setCharacterEncoding(encoding);
        }

        // 响应编码
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        next.doFilter(request, response);
    }

    public void destroy() {
    }
}