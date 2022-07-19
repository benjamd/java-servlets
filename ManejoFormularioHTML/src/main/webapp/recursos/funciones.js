 function validarForma(forma){
     var usuario = forma.usuario;
     if(usuario.value == "" || usuario.value == "Escribir usuario"){
         alert("Debe proporcionar un nombre de usaurio");
         usuario.focus();
         usuario.select();
         return false;
     }
     
     var password = forma.password;
     if(password.value == "" || password.value.length < 3){
         alert("Debes proporcionar un password al menos de 3 caracteres");
         password.focus();
         password.select();
         return false;
     }
     
     var tecnologias = forma.tecnologia;
     var checkSeleccionado = false;
     
     for(var i = 0; i < tecnologias.length; i++){
         if(tecnologias[i].checked){
             checkSeleccionado = true;
         }
     }
     
     if(!checkSeleccionado){
         alert("Debe seleccionar una tecnología");
         return false;
     }
     
     var generos = forma.genero;
     var radioSelecionado = false;
     
     for(var i = 0; i < generos.length; i++){
         if(generos[i].checked){
             radioSelecionado = true;
         }
     }
     
     if(!radioSelecionado){
         alert("Debe seleccionar un genero");
         return false;
     }
     
     var ocupacion = forma.ocupacion;
     
     if(ocupacion.value == ""){
         alert("Debe seleccionar una ocupacion");
         return false;
     }
     
     //Formulario es valido
     alert("Formulario es valido para enviar al servidor");
     return true;
     
 }