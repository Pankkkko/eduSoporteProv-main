package com.edutech.eduSoporteProv.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.edutech.eduSoporteProv.model.Usuario;
import com.edutech.eduSoporteProv.service.GestionRolesService;


@RestController
@RequestMapping("/api/rol")
public class GestionRolesController {
    // agregar funciones get y put para obtener y modificar los roles de los usuarios

    @Autowired
    private GestionRolesService gestionRolesService;

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioXid(@PathVariable int id) {
        Usuario buscado = gestionRolesService.findxId(id);
        if (buscado == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buscado, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable int id, @RequestBody Usuario usuario) {
        Usuario existente = gestionRolesService.findxId(id);
        if(existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existente.setRolUsuario(usuario.getRolUsuario());

        Usuario actualizado = gestionRolesService.save(existente);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}
