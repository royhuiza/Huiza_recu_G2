<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HUIZA Exa2 LP1</title>
<%@include file="jspf/head.jspf"%>
</head>
<body>
	<div class="container">
		<%@include file="jspf/header.jspf"%>
	</div>
	<div class="container mt-5 d-flex justify-content-center">
		<div class="card w-50">
			<div class="card-body d-flex justify-content-between">
				<h3 class="card-title">Autores</h3>
				<button type="button" class="btn btn-success" data-bs-toggle="modal"
					data-bs-target="#facModalNuevo" data-bs-whatever="@mdo">
					<i class="fa-regular fa-plus"></i>
				</button>
			</div>
			<div class="card-body">
				<table class="table" id="tablafac">
					<thead>
						<tr>
							<th scope="col">Nombre</th>
							<th scope="col" >Apellido</th>
							<th scope="col" >Pais</th>
							<th scope="col" >Estado</th>
							<th scope="col" colspan="2">Acción</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
		</div>
	</div>
	<!-- Modal Save -->
	<div class="modal fade" id="facModalNuevo" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Nuevo Autor</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">Nombre del autor:</label>
							<input type="text" class="form-control" id="facNuevoNombre">
							<label for="recipient-name" class="col-form-label">Apellido del Autor:</label>
							<input type="text" class="form-control" id="facNuevoApellido">
							<label for="recipient-name" class="col-form-label">Pais del Autor:</label>
							<input type="text" class="form-control" id="facNuevoPais">
							<label for="recipient-name" class="col-form-label">Estado del Autor:</label>
							<input type="text" class="form-control" id="facNuevoEstado">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Cerrar</button>
					<button type="button" class="btn btn-primary" id="save">Guardar</button>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal Edit-->
	<div class="modal fade" id="facModalEdit" tabindex="-1"
		aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<h1 class="modal-title fs-5" id="exampleModalLabel">Editar
						Autores</h1>
					<button type="button" class="btn-close" data-bs-dismiss="modal"
						aria-label="Close"></button>
				</div>
				<div class="modal-body">
					<form>
						<div class="mb-3">
							<label for="recipient-name" class="col-form-label">Nombre:</label>
							<input type="text" class="form-control" id="facEditNombre"> 
							<label for="recipient-name" class="col-form-label">Apellido:</label>
							<input type="text" class="form-control" id="facEditApellido"> 
							<label for="recipient-name" class="col-form-label">Pais:</label>
							<input type="text" class="form-control" id="facEditPais"> 
							<label for="recipient-name" class="col-form-label">Estado:</label>
							<input type="text" class="form-control" id="facEditEstado">
							
							<input type="hidden" class="form-control" id="idEdit">
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-secondary"
						data-bs-dismiss="modal">Close</button>
					<button type="button" class="btn btn-primary" id="edit">Editar</button>
				</div>
			</div>
		</div>
	</div>
	<%@include file="jspf/footer.jspf"%>
	<script type="text/javascript" src="js/peli.js"></script>
</body>
</html>