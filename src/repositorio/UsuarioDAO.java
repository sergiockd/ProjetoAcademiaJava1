package repositorio;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO  {
	
	Connection con = null;
	PreparedStatement pstmt = null ;
	int res;	
	ResultSet rs = null;
	
	public boolean cadastrarUsuario(Usuario usuario) {

		try {
			 pstmt = con.prepareStatement("insert into Usuario values (?,?,?,?)") ;
				pstmt.setString(1,usuario.getNome() );
				pstmt.setString(2,usuario.getEmail() );
				pstmt.setString(3,usuario.getSenha() );
				pstmt.setString(4,usuario.getTipo() );
		
				res = pstmt.executeUpdate();
				con.commit();
				
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		if(res == 1){
			System.out.println("Inserido com Sucesso !");
			
			return true ;
		}
			return false ;
	}

	public Usuario consultarUsuario(int id_usuario) {
		Connection con = null ;
		PreparedStatement pstmt = null ;
		
		try {
			pstmt = con.prepareStatement("select * from Usuario where id = ?");
			pstmt.setInt(1, id_usuario);
			rs = pstmt.executeQuery();
			if(rs.next()){
				
			Usuario usuario = new Usuario();
			usuario.setNome(rs.getString("nome"));
			usuario.setEmail(rs.getString("email"));
			usuario.setSenha(rs.getString("senha"));
			usuario.setTipo(rs.getInt("id_usuario_fk"));
			
			return usuario ; 
			}else {}
			
		}catch (Exception e) {
				
			}
		}
}
	
	


	
		
		
	
