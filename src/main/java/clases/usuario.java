package clases;

//Clase usuario
public class usuario {
private String username;
private String password;

public usuario(String username, String password) {
   this.username = username;
   this.password = password;
}
//Otros métodos y propiedades de Usuario

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



//ToString

}