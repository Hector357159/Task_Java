import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Task> tasks = new ArrayList<>();
        List<Project> projects = new ArrayList<>();
        List<User> users = new ArrayList<>();
        TaskManager taskManager = new TaskManager(tasks, projects);

        while (true) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Crear tarea");
            System.out.println("2. Crear proyecto");
            System.out.println("3. Crear usuario");
            System.out.println("4. Asignar tarea a usuario");
            System.out.println("5. Asignar tarea a proyecto");
            System.out.println("6. Mostrar tareas pendientes");
            System.out.println("7. Mostrar tareas en desarrollo");
            System.out.println("8. Mostrar tareas completadas");
            System.out.println("9. Salir");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.println("Ingrese el nombre de la tarea:");
                    String taskName = scanner.nextLine();
                    System.out.println("Ingrese el ID de la tarea:");
                    int taskId = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.println("Ingrese el estado de la tarea (1: PENDIENTE, 2: EN_DESARROLLO, 3: COMPLETADA):");
                    int estado = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    Task.Estado taskEstado = Task.Estado.values()[estado - 1];
                    System.out.println("Ingrese el ID del usuario asignado:");
                    int userId = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    User user = null;
                    for (User u : users) {
                        if (u.getId() == userId) {
                            user = u;
                            break;
                        }
                    }
                    if (user != null) {
                        taskManager.crearTarea(taskName, user, taskId, taskEstado);
                    } else {
                        System.out.println("Usuario no encontrado.");
                    }
                    break;
                case 2:
                    System.out.println("Ingrese el nombre del proyecto:");
                    String projectName = scanner.nextLine();
                    System.out.println("Ingrese el ID del proyecto:");
                    int projectId = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    taskManager.crearProyecto(projectName, projectId, new ArrayList<>());
                    break;
                case 3:
                    System.out.println("Ingrese el nombre del usuario:");
                    String userName = scanner.nextLine();
                    System.out.println("Ingrese el ID del usuario:");
                    int newUserId = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    User newUser = new User(newUserId, userName, new ArrayList<>());
                    users.add(newUser);
                    break;
                case 4:
                    System.out.println("Ingrese el ID del usuario:");
                    int userIdAsignar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.println("Ingrese el ID de la tarea:");
                    int taskIdAsignar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    Task taskAsignar = null;
                    for (Task t : tasks) {
                        if (t.getId() == taskIdAsignar) {
                            taskAsignar = t;
                            break;
                        }
                    }
                    if (taskAsignar != null) {
                        User userAsignar = null;
                        for (User u : users) {
                            if (u.getId() == userIdAsignar) {
                                userAsignar = u;
                                break;
                            }
                        }
                        if (userAsignar != null) {
                            taskManager.asignarTarea(userAsignar, taskAsignar);
                        } else {
                            System.out.println("Usuario no encontrado.");
                        }
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 5:
                    System.out.println("Ingrese el ID del proyecto:");
                    int projectIdAsignar = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    System.out.println("Ingrese el ID de la tarea:");
                    int taskIdProyecto = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    Task taskProyecto = null;
                    for (Task t : tasks) {
                        if (t.getId() == taskIdProyecto) {
                            taskProyecto = t;
                            break;
                        }
                    }
                    if (taskProyecto != null) {
                        Project projectAsignar = null;
                        for (Project p : projects) {
                            if (p.getId() == projectIdAsignar) {
                                projectAsignar = p;
                                break;
                            }
                        }
                        if (projectAsignar != null) {
                            taskManager.asignarTareaProyecto(projectAsignar, taskProyecto);
                        } else {
                            System.out.println("Proyecto no encontrado.");
                        }
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;
                case 6:
                    taskManager.mostrarTareasPendientes();
                    break;
                case 7:
                    taskManager.mostrarTareasEnDesarrollo();
                    break;
                case 8:
                    taskManager.mostrarTareasCompletadas();
                    break;
                case 9:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}