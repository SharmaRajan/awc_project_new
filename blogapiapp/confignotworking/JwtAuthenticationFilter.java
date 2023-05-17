package com.codewithrajan.blogapiapp.confignotworking;

import com.codewithrajan.blogapiapp.security.CustomUserDetailServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private CustomUserDetailServiceImpl userDetailsService;

    @Autowired
    private JwtTokenHelper jwtTokenHelper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String userName = null;

        String jwtToken = null;

        // 1. get jwt jwtToken from request
        final String requestToken = request.getHeader("Authorization");

        // Bearer 12d2efq2eq
        System.out.println("Request Token: " + requestToken);// for our purpose

        // 2. validate jwtToken
        if(requestToken != null && requestToken.startsWith("Bearer ")){
            // this is the real jwtToken without Bearer
                jwtToken = requestToken.substring(7);

                try{
                    // 3. get user from jwtToken
                    userName = this.jwtTokenHelper.getUsernameFromToken(jwtToken);
                }catch (IllegalArgumentException exc){
                    System.out.println("Unable to get jwt jwtToken");
                }catch (ExpiredJwtException exc){
                    System.out.println("Jwt jwtToken has expired");
                }catch (MalformedJwtException exc){
                    System.out.println("Invalid jwt");
                }catch (RuntimeException e){
                    e.printStackTrace();
                }
        }else{
            System.out.println("JwtToken does begin with bearer");
        }

        // once we get the jwtToken, now we validate
        if(userName != null && SecurityContextHolder.getContext().getAuthentication() != null){

            // 4. load user associated with jwtToken
            final UserDetails userDetails = this.userDetailsService.loadUserByUsername(userName);

                if(this.jwtTokenHelper.validateToken(jwtToken,userDetails)){
                    // sahi chal raha hai
                    // authentication karna hai
                    // SecurityContextHolder will authenticate

                    // 5. set spring security

                    UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                    usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                    SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
                    //
                }else{
                    System.out.println("Invalid jwt jwtToken");
                }
        }else{
            System.out.println("UserName is null or context is not null");
        }

        filterChain.doFilter(request,response);
    }
}
