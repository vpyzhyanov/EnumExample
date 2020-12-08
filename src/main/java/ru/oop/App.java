package ru.oop;

/**
 * Пример различных вариантов использования enum
 */
public class App
{
    public static void main(String[] args)
    {
        State state = State.INIT;
        System.out.println("Сообщение из состояния: " + state.getMessage());

        System.out.println("Идентификатор состояния: " + state.getId());

        System.out.println("Получить состояние по идентификатору (используя метод описанный в State): "
                + State.getStateById("wait"));

        System.out.println("Порядковый номер состояния PROCESS: "
                + State.PROCESS.ordinal());

        System.out.println("Получить состояние по порядковому номеру (используя стандартные средства): "
                + State.values()[2]);

        System.out.println("Получить состояние по имени состояния (используя стандартнй метод): "
                + State.valueOf("WAIT"));

        System.out.println("Выполнить действие для состояния WAIT "
                + "(используя метод определённый у экземпляра состояния): ");
        State.WAIT.doAction("Это действие мы увидим");

        System.out.println("Выполнить действие для состояния INIT "
                + "(используя метод определённый у экземпляра состояния): ");
        state.doAction("У этого состояния определено стандартное действие");
    }
}
