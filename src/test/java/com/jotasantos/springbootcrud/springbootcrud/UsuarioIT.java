package com.jotasantos.springbootcrud.springbootcrud;

import com.jotasantos.springbootcrud.springbootcrud.core.config.ApiPath;
import com.jotasantos.springbootcrud.springbootcrud.core.entities.Usuario;
import com.jotasantos.springbootcrud.springbootcrud.enums.EnumStatusUsuario;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioCreateDTO;
import com.jotasantos.springbootcrud.springbootcrud.web.dtos.usuarios.UsuarioResponseDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Sql(scripts = "/sql/usuarios/usuarios-insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "/sql/usuarios/truncate-table-usuarios.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
public class UsuarioIT {

    @Autowired
    WebTestClient testClient;

    @Test
    public void createUsuario_ComDadosValidos_RetornarUsuarioCriadoComStatus201() {

        UsuarioCreateDTO usuarioCreateDTO = new UsuarioCreateDTO("jailson Santos", "gestald118@gmail.com", EnumStatusUsuario.ATIVO);

        UsuarioResponseDTO usuarioResponseDTO = testClient
                .post()
                .uri(ApiPath.USUARIOS)
                .contentType(MediaType.APPLICATION_JSON)
                .bodyValue(usuarioCreateDTO)
                .exchange()
                .expectStatus().isCreated()
                .expectBody(UsuarioResponseDTO.class)
                .returnResult()
                .getResponseBody();

        Assertions.assertThat(usuarioResponseDTO).isNotNull();
        Assertions.assertThat(usuarioResponseDTO.id()).isNotNull();
        Assertions.assertThat(usuarioResponseDTO.nome()).isEqualTo("jailson Santos");
        Assertions.assertThat(usuarioResponseDTO.email()).isEqualTo("gestald118@gmail.com");
        Assertions.assertThat(usuarioResponseDTO.statusUsuario().getDescricao()).isEqualTo(EnumStatusUsuario.ATIVO.getDescricao());
    }

}
