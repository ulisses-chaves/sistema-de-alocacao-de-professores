/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Hirukar.Project.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author RODEMARCK
 */

@RestController
@RequestMapping("/api/ajaxrest")//api/ajaxrest/index_testes
public class AjaxRestController {
    @RequestMapping(value = "/index_testes", method = RequestMethod.GET, produces = {MimeTypeUtils.TEXT_PLAIN_VALUE})
    public ResponseEntity<String> index1(){
        ResponseEntity<String> re = null;
        re = new ResponseEntity<String>("index_testes",HttpStatus.OK);
        return re;
    }
}
