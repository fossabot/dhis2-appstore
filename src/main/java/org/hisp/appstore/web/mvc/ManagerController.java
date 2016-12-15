package org.hisp.appstore.web.mvc;

import org.hisp.appstore.api.domain.User;
import org.hisp.appstore.session.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by zubair on 09.12.16.
 */
@Controller
@RequestMapping ( value = "/manager" )
public class ManagerController
{
    @RequestMapping( method = RequestMethod.GET )
    public String managerIndex( Model model, Authentication authentication )
    {

        User currentUser = (User) authentication.getPrincipal();

        model.addAttribute( "message", currentUser.getFirstName() );

        return "manager";
    }
}