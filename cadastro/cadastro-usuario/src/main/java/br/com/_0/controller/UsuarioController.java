package br.com._0.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com._0.business.UsuarioService;
import br.com._0.infrastructure.entity.Usuario;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/Usuarios")
@RequiredArgsConstructor //para contrutor porta 8080

public class UsuarioController {
        //para intejar a dependencia do usuarioService
    private final UsuarioService usuarioService;
    //4 verbos do http
    @PostMapping //gravar dados
    public ResponseEntity<Void>salvarUsuario(@RequestBody Usuario usuario){
        usuarioService.salvarUsuario(usuario);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<Usuario>buscarUsuarioPorEmail(@RequestParam String email){
        return ResponseEntity.ok(usuarioService.buscarUsuarioPorEmail(email));
    }
    @DeleteMapping
    public ResponseEntity<Void>deletarUsuarioPorEmail(@RequestParam String email){
        usuarioService.detelarUsuarioPorEmail(email);
        return ResponseEntity.ok().build();
    }
    @PutMapping
    public ResponseEntity<Void>atualizarUsuarioPorId(@RequestParam Integer id,@RequestBody Usuario usuario){
        usuarioService.atualizarUsuarioPorId(id, usuario);
        return ResponseEntity.ok().build();
    }


}
