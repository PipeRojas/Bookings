package org.adaSchool.bookings.controller.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilterRequest extends OncePerRequestFilter {
    @Autowired
    private JWTGenerate jwtGenerate;

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String autorizationHeader = request.getHeader("Authorization");
        if(autorizationHeader != null && autorizationHeader.startsWith("Bearer")){
            String jwt = autorizationHeader.substring(7);
            String username = jwtGenerate.getUsername(jwt);
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null){
                UserDetails user = userDetailsService.loadUserByUsername(username);
                if(jwtGenerate.validateToken(jwt,user)) {
                    SecurityContextHolder.getContext().setAuthentication(new TokenAuthentication(jwt, username, null));
                    request.setAttribute("claims", jwtGenerate.getClaim(jwt));
                    request.setAttribute("subject", jwtGenerate.getClaim(jwt).getSubject());
                    request.setAttribute("roles",  null);
                }
            }
        }
        filterChain.doFilter(request,response);
    }
}
