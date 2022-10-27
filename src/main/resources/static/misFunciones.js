function traerInformacion() {
    $.ajax({
        url:"http://localhost:8080/api/Category/all",
        type:'GET',
        datatype:"JSON",
        success:function(respuesta) {
            pintarDatos(respuesta);
        },
        error: function(respuesta, xhr){
            alert("Error de Peticion!");
        }
    });
}

function pintarDatos(datos) {

    let html="";
    html +="<tr>";
    Object.keys(datos[0]).forEach(elemento=>{
        html+="</th>"+elemento+"th";
    });
    html += "</tr>";

    $("#tabla").empty();
    $("#tabla").append(html);

    }


