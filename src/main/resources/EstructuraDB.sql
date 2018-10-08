create table Users(
	id integer auto_increment primary key,
	username varchar(25),
	password varchar(25)
);

create table Cliente(
	id integer auto_increment primary key,
	ci varchar(25),
    nombre varchar(50),
    apellido varchar(50),
    direccion varchar(100),
    telefono varchar(100)
);

create table Marca(
	id integer auto_increment primary key,
    descripcion varchar(25)
);

create table Modelo(
	id integer auto_increment primary key,
    descripcion varchar(25)
);

create table Vehiculo(
	id integer auto_increment primary key,
    marca_id integer ,
    modelo_id integer ,
    matricula varchar(25),
    chasis varchar(50),
    estado_id integer,
    observacion varchar(500),
    foreign key(marca_id) references Marca(id),
    foreign key(modelo_id) references Modelo(id)
);

create table Estado_Renta(
	id integer auto_increment primary key,
    descripcion varchar(50)
);


create table Renta(
	id integer auto_increment primary key,
    cliente_id integer,
    fecha_operacion timestamp default CURRENT_TIMESTAMP,
    estado_id integer,
    user_id integer,
    observacion varchar(255),
    monto_total long,
    foreign key(cliente_id) references Cliente(id),
    foreign key(estado_id) references Estado_Operacion(id),
    foreign key(user_id) references Users(id)
);

create table Detalle_Renta(
	id integer auto_increment primary key,
    renta_id integer,
    vehiculo_id integer,
    fecha_inicio timestamp default CURRENT_TIMESTAMP,
    fecha_fin timestamp default CURRENT_TIMESTAMP,
    monto long,
    foreign key(renta_id) references Renta(id),
    foreign key(vehiculo_id) references Vehiculo(id)
)