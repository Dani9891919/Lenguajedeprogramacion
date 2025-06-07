
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bienvenido al Mantenedor de Películas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            min-height: 100vh;
            background-color: #f8f9fa;
        }
        .spinner-border {
            width: 3rem;
            height: 3rem;
        }
        .text-center {
            font-size: 1.2rem;
            color: #495057;
        }
    </style>
    <meta http-equiv="refresh" content="2;url=peliculas?action=listar">
</head>
<body>
    <div class="text-center">
        <div class="spinner-border text-primary" role="status">
            <span class="visually-hidden">Cargando...</span>
        </div>
        <p class="mt-3">Cargando mantenedor de películas...</p>
    </div>
</body>
</html>