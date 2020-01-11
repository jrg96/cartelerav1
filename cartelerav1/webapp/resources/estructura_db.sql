CREATE TABLE Banners (
  id  NUMBER(11) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  titulo VARCHAR2(250) NOT NULL,
  fecha DATE NOT NULL,
  archivo VARCHAR2(250) NOT NULL,
  estatus VARCHAR2(20) NOT NULL CHECK( estatus IN ('Activo','Inactivo'))
);

ALTER TABLE Banners ADD (
  CONSTRAINT banner_pk PRIMARY KEY (id));

------------------------------------------------------------------------------

CREATE TABLE Detalles (
  id NUMBER(11) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  director varchar2(100) DEFAULT NULL,
  actores varchar2(255) DEFAULT NULL,
  sinopsis CLOB,
  trailer varchar2(255) DEFAULT NULL
);

ALTER TABLE Detalles ADD (
  CONSTRAINT detalle_pk PRIMARY KEY (id));

------------------------------------------------------------------------------------
CREATE TABLE Peliculas (
  id NUMBER(11) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  titulo varchar2(150) NOT NULL,
  duracion NUMBER(11) NOT NULL,
  clasificacion varchar2(5) NOT NULL CHECK( clasificacion IN ('A','B', 'C')),
  genero varchar2(45) NOT NULL,
  imagen varchar2(200) DEFAULT NULL,
  fechaEstreno date NOT NULL,
  estatus varchar2(45) DEFAULT 'Activa' CHECK( estatus IN ('Activa','Inactiva')) NOT NULL ,
  idDetalle NUMBER(11) DEFAULT NULL
);

ALTER TABLE Peliculas ADD (
  CONSTRAINT pelicula_pk PRIMARY KEY (id));
  
ALTER TABLE Peliculas
ADD CONSTRAINT fk_peliculas_detalles
   FOREIGN KEY (idDetalle)
   REFERENCES Detalles (id);

----------------------------------------------------------------------------------

CREATE TABLE Horarios (
  id NUMBER(11) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  fecha date NOT NULL,
  hora date NOT NULL,
  sala varchar2(100) NOT NULL,
  precio NUMBER(4,2) DEFAULT 0 NOT NULL,
  idPelicula NUMBER(11) NOT NULL
);

ALTER TABLE Horarios ADD (
  CONSTRAINT horario_pk PRIMARY KEY (id));

ALTER TABLE Horarios
ADD CONSTRAINT fk_horarios_peliculas
   FOREIGN KEY (idPelicula)
   REFERENCES Peliculas (id);

----------------------------------------------------------------------------------
CREATE TABLE Noticias (
  id NUMBER(11) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  titulo varchar2(250) NOT NULL,
  fecha date NOT NULL,
  detalle CLOB NOT NULL,
  estatus varchar2(20) CHECK( estatus IN ('Activa','Inactiva')) NOT NULL
);

ALTER TABLE Noticias ADD (
  CONSTRAINT noticia_pk PRIMARY KEY (id));

-----------------------------------------------------------------------------------
CREATE TABLE Usuarios (
  id NUMBER(11) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  nombre varchar2(150) NOT NULL,
  email varchar2(50) NOT NULL,
  username varchar2(100) NOT NULL,
  password varchar2(100) NOT NULL
);

ALTER TABLE Usuarios ADD (
  CONSTRAINT usuario_pk PRIMARY KEY (id));

ALTER TABLE Usuarios
ADD CONSTRAINT unique_username UNIQUE(username);

-----------------------------------------------------------------------------------

CREATE TABLE UsuarioPerfil (
  id NUMBER(11) GENERATED ALWAYS as IDENTITY(START with 1 INCREMENT by 1),
  username varchar2(100) NOT NULL,
  perfil varchar2(50) NOT NULL
);

ALTER TABLE UsuarioPerfil ADD (
  CONSTRAINT usuario_perfil_pk PRIMARY KEY (id));

ALTER TABLE UsuarioPerfil
ADD CONSTRAINT fk_usuarios_perfil
   FOREIGN KEY (username)
   REFERENCES Usuarios (username);
