package com.edutech.eduSoporteProv.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.eduSoporteProv.model.Usuario;
import com.edutech.eduSoporteProv.service.UsuarioService;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    
    @GetMapping
    public ResponseEntity <List<Usuario>> getUsuarios(){
        List<Usuario> usuarios = usuarioService.findAll();
        if(!usuarios.isEmpty()){
            return ResponseEntity.ok(usuarios);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Usuario> postUsuario(@RequestBody Usuario usuario){
        Usuario buscado = usuarioService.findxId(usuario.getId());
        if(buscado == null){
            return new ResponseEntity<>(usuarioService.save(usuario), HttpStatus.ACCEPTED);
        }   else{
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable int id){
        usuarioService.deletexId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioXid(@PathVariable int id) {
        Usuario buscado = usuarioService.findxId(id);
        if(buscado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buscado,HttpStatus.OK);
    }   
}
