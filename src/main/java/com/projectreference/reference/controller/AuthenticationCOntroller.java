package com.projectreference.reference.controller;

import com.projectreference.reference.Model.AuthenticationRequest1;
import com.projectreference.reference.Model.AuthenticationResponse;
import com.projectreference.reference.MyUserDetailsService;
import com.projectreference.reference.MyuserDetails;
import com.projectreference.reference.Utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationCOntroller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthnticateToken(@RequestParam AuthenticationRequest1 authenticationRequest1) throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest1.getUserName(), authenticationRequest1.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("Incorrect username and password", e);
        }

        final UserDetails userDetails = myUserDetailsService.loadUserByUsername(authenticationRequest1.getUserName());

        final String jwt = jwtUtils.generateToken(userDetails);

        return ResponseEntity.ok(new AuthenticationResponse(jwt));

    }
}
