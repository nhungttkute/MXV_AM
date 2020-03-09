package com.newgen.am.controller;

import com.google.gson.Gson;
import com.newgen.am.common.AMLogger;
import com.newgen.am.common.Constant;
import com.newgen.am.common.Utility;
import javax.servlet.http.HttpServletRequest;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.newgen.am.dto.LoginInvestorUserDataDTO;
import com.newgen.am.dto.UserResponseDTO;
import com.newgen.am.dto.AMResponseObj;
import com.newgen.am.dto.DataObj;
import com.newgen.am.dto.LoginInvestorUserResponseDTO;
import com.newgen.am.model.LoginInvestorUser;
import com.newgen.am.repository.MemberRepository;
import com.newgen.am.service.LoginInvestorUserService;
import java.util.Arrays;
import java.util.List;

@RestController
public class LoginInvestorUserController {

    private String className = "LoginInvestorUserController";

    @Autowired
    private LoginInvestorUserService investorUserService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/users/login")
    public AMResponseObj login(@RequestBody LoginInvestorUserDataDTO userDto) {
        String methodName = "login";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: /users/login");
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + Utility.convertObjectToJson(userDto));
        AMResponseObj response = new AMResponseObj();
        try {
            LoginInvestorUserResponseDTO loginUserDto = modelMapper.map(investorUserService.signin(userDto.getUsername(), userDto.getPassword(), refId), LoginInvestorUserResponseDTO.class);
            response.setStatus(Constant.RESPONSE_OK);
            response.setData(new DataObj());
            response.getData().setUser(loginUserDto);
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }

    @DeleteMapping(value = "/users/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public AMResponseObj delete(@PathVariable Long userId) {
        String methodName = "delete";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: /users/delete");
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + userId);
        AMResponseObj response = new AMResponseObj();

        try {
            investorUserService.delete(userId, refId);
            response.setStatus(Constant.RESPONSE_OK);
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }

    @GetMapping(value = "/users/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public AMResponseObj search(@PathVariable Long userId) {
        return getUserInfo(userId);
    }

    @GetMapping(value = "/local/users/{userId}")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public AMResponseObj search2(@PathVariable Long userId) {
        return getUserInfo(userId);
    }

