//Variables
var today = new Date();
var formP = $('#formP');
var btnPacientesAdd = $('#btnPacientesAdd');
var formContent = $('.formContent');
var selectAreaTrabajo = $('#selectAreaTrabajo');
var optionSelected = $('.optionSelected');
var user = $('#inputEmail');
var password = $('#inputPassword');
var birth = $('#date');
var edadInput = $('#inputEdad');
var divContent = $('.divContent');
var deleteModal = $('#deleteModal');
var changeModal = $('#changeModal');
var inputSearch = $('#inputSearch');
var borderHr= $('.borderHr');

//Content hide
formContent.hide()
selectAreaTrabajo.hide();
divContent.hide();
borderHr.hide();

$(function() {
	//Calendar configuration
	$('#datepicker').datepicker({
		format: 'dd-mm-yyyy',
		orientation: "bottom auto",
		startView: 2,
		minViewMode: 0,
		maxViewMode: 3,
		autoclose: true,
		language: "es",
		todayHighlight: true,
		endDate: today.getDate() + '-' + (today.getMonth() + 1) + '-' + today.getFullYear(),
	});


});



// Forms visibility
function onHandleClick(formID) {
	formContent.hide();
	divContent.hide();
	borderHr.show();
	$("#" + formID).show();
}

//Change rol to admin
function onChangeSelected() {
	let selectorValue = optionSelected.val();
	if (selectorValue == 'medico') {
		selectAreaTrabajo.show();
	} else {
		selectAreaTrabajo.hide();
	}
}

//Storage
function localStorage() {
	let userV = user.val();
	let passV = password.val();
	localStorage.setItem('user', userV);
	localStorage.setItem('password', passV);
}

//age
function onHandleAge() {
	let birthV = new Date(birth.val())
	let edad = today.getFullYear() - birthV.getFullYear();
	let m = today.getMonth() - birthV.getMonth();

	if (m < 0 || (m === 0 && today.getDate() < birthV.getDate())) {
		edad--;
	}

	edadInput.val(edad);
	//chequear que me tira NaN la edad
	return edad;
}

function showContent() {
	divContent.show();
	inputSearch.submit();
}






