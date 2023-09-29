 /**
  * Validar os campos 
  * @author Imilio manuel
  */
 function validar(){
	 let nome = frmContacto.nome.value;
	 let fone = frmContacto.fone.value;
	 if(nome ===""){
		 alert("Preencha o campo nome");
		 frmContacto.nome.focus();
		 return false;
	 }else if(fone ===""){
		 alert("Preencha o campo fone");
		 frmContacto.fone.focus();
		 return false;
	 }else{
		 document.forms["frmContacto"].submit();
	 }
 }