package com.reciclajeApp.mapper;

import com.reciclajeApp.domain.Usuario;

import com.reciclajeApp.dto.UsuarioDTO;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;


/**
* @author Zathura Code Generator Version 9.0 http://zathuracode.org
* www.zathuracode.org
*
* Mapper Build with MapStruct https://mapstruct.org
* MapStruct is a code generator that greatly simplifies the
* implementation of mappings between Java bean type
* based on a convention over configuration approach.
*/
@Mapper
public interface UsuarioMapper {
    @Mapping(source = "tipousuario.idtipousuario", target = "idtipousuario_Tipousuario")
    public UsuarioDTO usuarioToUsuarioDTO(Usuario usuario);

    @Mapping(source = "idtipousuario_Tipousuario", target = "tipousuario.idtipousuario")
    public Usuario usuarioDTOToUsuario(UsuarioDTO usuarioDTO);

    public List<UsuarioDTO> listUsuarioToListUsuarioDTO(List<Usuario> usuarios);

    public List<Usuario> listUsuarioDTOToListUsuario(
        List<UsuarioDTO> usuarioDTOs);
}
