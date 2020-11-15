 
package mtruck.api.dtos;

public class ResponseLoginDTO {
  private String perfil_usuario;
  private String nome;
  private String email;
  
  public ResponseLoginDTO(String perfil_usuario, String nome, String email){
    this.perfil_usuario = perfil_usuario;
    this.nome = nome;
    this.email = email;
  }

  public String getEmail() {
    return email;
  }

  public String getPerfil_usuario() {
      return perfil_usuario;
    }

  public String getNome() {
      return nome;
    }
}