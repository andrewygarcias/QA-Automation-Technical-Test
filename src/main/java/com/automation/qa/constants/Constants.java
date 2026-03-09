package com.automation.qa.constants;

import com.automation.qa.models.UserManagement.response.DataR;

public class Constants {
    public static final String BASEURL = "base.url";
    public static final String USERUPDATE="User Update";
    public static final String EXPECTEDURL = "https://demo.applitools.com/hackathonAppV2.html";
    public static final String CSSVERDE = "rgba(36, 179, 20, 1)";
    public static final String CSSROJO = "rgba(230, 82, 82, 1)";
    public static final String CSSCOLORPROPERTY = "color";
    public static final String POSITIVEVALUES = "+";
    public static final String NEGATIVEVALUES = "-";
    public static final String ENDPOINT_CREATEUSER = "users";
    public static final String ENDPOINT_GETUSERID = "users";
    public static final String ENDPOINT_UPDATEUSERID = "users";
    public static final String ENDPOINT_DELETEUSERID = "users";
    public static final String MESSAGE_STATUS_CODE_CREATION_OK = "La respuesta de la creacion de usuario debe ser 201";
    public static final String MESSAGE_STATUS_CODE_GET_OK = "La respuesta de la consulta de usuario debe ser 200";
    public static final String MESSAGE_STATUS_UPDATE_GET_OK = "La respuesta de la actualizacion de usuario debe ser 200";
    public static final String MESSAGE_STATUS_DELETE_GET_OK = "La respuesta de la eliminacion de usuario debe ser 204";
    public static final String BASEURLAPI = "url";
    public static final String APIKEY_VALUE = "reqres_264a839f9edf4608b4668a09df2aa266";
    public static final String APIKEY = "x-api-key";
    public static final String IDUSERCREATE = "idUser";
    public static final String SCHEMARESCREATEUSER = "ResponseCreateUser";
    public static final String SCHEMAREGETUSER = "ResponseGetUser";
    public static final String SCHEMAREUPDATEUSER = "ResponseUpdateUser";
    public static final String VALIDATEIDUSER = "El id del usuario";
    public static final String VALIDATEEMAILUSER = "El email del usuario";
    public static final String VALIDATEFIRSTNAMEUSER = "El first name del usuario";
    public static final String VALIDATELASTNAMEUSER = "El last name del usuario";
    public static final String VALIDATEAVATARUSER = "El avatar del usuario";
    public static final String VALIDATENAMEUSER = "El name del usuario";
    public static final String VALIDATEJOBUSER = "El job del usuario";
    public static final String URLUNDERTEST = "Url bajo pruebas";
    public static final DataR VALIDATEUSERGETID = DataR.builder().id(2).email("janet.weaver@reqres.in").avatar("https://reqres.in/img/faces/2-image.jpg").last_name("Weaver").first_name("Janet").build();
}
