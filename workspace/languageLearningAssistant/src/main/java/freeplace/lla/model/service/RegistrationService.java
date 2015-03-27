package freeplace.lla.model.service;

import freeplace.lla.model.constants.ApplicationRoles;
import freeplace.lla.model.data.service.LanguageServiceImpl;
import freeplace.lla.model.data.service.RoleServiceImpl;
import freeplace.lla.model.data.service.UserAccountServiceImpl;
import freeplace.lla.model.data.service.UserServiceImpl;
import freeplace.lla.model.entities.UserAccount;
import freeplace.lla.model.springforms.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by klymenko.ruslan on 26.03.2015.
 */
@Service
public class RegistrationService {

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private RoleServiceImpl roleService;

    @Autowired
    private UserAccountServiceImpl userAccountService;

    @Autowired
    private LanguageServiceImpl languageService;

    public UserServiceImpl getUserService() {
        return userService;
    }

    public void setUserService(UserServiceImpl userService) {
        this.userService = userService;
    }

    public RoleServiceImpl getRoleService() {
        return roleService;
    }

    public void setRoleService(RoleServiceImpl roleService) {
        this.roleService = roleService;
    }

    public UserAccountServiceImpl getUserAccountService() {
        return userAccountService;
    }

    public void setUserAccountService(UserAccountServiceImpl userAccountService) {
        this.userAccountService = userAccountService;
    }

    public LanguageServiceImpl getLanguageService() {
        return languageService;
    }

    public void setLanguageService(LanguageServiceImpl languageService) {
        this.languageService = languageService;
    }

    public void createNewUserWithAccount(User user) {
        freeplace.lla.model.entities.User userModel = new freeplace.lla.model.entities.User();
        userModel.setName(user.getName());
        userModel.setLastName(user.getLastName());
        userModel.setEmail(user.getEmail());
        userModel.setLogin(user.getLogin());
        userModel.setPassword(user.getPassword());
        userModel.setRole(roleService.findByName(ApplicationRoles.ROLE_USER.name()));
        userModel.setNativeLanguage(languageService.findByName(user.getNativeLanguage()));
        //Create new account for user
        UserAccount userAccount = setUpNewUserAccount();
        userAccountService.add(userAccount);
        userModel.setUserAccount(userAccount);
        // Create user
        userService.add(userModel);

    }

    private UserAccount setUpNewUserAccount() {
        UserAccount userAccount = new UserAccount();
        userAccount.setIsEnabled(true);
        userAccount.setIsExpired(false);
        userAccount.setIsExpiredCredentials(false);
        userAccount.setIsLocked(false);

        return userAccount;
    }
}
