package com.example.barbershop.config.jwt;

import com.example.barbershop.config.CustomAccountDetails;
import com.example.barbershop.service.CustomAccountDetailService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.util.StringUtils.hasText;

@Component
@Log
public class JwtFilter extends GenericFilterBean {

    public static final String AUTHORIZATION = "Authorization";

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    private CustomAccountDetailService customAccountDetailService;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        logger.info("do filter");
        String token = getTokenFromRequest((HttpServletRequest) servletRequest);
        if (token!=null && jwtProvider.validateToken(token)){
            String accountEmail = jwtProvider.getEmailFromToken(token);
            CustomAccountDetails customAccountDetails = customAccountDetailService.loadUserByUsername(accountEmail);
            UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(customAccountDetails, null, customAccountDetails.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private String getTokenFromRequest(HttpServletRequest request){
        String bearer = request.getHeader(AUTHORIZATION);
        if(hasText(bearer) && bearer.startsWith("Bearer ")){
            return bearer.substring(7);
        }
        return null;
    }

}
