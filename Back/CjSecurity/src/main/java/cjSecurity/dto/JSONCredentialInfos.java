package cjSecurity.dto;

import java.util.HashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JSONCredentialInfos {

	private String login;
	private Set<String> roles = new HashSet<String>();

    public void addRole(String role) {
        if (role != null && !role.isEmpty())
            roles.add("ROLE_"+role);
    }
}
