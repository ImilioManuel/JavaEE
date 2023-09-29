<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Agenda de Contactos</title>
<link rel="icon" href="img/fone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Editar Contacto!</h1>
	<hr>
	<form name="frmContacto" action="update">
		<table>
			<tr>
				<td><input type="text" id="caixa3" name="idcon" readonly="readonly" value="<%out.print(request.getAttribute("idcon"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="caixa1" name="nome" value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="caixa2" name="fone" value="<%out.print(request.getAttribute("fone"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" class="caixa1" name="email" value="<%out.print(request.getAttribute("email"));%>"></td>
			</tr>
		</table>
		<input type="button" class="botao1" value="Salvar" onclick="validar()">
	</form>
	<script src="js/validador.js"></script>
	
</body>
</html>