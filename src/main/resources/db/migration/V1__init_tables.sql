
    drop table if exists appointments;
    drop table if exists appointments_seq;

    drop table if exists doctors;
    drop table if exists doctors_seq;

    drop table if exists patients;
    drop table if exists patients_seq;


    create table doctors (
        id integer primary key ,
        address varchar(255),
        education varchar(255),
        name varchar(255),
        speciality varchar(255)
    ) engine=InnoDB;

    create table doctors_seq (next_val bigint) engine=InnoDB;
    insert into doctors_seq values ( 100 );


    create table patients (
        id integer not null,
        birthdate date,
        gender smallint,
        name varchar(255),
        primary key (id)
    ) engine=InnoDB;

    create table patients_seq (next_val bigint) engine=InnoDB;
    insert into patients_seq values ( 100 );

    create table appointments (
        id integer not null,
        brief_complain varchar(255),
        date datetime(6),
        doctor_id integer,
        patient_id integer,
        primary key (id)
    ) engine=InnoDB;

    create table appointments_seq (next_val bigint) engine=InnoDB;
    insert into appointments_seq values ( 100 );

    alter table appointments
    add constraint FK_DOCTOR_ID
    foreign key (doctor_id) references doctors (id);

    alter table appointments
    add constraint FK_PATIENT_ID
    foreign key (patient_id) references patients (id);
