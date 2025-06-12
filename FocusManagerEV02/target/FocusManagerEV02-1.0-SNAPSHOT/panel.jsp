<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Focus Manager</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
  <style>
    body {
      background-color: #111;
      color: white;
      font-family: sans-serif;
      padding: 2rem;
    }

    .window {
      background-color: #222;
      border-radius: 10px;
      padding: 1.5rem;
      max-width: 400px;
      margin: 2rem auto;
      box-shadow: 0 0 10px rgba(0,0,0,0.5);
    }

    .window-header {
      display: flex;
      gap: 0.5rem;
      margin-bottom: 1rem;
    }

    .circle {
      width: 12px;
      height: 12px;
      border-radius: 50%;
      display: inline-block;
    }

    .red { background-color: #e74c3c; }
    .yellow { background-color: #f1c40f; }
    .green { background-color: #2ecc71; }

    select, input {
      margin-bottom: 1rem;
      width: 100%;
    }

    .btns {
      display: flex;
      justify-content: space-between;
    }

    .btn-cancel {
      background-color: #e74c3c;
      border: none;
      padding: 0.5rem 1rem;
      border-radius: 5px;
    }

    .btn-confirm {
      background-color: #2ecc71;
      border: none;
      padding: 0.5rem 1rem;
      border-radius: 5px;
    }
  </style>
</head>
<body>
  <%
    if(session.getAttribute("nombre") == null){
      response.sendRedirect("index.html");
      return;
    }
  %>

  <h1 style="text-align:center;">Bienvenid@ a Focus Manager</h1>

  <div class="window">
    <div class="window-header">
      <span class="circle red"></span>
      <span class="circle yellow"></span>
      <span class="circle green"></span>
    </div>
    
    <label for="titulo"><strong>Título</strong></label>
    <input type="text" id="titulo" placeholder="Escribe algo">

    <select>
      <option>GA6-220501096-AA4-EV02</option>
    </select>

    <select>
      <option>GA6-220501096-AA4-EV03</option>
    </select>

    <div class="btns">
      <button class="btn-cancel">✖</button>
      <button class="btn-confirm">✔</button>
    </div>
  </div>
</body>
</html>
