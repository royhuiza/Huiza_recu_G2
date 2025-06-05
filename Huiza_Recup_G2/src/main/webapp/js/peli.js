$(document).ready(function(){
	listar();
});

// Save new author
$("#save").click(function() {
	let nombres = $("#facNuevoNombre").val();
	let apellidos = $("#facNuevoApellido").val();
	let pais = $("#facNuevoPais").val();
	let estado = $("#facNuevoEstado").val();
	
	if (nombres === "" || apellidos === "" || pais === "" || estado === "") {
			alert("Completa todos los campos.");
			return;
		}
		
	$.post("autores", { "nombres": nombres, "apellidos": apellidos, "pais":pais, "estado":estado, "opc": 3 }, function() {
		listar();
	});
	limpiar();
	cerrarNuevo();
});

// Edit existing author
$("#edit").click(function() {
	let id = $("#idEdit").val();
	let nombres = $("#facEditNombre").val();
	let apellidos = $("#facEditApellido").val();
	let pais = $("#facEditPais").val();  // Fixed ID here
	let estado = $("#facEditEstado").val();

	// Send the edited data to the server
	$.post("autores", { "id": id, "nombres": nombres, "apellidos": apellidos, "pais":pais, "estado":estado, "opc": 4 }, function() {
		listar();
	});
	cerrarEdit();
});

// Edit modal
function editar(id) {
	$.get("autores", { "id": id, "opc": 2 }, function(data) {
		var x = JSON.parse(data);
		// Ensure all fields are populated correctly
		$("#facEditNombre").val(x.nombres);
		$("#facEditApellido").val(x.apellidos); // Set Apellido here
		$("#facEditPais").val(x.pais); // Set Pais here
		$("#facEditEstado").val(x.estado); // Set Estado here
		$("#idEdit").val(x.idautores); // Set the hidden ID
	});
	mostrarEdit();
}

// List authors
function listar() {
	$.get("autores", { "opc": 1 }, function(data) {
		var x = JSON.parse(data);
		$("#tablafac tbody tr").remove();
		x.forEach(function(item) {
			$("#tablafac").append("<tr><td>" + item.nombres + "</td><td>" + item.apellidos + "</td><td>" + item.pais + "</td><td>" + item.estado + "</td><td><a href='#' onclick='editar(" + item.idautores + ")' class='btn btn-warning'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar(" + item.idautores + ")' class='btn btn-danger'><i class='fas fa-trash-alt'></i></a></td></tr>");
		});
	});
}

// Delete author
function eliminar(id) {
	$.get("autores", { "id": id, "opc": 5 }, function() {
		listar();
	});
}

// Reset form
function limpiar() {
	$("#facNuevoNombre").val("");
	$("#facNuevoApellido").val("");
	$("#facNuevoPais").val("");
	$("#facNuevoEstado").val("");
}

// Close new modal
function cerrarNuevo() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('facModalNuevo'));
	if (modalInstance) {
		modalInstance.hide();
	}
}

// Close edit modal
function cerrarEdit() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('facModalEdit'));
	if (modalInstance) {
		modalInstance.hide();
	}
}

// Show edit modal
function mostrarEdit() {
	const modal = new bootstrap.Modal(document.getElementById('facModalEdit'));
	modal.show();
}
