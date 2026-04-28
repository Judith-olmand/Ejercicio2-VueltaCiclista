Mantenimiento de Ciclistas (JDBC CRUD)
Programa avanzado en Java que permite la gestión integral de una base de datos de ciclismo, implementando todas las operaciones fundamentales de persistencia (CRUD).

🚀 Funcionalidades
Altas Dinámicas: Permite registrar nuevos ciclistas asignándoles un ID de forma inteligente (reutilizando huecos libres o generando el siguiente consecutivo).

Consultas Personalizadas: * Listado general de ciclistas con información de sus equipos.

Filtrado de ciclistas por el país de origen de su equipo mediante consultas parametrizadas.

Actualización Selectiva: Permite modificar datos específicos de un ciclista, como su edad (con validación de rango) o su equipo.

Bajas Seguras: Elimina registros de ciclistas gestionando la integridad referencial en la base de datos (eliminación previa en tablas relacionadas).

Validación de Datos: Comprobación en tiempo real de la existencia de IDs (ciclistas y equipos) antes de ejecutar operaciones.

🛠️ Estructura técnica
El proyecto aplica un diseño modular para separar las responsabilidades de SQL:

PreparedStatement: Uso extensivo para prevenir ataques de Inyección SQL y mejorar el rendimiento.

Lógica de Identificadores: Clase ExtraerID que implementa algoritmos para la optimización de claves primarias.

Gestión de Conexiones: Implementación de try-with-resources para asegurar que los recursos de la base de datos se liberen correctamente.

Arquitectura por Módulos:

Insertar, Actualizar, Eliminar, Mostrar: Clases especializadas en cada operación del CRUD.

Comprobador: Clase de soporte para validación de existencia de registros.