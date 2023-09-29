<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="pt-pt">
<head>
<meta charset="utf-8">
<%@ page import="Model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
@SuppressWarnings("unchecked")
	ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("contactos");
	
%>
<title>Agenda de Contactos</title>
<link rel="icon" href="img/fone.png">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h1>Agenda de Contactos</h1>
	<a href="novo.html" class="botao1">Novo Contacto</a>
	<a href="report" class="botao2">Relatório</a>
	<table id= "tabela">
		<thead>
			<tr>
				<th>Id</th>
				<th>Nome</th>
				<th>Telefone</th>
				<th>E-mail</th>
				<th>Opções</th>
			</tr>
		</thead>
		<tbody>
			<%for(int i = 0; i < lista.size();i++){%>
				<tr>
					<td><%=lista.get(i).getIdcon()%></td>
					<td><%=lista.get(i).getNome()%></td>
					<td><%=lista.get(i).getFone()%></td>
					<td><%=lista.get(i).getEmail()%></td>
					<td><a href="select?idcon=<%=lista.get(i).getIdcon()%>" class="botao1">Editar</a>
					<a href="javaScript:confirmar(<%=lista.get(i).getIdcon()%>)" class="botao2">Deletar</a></td>
				</tr>
			<%} %>
		</tbody>
	</table>
	<script src="js/delete.js"></script>
</body>
</html>