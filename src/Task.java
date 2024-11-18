public class Task {
    //Atributos de la clase Task
    private int id;
    private String name;
    private User user;
    private Estado estado;
    //Enumeracion de los estados de la tarea
    public enum Estado {
        PENDIENTE, EN_DESARROLLO, COMPLETADA
    }

    //Constructor de la clase Task
    public Task(User user, int id, String name, Estado estado) {
        this.user = user;
        this.id = id;
        this.name = name;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    //Metodo que cambia el estado de la tarea
    public void cabiarEstado(int state) {
        switch (state) {
            case 1:
                this.estado = Estado.PENDIENTE;
                break;
            case 2:
                this.estado = Estado.EN_DESARROLLO;
                break;
            case 3:
                this.estado = Estado.COMPLETADA;
                break;
            default:
                throw new IllegalArgumentException("Opcion no valida");
        }

    }
    //Metodo que asigna un usuario a la tarea
    public void asignarUsuario(User user) {
        this.user = user;
    }
}