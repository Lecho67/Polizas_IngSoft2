# Documentación Polizas_IngSoft2

## Método GET Recurso 1
localhost:8080/api/usuarios
1. Obtener Todos los Usuarios
2. **Método HTTP:** `GET`
3. **URL:** `/api/usuarios`
4. **Descripción:** Obtiene la lista de todos los usuarios registrados en el sistema.
5. **Respuesta Exitosa:**
    - **Código de Estado:** `200` (OK)
    - **Cuerpo de la Respuesta:** Una lista de objetos JSON, cada uno representando a un usuario.

## Método GET Recurso 2
localhost:8080/api/polizas
### Obtener Todas las Pólizas de Seguro

- **Método HTTP:** `GET`
- **URL:** `/api/polizas`
- **Descripción:** Obtiene la lista de todas las pólizas de seguro registradas en el sistema.
- **Respuesta Exitosa:**
    - **Código de Estado:** `200` (OK)
    - **Cuerpo de la Respuesta:** Una lista de objetos JSON, cada uno representando a una póliza de seguro.
 ## Método POST Recurso 3
localhost:8080/api/compra-polizas

 ### Recurso: Compra de Póliza

### Nota Importante

Recuerde que para utilizar este método es necesario primero utilizar el Recurso 5, el cual permite crear una transacción asociada al usuario. Solo después de haber creado la transacción con éxito utilizando el Recurso 5, podrá asociar esa transacción existente con la compra de la póliza utilizando este método.

El Recurso 5 se encarga de registrar un pago realizado desde el extranjero y guarda la transacción temporalmente en Redis. Una vez que la transacción esté registrada, podrá utilizar este método para realizar la compra de una póliza y asociarla con la transacción existente.

¡Asegúrese de haber creado la transacción utilizando el Recurso 5 antes de utilizar este método para evitar errores en la compra de la póliza!

- **Método HTTP:** `POST`
- **URL:** `/api/compra-polizas`
- **Descripción:** Realiza la compra de una póliza de seguro utilizando una transacción previamente registrada.
- **Parámetros:**
    - ```json
      {
      "formaDePago": "Tarjeta de crédito",  
        "poliza": { "id": 1 },  
        "usuario": { "id": 1 },  
        }
      ```
        - **poliza.id:** Identificador único de la póliza a comprar.
        - **usuario.id:** Identificador único del usuario que realiza la compra.
        - **formaDePago:** Método de pago utilizado para la compra.
- **Respuesta Exitosa:**
    - **Código de Estado:** `201` (Creado)
    - ```json
      {
      "id": 1,  
        "formaDePago": "Tarjeta de crédito",  
        "poliza": { "id": 1, "descripcion": "Póliza de seguro de vida",  
        "cobertura": "Beneficios por fallecimiento, invalidez, enfermedades críticas" },
        "usuario": { "id": 1, "nombre": "Santiago", "apellido": "Gonzales", "email": Gonsan@gmail.com },  
        "transaccion": { "id": 1, "monto": 1000.00, "moneda": "USD", "trm": 3800.00 }
      }
      ```
        - **id:** Identificador único de la compra de la póliza.
        - **formaDePago:** Método de pago utilizado para la compra.
        - **poliza:** Detalles de la póliza comprada.
        - **usuario:** Detalles del usuario que realizó la compra.
        - **transaccion:** Detalles de la transacción asociada a la compra.

Este recurso permite realizar la compra de una póliza de seguro utilizando una transacción previamente registrada en el sistema. La respuesta contiene detalles de la compra, incluida la información de la póliza, el usuario y la transacción asociada.


## Método GET Recurso 4
localhost:8080/api/poliza/2

### Recurso: Detalles de Póliza por Usuario

#### Método HTTP `GET`

#### URL

`/api/poliza/{id}`

#### Descripción

Este recurso permite obtener los detalles de las pólizas asociadas a un usuario específico.

#### Parámetros de la URL

- `{id}`: El ID del usuario del cual se desean obtener los detalles de las pólizas.
    

#### Respuesta Exitosa

- Código de estado: 200 (OK)
- Cuerpo de respuesta: Lista de objetos JSON que representan las pólizas asociadas al usuario.

## Metodo POST Recurso 5 
localhost:8080/api/transacciones/{usuario_id}

### Pago desde el Extranjero

- **Antes de utilizar el recurso 3:** Asegúrese de haber realizado un pago antes de utilizar el recurso 3, utilizando el recurso 5, debido a que la transaccion creada en el recurso 5 no se crea en la base de datos sql hasta que no se confirme con el recurso 3 que tiene una compra de un usuario a la cual asociarse.
- **Método HTTP:** `POST`
- **URL:** `/api/transacciones/{usuario_id}`
- **Descripción:** Registra un pago realizado desde el extranjero y guarda temporalmente la transacción en Redis.
- **Parámetros:**
    - **usuario_id:** Identificador del usuario que realiza el pago.
    - ```json
      {
        "monto": 1000.00,  
        "moneda": "USD"  
        }
      ```
        - **monto:** Monto del pago en la moneda extranjera.
        - **moneda:** Moneda en la que se realiza el pago (por ejemplo, USD).
- **Respuesta Exitosa:**
    - **Código de Estado:** `201` (Creado)
    - ```json
      {
        "id": 1,  
        "monto": 1000.00,  
        "moneda": "USD",  
        "trm": 3800.00,  
        "horaTrm": "2024-04-21 17:40:13"  
        }
      ```
        - **id:** Identificador único de la transacción.
        - **monto:** Monto del pago en la moneda extranjera.
        - **moneda:** Moneda en la que se realizó el pago.
        - **trm:** Tasa de cambio (TRM) obtenida para la conversión a moneda local.
- **Respuesta de Error:**
    - **Código de Estado:** `400` (Solicitud Incorrecta)
    - **Cuerpo de la Respuesta:** Mensaje de error indicando la razón del error.

## Metodo POST Crear Usuario
localhost:8080/api/usuarios
### 1\. Crear Usuario

- **Método HTTP:** `POST`
- **URL:** `/api/usuarios`
- **Descripción:** Crea un nuevo usuario en el sistema.
- ``` json
        {  
          "nombre": "Nombre del usuario",  
          "apellido": "Apellido del usuario",  
          "email": "Correo electrónico del usuario",  
          "contraseña": "Contraseña del usuario"
         }
    
     ```
## Método POST crear poliza
localhost:8080/api/polizas

### 1\. Crear Póliza de Seguro

- **Método HTTP:** `POST`
- **URL:** `/api/polizas`
- **Descripción:** Crea una nueva póliza de seguro con la información proporcionada.
- **Parámetros de la Solicitud:**
    - `descripcion` (cadena): Descripción de la póliza.
    - `cobertura` (cadena): Detalles de la cobertura de la póliza.
- ``` json
        {  
        "descripcion": "Póliza de seguro de vida",  
        "cobertura": "Beneficios por fallecimiento, invalidez, enfermedades críticas"  
        }
    
     ```



