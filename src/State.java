public interface State<C extends Agente>{
    void enter();
    void execute();
    void exit();
    C getCharacter();
}
