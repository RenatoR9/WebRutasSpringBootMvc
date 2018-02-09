//FUNCION PARA LLAMAR Y MOSTRAR LA VENTANA FLOTANTE ONGRESO BUSES
function buses() {
            	$(".ventanaBuses").slideDown("slow");
            }

function buses1() {
	$(".ventanaMsj").slideDown("slow");
}


//FUNCION PARA CERRAR LA VENTANA INGRESO BUSES CON EL BOTON SALIR O CANCELAR
function cerrar()
{
    var ventana = document.getElementById('miVentana');
    ventana.style.display = 'none';
}

function cerrar1()
{
    var ventana = document.getElementById('miVentana1');
    ventana.style.display = 'none';
}


//FUNCION PARA MOSTRAR O HABILITAR EL SUBMENU EN LOS BOTONES GUARDAR O CANCELAR
function mostrar(){
$('li').hover(
        function(){
            $(this).children('ul').slideDown("slow");
        },
        function(){
            $(this).children('ul').slideUp(1);
        }
    );
    
$(".nav nav-pills").on('click',function(){
	$('nav').toggleClass('menu');
})


//FUNCION PARA OCULTAR EL SUBMENU CUANDO SE LE DA CLICK PARA LLAMAR A CUALQUIER VENTANA
}
function ocultar(){
	document.getElementById('menu1').style.display='none';
}