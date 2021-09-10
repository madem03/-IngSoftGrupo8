/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ManagedBeans;


import DaoUsuario.UsuarioDAOImp;
import java.io.Serializable;
import java.util.List;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import modelo.*;
import DaoUsuario.UsuarioDao;
import java.math.BigDecimal;

/**
 *
 * @author darwin31
 */
@Named(value = "mbCrearUsuario")
@ViewScoped
public class MbUsuario implements Serializable{
    
    private Usuario usuario;
    private List<Usuario> lstUsuario;
    
    public MbUsuario() {
        usuario = new Usuario();
        Rol rol = new Rol();
        
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }  

    public List<Usuario> getLstUsuario() {
        UsuarioDao usuarioDao = new UsuarioDAOImp();
        lstUsuario= usuarioDao.ReadUsuarios();
        return lstUsuario;
    }

    public void setLstUsuario(List<Usuario> lstUsuario) {
        
        this.lstUsuario = lstUsuario;
    }
    
    public void leer(Usuario usuario_sel){
        usuario = usuario_sel;
    }
    
    public void agregarUsuario(){
        UsuarioDao usuarioDao = new UsuarioDAOImp();
        usuarioDao.createUsuario(usuario);
        usuario = new Usuario();
    }
    public void eliminarUsuario(){
        UsuarioDao usuarioDao = new UsuarioDAOImp();
        usuarioDao.deleteUsuario(usuario);
        usuario = new Usuario();
    }
    public void modificarUsuario(){
        UsuarioDao usuarioDao = new UsuarioDAOImp();
        usuarioDao.updateUsuario(usuario);
        usuario = new Usuario();
    }
    
 
}
