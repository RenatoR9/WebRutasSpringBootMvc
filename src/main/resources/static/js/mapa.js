var mapa;
var flightPlanCoordinates = [
                             {lat: -2.204845, lng: -80.974285},
                             {lat: -2.205179, lng: -80.973763},
                             {lat: -2.205794, lng: -80.973716},
                             {lat: -2.205288, lng: -80.975320}
                           ];

		function inicializar() {
			var opciones = {
			  zoom: 15,
			  mapTypeId: google.maps.MapTypeId.ROADMAP
			};
			mapa = new google.maps.Map(document.getElementById('mapa_content'), opciones);
			if (navigator.geolocation)
			{
			    //Hago el CallBack a mostrarLocalizacion
				navigator.geolocation.getCurrentPosition(mostrarLocalizacion,manejadorDeError);
			}
			else{
			    //Caso contraio muestro error
				alert("Su navegador no soporta Geolocalizacion");
				}
			
			
			                           var flightPath = new google.maps.Polyline({
			                             path: flightPlanCoordinates,
			                             geodesic: true,
			                             strokeColor: '#FF0000',
			                             strokeOpacity: 1.0,
			                             strokeWeight: 2
			                           });

			                           flightPath.setMap(mapa);
			
		}
			function mostrarLocalizacion()
	     {
            var pos = new google.maps.LatLng(flightPlanCoordinates[0].lat, flightPlanCoordinates[0].lng);
            //Muestro un tooltip con un mensaje sobre el mapa
            var infowindow = new google.maps.InfoWindow({
              map: mapa,
              position: pos,
              content: 'ESTAS AQUI'
            });

            mapa.setCenter(pos);
	      }

	    function manejadorDeError(error) {

		   switch(error.code)
            {
                case error.PERMISSION_DENIED: alert("El usuario no permite compartir datos de geolocalizacion");
                break;

                case error.POSITION_UNAVAILABLE: alert("Imposible detectar la posicio actual");
                break;

                case error.TIMEOUT: alert("La posicion debe recuperar el tiempo de espera");
                break;

                default: alert("Error desconocido");
                break;
            }
			var opciones = {
			  map: mapa,
			  position: new google.maps.LatLng(60, 105),
			  content: content
			};
			var infowindow = new google.maps.InfoWindow(opciones);
			mapa.setCenter(opciones.position);
      }
	    
	    google.maps.event.addDomListener(window, 'load', inicializar);
	    
	    