package com.cjsecurite.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(value="*")
@RestController
@PreAuthorize("hasRole('ROLE_securityAgent')")
@RequestMapping("/ano")
public class SimpleUser {
	

}
