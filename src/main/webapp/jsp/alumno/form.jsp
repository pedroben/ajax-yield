<%-- 
    Document   : form
    Created on : Jan 24, 2013, 12:02:17 AM
    Author     : Sergio
--%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Entrada</h2>
    <div class="control-group">
        <label class="control-label" for="inputId">Id:</label>
        <div class="controls">
            <input type="text" id="id" name="id" placeholder="id" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="inputTitulo">Título:</label>
        <div class="controls">
            <input type="text" id="titulo" name="tiulo" size="15" placeholder="Título" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label"  for="inputContenido">Contenido:</label>
        <div class="controls">
            <input type="text" id="contenido" name="contenido" size="15" placeholder="Contenido" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="id_usuario">Usuario: </label> 
        <div class="controls">           
            <input readonly="true" id="id_usuario" class="input-mini"
                   name="id_usuario" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_usuario_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="id_hilo">Hilo </label> 
        <div class="controls">                
            <input readonly="true" id="id_hilo" class="input-mini"
                   name="id_hilo" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_hilo_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
     <div class="control-group">
            <label class="control-label" for="fecha">Fecha: </label> 
            <div class="controls">
                <input id="fecha" name="fecha" type="date" size="30" maxlength="50" value="" /> 
            </div>
        </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>
