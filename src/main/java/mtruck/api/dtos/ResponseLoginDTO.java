 
package mtruck.api.dtos;

import java.util.UUID;

public class ResponseLoginDTO {
  private String perfil_usuario;
  private String nome;
  private String email;
  private UUID empresa_id;
  
  public ResponseLoginDTO(String perfil_usuario, String nome, String email, UUID empresa_id){
    this.perfil_usuario = perfil_usuario;
    this.nome = nome;
    this.email = email;
    this.empresa_id = empresa_id;
  }

  public String getEmail() {
    return email;
  }

  public String getPerfil_usuario() {
      return perfil_usuario;
    }
  
  public UUID getEmpresa_id() {
      return empresa_id;
    }

  public String getNome() {
      return nome;
    }
  
}