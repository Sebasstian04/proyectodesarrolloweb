package controller;

import java.util.List;

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

import controllervo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import model.Usuarios;
import service.UsuariosService;

@RestController
@RequestMapping("/usuarios")
@Api(tags = "usuarios")
public class UsuariosController {

    private final UsuariosService usuariosService;
	
	   public UsuariosController(UsuariosService usuariosService) {
		   this.usuariosService = usuariosService;
		   
			}
	@PostMapping
	@ApiOperation(value = "Crear usuario", notes ="Servicios para crear un nuevo usuario")
	@ApiResponses(value = {@ApiResponse(code = 201 , message = "Usuario creado Correctamente"),
	@ApiResponse(code = 400, message = "Solicitud Invalida")})
	public ResponseEntity<Usuarios> createUsuarios(@RequestBody UserVO userVo){
		
	Usuarios usuarios = new Usuarios();
	
	usuarios.setNombre(userVo.getNombre());
	usuarios.setApellidos(userVo.getApellidos());
	usuarios.setTipodoc(userVo.getTipodoc());
	usuarios.setNumerodoc(userVo.getNumerodoc());
	usuarios.setEmail(userVo.getEmail());
	usuarios.setDireccion(userVo.getDireccion());
	usuarios.setTelefono(userVo.getTelefono());
	usuarios.setRol(userVo.getRol());
	
	return new ResponseEntity<Usuarios>(this.usuariosService.create(usuarios), HttpStatus.CREATED);
	
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar Usuario", notes ="Servicios para Actualizar un nuevo usuario")
	@ApiResponses(value = {@ApiResponse(code = 201 , message = "Usuario Actualizado Correctamente"),
	@ApiResponse(code = 404, message = "Ususario no econtrado")})
	public ResponseEntity<Usuarios> updateUsuarios(@PathVariable("id")int id, @RequestBody UserVO userVo){
		
		Usuarios usuarios = this.usuariosService.findById(id);
			
		if (usuarios == null) {
			return new ResponseEntity<Usuarios>(HttpStatus.NOT_FOUND);
			}else {
				
				usuarios.setNombre(userVo.getNombre());
				usuarios.setApellidos(userVo.getApellidos());
				usuarios.setTipodoc(userVo.getTipodoc());
				usuarios.setNumerodoc(userVo.getNumerodoc());
				usuarios.setEmail(userVo.getEmail());
				usuarios.setDireccion(userVo.getDireccion());
				usuarios.setTelefono(userVo.getTelefono());
				usuarios.setRol(userVo.getRol());
				
			}
		
			return new ResponseEntity<Usuarios>(this.usuariosService.update(usuarios), HttpStatus.OK);
		
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar Usuario", notes ="Servicios para Eliminar un  usuario")
	@ApiResponses(value = {@ApiResponse(code = 201 , message = "Usuario Eliminado "),
	@ApiResponse(code = 404, message = "Ususario no econtrado")})
	public void removeUsuarios(@PathVariable("id")int id) {
		Usuarios usuarios = this.usuariosService.findById(id);
		if (usuarios != null) {
			this.usuariosService.delete(usuarios);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Usuarios", notes ="Servicios para Listar todos los usuarios")
	@ApiResponses(value = {@ApiResponse(code = 201 , message = "Usuarios encontrados Correctamente"),
	@ApiResponse(code = 404, message = "Ususario no econtrado")})
	public ResponseEntity<List<Usuarios>> findAll(){
		return ResponseEntity.ok(this.usuariosService.findAll());
	}
	
}
