package com.ecommerce.controller;


import com.ecommerce.controller.dto.request.Auth.AuthRequestDTO;
import com.ecommerce.controller.dto.response.AuthResponseDTO;
import com.ecommerce.controller.dto.response.ResponseDTO;
import com.ecommerce.controller.dto.response.StatusDTO;
import com.ecommerce.domain.service.AuthService;
import com.ecommerce.config.JwtTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api")
@CrossOrigin(origins= "*" , allowedHeaders = "*")
@RestController
@Validated
@Api(value = "Ecommerce - Auth", description = "Operations pertaining to Auth", tags = "Auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private JwtTokenService jwtTokenService;

    @CrossOrigin(origins= "*" , allowedHeaders = "*")
    @ApiOperation(value = "Auth.", response = ResponseDTO.class)
    @RequestMapping(value = "/v1/ecommerce/auth", method = RequestMethod.POST)
    public AuthResponseDTO auth(
            @RequestBody @Valid AuthRequestDTO authRequestDTO
    ){
        AuthResponseDTO authResponseDTO  = new AuthResponseDTO();
        StatusDTO statusDTO = new StatusDTO();
        try {

            UserDetails userDetails = authService.loadUserByUsername(authRequestDTO.getEmail());
            if (userDetails != null && authRequestDTO.getPassword().equals(userDetails.getPassword())) {
                String token = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKQUlSTyBBTkRSRVMgU09URUxPIEZMT1JFWiIsImlhdCI6MTcyNjAwNzgyMywidXNlci1kZXRhaWwiOnsiYXBwbGljYXRpb25Db2RlIjoxLCJ1c2VyQ29kZSI6MTA1NywicHJvZmlsZUNvZGUiOjEsImRvY3VtZW50VHlwZSI6MSwiZG9jdW1lbnROdW1iZXIiOiIxMDAwOTgzNTkyIiwiYWN0aXZlIjp0cnVlLCJ1c2VyIjoiSkFJUk8gQU5EUkVTIFNPVEVMTyBGTE9SRVoiLCJwYXNzd29yZCI6IjBmYzUyYTExYzMxODQ1MTEyNTRmMTAxOTBkMThmYTQyIn0sImV4cCI6MTcyNjA5NzgyM30.moDc_IP5rM1ihtc3BywgTvMDRh6pdq7NRfZGV44cSlc";
                //jwtTokenService.generateToken(userDetails);
                authResponseDTO.setToken(token);
                authResponseDTO.setRol("Admin");
                return authResponseDTO;
            } else {
                throw new RuntimeException("Invalid credentials");
            }
        }catch (Exception e){
            statusDTO.setCode("404");
            statusDTO.setDetailMessageError(e.getMessage());
            authResponseDTO.setStatusDTO(statusDTO);
            return authResponseDTO;
        }
    }



}
