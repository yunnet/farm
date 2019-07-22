package com.farm.auth.server.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.farm.auth.server.service.AuthService;
import com.farm.auth.server.util.user.JwtAuthenticationRequest;
import com.farm.common.msg.ObjectRestResponse;

/**
 * 版权所有: 2018 ® iot Company  <br />
 * 单元名称: AuthController.java  <br />
 * 说        明:  <br />
 * 作        者: yunnet <br />
 * 创建时间: 2018-09-04 13:51:14 <br />
 * 最后修改: 2018-09-04 13:51:14 <br />
 * 修改历史: <br />
 */
@RestController
@RequestMapping("jwt")
public class AuthController {
	private final static Logger logger = LoggerFactory.getLogger(AuthController.class);
	
	@Value("${jwt.token-header}")   //Authorization
    private String tokenHeader;

    @Autowired
    private AuthService authService;
    
    /**
     * 创建token
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/token", method = RequestMethod.POST)
    public ObjectRestResponse<String> createAuthenticationToken(@RequestBody JwtAuthenticationRequest request)throws Exception{
    	logger.info("{} require logging...", request.getUsername());
    	
    	String token = authService.login(request);
    	return new ObjectRestResponse<String>().data(token);
    }
    
    /**
     * 刷新重新获取token
     * @param request
     * @return
     * @throws Exception
     */
	@RequestMapping(value = "/refresh", method = RequestMethod.GET)
    public ObjectRestResponse<String> refreshAndGetAuthenticationToken(HttpServletRequest request)throws Exception{
    	String token = request.getHeader(this.tokenHeader);
        String refreshedToken = authService.refresh(token);
        return new ObjectRestResponse<String>().data(refreshedToken);
    }
    
	/**
	 * 验证token
	 * @param token
	 * @return
	 * @throws Exception
	 */
    @RequestMapping(value = "/verify", method = RequestMethod.GET)
    public ObjectRestResponse<?> verify(String token) throws Exception{
    	authService.validate(token);
    	return new ObjectRestResponse<>();
    }
}