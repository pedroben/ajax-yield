<%-- 
    Document   : form
    Created on : Jan 21, 2013, 10:24:17 AM
    Author     : Jose
--%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <h2>Follower</h2>
    <div class="control-group">
        <label class="control-label" for="inputId">Id:</label>
        <div class="controls">
            <input type="text" id="id" name="id" placeholder="id" />
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="id_usuario1">Usuario 1: </label> 
        <div class="controls">           
            <input readonly="true" id="id_usuario1" class="input-mini"
                   name="id_usuario1" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_usuario_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
    <div class="control-group">
        <label class="control-label" for="id_usuario2">Usuario 2: </label> 
        <div class="controls">           
            <input readonly="true" id="id_usuario2" class="input-mini"
                   name="id_usuario2" type="text" size="5" maxlength="5" />  
            <a class="btn btn-mini" id="id_usuario_button" href="#"><i class="icon-search"></i></a>
        </div>
    </div>
    <div class="control-group">
        <div class="controls">
            <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
        </div>
    </div>
</form>
