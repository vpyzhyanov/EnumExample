package ru.oop;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * Состояние
 *
 * @author vpyzhyanov
 * @since 08.12.2020
 */
public enum State
{
    INIT("Hello", "init"),
    WAIT("Enter command", "wait", text -> System.out.println(text + " in state wait")),
    PROCESS("Working...", "process", text -> System.out.println(text + " in state process"));

    private final String message;
    private final String id;
    Consumer<String> action;

    State(String message, String id, Consumer<String> action)
    {
        this.message = message;
        this.id = id;
        this.action = action;
    }

    State(String message, String id)
    {
        this.message = message;
        this.id = id;
        this.action = text -> System.out.println("Действие отсутствует");
    }

    public String getMessage()
    {
        return message;
    }

    public String getId()
    {
        return id;
    }

    /**
     * Получить состояние по идентификатору
     */
    public static State getStateById(String id)
    {
        return Arrays.stream(State.values())
                .filter(state -> state.getId().equals(id))
                .findFirst().orElse(INIT);
    }

    public void doAction(String inputText)
    {
        action.accept(inputText);
    }
}
