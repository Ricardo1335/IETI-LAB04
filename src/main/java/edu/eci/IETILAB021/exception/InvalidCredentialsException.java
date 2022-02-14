package edu.eci.IETILAB021.exception;


import org.springframework.http.HttpStatus;

import edu.eci.IETILAB021.data.ErrorCodeEnum;
import edu.eci.IETILAB021.dto.ServerErrorResponseDto;
import javax.ws.rs.InternalServerErrorException;

public class InvalidCredentialsException extends InternalServerErrorException
{
   public InvalidCredentialsException() {

      super(new ServerErrorResponseDto("User not found", ErrorCodeEnum.USER_NOT_FOUND, HttpStatus.NOT_FOUND).getMessage());

   }
}
