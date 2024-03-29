package edu.eci.IETILAB021.controller.auth;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.IETILAB021.data.User;
import edu.eci.IETILAB021.dto.LoginDto;
import edu.eci.IETILAB021.dto.TokenDto;
import edu.eci.IETILAB021.exception.InvalidCredentialsException;
import edu.eci.IETILAB021.service.UserService;

import java.util.Calendar;
import java.util.Date;

import static edu.eci.IETILAB021.data.Constants.CLAIMS_ROLES_KEY;
import static edu.eci.IETILAB021.data.Constants.TOKEN_DURATION_MINUTES;

@RestController
@RequestMapping( "/v1/auth" )
public class AuthController
{

    @Value( "clave123" )
    String secret;

    private final UserService userService;

    public AuthController( @Autowired UserService userService )
    {
        this.userService = userService;
    }

    @PostMapping
    public TokenDto login( @RequestBody LoginDto loginDto )
    {
        User user = userService.findByEmail( loginDto.getEmail() );
        if ( BCrypt.checkpw( loginDto.getPassword(), user.getPasswordHash() ) )
        {
            return generateTokenDto( user );
        }
        else
        {
            throw new InvalidCredentialsException();
        }

    }

    private String generateToken( User user, Date expirationDate )
    {
        return Jwts.builder()
            .setSubject( user.getId() )
            .claim( CLAIMS_ROLES_KEY, user.getRoles() )
            .setIssuedAt(new Date() )
            .setExpiration( expirationDate )
            .signWith( SignatureAlgorithm.HS256, secret )
            .compact();
    }

    private TokenDto generateTokenDto( User user )
    {
        Calendar expirationDate = Calendar.getInstance();
        expirationDate.add( Calendar.MINUTE, TOKEN_DURATION_MINUTES );
        String token = generateToken( user, expirationDate.getTime() );
        return new TokenDto( token, expirationDate.getTime() );
    }
}