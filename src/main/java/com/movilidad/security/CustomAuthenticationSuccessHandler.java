package com.movilidad.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

/**
 *
 * @author Omar.beltran
 */
@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        
        String targetUrl = determineTargetUrl(authentication);
        response.sendRedirect(targetUrl);
    }

    protected String determineTargetUrl(Authentication authentication) {
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        
        for (GrantedAuthority grantedAuthority : authorities) {
            switch (grantedAuthority.getAuthority()) {
                case "ROLE_ACC_ABO":
                    return "/acc/accidente/master.jsf?faces-redirect=true";
                case "ROLE_MTTO":
                    return "/mtto/clasificNovMtto/list.jsf?faces-redirect=true";
                case "ROLE_SEG":
                    return "acc/accidente/master.jsf?faces-redirect=true";
                case "ROLE_LIQ":
                    return "genericaJornada/ControlJornada.jsf?faces-redirect=true";
                case "ROLE_TC":
                    return "empleado/empleadoTabla.jsf?faces-redirect=true";
                default:
                    break;
            } 
        }
        // Página por defecto si no coincide con ningún rol específico
        return "/panelPrincipal/panelPrincipal.jsf?faces-redirect=true";
    }
}