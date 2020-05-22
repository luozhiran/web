package services.filter;


import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class CharsetEncodingFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.err.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.err.println("|  初始化CharsetEncodingFilter过滤器              |");
        encoding = filterConfig.getInitParameter("encoding");
        System.err.println("|_______________________________________________|\n\n");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding(encoding);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.err.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
        System.err.println("|  销毁CharsetEncodingFilter过滤器                |");
        System.err.println("|_______________________________________________|\n\n");
    }
}
