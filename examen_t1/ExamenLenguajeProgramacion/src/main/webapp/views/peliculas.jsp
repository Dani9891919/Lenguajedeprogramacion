 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mantenedor de Películas</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            padding-top: 20px;
            background-color: #f8f9fa;
        }
        .container {
            background-color: #fff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 0 15px rgba(0,0,0,0.1);
        }
        h2, h3 {
            color: #0056b3;
            margin-bottom: 25px;
            text-align: center;
        }
        .form-section, .list-section {
            margin-bottom: 40px;
        }
        .table-responsive {
            margin-top: 20px;
        }
        .btn-action {
            margin-right: 5px;
        }
    </style>
</head>
<body>
    <div class="container">
        <h2 class="mb-4">Gestión de Películas Cibertec</h2>

        <div class="form-section card card-body mb-4">
            <h3 class="mb-3">
                <c:if test="${pelicula != null}">Editar Película</c:if>
                <c:if test="${pelicula == null}">Agregar Nueva Película</c:if>
            </h3>
            <form action="peliculas" method="post">
                <%-- Campos ocultos para la acción y el ID en caso de edición --%>
                <c:if test="${pelicula != null}">
                    <input type="hidden" name="action" value="update" />
                    <input type="hidden" name="idpelicula" value="${pelicula.idpelicula}" />
                </c:if>
                <c:if test="${pelicula == null}">
                    <input type="hidden" name="action" value="insert" />
                </c:if>

                <div class="mb-3">
                    <label for="nombre" class="form-label">Nombre:</label>
                    <input type="text" class="form-control" id="nombre" name="nombre" value="${pelicula.nombre}" required />
                </div>

                <div class="mb-3">
                    <label for="director" class="form-label">Director:</label>
                    <input type="text" class="form-control" id="director" name="director" value="${pelicula.director}" required />
                </div>

                <div class="mb-3">
                    <label for="fechaEstreno" class="form-label">Fecha de Estreno:</label>
                    <input type="date" class="form-control" id="fechaEstreno" name="fechaEstreno"
                           value="<fmt:formatDate value='${pelicula.fechaEstreno}' pattern='yyyy-MM-dd'/>" required />
                </div>

                <div class="mb-3">
                    <label for="idgenero" class="form-label">Género:</label>
                    <select class="form-select" id="idgenero" name="idgenero" required>
                        <option value="">-- Seleccione un Género --</option>
                        <c:forEach var="genero" items="${listaGeneros}">
                            <option value="${genero.idgenero}"
                                <c:if test="${pelicula.genero.idgenero == genero.idgenero}">selected</c:if>>
                                ${genero.nombre}
                            </option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-success btn-action">
                    <c:if test="${pelicula != null}">Actualizar Película</c:if>
                    <c:if test="${pelicula == null}">Guardar Película</c:if>
                </button>
                <c:if test="${pelicula != null}">
                    <button type="button" class="btn btn-secondary btn-action" onclick="window.location.href='peliculas?action=listar'">Cancelar</button>
                </c:if>
            </form>
        </div>

        <div class="list-section">
            <h3 class="mb-3">Listado de Películas</h3>
            <div class="d-flex justify-content-end mb-3">
                <a href="peliculas?action=new" class="btn btn-primary">Agregar Nueva Película</a>
            </div>

            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead class="table-dark">
                        <tr>
                            <th>ID</th>
                            <th>Nombre</th>
                            <th>Director</th>
                            <th>Fecha de Estreno</th>
                            <th>Género</th>
                            <th>Acciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="peli" items="${listaPeliculas}">
                            <tr>
                                <td>${peli.idpelicula}</td>
                                <td>${peli.nombre}</td>
                                <td>${peli.director}</td>
                                <td><fmt:formatDate value="${peli.fechaEstreno}" pattern="dd/MM/yyyy"/></td>
                                <td>${peli.genero.nombre}</td>
                                <td>
                                    <a href="peliculas?action=edit&id=${peli.idpelicula}" class="btn btn-warning btn-sm btn-action">Editar</a>
                                    <a href="peliculas?action=delete&id=${peli.idpelicula}" class="btn btn-danger btn-sm btn-action" onclick="return confirm('¿Estás seguro de eliminar la película ${peli.nombre}?');">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                        <c:if test="${empty listaPeliculas}">
                            <tr>
                                <td colspan="6" class="text-center text-muted">No hay películas registradas.</td>
                            </tr>
                        </c:if>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </body>
</html>