    @GetMapping(value = "/users")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public AMResponseObj list() {
        String methodName = "list";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: /users");
        AMResponseObj response = new AMResponseObj();
        try {
            List<LoginInvestorUser> users = investorUserService.list(refId);
            List<UserResponseDTO> userDtoList = Arrays.asList(modelMapper.map(users, UserResponseDTO[].class));
            response.setStatus(Constant.RESPONSE_OK);
            response.setData(new DataObj());
            response.getData().setUsers(userDtoList);
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        return response;
    }

    @GetMapping("/users/refresh")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_CLIENT')")
    public AMResponseObj refresh(HttpServletRequest req) {
        String methodName = "refresh";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: /users/refresh");
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + req.getRemoteUser());
        AMResponseObj response = new AMResponseObj();
        try {
            String accessToken = investorUserService.refresh(req.getRemoteUser(), refId);
            response.setStatus(Constant.RESPONSE_OK);
            response.setData(new DataObj());
            response.getData().setAccessToken(accessToken);
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }

    @PostMapping("/users/logout/{userId}")
    public AMResponseObj logout(@PathVariable Long userId) {
        String methodName = "logout";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: /users/logout");
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + userId);
        AMResponseObj response = new AMResponseObj();
        try {
            LoginInvestorUser user = investorUserService.search(userId, refId);
            if (user != null) {
                user.setAccessToken(null);
                user.setLogined(false);
                investorUserService.save(user, refId);
                response.setStatus(Constant.RESPONSE_OK);
            } else {
                response.setStatus(Constant.RESPONSE_ERROR);
                response.setErrMsg("This user doesn't exist.");
            }
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }
    
    @PostMapping("/users/verifyPin/{userId}")
    public AMResponseObj verifyPin(@PathVariable Long userId, @RequestBody LoginInvestorUserDataDTO user) {
        String methodName = "verifyPin";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: /users/verifyPin/" + userId);
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + Utility.convertObjectToJson(user));
        AMResponseObj response = new AMResponseObj();
        try {
            if (investorUserService.verifyPin(userId, user.getPin(), refId)) {
                response.setStatus(Constant.RESPONSE_OK);
            } else {
                response.setStatus(Constant.RESPONSE_ERROR);
                response.setErrMsg("Cannot verify Pin.");
            }
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }

    @PostMapping("/users/{userId}/watchlist")
    public AMResponseObj saveWatchList(@PathVariable Long userId, @RequestBody LoginInvestorUserDataDTO input) {
        String methodName = "saveWatchList";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: " + String.format("/users/%s/watchlist", userId));
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + new Gson().toJson(input));
        AMResponseObj response = new AMResponseObj();
        try {
            LoginInvestorUser user = investorUserService.search(userId, refId);
            if (user != null) {
                user.setWatchlists(input.getWatchlists());
                LoginInvestorUser newUser = investorUserService.save(user, refId);
                response.setStatus(Constant.RESPONSE_OK);
                response.setData(new DataObj());
                response.getData().setWatchLists(newUser.getWatchlists());
            } else {
                response.setStatus(Constant.RESPONSE_ERROR);
                response.setErrMsg("This user doesn't exist.");
            }
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }
    
    @PostMapping("/users/{userId}/layout")
    public AMResponseObj saveLayout(@PathVariable Long userId, @RequestBody LoginInvestorUserDataDTO input) {
        String methodName = "saveLayout";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: " + String.format("/users/%s/layout", userId));
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + new Gson().toJson(input));
        AMResponseObj response = new AMResponseObj();
        try {
            LoginInvestorUser user = investorUserService.search(userId, refId);
            if (user != null) {
                if (Utility.isNotNull(input.getLayout())) {
                    user.setLayout(input.getLayout());
                }
                if (Utility.isNotNull(input.getLanguage())) {
                    user.setLanguage(input.getLanguage());
                }
                if (Utility.isNotNull(input.getTheme())) {
                    user.setTheme(input.getTheme());
                }
                if (Utility.isNotNull(input.getFontSize()) && input.getFontSize() > 0) {
                    user.setFontSize(input.getFontSize());
                }
                LoginInvestorUser newUser = investorUserService.save(user, refId);
                response.setStatus(Constant.RESPONSE_OK);
                response.setData(new DataObj());
                response.getData().setLayout(newUser.getLayout());
                response.getData().setLanguage(newUser.getLanguage());
                response.getData().setTheme(newUser.getTheme());
                response.getData().setFontSize(newUser.getFontSize());
            } else {
                response.setStatus(Constant.RESPONSE_ERROR);
                response.setErrMsg("This user doesn't exist.");
            }
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }
    
    @PostMapping("/users/{userId}/password")
    public AMResponseObj changePassword(@PathVariable Long userId, @RequestBody LoginInvestorUserDataDTO input) {
        String methodName = "changePassword";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API: " + String.format("/users/%s/password", userId));
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + new Gson().toJson(input));
        AMResponseObj response = new AMResponseObj();
        try {
            LoginInvestorUser user = investorUserService.search(userId, refId);
            if (user != null) {
                user.setLayout(input.getLayout());
                LoginInvestorUser newUser = investorUserService.save(user, refId);
                response.setStatus(Constant.RESPONSE_OK);
                response.setData(new DataObj());
                response.getData().setLayout(newUser.getLayout());
            } else {
                response.setStatus(Constant.RESPONSE_ERROR);
                response.setErrMsg("This user doesn't exist.");
            }
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }

    private LoginInvestorUserResponseDTO clearAccessTokenInfo(LoginInvestorUserResponseDTO user) {
        user.setAccessToken(null);
        user.setTokenExpiration(0l);
        return user;
    }

    private AMResponseObj getUserInfo(Long userId) {
        String methodName = "search";
        long refId = System.currentTimeMillis();
        AMLogger.logMessage(className, methodName, refId, "REQUEST_API:" + String.format("/users/%s", userId));
        AMLogger.logMessage(className, methodName, refId, "INPUT:" + userId);
        AMResponseObj response = new AMResponseObj();
        try {
            LoginInvestorUserResponseDTO user = modelMapper.map(investorUserService.search(userId, refId), LoginInvestorUserResponseDTO.class);

            response.setStatus(Constant.RESPONSE_OK);
            response.setData(new DataObj());
            response.getData().setUser(clearAccessTokenInfo(user));
        } catch (Exception ex) {
            AMLogger.logError(className, methodName, refId, ex);
            response.setStatus(Constant.RESPONSE_ERROR);
            response.setErrMsg(ex.getMessage());
        }
        AMLogger.logMessage(className, methodName, refId, "OUTPUT:" + Utility.convertObjectToJson(response));
        return response;
    }
   
}
