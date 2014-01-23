<%-- 
    Document   : form
    Created on : Jan 21, 2013, 10:24:17 AM
    Author     : Jose
--%>
<%@page import="java.text.SimpleDateFormat"%>
<form class="form-horizontal" action="#" id="formulario" name="formulario">
    <fieldset>
        <div class="control-group">
            <label class="control-label" for="id">Id: </label>
            <div class="controls">
                <input id="id" name="id" type="text" size="30" maxlength="50" disabled="true" />
            </div>
        </div>        
        <div class="control-group">
            <label class="control-label"  for="inputLogin">Login:</label>
            <div class="controls">
                <input type="text" id="login" name="login" size="15"placeholder="Login" />
            </div>
        </div>
        <div class="control-group">
            <label class="control-label"  for="inputPassword">Password:</label>
            <div class="controls">
                <input type="text" id="password" name="password" size="15" placeholder="Password" />
            </div>
        </div>
        <div class="control-group">
            <div class="controls">
                <button type="submit" id="submitForm" class="btn submitForm">Submit</button>
            </div>
        </div>
    </fieldset>
</form>

