package com.edutech.eduSoporteProv.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutech.eduSoporteProv.model.Proveedor;
import com.edutech.eduSoporteProv.service.ProveedorService;

@RestController
@RequestMapping("/api/proveedores")
public class ProveedorController {
    @Autowired
    private ProveedorService proveedorService;

    @GetMapping
    public ResponseEntity<List<Proveedor>> getProveedores(){
        List<Proveedor> proveedores = proveedorService.findAll();
        if(!proveedores.isEmpty()){
            return new ResponseEntity<>(proveedores, HttpStatus.OK);
        // si proveedores tiene un objeto
        }
        // si no contiene proveedores
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Proveedor> postProveedor(@RequestBody Proveedor proveedor){
        Proveedor buscado = proveedorService.findxId(proveedor.getId());
        if (buscado == null){
            return new ResponseEntity<>(proveedorService.save(proveedor), HttpStatus.ACCEPTED);
        }   else{
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable int id){
        proveedorService.deletexId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proveedor> getProveedoresXid(@PathVariable int id) {
        Proveedor buscado = proveedorService.findxId(id);
        if(buscado==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(buscado,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proveedor> updateProveedor(@PathVariable int id, @RequestBody Proveedor proveedor) {
        Proveedor existente = proveedorService.findxId(id);
        if (existente == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        existente.setNombre(proveedor.getNombre());
        existente.setCategoria(proveedor.getCategoria());
        existente.setContacto(proveedor.getContacto());
        
        Proveedor actualizado = proveedorService.save(existente);
        return new ResponseEntity<>(actualizado, HttpStatus.OK);
    }
}

