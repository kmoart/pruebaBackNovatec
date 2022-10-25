import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { UsuariosService } from '../../services/usuarios.service';
import { usuarioModel } from '../../models/usuario.model';

@Component({
  selector: 'app-reactive',
  templateUrl: './reactive.component.html',
  styleUrls: ['./reactive.component.css']
})
export class ReactiveComponent implements OnInit {

  forma!: FormGroup;

  usuario = new usuarioModel();
  usuariosModel: any;

  constructor(private fb: FormBuilder, private usuarioService: UsuariosService) {
    this.crearFomulario();
   }

  ngOnInit(): void {
    this.usuarioService.getUsuarios()
        .subscribe( usuarios =>{
          console.log(usuarios);
          this.usuariosModel = usuarios; 
        });
  }

  get nombreNoValido(){
    return this.forma.get('nombre')?.invalid && this.forma.get('nombre')?.touched; 
  }

  get tipoUsuarioNoValido(){
    return this.forma.get('tipoUsuario')?.invalid && this.forma.get('tipoUsuario')?.touched; 
  }

  get correoNoValido(){
    return this.forma.get('correo')?.invalid && this.forma.get('correo')?.touched; 
  }

  crearFomulario(){
    this.forma = this.fb.group({
      nombre: ['', Validators.required, Validators.minLength(5)],
      tipoUsuario: ['', Validators.required, Validators.minLength(5) ],
      correo: ['', [Validators.required,Validators.email] ],
    });
  }

  guardar( ){
    console.log( this.forma);

    if( this.forma.invalid){
      return Object.values( this.forma.controls ).forEach(control =>{
        control.markAsTouched();
      });
    }

    this.usuario.nombre = this.forma.value.nombre;
    this.usuario.tipoUsuario = this.forma.value.tipoUsuario;
    this.usuario.email = this.forma.value.correo;

    console.log(this.usuario);
    
    this.usuarioService.crearUsuario(this.usuario)
      .subscribe( resp => {
          console.log(resp);
      });
  }

  obtenerUsuarios(){
  

    this.usuarioService.getUsuarios()
    .subscribe( usuarios =>{
      console.log(usuarios);
        this.usuariosModel = usuarios; 
    });

    
  }

}
