package uz.app.quiz.config;



import org.json.simple.JSONObject;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Component
public class PaycomBasicAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {






    @Override
    public void commence(HttpServletRequest request,
                         HttpServletResponse response,
                         AuthenticationException authException)
                                                                throws IOException {

        response.setStatus(200);




       response.setContentType("application/json");
       response.setCharacterEncoding("UTF-8");


        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObjectError = new JSONObject();

        jsonObjectError.put("code", -32504);
        jsonObjectError.put("message", "Auth error");

        jsonObject.put("jsonrpc", "2.0");
        jsonObject.put("error", jsonObjectError);

        String message = jsonObject.toJSONString();

        PrintWriter writer = response.getWriter();
        writer.write(message);





    }

    @Override
    public void afterPropertiesSet()  {
        setRealmName("/payme_api");
        super.afterPropertiesSet();
    }
}
