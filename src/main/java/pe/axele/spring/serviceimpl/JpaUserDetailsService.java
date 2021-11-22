package pe.axele.spring.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.axele.spring.model.Role;
import pe.axele.spring.model.Users;
import pe.axele.spring.repository.IUsersRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {
	@Autowired
	private IUsersRepository usuarioRepository;
	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(String nameUsers) throws UsernameNotFoundException {
		Users usuario = usuarioRepository.findByUsername(nameUsers);
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Role role : usuario.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getAuthorityRol()));
		}
		return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(),true,true,true,authorities);
	}

}
