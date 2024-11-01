package jwp.controller.user;

import core.mvc.Controller;
import core.mvc.view.JspView;
import core.mvc.view.View;
import jwp.dao.UserDao;
import jwp.model.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UpdateUserController implements Controller {

    private final UserDao userDao = new UserDao();

    @Override
    public View execute(HttpServletRequest req, HttpServletResponse resp) throws Exception {
        User modifiedUser = new User(
                req.getParameter("userId"),
                req.getParameter("password"),
                req.getParameter("name"),
                req.getParameter("email"));
        userDao.update(modifiedUser);
        return new JspView("redirect:/user/list");
    }
}