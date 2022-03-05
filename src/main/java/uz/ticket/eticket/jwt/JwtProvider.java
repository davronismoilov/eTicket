package uz.ticket.eticket.jwt;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import uz.ticket.eticket.entity.user.User;
import uz.ticket.eticket.repository.user.UserRepository;

import java.util.Date;

@Component
public class JwtProvider {
    @Value("${jwt.secret.key}")
    private String secretKey;

    @Value("${jwt.expiry.date}")
    private long expiryDate;


    @Autowired
    UserRepository userRepository;


    public String generateToken(User user) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiryDate))
                .setSubject(user.getUsername())
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();

    }

    public User parseToken(String token) {
        // tokenni tekshirish
        if (!validateJwtToken(token))
            return null;


        // vaqtni tekshirish
        if (checkExpiryDate(token))
            return null;


        String username = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();


        return userRepository.findByUsername(username).orElse(null);

    }


    private boolean validateJwtToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (
                ExpiredJwtException |
                        UnsupportedJwtException |
                        MalformedJwtException |
                        SignatureException |
                        IllegalArgumentException e) {

            return false;
        }
    }

    private boolean checkExpiryDate(String authToken) {

        Date expiration = Jwts.parser().
                setSigningKey(secretKey).
                parseClaimsJws(authToken).
                getBody().getExpiration();

        return System.currentTimeMillis() > expiration.getTime();
    }


}
