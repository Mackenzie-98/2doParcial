<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulario Nuevo Ciclista</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-gtEjrD/SeCtmISkJkNUaaKMoLD0//ElJ19smozuHV6z3Iehds+3Ulb9Bn9Plx0x4" crossorigin="anonymous"></script>
</head>
<body>
	<form method = "post" action="/agregarCliente">
	  <div class="mb-3">
	    <label for="id" class="form-label">ID</label>
	    <input type="text" class="form-control" name="id">
	  </div>
	  <div class="mb-3">
	    <label for="name" class="form-label">Nombre</label>
	    <input type="text" class="form-control" name="name">
	  </div>
	  <div class="mb-3">
	    <label for="correo" class="form-label">Email address</label>
	    <input type="email" class="form-control" name="email">
	  </div>
	  <div class="mb-3">
	    <label for="birthDate" class="form-label">Fecha nacimiento</label>
	    <input type="date" class="form-control" name="birthDate">
	  </div>
	  <div class="mb-3">
	    <label for="country" class="form-label">Country</label>
	    <input type="text" class="form-control" name="country">
	  </div>
	  <div class="mb-3">
	    <label for="Team" class="form-label">Team</label>
	    <input type="text" class="form-control" name="Team">
	  </div>
	  <button type="submit" class="btn btn-primary">Submit</button>
	</form>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT" crossorigin="anonymous"></script>
</body>
</html>