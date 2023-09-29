 /**
  * Confirmar a deleção 
  * @author Imilio manuel
  * @param  idcon 
  */
function confirmar(idcon){
	let resposta = confirm("Desejas Eliminar este contacto?")
	if(resposta === true)
		{
			window.location.href= "delete?idcon="+idcon
	}	
}