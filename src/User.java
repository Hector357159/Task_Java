import java.util.List;

public class User {
    //Atributos de la clase
    private int  id;
    private String  name;
    private List<Task> tasks;
    //Constructor de la clase
    public User(int id, String name, List<Task> tasks) {
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

    public void asignarTarea(Task task) {
        tasks.add(task);
    }

    public void removerTarea(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
            }
        }
    }

}
