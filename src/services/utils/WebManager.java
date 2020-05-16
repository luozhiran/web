package services.utils;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;

public class WebManager {

    public static int plugCounter(ServletContext servletContext) {
        Integer counter = (Integer) servletContext.getAttribute("counter");
        if (counter == null) {
            counter = 1;
        } else {
            counter = counter + 1;
        }
        servletContext.setAttribute("counter", counter);

        return counter;
    }
}
