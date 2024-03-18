package org.nqh.asm2.config;

import java.util.ArrayList;
import java.util.List;
import org.nqh.asm2.pojo.User;
import org.nqh.asm2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private static final org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(CustomUserDetailsService.class);

    @Autowired
    private UserRepository userRepository; 

    @Override
    public CustomUserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // Tìm kiếm user theo email
        User user = userRepository.findByEmail(email);
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRoleByRoleId().getRoleName()));

        // Truyền danh sách authorities vào hàm tạo User
        CustomUserDetails userDetails = new CustomUserDetails(user, authorities);
        // Log kết quả
        logger.info("loadUserByUsername result: {}", userDetails);
        return userDetails;
    }
}