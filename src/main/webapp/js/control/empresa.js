/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var control_empresa_list = function(path) {
    //contexto privado

    var prefijo_div = "#empresa_list ";

    function cargaBotoneraMantenimiento() {
        var botonera = [
            {"class": "btn btn-mini action01", "icon": "icon-eye-open", "text": ""},
            {"class": "btn btn-mini action02", "icon": "icon-zoom-in", "text": ""},
            {"class": "btn btn-mini action03", "icon": "icon-pencil", "text": ""},
            {"class": "btn btn-mini action04", "icon": "icon-remove", "text": ""}
        ];
        return botonera;
    }

    function cargaBotoneraBuscando() {
        var botonera = [
            {"class": "btn btn-mini action01", "icon": "icon-ok", "text": ""}
        ];
        return botonera;
    }

    function loadDivView(view, place, id) {
        $(prefijo_div + place).empty().append((view.getObjectTable(id))
                + '<button class="btn btn-primary" id="limpiar">Limpiar</button>');
        $(prefijo_div + '#limpiar').click(function() {
            $(prefijo_div + place).empty();
        });
    }
    function loadForeign(strObjetoForeign, strPlace, control, functionCallback) {
        var objConsulta = objeto(strObjetoForeign, path);
        var consultaView = vista(objConsulta, path);

        cabecera = '<button id="full-width" type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button><h3 id="myModalLabel">Elección</h3>';
        pie = '<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Cerrar</button>';
        listado = consultaView.getEmptyList();
        loadForm(strPlace, cabecera, listado, pie, true);

        $(prefijo_div + strPlace).css({
            'right': '20px',
            'left': '20px',
            'width': 'auto',
            'margin': '0',
            'display': 'block'
        });

        var consultaControl = control(path);
        consultaControl.inicia(consultaView, 1, null, null, 10, null, null, null, functionCallback, null, null, null);

    }
    function loadModalForm(view, place, id, action) {
        cabecera = '<button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>';
        if (action == "edit") {
            cabecera += '<h3 id="myModalLabel">Edición de ' + view.getObject().getName() + "</h3>";
        } else {
            cabecera += '<h3 id="myModalLabel">Alta de ' + view.getObject().getName() + "</h3>";
        }
        pie = '<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">Cerrar</button>';

        loadForm(place, cabecera, view.getEmptyForm(), pie, false);
        if (action == "edit") {
            view.doFillForm(id);
        } else {
            $(prefijo_div + '#id').val('0').attr("disabled", true);
            $(prefijo_div + '#nombre').focus();
        }
        //clave ajena usuario
        cargaClaveAjena('#id_usuario', '#id_usuario_desc', 'usuario')

        $(prefijo_div + '#id_usuario_button').unbind('click');
        $(prefijo_div + '#id_usuario_button').click(function() {
            loadForeign('usuario', '#modal02', control_usuario_list, callbackSearchUsuario);
            function callbackSearchUsuario(id) {
                $(prefijo_div + '#modal02').modal('hide');
                $(prefijo_div + '#modal02').data('modal', null);
                $(prefijo_div + '#id_usuario').val($(this).attr('id'));
                cargaClaveAjena('#id_usuario', '#id_usuario_desc', 'usuario');
                return false;
            }
            return false;
        });

////        //clave ajena usuario
//        cargaClaveAjena('#id_usuario', '#id_usuario_desc', 'usuario')
//        $(prefijo_div + '#id_usuario_button').unbind('click');
//        $(prefijo_div + '#id_usuario_button').click(function() {
//            loadForeign('usuario', '#modal02', control_usuario_list, callbackSearchHilo);
//            function callbackSearchHilo(id) {
//                $(prefijo_div + '#modal02').modal('hide');
//                $(prefijo_div + '#modal02').data('modal', null);
//                $(prefijo_div + '#id_usuario').val($(this).attr('id'));
//                cargaClaveAjena('#id_usuario', '#id_usuario_desc', 'usuario');
//                return false;
//            }
//            return false;
//        });
        // Validación del formulario.
        //http://jqueryvalidation.org/documentation/
        $('#formulario').validate({
            rules: {
                id_usuario: {
                    required: true,
                    // maxlength: 255
                },
                nombre: {
                    required: true,
                    maxlength: 255
                },
                cif: {
                    required: true,
                    maxlength: 255
                },
                direccion: {
                    required: true,
                    maxlength: 255
                            //       digits: true
                },
                localidad: {
                    required: true,
                    maxlength: 255
                },
                provincia: {
                    required: true,
                    maxlength: 255
                },
                pais: {
                    required: true,
                    maxlength: 255
                },
                telefono: {
                    required: true,
                    maxlength: 255
                },
                fax: {
                    required: true,
                    maxlength: 255
                },
                actividad: {
                    required: true,
                    maxlength: 255
                },
                nombrecontacto: {
                    required: true,
                    maxlength: 255
                },
                emailcontacto: {
                    required: true,
                    maxlength: 255,
                    email: true
                },
                validada: {
                    required: true,
                    maxlength: 255
                }

            },
            messages: {
                id_usuario: {
                    required: "Elige un id_usuario.",
                },
                nombre: {
                    required: "Introduce un Nombre."
                },
                cif: {
                    required: "Introduce un Cif.",
                },
                direccion: {
                    required: "Introduce una Direccion.",
                },
                localidad: {
                    required: "Introduce una Localidad",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                },
                provincia: {
                    required: "Introduce una Provincia",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                },
                pais: {
                    required: "Introduce un Pais",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                },
                telefono: {
                    required: "Introduce un Telefono",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                },
                fax: {
                    required: "Introduce un Fax",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                },
                actividad: {
                    required: "Introduce una Actividad",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                },
                nombrecontacto: {
                    required: "Introduce un Nombre de Contacto",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                },
                emailcontacto: {
                    required: "Introduce un Correo Electrónico",
                    maxlength: "Tiene que ser menos de 255 caracteres",
                    email: "Introduzca un correo correcto"
                },
                validada: {
                    required: "Introduzca 1 ó 0",
                    maxlength: "Tiene que ser menos de 255 caracteres"
                }


            },
            highlight: function(element) {
                $(element).closest('.control-group').removeClass('success').addClass('error');
            },
            success: function(element) {
                element
                        .text('OK!').addClass('valid')
                        .closest('.control-group').removeClass('error').addClass('success');
            }
        });

        $(prefijo_div + '#submitForm').unbind('click');
        $(prefijo_div + '#submitForm').click(function() {
            if ($('#formulario').valid()) {
                enviarDatosUpdateForm(view, prefijo_div);
            }
            return false;
        });
    }
    function cargaClaveAjena(lugarID, lugarDesc, objetoClaveAjena) {
        if ($(prefijo_div + lugarID).val() !== "") {
            objInfo = objeto(objetoClaveAjena, path).getOne($(prefijo_div + lugarID).val());
            props = Object.getOwnPropertyNames(objInfo);
            $(prefijo_div + lugarDesc).empty().html(objInfo[props[1]]);
        }
    }
    function removeConfirmationModalForm(view, place, id) {
        cabecera = "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>" +
                "<h3 id=\"myModalLabel\">Borrado de " + view.getObject().getName() + "</h3>";
        pie = "<div id=\"result\">¿Seguro que desea borrar el registro?</div>" +
                '<button id="btnBorrarSi" class="btn btn-danger" data-dismiss="modal" aria-hidden="true">Sí</button>' +
                '<button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">No</button>';
        loadForm(place, cabecera, view.getObjectTable(id), pie, false);
        $(prefijo_div + '#btnBorrarSi').unbind('click');
        $(prefijo_div + '#btnBorrarSi').click(function() {
            resultado = view.getObject().removeOne(id);
            cabecera = "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>" + "<h3 id=\"myModalLabel\">Respuesta del servidor</h3>";
            pie = "<button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Cerrar</button>";
            loadForm('#modal02', cabecera, "Código: " + resultado["status"] + "<br />" + resultado["message"] + "<br />", pie, true);
        });
    }

    function loadModalView(view, place, id) {
        cabecera = "<button type=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">×</button>" +
                "<h3 id=\"myModalLabel\">Detalle de " + view.getObject().getName() + "</h3>";
        pie = "<button class=\"btn btn-primary\" data-dismiss=\"modal\" aria-hidden=\"true\">Cerrar</button>";
        loadForm(place, cabecera, view.getObjectTable(id), pie, true);
    }

    return {
        inicia: function(view, pag, order, ordervalue, rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue) {

            var thisObject = this;

            //controlar que no estemos en una página fuera de órbita

            if (parseInt(pag) > parseInt(view.getObject().getPages(rpp, filter, filteroperator, filtervalue))) {
                pag = view.getObject().getPages(rpp, filter, filteroperator, filtervalue);
            }

            //muestra la botonera de páginas

            $(prefijo_div + "#pagination").empty().append(view.getLoading()).html(view.getPageLinks(pag, rpp, filter, filteroperator, filtervalue, systemfilter, systemfilteroperator, systemfiltervalue));

            //muestra el listado principal

            if (callback) {
                $(prefijo_div + "#datos").empty().append(view.getLoading()).html(view.getPageTable(pag, order, ordervalue, rpp, filter, filteroperator, filtervalue, systemfilter, systemfilteroperator, systemfiltervalue, cargaBotoneraBuscando()));
            } else {
                $(prefijo_div + "#datos").empty().append(view.getLoading()).html(view.getPageTable(pag, order, ordervalue, rpp, filter, filteroperator, filtervalue, systemfilter, systemfilteroperator, systemfiltervalue, cargaBotoneraMantenimiento()));
            }

            //muestra la frase con el número de registros de la consulta

            $(prefijo_div + "#registers").empty().append(view.getLoading()).html(view.getRegistersInfo(filter, filteroperator, filtervalue, systemfilter, systemfilteroperator, systemfiltervalue));

            //muestra la frase de estado de la ordenación de la tabla

            $(prefijo_div + "#order").empty().append(view.getLoading()).html(view.getOrderInfo(order, ordervalue));

            //muestra la frase de estado del filtro de la tabla aplicado

            $(prefijo_div + "#filter").empty().append(view.getLoading()).html(view.getFilterInfo(filter, filteroperator, filtervalue));

            //asignación eventos de la botonera de cada línea del listado principal
            if (callback) {
                $(prefijo_div + '.btn.btn-mini.action01').unbind('click');
                $(prefijo_div + '.btn.btn-mini.action01').click(callback);
            } else {
                $(prefijo_div + '.btn.btn-mini.action01').unbind('click');
                $(prefijo_div + '.btn.btn-mini.action01').click(function() {
                    loadDivView(view, '#datos2', $(this).attr('id'));
                });

                $(prefijo_div + '.btn.btn-mini.action02').unbind('click');
                $(prefijo_div + '.btn.btn-mini.action02').click(function() {
                    loadModalView(view, '#modal01', $(this).attr('id'));
                });

                $(prefijo_div + '.btn.btn-mini.action03').unbind('click');
                $(prefijo_div + '.btn.btn-mini.action03').click(function() {
                    loadModalForm(view, '#modal01', $(this).attr('id'), "edit");
                });

                $(prefijo_div + '.btn.btn-mini.action04').unbind('click');
                $(prefijo_div + '.btn.btn-mini.action04').click(function() {
                    removeConfirmationModalForm(view, '#modal01', $(this).attr('id'));
                });

            }

            //asignación de evento del enlace para quitar el orden en el listado principal

            $(prefijo_div + '#linkQuitarOrden').unbind('click');
            $(prefijo_div + '#linkQuitarOrden').click(function() {
                thisObject.inicia(view, pag, null, null, rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
            });

            //asignación de evento del enlace para quitar el filtro en el listado principal

            $(prefijo_div + '#linkQuitarFiltro').unbind('click');
            $(prefijo_div + '#linkQuitarFiltro').click(function() {
                thisObject.inicia(view, pag, order, ordervalue, rpp, null, null, null, callback, systemfilter, systemfilteroperator, systemfiltervalue);
            });

            //asignación de eventos de la ordenación por columnas del listado principal

            $.each(view.getObject().getFieldNames(), function(index, valor) {
                $(prefijo_div + '.orderAsc').unbind('click');
                $(prefijo_div + '.orderAsc' + index).click(function() {
                    rpp = $(prefijo_div + "#rpp option:selected").text();
                    thisObject.inicia(view, pag, valor, "asc", rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
                });
                $(prefijo_div + '.orderDesc').unbind('click');
                $(prefijo_div + '.orderDesc' + index).click(function() {
                    rpp = $(prefijo_div + "#rpp option:selected").text();
                    thisObject.inicia(view, pag, valor, "desc", rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
                });

            });

            //asignación del evento de click para cambiar de página en la botonera de paginación

            $(prefijo_div + '.pagination_link').unbind('click');
            $(prefijo_div + '.pagination_link').click(function() {
                var id = $(this).attr('id');
                rpp = $(prefijo_div + "#rpp option:selected").text();
                thisObject.inicia(view, id, order, ordervalue, rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
                return false;
            });

            // Navegar por la paginación capturando las teclas Re Pág - Av Pág   

//            window.onkeydown = tecla;
//            function tecla(event) {
//                event.preventDefault();
//                num = event.keyCode;
//                if (num == 112)
////                    alert("Pulsaste F1");
//    
//    
//
//                if (num == 123) {
////                    alert("Pulsaste F12"); 
//
//                }
//            }








            //    $(prefijo_div + '.pagination_link').unbind('keypress');
            $(prefijo_div + '.pagination_link').keypress(function(event) {
                if (event.wich == 100) {
                    var id = $(this).attr('id');
                    rpp = $(prefijo_div + "#rpp option:selected").text();
                    thisObject.inicia(view, id + 1, order, ordervalue, rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
                    return false;
                }
            });


            //boton de crear un nuevo elemento

            if (callback) {
                $(prefijo_div + '#crear').css("display", "none");
            } else {
                $(prefijo_div + '#crear').unbind('click');
                $(prefijo_div + '#crear').click(function() {
                    loadModalForm(view, prefijo_div + '#modal01', $(this).attr('id'));
                });
            }

            //asignación del evento de filtrado al boton

            $(prefijo_div + '#btnFiltrar').unbind('click');
            $(prefijo_div + "#btnFiltrar").click(function() {
                filter = $(prefijo_div + "#selectFilter option:selected").text();
                filteroperator = $(prefijo_div + "#selectFilteroperator option:selected").text();
                filtervalue = $(prefijo_div + "#inputFiltervalue").val();
                thisObject.inicia(view, pag, order, ordervalue, rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
                return false;
            });

            //asigación de evento de refresco de la tabla cuando volvemos de una operación en ventana modal

            $(prefijo_div + '#modal01').unbind('hidden');
            $(prefijo_div + '#modal01').on('hidden', function() {

                rpp = $(prefijo_div + "#rpp option:selected").text();
                thisObject.inicia(view, pag, order, ordervalue, rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
            });

            //asignación del evento de cambio del numero de regs por página

            $(prefijo_div + '#rpp').unbind('change');
            $(prefijo_div + '#rpp').on('change', function() {
                rpp = $(prefijo_div + "#rpp option:selected").text();
                thisObject.inicia(view, pag, order, ordervalue, rpp, filter, filteroperator, filtervalue, callback, systemfilter, systemfilteroperator, systemfiltervalue);
            });
        }
    };
};
