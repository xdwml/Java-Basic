package cn.itcast.travel.web.servlet;

import cn.itcast.travel.domain.ResultInfo;
import cn.itcast.travel.domain.User;
import cn.itcast.travel.service.UserService;
import cn.itcast.travel.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user/*")//能匹配/user/add或者 /user/find
public class UserServlet extends BaseServlet {
    //声明UserService业务对象
    private UserService service=new UserServiceImpl();
    /**
     * 注册功能
     * @param request
     * @param response
     * @throws IOException
     */
    public void regist(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //验证码校验
        //从前台获取验证码
        String check=request.getParameter("check");
        //从session中获取验证码
        HttpSession session = request.getSession();
        String checkcode_server = (String) session.getAttribute("CHECKCODE_SERVER");
        session.removeAttribute("CHECKCODE_SERVER");//用完移除验证码，为了保证验证码只能使用一次
        //比较验证码是否一致,忽略大小写
        if(checkcode_server==null||!checkcode_server.equalsIgnoreCase(check)){
            //验证码错误
            ResultInfo info=new ResultInfo();
            //验证失败
            info.setFlag(false);
            info.setErrorMsg("验证码错误！");
            //将info对象序列化为json
            ObjectMapper mapper=new ObjectMapper();
            String json=mapper.writeValueAsString(info);
            //将json数据写回客户端
            response.setContentType("application/json;charset=utf-8");//设置content-type
            response.getWriter().write(json);
            return;
        }
        //1.获取数据
        Map<String,String[]> map=request.getParameterMap();
        //2.封装对象
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //3.调用service完成注册
        //UserService service=new UserServiceImpl();//统一声明
        boolean flag=service.regist(user);
        ResultInfo info=new ResultInfo();
        //4.响应结果
        if(flag){
            //注册成功
            info.setFlag(true);
        }else{
            //注册失败
            info.setFlag(false);
            info.setErrorMsg("注册失败！");
        }
        //将info对象序列化为json
        ObjectMapper mapper=new ObjectMapper();
        String json=mapper.writeValueAsString(info);
        //将json数据写回客户端
        response.setContentType("application/json;charset=utf-8");//设置content-type
        response.getWriter().write(json);
    }

    /**
     * 登录功能
     * @param request
     * @param response
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取用户名和密码数据
        Map<String,String[]> map = request.getParameterMap();
        //2.封装User对象
        User user=new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //3.调用Service查询
        //UserService service=new UserServiceImpl();//统一声明
        User u=service.login(user);//数据比较全的U对象

        ResultInfo info=new ResultInfo();
        //4.判断用户对象是否为null
        if(u == null ){
            //用户名密码错误
            info.setFlag(false);
            info.setErrorMsg("用户名或密码错误！");
        }
        //5.判断用户是否激活
        if(u !=null && !"Y".equals(u.getStatus()) ){
            //用户尚未激活
            info.setFlag(false);
            info.setErrorMsg("您尚未激活，请激活！");
        }
        //6.判断登陆成功
        if(u !=null && "Y".equals(u.getStatus()) ){
            request.getSession().setAttribute("user",u);//登录成功标记
            //登录成功
            info.setFlag(true);

        }
        //响应数据
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");//设置content-type
        mapper.writeValue(response.getOutputStream(),info);
    }

    /**
     * 查找单个对象
     * @param request
     * @param response
     * @throws IOException
     */
    public void findOne(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //从session中获取登录用户
        Object user = request.getSession().getAttribute("user");
        //将user写回客户端
        ObjectMapper mapper=new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");//设置content-type
        mapper.writeValue(response.getOutputStream(),user);
    }

    /**
     * 退出功能
     * @param request
     * @param response
     * @throws IOException
     */
    public void exit(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.销毁session
        request.getSession().invalidate();
        //2.跳转登录页面
        response.sendRedirect(request.getContextPath()+"/login.html");
    }

    /**
     * 激活功能
     * @param request
     * @param response
     * @throws IOException
     */
    public void active(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //1.获取激活码
        String code = request.getParameter("code");
        if(code!=null){
            //2.调用service完成激活
            //UserService service=new UserServiceImpl();//统一声明
            boolean flag=service.active(code);
            //3.判断标记
            String msg=null;
            if(flag){
                //激活成功
                msg="激活成功，请<a href='login.html'>登录</a>";
            }else{
                //激活失败
                msg="激活失败，请联系管理员！";
            }
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write(msg);
        }
    }
}
