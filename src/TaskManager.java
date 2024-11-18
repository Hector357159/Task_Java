import java.util.List;

public class TaskManager {
    //Atributos de la clase
    private List<Task> tasks;
    private List<Project> Projects;

    //Constructor de la clase
    public TaskManager(List<Task> tasks, List<Project> projects) {
        this.tasks = tasks;
        Projects = projects;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public List<Project> getProjects() {
        return Projects;
    }

    public void setProjects(List<Project> projects) {
        Projects = projects;
    }

    //Metodos de Task
    //Metodo que crea una tarea
    public void crearTarea(String name, User user, int id, Task.Estado estado) {
        Task task = new Task(user, id, name, estado);
        tasks.add(task);
    }
    //Metodo que cambia el estado de una tarea
    public void eliminarTarea(int taskId) {
        for (Task task : tasks) {
            if (task.getId() == taskId) {
                tasks.remove(task);
            }
        }
    }
    //Metodo que muestra el estado de las tareas
    public void mostrarEstadoTareas() {
        for (Task task : tasks) {
            System.out.println(task.getName() + " - " + task.getEstado());
        }
    }
    //Metodos de Project
    //Metodo que crea un proyecto
    public void crearProyecto(String name, int id, List<Task> tasks) {
        Project project = new Project(id, name, tasks);
        Projects.add(project);
    }
    //Metodo que elimina un proyecto
    public void eliminarProyecto(Project project) {
        Projects.remove(project);
    }
    //Metodos de Asignacion
    //Metodo que asigna una tarea a un usuario
    public void asignarTarea(User user, Task task) {
        user.asignarTarea(task);
    }
    //Metodo que asigna una tarea a un proyecto
    public void asignarTareaProyecto(Project projectId, Task taskId) {
        for (Project project : Projects) {
            if (project.getId() == projectId.getId()) {
                project.addTask(taskId);
            }
        }
    }
    //Metodos de reportes
    //Metodo que muestra las tareas pendientes
    public void mostrarTareasPendientes() {
        for (Task task : tasks) {
            if (task.getEstado() == Task.Estado.PENDIENTE) {
                System.out.println(task.getName());
            }
        }
    }
    //Metodo que muestra las tareas en desarrollo
    public void mostrarTareasEnDesarrollo() {
        for (Task task : tasks) {
            if (task.getEstado() == Task.Estado.EN_DESARROLLO) {
                System.out.println(task.getName());
            }
        }
    }
    //Metodo que muestra las tareas completadas
    public void mostrarTareasCompletadas() {
        for (Task task : tasks) {
            if (task.getEstado() == Task.Estado.COMPLETADA) {
                System.out.println(task.getName());
            }
        }
    }
    //Metodo que muestra las tareas de un proyecto y su estado
    public void mostrarTareasProyecto(Project project) {
        for (Project project1 : Projects) {
            if (project1.getId() == project.getId()) {
                for (Task task : project1.getTasks()) {
                    System.out.println(task.getName() + " - " + task.getEstado());
                }
            }
        }
    }

}
