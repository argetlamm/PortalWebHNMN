//Funcionalidades de botones Agregar, Quitar, Quitar todos, Enviar, Cancelar con sus respectivas validaciones.
$().ready(function() {	
	$('.pasar').click(function() {
        var inputs = $('#correosEst');
        var asociado = $(inputs).val();
        var sel = document.getElementById("destino");
        var err = 0;
        var correosConcatenados = "";
        var totalOptions = $('#destino option').length + 1;
        
        //Validación para ver si el email ya está en la lista (select)
        for (var i = 0; i < sel.length; i++) {
            var opt = sel[i];
            console.log(opt.value);
            if (opt.value == (asociado)){
                errorAlert('Error', 'El email ingresado ya está en la lista');
                $("#correosEst").val("");
                err = 1;
            }
        }

        if (($(inputs).val()<= 0) && (err != 1)) {
            $("#correosEst").val("");
        }else if (err != 1){
            correosConcatenados = $("#destinoInput").val() + asociado+"/";
            $("#destinoInput").val(correosConcatenados);
            $("#correosEst").val("");
            $("#totalCorreos").val(totalOptions);
            return !$('#destino').append('<option value="'+asociado+'">'+asociado+'</option>');
        }
    });

    $('.quitar').click(function() {
        var opcSel = $('#destino option:selected').index();
        var correoIndividual = "";
        var correosResultantes = "";
        var totalOptions = $('#destino option').length;
        var totalFinal = totalOptions - 1;

        confirm(function(e,btn){
                for(var i=0; i<totalOptions; i++){
                    if(i != opcSel){
                        correoIndividual = $("#destino option:eq(" + i + ")").text() + "/";
                    }else{
                        correoIndividual = "";
                    }
                    correosResultantes = correosResultantes + correoIndividual;
                }

                if(totalFinal >= 0){
    				$("#totalCorreos").val(totalFinal);
    			}else{
    				$("#totalCorreos").val('0');
    			}
                
                $("#destinoInput").val(correosResultantes);

                e.preventDefault();
                return !$('#destino option:selected').remove();
            },
            function(e, btn){
                e.preventDefault();
            });
    });

    $('.quitartodos').click(function() {
        confirm(function(e,btn){

                $('#destino option').each(function() {
                    $(this).remove().appendTo('#origen');
                    $("#destinoInput").val('');
                    $("#totalCorreos").val('0');
                });

            },
            function(e, btn){
                e.preventDefault();
            });
    });

    $('.enviar').click(function() {
        if (document.getElementById('destino').options.length == 0){
            errorAlert('Error', 'La lista está vacía');
        }
    });

    $('.cancelar').click(function() {
        $('#destino option').each(function() {
            $(this).remove().appendTo('#origen');
            $("#destinoInput").val('');
            $("#totalCorreos").val('0');
        });
    });
    
    $("body").on("keydown", "input.agregar", function(e) {
        if (event.which === 13 || event.keyCode === 13 || event.key === "Enter") {
            e.preventDefault();
            var inputs = $('#correosEst');
            var asociado = $(inputs).val();
            var sel = document.getElementById("destino");
            var err = 0;
            var correosConcatenados = "";
            var totalOptions = $('#destino option').length + 1;
            
            //Validación para ver si un email ya está en la lista (select) al agregarlo mediante enter
            for (var i = 0; i < sel.length; i++) {
                var opt = sel[i];
                console.log(opt.value);
                if (opt.value == (asociado)){
                    errorAlert('Error', 'El email ingresado ya está en la lista');
                    $("#correosEst").val("");
                    err = 1;
                }
            }

            if (($(inputs).val()<= 0) && (err != 1)) {
                $("#correosEst").val("");
            }else if (err != 1){
                correosConcatenados = $("#destinoInput").val() + asociado + "@/";
                $("#destinoInput").val(correosConcatenados);
                $("#correosEst").val("");
                $("#totalCorreos").val(totalOptions);
                return !$('#destino').append('<option value="'+asociado+'">'+asociado+'</option>');
            }
        }
    }); 
    
    $('input').on('keydown', function(e) {
    	if (event.which === 13 || event.keyCode === 13 || event.key === "Enter") {
        	e.preventDefault();    		
    	}
    });	
});

//Función para el botón mirar-ocultar la contraseña
$(".toggle-password").click(function() {

    $(this).toggleClass("fa-eye fa-eye-slash");
    var input = $($(this).attr("toggle"));
    if (input.attr("type") == "password") {
        input.attr("type", "text");
    } else {
        input.attr("type", "password");
    }
});