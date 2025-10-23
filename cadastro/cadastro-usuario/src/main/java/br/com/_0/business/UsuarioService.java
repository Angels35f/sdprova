package br.com._0.business;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com._0.infrastructure.entity.Usuario;
import br.com._0.infrastructure.repository.UsuarioRepository;

@Service
public class UsuarioService {

    private final UsuarioRepository repository;

    public UsuarioService(UsuarioRepository repository) {
        this.repository = repository;
    }

    //método de salvar
    public void salvarUsuario(Usuario usuario){
        repository.saveAndFlush(usuario);
        }
    //buscar usuario
    public Usuario buscarUsuarioPorEmail(String email){
        return repository.findByEmail(email).orElseThrow(
        ()-> new RuntimeException("Email não encontrado!")
    );
    }
    //deletar usuario por e-mail
    public void detelarUsuarioPorEmail(String email){
        repository.deleteByEmail(email);
    }
    //atualizar usuario
    public void atualizarUsuarioPorId(Integer id,Usuario usuario){
        Usuario usuarioEntity = repository.findById(id).orElseThrow(
            ()-> new RuntimeException("Usuario não encontrado!")
        );
        Usuario usuarioAtualizado = Usuario.builder()
        .email(usuario.getEmail() !=null ?
        usuario.getEmail() : usuarioEntity.getEmail())
        .nome(usuario.getNome() !=null ?
        usuario.getNome() : usuarioEntity.getNome())
        .id(usuario.getId()) 
        .build();
        //salvar todos os dados para passar novamente para o bd
        repository.saveAndFlush(usuarioAtualizado);
    }
    public List<Usuario> listar(){
        return repository.findAll();
    }
}
