package com.jaspersoft.rest.client.integration.web;

import com.jaspersoft.jasperserver.dto.authority.ClientUser;
import com.jaspersoft.rest.client.integration.service.JSRestClientService;
import com.jaspersoft.rest.client.integration.service.TableTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Alexander Krasnyanskiy
 */
@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private TableTitleService tableTitleService;

    @Autowired
    private JSRestClientService restService;

    @RequestMapping(method = RequestMethod.GET)
    public String getUsers(Model model) {

        List<ClientUser> users = restService.configure()
                .usersService()
                .allUsers()
                .get()
                .entity()
                .getUserList();

        model.addAttribute("users", users);
        model.addAttribute("tableTitle", tableTitleService.getTitle());

        return "users";
    }
}