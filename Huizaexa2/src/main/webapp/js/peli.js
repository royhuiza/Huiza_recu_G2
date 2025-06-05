$(document).ready(function(){
	listar();
});

$("#save").click(function() {
	let titulo = $("#facNuevoTitulo").val();
	let genero = $("#facNuevoGenero").val();
	let idioma = $("#facNuevoIdioma").val();
	
	if (titulo === "" || genero === "" || idioma === "") {
			alert("Completa todos los campos.");
			return;
		}
		
	$.post("pelicula", { "titulo": titulo, "genero": genero, "idioma":idioma, "opc": 3 }, function() {
		listar();
	});
	limpiar();
	cerrarNuevo();

});
$("#edit").click(function() {
	
	let id = $("#idEdit").val();
	let titulo = $("#facEditTitulo").val();
	let genero = $("#facEditGenero").val();
	let idioma = $("#facEditIdioma").val();
	$.post("pelicula", { "id": id, "titulo": titulo, "genero": genero, "idioma":idioma, "opc": 4 }, function() {
		listar();
	});
	cerrarEdit();

});
function editar(id) {
	$.get("pelicula", { "id": id, "opc": 2 }, function(data) {
		var x = JSON.parse(data);
		$("#facEditTitulo").val(x.titulo);
		$("#facEditGenero").val(x.genero);
		$("#facEditIdioma").val(x.idioma);
		$("#idEdit").val(x.idpelicula);
	});
	mostrarEdit();
}
function listar() {
	$.get("pelicula", { "opc": 1 }, function(data) {
		var x = JSON.parse(data);
		$("#tablafac tbody tr").remove();
		x.forEach(function(item) {
			$("#tablafac").append("<tr><td>" + item.titulo + "</td><td>" + item.genero + "</td><td>" + item.idioma + "</td><td><a href='#' onclick='editar(" + item.idpelicula + ")' class='btn btn-warning'><i class='far fa-edit'></i></a></td><td><a href='#' onclick='eliminar(" + item.idpelicula + ")' class='btn btn-danger'><i class='fas fa-trash-alt'></i></a></td></tr>"
			);
		});
	});
}
function eliminar(id) {

	$.get("pelicula", { "id": id, "opc": 5 }, function() {
		listar();
	});
}
function limpiar() {
	$("#facNuevoTitulo").val("");
	$("#facNuevoGenero").val("");
	$("#facNuevoIdioma").val("");
}
function cerrarNuevo() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('facModalNuevo')); //cuidado
	if (modalInstance) {
		modalInstance.hide();
	}
}
function cerrarEdit() {
	const modalInstance = bootstrap.Modal.getInstance(document.getElementById('facModalEdit'));
	if (modalInstance) {
		modalInstance.hide();
	}
}
function mostrarEdit() {
	const modal = new bootstrap.Modal(document.getElementById('facModalEdit'));
	modal.show();

}