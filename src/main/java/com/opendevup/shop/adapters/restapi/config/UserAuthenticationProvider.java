package com.opendevup.shop.adapters.restapi.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.opendevup.shop.adapters.persistence.user.JpaUserRepository;
import com.opendevup.shop.adapters.persistence.user.UserEntity;
import com.opendevup.shop.domain.User;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
@Slf4j
public class UserAuthenticationProvider {

    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    private final JpaUserRepository repository;

    @PostConstruct
    protected void init() {
        // this is to avoid having the raw secret key available in the JVM
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(User user) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000 * 24);
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withIssuer(user.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .withClaim("roles", user.getRoles()
                        .stream()
                        .map(role -> role.getName().name())
                        .collect(Collectors.toList())
                )
                .sign(algorithm);
    }

    public String createRefreshToken(User user) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 604800000);
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withIssuer(user.getUsername())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
    }

    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        UserEntity user = UserEntity.builder()
                .username(decoded.getIssuer())
                .build();

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

    public Authentication validateTokenStrongly(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        log.info("secretKey : "+secretKey);
        JWTVerifier verifier = JWT.require(algorithm)
                .build();
        log.info("token : "+token);
        DecodedJWT decoded = verifier.verify(token);
        log.info("username : "+decoded.getIssuer());
        UserEntity user = repository.findByUsername(decoded.getIssuer())
                .orElseThrow();

        return new UsernamePasswordAuthenticationToken(user, null, Collections.emptyList());
    }

}
