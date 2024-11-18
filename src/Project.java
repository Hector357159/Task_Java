import java.util.List;

public class Project {
    //Atributos de la clase
    private int id;
    private String name;
    private List<Task> tasks;

    //Constructor de la clase
    public Project(int id, String name, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
    //Metodo que agrega una tarea al proyecto
    public void addTask(Task task) {
        tasks.add(task);
    }
    //Metodo que elimina una tarea del proyecto
    public void removeTask(Task task) {
        tasks.remove(task);
    }
}
